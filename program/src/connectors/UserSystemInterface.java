package connectors;

import classes.Animals;
import classes.Compound;
import classes.Staff;
import interfaces.UserInterfaceDAO;

import java.util.ArrayList;
import java.util.Scanner;

public class UserSystemInterface implements UserInterfaceDAO {
    private static Scanner input = new Scanner(System.in);

    ArrayList<Animals> animals;
    ArrayList<Staff> staff;
    ArrayList<Compound> compounds;

    private boolean goOn = true;
    private boolean tryAgain = false;
    private String text = "";
    private int choice;
    private int x;

    public UserSystemInterface(ArrayList<Animals> a, ArrayList<Staff> s, ArrayList<Compound> c) {
        this.animals = a;
        this.staff = s;
        this.compounds = c;
    }

    @Override
    public void menu() {
        while (goOn) {
            System.out.println("Hauptmenu");
            System.out.println("====================");
            System.out.println("1 - Alles anzeigen");
            System.out.println("2 - Anlegen");
            System.out.println("3 - Anzeigen");
            System.out.println("4 - Ändern");
            System.out.println("5 - Löschen");
            System.out.println("6 - Programm beenden");

            System.out.println("Ihre Auswahl: ");
            choice = input.nextInt();
            goOn = selectionMainMenu(choice);
        }
    }

