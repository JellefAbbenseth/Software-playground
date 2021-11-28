using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace GrowthV2
{
	class Programm
	{
		static void Main() 
		{
			Spieler Char = new Spieler();
			
			Console.Write("Bitte geben Sie den Namen Ihres Spielers ein: ");
			Char.Name = Console.ReadLine();
			Char.Leben = 100;
			Char.Ausdauer = 100;
			Char.Erfahrung = 0;
			Char.Schadenmultiplikator = 2;
			Char.Schadenadditor = 0;
			int Lebenstrank = 3;
			int Ausdauertrank = 3;
			

			int MaxLeben = Char.Leben;
			int MaxAusdauer= Char.Ausdauer;
			string Ort = "Rast";
			int Auswahl = 0;
			int Kampf = 0;
			bool SpielEnde = false;
			bool Sieg = false;
			
			Profil(Char.Name, Char.Leben, Char.Ausdauer, Char.Erfahrung, Char.Schadenmultiplikator, Char.Schadenadditor);
			Console.WriteLine("Sie haben {0} Lebens- und {1} Ausdauertränke", Lebenstrank, Ausdauertrank);
			Console.WriteLine("Ihr aktueller Ort: " +Ort);
				
			do {
				Auswahl = Abfrage();
				
				switch (Auswahl) { //Verschiedene Fälle
					case 1:  //Ausruhen
						if (Ort == "Rast"){
							Char.Leben = MaxLeben;
							Char.Ausdauer = MaxAusdauer;
						}
						
						if(Char.Leben < MaxLeben) {
							Char.Leben = Ausruhen(Char.Leben);
							
						} else {
							Char.Leben = MaxLeben;
						}
						
						if(Char.Ausdauer < MaxAusdauer) {
							Char.Ausdauer = Ausruhen(Char.Ausdauer);
						} else {
							Char.Ausdauer = MaxAusdauer;
						}
					break;
					
					case 2: // weiter gehen
						Kampf = Wuerfel1();
						// Console.WriteLine("Würfelzahl: " +Kampf);
						if(Kampf <4)
						{
							Console.WriteLine("Keine Begegnung.");
						} else							
						{
							int[] kaempfen = Kaempfen(Char.Leben, Char.Ausdauer, Char.Erfahrung, Char.Schadenmultiplikator, Char.Schadenadditor, Lebenstrank, Ausdauertrank, MaxLeben, MaxAusdauer);

							Char.Leben = kaempfen[0];
							Char.Ausdauer = kaempfen[1];
							Char.Erfahrung = kaempfen[2];
							Lebenstrank = kaempfen[3];
							Ausdauertrank = kaempfen[4];
						}
					break;	
					
					case 3: //Profil
						Profil(Char.Name, Char.Leben, Char.Ausdauer, Char.Erfahrung, Char.Schadenmultiplikator, Char.Schadenadditor);
					break;
				}
				
				Console.WriteLine();
				
				if(Char.Leben <= 0 || Char.Erfahrung >= 100) {
					SpielEnde = true;
					
					if(Char.Leben > 0)
                    {
						Sieg = true;
					}
				}
			} while(SpielEnde == false);
			
			if(Sieg == true) {
				Console.WriteLine("Du hast gewonnen.");
			} else {
				Console.WriteLine("Das war wohl nichts. Versuche es erneut.");
			}
			
			Console.ReadKey();
		}
		
		static void Profil(string Name, int Leben, int Ausdauer, int Erfahrung, int Schadenm, int Schadena)
		{
			Console.WriteLine("Name: " +Name);
			Console.WriteLine("Leben: {0}  Ausdauer: {1}  Erfahrung: {2}" ,Leben, Ausdauer, Erfahrung);
			Console.WriteLine("Schaden: Würfelzahl * {0} + {1}", Schadenm, Schadena);
		}
		
		static int[] Kaempfen(int Leb, int Aus, int Erf, int Schm, int Scha, int LT, int AT, int MaxLeben, int MaxAusdauer)
		{
			string[] Monster = Gegner1();
			string Gegner = Monster[0];
			int GLeb = Convert.ToInt32(Monster[1]);
			int GAus = Convert.ToInt32(Monster[2]);
			int GErf = Convert.ToInt32(Monster[3]);
			int GSchm = Convert.ToInt32(Monster[4]);
			int GScha = Convert.ToInt32(Monster[5]);

			int Auswahl = 0;
			int Schaden = 0;
			string Verteidigen = "";

			Console.WriteLine("Sie begegnen einem: " + Gegner);

			do
			{
				Console.WriteLine("Was möchten Sie tun?");
				Console.WriteLine("Kämpfen: 1  Inspizieren: 2 Tränke: 3");
				Console.WriteLine("Ausruhen: 4  Fliehen: 5");
				Auswahl = Convert.ToInt32(Console.ReadLine());
				Verteidigen = Verteidigung();

				switch (Auswahl)
				{
					case 1: // Kämpfen
						if (Aus >= 5)
						{
							Schaden = Wuerfel1() * Schm + Scha;
							GLeb = GLeb - Schaden;
							Aus = Aus - 5;
							Console.WriteLine("Du fügst dem Gegner {0} Schaden zu. Dir verbleiben {1} Ausdauer.", Schaden, Aus);
						}
						else
						{
							Console.WriteLine("Du hast keine Ausdauer mehr. Du erholst dich.");
							Aus = Ausruhen(Aus);
						}

						if (GLeb > 0)
						{						
							if(Verteidigen == "Ausweichen")
							{
								Console.WriteLine("Du bist ausgewichen.");
							} else if(Verteidigen == "Blocken")
							{
								Console.WriteLine("Du hast den Angriff geblockt, der Gegner hat sich dabei verletzt.");
								GLeb = GLeb - Wuerfel1();
							} else
							{
								if (GAus >= 5)
								{
									Schaden = Wuerfel1() * GSchm + GScha;
									Leb = Leb - Schaden;
									GAus = GAus - 5;
									Console.WriteLine("Der Gegner fügt dir {0} Schaden zu. Dein Restleben ist: {1}", Schaden, Leb);
								}
								else
								{
									Console.WriteLine("Der Gegner erholt sich.");
									GAus = Ausruhen(GAus);
								}
							}
						}
						else
						{
							Console.WriteLine("Du hast den Gegner besiegt. Du erhältst {0} Erfahrungspunkte.", GErf);
							Erf = Erf + GErf;
							Console.WriteLine("Du hast aktuell {0} Erfahrungspunkte.", Erf);
						}
						break;

					case 2: //Inspizieren
						Console.WriteLine("Das Profil deines Gegners: ");
						Profil(Gegner, GLeb, GAus, GErf, GSchm, GScha);
						Console.WriteLine("Drücke eine Taste!");
						Console.ReadKey();
						Console.WriteLine();

						if(Verteidigen == "Ausweichen")
						{
							Console.WriteLine("Du bist ausgewichen.");
						} else if(Verteidigen == "Blocken")
						{
							Console.WriteLine("Du hast den Angriff geblockt, der Gegner hat sich dabei verletzt.");
							GLeb = GLeb - Wuerfel1();
						} else
						{
							if (GAus >= 5)
							{
								Schaden = Wuerfel1() * GSchm + GScha;
								Leb = Leb - Schaden;
								GAus = GAus - 5;
								Console.WriteLine("Der Gegner fügt dir {0} Schaden zu. Dein Restleben ist: {1}", Schaden, Leb);
							}
							else
							{
								Console.WriteLine("Der Gegner erholt sich.");
								GAus = Ausruhen(GAus);
							}
						}
						break;

					case 3: //Tränke
						Console.WriteLine("Welchen Trank möchten Sie nehmen?");
						Console.WriteLine("Lebenstrank: 1  Ausdauertrank: 2");
						Auswahl = Convert.ToInt32(Console.ReadLine());

						if(Auswahl == 1)
						{
							Leb = MaxLeben;
							LT = LT - 1;
						} else
						{
							Aus = MaxAusdauer;
							AT = AT - 1;
						}

						Console.WriteLine("Sie sind zurückgewichen und haben einen Trank getrunken.");
						Console.WriteLine("Sie haben noch {0} Lebens- und {1} Ausdauertränke.", LT, AT);
						Console.WriteLine("Ihr Leben: {0}  Ihre Ausdauer: {1}", Leb, Aus);
						break;

					case 4: //Ausruhen
						if (Aus < MaxAusdauer)
						{
							Aus = Ausruhen(Aus);
						}
						else
						{
							Aus = MaxAusdauer;
						}
						Console.WriteLine("Du hast dich erholt. Deine Ausdauer ist: " + Aus);
						Console.WriteLine("Zur Erholung bist du zurückgewichen.");

						break;

					case 5: //Fliehen
						int Fliehen = Wuerfel1();
						if (Fliehen > 3)
						{
							GLeb = 0;
							Console.WriteLine("Du bist erfolgreich geflohen.");
						}
						else if (GAus >= 5)
						{
							Schaden = Wuerfel1() * GSchm + GScha;
							Leb = Leb - Schaden;
							GAus = GAus - 5;
							Console.WriteLine("Deine Flucht ist fehlgeschlagen.");
							Console.WriteLine("Der Gegner fügt dir {0} Schaden zu. Dein Restleben ist: {1}", Schaden, Leb);
						}
						else
						{
							Console.WriteLine("Der Gegner erholt sich.");
							GAus = Ausruhen(GAus);
						}
						break;
				}

				Console.WriteLine();
				if(Leb <= 0)
				{
					GLeb = 0;
					Erf = 100;
				}

			} while (GLeb > 0);

			int[] ergebnis = new int[5];

			ergebnis[0] = Leb;
			ergebnis[1] = Aus;
			ergebnis[2] = Erf;
			ergebnis[3] = LT;
			ergebnis[4] = AT;

			return ergebnis;
		}

		static string[] Gegner1()
		{
			string name = "";
			int Leb = 0;
			int Aus = 0;
			int Erf = 0;
			int Schm = 0;
			int Scha = 0;
			int zahl = Wuerfel2();

			if(zahl <11)
			{
				name = "Wolf";
				Leb = Wuerfel1() * 10;
				Aus = Leb;
				
				if(Leb < 36)
				{
					Erf = 10;
					Schm = 1;
					Scha = 3;
				} else
				{
					Erf = 15;
					Schm = 2;
					Scha = 1;
				}
			} else if(zahl<21)
			{
				name = "Goblin";
				Leb = Wuerfel1() * 8;
				Aus = Leb;

				if (Leb < 26)
				{
					Erf = 5;
					Schm = 1;
					Scha = 2;
				}
				else
				{
					Erf = 10;
					Schm = 1;
					Scha = 4;
				}
			}
			else
			{
				name = "Hobgoblin";
				Leb = (Wuerfel1() + 6) * 10;
				Aus = Leb;

				if (Leb < 91)
				{
					Erf = 15;
					Schm = 2;
					Scha = 2;
				}
				else
				{
					Erf = 20;
					Schm = 2;
					Scha = 5;
				}
			}
			
			string[] gegner = new string[6];
			gegner[0] = name;
			gegner[1] = Convert.ToString(Leb);
			gegner[2] = Convert.ToString(Aus);
			gegner[3] = Convert.ToString(Erf);
			gegner[4] = Convert.ToString(Schm);
			gegner[5] = Convert.ToString(Scha);

			return gegner;
		}

		static int Ausruhen(int Wert)
		{
			int ergebnis = Wert + 10;
			//Console.WriteLine(ergebnis); //zum Prüfen
			return ergebnis;
		} 

		static string Verteidigung()
		{
			int zahl = Wuerfel2();
			string ergebnis = "";

			if(zahl < 8)
			{
				ergebnis = "Ausweichen";
			} else if(zahl<15)
			{
				ergebnis = "Blocken";
			}
			return ergebnis;
		}
		
		static int Abfrage()
		{
			Console.WriteLine("Was möchten Sie tun?");
			Console.WriteLine("Ausruhen : 1; Weiter gehen: 2; Profil: 3");
			int ergebnis = Convert.ToInt32(Console.ReadLine());
			return ergebnis;
		} 
		
		static int Wuerfel1()
		{
			Thread.Sleep(100);
			Random zufallszahl = new Random();
			int Wert = zufallszahl.Next(1,7);
			//Console.WriteLine(Wert);
			return Wert;
		}

		static int Wuerfel2()
		{
			Thread.Sleep(100);
			Random zufallszahl = new Random();
			int Wert = zufallszahl.Next(1, 22);
			//Console.WriteLine(Wert);
			return Wert;
		}
	}
	
	class Wesen
	{
		// Eigenschaften
		public int Leben { get; set; }
		public int Ausdauer { get; set; }
		public int Erfahrung { get; set; }
		public int Schadenmultiplikator { get; set; }
		public int Schadenadditor { get; set; }

		/*
		public Wesen(){
			
		}
		
		public Wesen(int leben, int ausdauer, int erfahrung, int schadenmultiplikator) {
			this.Leben = leben;
			this.Ausdauer = ausdauer;
			this.Erfahrung = erfahrung;
			this.Schadenmultiplikator = schadenmultiplikator;
		} */
		
	}
	
	class Spieler:Wesen
	{
		// Eigenschaften
		public string Name { get; set; }
	}
	
	class Monster:Wesen
	{
		// Eigenschaften
		public string Art { get; set; }
	}
}