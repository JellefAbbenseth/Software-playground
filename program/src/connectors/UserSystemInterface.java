package connectors;

import classes.Animals;
import classes.Compound;
import classes.Staff;
import interfaces.UserInterfaceDAO;
import interfaces.ZooAdmDAO;

import java.util.ArrayList;
import java.util.Scanner;

public class UserSystemInterface implements UserInterfaceDAO {
    private static final Scanner INPUT = new Scanner(System.in);
    private final ZooAdmDAO zooAdmin;

    ArrayList<Animals> animals;
    ArrayList<Staff> staff;
    ArrayList<Compound> compounds;


    private boolean goOn = true;
    private boolean tryAgain = false;
    private String text = "";
    private String type = "";
    private String firstName;
    private String lastName;
    private String responsibility;
    private char sex;
    private int choice;
    private int x;
    private int id;
    private int age;
    private int coId;
    private int habitat;
    private int maxResidents;
    private int stId;


    public UserSystemInterface(ArrayList<Animals> a, ArrayList<Staff> s, ArrayList<Compound> c, ZooAdmDAO zooAdmin) {
        this.animals = a;
        this.staff = s;
        this.compounds = c;
        this.zooAdmin = zooAdmin;
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
            choice = INPUT.nextInt();
            goOn = selectionMainMenu(choice);
        }
        INPUT.close();
    }

    private boolean selectionMainMenu(int choice) {
        switch (choice) {
            case 1:
                showAll();
                break;
            case 2:
                do {
                    System.out.println("Neuer Eintrag");
                    System.out.println("====================");
                    System.out.println("1 - Unterbringung");
                    System.out.println("2 - Tiere");
                    System.out.println("3 - Mitarbeiter");

                    System.out.println("Ihre Auswahl: ");
                    choice = INPUT.nextInt();
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
                    choice = INPUT.nextInt();
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
                    choice = INPUT.nextInt();
                    tryAgain = modifyMenu(choice);
                } while(tryAgain);
                break;
            case 5:
                do {
                    System.out.println("Löschen");
                    System.out.println("====================");
                    System.out.println("1 - Unterbringung");
                    System.out.println("2 - Tiere");
                    System.out.println("3 - Mitarbeiter");

                    System.out.println("Ihre Auswahl: ");
                    choice = INPUT.nextInt();
                    tryAgain = deleteMenu(choice);
                } while(tryAgain);
                break;
            case 6:
                System.out.println("Programm wird beendet!");
                zooAdmin.writeAll(animals,compounds,staff);
                return false;
            default:
                System.out.println("Keine Gültige Eingabe, bitte wiederholen!");
        }
        return true;
    }

    private boolean deleteMenu(int choice) {
        switch (choice) {
            case 1:
                deleteObject("compounds");
                break;
            case 2:
                deleteObject("animals");
                break;
            case 3:
                deleteObject("staff");
                break;
            default:
                System.out.println("Keine Gültige Eingabe, bitte wiederholen!");
                return true;
        }
        return false;
    }

    private void showAll() {
        System.out.println("\n------------------------------");
        System.out.println("Unterbringungen: ");
        for (int i = 0; i < compounds.size(); i++) {
            text = compounds.get(i).display();
            System.out.println(text);
            for (int j = 0; j < animals.size(); j++) {
                if (animals.get(j).getCoId() == compounds.get(i).getId()) {
                    text = animals.get(j).display();
                    System.out.println(text);
                }
            }
            for (int j = 0; j < staff.size(); j++) {
                if (staff.get(j).getCrId() == compounds.get(i).getStId()) {
                    text = staff.get(j).display();
                    System.out.println(text);
                }
            }
        }
        System.out.println("------------------------------\n");
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
    public void insertAnimal() {
        id = this.animals.size() + 1;
        System.out.println("Bitte ein Alter angeben:");
        age = INPUT.nextInt();
        System.out.println("Bitte das Geschlecht angeben:");
        text = INPUT.next();
        sex = text.charAt(0);
        System.out.println("Bitte die Spezies angeben:");
        String species = INPUT.next();
        System.out.println("Bitte die Tierart angeben:");
        String type = INPUT.next();
        System.out.println("Bitte die Unterbringung angeben:");
        coId = INPUT.nextInt();
        animals.add(new Animals(id, age, sex, species,
                type, coId));
    }

    @Override
    public void insertCompound() {
        id = compounds.size() + 1;
        System.out.println("Anzahl Gebäude: " +id);
        System.out.println("Bitte den Namen der Unterbringung angeben:");
        type = INPUT.next();
        System.out.println("""
                            1 - Land
                            2 - Wasser
                            3 - Luft
                            4 - Land, Wasser
                            5 - Land, Luft
                            6 - Wasser, Luft
                            7 - Land, Wasser, Luft
                            """);
        System.out.println("Bitte die Art der Unterbringung angeben:");
        habitat = INPUT.nextInt();
        System.out.println("Bitte die maximale Anzahl an Bewohner angeben:");
        maxResidents = INPUT.nextInt();
        System.out.println("Bitte geben Sie den Pfleger an:");
        stId = INPUT.nextInt();
        compounds.add(new Compound(id, type,
                habitat, maxResidents, stId));
    }

    @Override
    public void insertStaff() {
        id = this.staff.size() + 1;
        System.out.println("Bitte den Vornamen eingeben: ");
        firstName = INPUT.next();
        System.out.println("Bitte den Nachnamen eingeben: ");
        lastName = INPUT.next();
        System.out.println("Bitte das Alter eingeben: ");
        age = INPUT.nextInt();
        System.out.println("Bitte die Pflegeart eingeben: ");
        responsibility = INPUT.next();
        staff.add(new Staff(id, age,sex,firstName,
                lastName, responsibility));
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
            choice = INPUT.nextInt() - 1;
            if (choice < compounds.size()) {
                compoundChange(choice);
            } else {
                System.out.println("Keine Unterbringung mit dieser ID vorhanden!");
            }
        } else if (type == "animals") {
            System.out.println("Welches Tier ändern?");
            choice = INPUT.nextInt() - 1;
            if (choice < animals.size()) {
                animalChange(choice);
            } else {
                System.out.println("Kein Tier mit dieser ID vorhanden!");
            }
        } else {
            System.out.println("Welchen Mitarbeiter ändern?");
            choice = INPUT.nextInt() - 1;
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
            choice = INPUT.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Bitte geben Sie die Art der Pflege an:");
                    text = INPUT.next();
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

    private void animalChange(int choice) {
        x = choice;
        System.out.println("Tier:");
        text = animals.get(x).display();
        System.out.println(text);
        System.out.println("Was möchten Sie ändern?");
        do {
            System.out.println("1 - Unterbringung wechseln");
            System.out.println("2 - weiter");
            System.out.println("Ihre Auswahl:");
            choice = INPUT.nextInt();
            int id;
            switch (choice) {
                case 1:
                    System.out.println("Bitte geben Sie die ID der Unterbringung an:");
                    id = INPUT.nextInt();
                    if (id < compounds.size()) {
                        animals.get(x).setCoId(id);
                    } else {
                        System.out.println("Diese Unterbringung existiert nicht!");
                    }
                    tryAgain = false;
                    break;
                case 2:
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
        System.out.println("Möchten Sie den Pfleger wechseln?");

        do {
            System.out.println("1 - wechseln");
            System.out.println("2 - weiter");
            System.out.println("Ihre Auswahl:");
            choice = INPUT.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Bitte geben Sie die Id des Pflegers an:");
                    id = INPUT.nextInt();
                    compounds.get(x).setStId(id);
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
        switch (type) {
            case "compounds":
                System.out.println("Bitte Id der zu löschenden Unterbringung eingeben:");
                id = INPUT.nextInt();
                if (id == 0) {
                    System.out.println("Id 0 nicht zu löschen!");
                    break;
                }
                for (int i = 0; i < compounds.size(); i++) {
                    if (compounds.get(i).getId() == id) {
                        compounds.remove(i);
                    }
                }
                for (int i = 0; i < animals.size(); i++) {
                    if (animals.get(i).getCoId() == id) {
                        animals.get(i).setCoId(0);
                    }
                }
                break;
            case "animals":
                System.out.println("Bitte Id des zu löschenden Tieres eingeben:");
                id = INPUT.nextInt();
                for (int i = 0; i < animals.size(); i++) {
                    if (animals.get(i).getCrId() == id) {
                        animals.remove(i);
                    }
                }
                break;
            case "staff":
                System.out.println("Bitte Id des zu löschenden Mitarbeiters eingeben:");
                id = INPUT.nextInt();
                if (id == 0) {
                    System.out.println("Id 0 nicht zu löschen!");
                    break;
                }
                for (int i = 0; i < staff.size(); i++) {
                    if (staff.get(i).getCrId() == id) {
                        staff.remove(i);
                    }
                }
                for (int i = 0; i < compounds.size(); i++) {
                    if (compounds.get(i).getStId() == id) {
                        compounds.get(i).setStId(0);
                    }
                }
                break;
            default:
                System.out.println("Keine Gültige Eingabe!");
        }
    }
}