    private boolean selectionMainMenu(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Alles angezeigt!");
                break;
            case 2:
                do {
                    System.out.println("Neuer Eintrag");
                    System.out.println("====================");
                    System.out.println("1 - Unterbringung");
                    System.out.println("2 - Tiere");
                    System.out.println("3 - Mitarbeiter");

                    System.out.println("Ihre Auswahl: ");
                    choice = input.nextInt();
                    tryAgain = insertMenu(choice);
                } while(tryAgain);
                break;
            case 3:
                do {
                    System.out.println("Anzeigen");
                    System.out.println("====================");
                    System.out.println("1 - Unterbringung");
                    System.out.println("2 - Tiere");
                    System.out.println("3 - Mitarbeiter");

                    System.out.println("Ihre Auswahl: ");
                    choice = input.nextInt();
                    tryAgain = showMenu(choice);
                } while(tryAgain);
                break;
            case 4:
                do {
                    System.out.println("Ändern");
                    System.out.println("====================");
                    System.out.println("1 - Unterbringung");
                    System.out.println("2 - Tiere");
                    System.out.println("3 - Mitarbeiter");

                    System.out.println("Ihre Auswahl: ");
                    choice = input.nextInt();
                    tryAgain = modifyMenu(choice);
                } while(tryAgain);
                break;
            case 5:
                System.out.println("Etwas gelöscht!");
                break;
            case 6:
                System.out.println("Programm wird beendet!");
                return false;
            default:
                System.out.println("Keine Gültige Eingabe, bitte wiederholen!");
        }
        return true;
    }

    private boolean modifyMenu(int choice) {
        switch (choice) {
            case 1:
                updateObject("compounds");
                break;
            case 2:
                updateObject("animals");
                break;
            case 3:
                updateObject("staff");
                break;
            default:
                System.out.println("Keine Gültige Eingabe, bitte wiederholen!");
                return true;
        }
        return false;
    }

    private boolean showMenu(int choice) {
        switch (choice) {
            case 1:
                objectRead("compounds");
                break;
            case 2:
                objectRead("animals");
                break;
            case 3:
                objectRead("staff");
                break;
            default:
                System.out.println("Keine Gültige Eingabe, bitte wiederholen!");
                return true;
        }
        return false;
    }

    private boolean insertMenu(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Unterbringung hinzufügen!");
                insertCompound();
                break;
            case 2:
                System.out.println("Tiere hinzufügen!");
                insertAnimal();
                break;
            case 3:
                System.out.println("Mitarbeiter hinzufügen!");
                insertStaff();
                break;
            default:
                System.out.println("Keine Gültige Eingabe, bitte wiederholen!");
                return true;
        }
        return false;
    }

    @Override
    public boolean insertAnimal() {
        return false;
    }

    @Override
    public boolean insertCompound() {
        return false;
    }

    @Override
    public boolean insertStaff() {
        return false;
    }

    @Override
    public void objectRead(String type) {
        text = "";
        if (type == "compounds") {
            for (int i = 0; i < compounds.size(); i++) {
                text = compounds.get(i).display();
                System.out.println(text);
            }
        } else if (type == "animals") {
            for (int i = 0; i < animals.size(); i++) {
                text = animals.get(i).display();
                System.out.println(text);
            }
        } else {
            for (int i = 0; i < staff.size(); i++) {
                text = staff.get(i).display();
                System.out.println(text);
            }
        }
    }

    @Override
    public void updateObject(String type) {
        if (type == "compounds") {
            System.out.println("Welche Unterbringung ändern?");
            choice = input.nextInt();
            if (choice < compounds.size()) {
                compoundChange(choice);
            } else {
                System.out.println("Keine Unterbringung mit dieser ID vorhanden!");
            }
        } else if (type == "animals") {
            System.out.println("Welches Tier ändern?");
            choice = input.nextInt();
            if (choice < animals.size()) {
                animalsChange(choice);
            } else {
                System.out.println("Kein Tier mit dieser ID vorhanden!");
            }
        } else {
            System.out.println("Welchen Mitarbeiter ändern?");
            choice = input.nextInt();
            if (choice < staff.size()) {
                staffChange(choice);
            } else {
                System.out.println("Kein Tier mit dieser ID vorhanden!");
            }
        }
    }

    private void staffChange(int choice) {
        x = choice;
        System.out.println("Mitarbeiter:");
        text = staff.get(x).display();
        System.out.println(text);
        System.out.println("Möchten Sie Arten der Pflege ändern?");

        do {
            System.out.println("1 - hinzufügen");
            System.out.println("2 - abbrechen");
            System.out.println("Ihre Auswahl:");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Bitte geben Sie die Art der Pflege an:");
                    text = input.next();
                    staff.get(x).setResponsibility(text);
                case 2:
                    tryAgain = false;
                    break;
                default:
                    System.out.println("Keine Gültige Eingabe, bitte erneut versuchen!");
                    tryAgain = true;
            }
        } while (tryAgain);
        System.out.println("Mitarbeiter nach Änderung:");
        text = staff.get(x).display();
        System.out.println(text);
    }

    private void animalsChange(int choice) {
        x = choice;
        System.out.println("Tier:");
        text = animals.get(x).display();
        System.out.println(text);
        System.out.println("Was möchten Sie ändern?");
        do {
            System.out.println("1 - Unterbringung wechseln");
            System.out.println("2 - Partner hinzufügen/ändern");
            System.out.println("3 - Kind hinzufügen");
            System.out.println("Ihre Auswahl:");
            choice = input.nextInt();
            int id;
            switch (choice) {
                case 1:
                    System.out.println("Bitte geben Sie die ID der Unterbringung an:");
                    id = input.nextInt();
                    if (id < compounds.size()) {
                        int oldId = animals.get(x).getCompound();
                        // Compound, delete old resident!!
                        animals.get(x).setCompound(id);
                    } else {
                        System.out.println("Diese Unterbringung existiert nicht!");
                    }
                    tryAgain = false;
                    break;
                case 2:
                    System.out.println("Bitte geben Sie die ID des Partners an:");
                    id = input.nextInt();
                    if (id < animals.size()) {
                        animals.get(x).setPaID(id);
                    } else {
                        System.out.println("Dieses Tier existiert nicht!");
                    }
                    tryAgain = false;
                    break;
                case 3:
                    System.out.println("Bitte geben Sie die ID des Kindes an:");
                    id = input.nextInt();
                    if (id < animals.size()) {
                        animals.get(x).newChild(id);
                    } else {
                        System.out.println("Dieses Tier existiert nicht!");
                    }
                    tryAgain = false;
                    break;
                default:
                    System.out.println("Keine Gültige Eingabe, bitte erneut versuchen!");
                    tryAgain = true;
            }
        } while (tryAgain);
        System.out.println("Tier nach Änderung:");
        text = animals.get(x).display();
        System.out.println(text);
    }

    private void compoundChange(int choice) {
        x = choice;
        System.out.println("Unterbringung:");
        text = compounds.get(x).display();
        System.out.println(text);
        System.out.println("Möchten Sie Arten der Pflege hinzufügen?");

        do {
            System.out.println("1 - hinzufügen");
            System.out.println("2 - abbrechen");
            System.out.println("Ihre Auswahl:");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Bitte geben Sie die Art der Unterbringung an:");
                    text = input.next();
                    compounds.get(x).newCares(text);
                case 2:
                    tryAgain = false;
                    break;
                default:
                    System.out.println("Keine Gültige Eingabe, bitte erneut versuchen!");
                    tryAgain = true;
            }
        } while (tryAgain);
        System.out.println("Unterbringung nach Änderung:");
        text = compounds.get(x).display();
        System.out.println(text);
    }

    @Override
    public void deleteObject(String type) {

    }
}
