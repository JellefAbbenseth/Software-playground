import classes.Animals;
import classes.Compound;
import classes.Staff;

import java.util.ArrayList;

public class ZooAdministration {
    public static void main(String[] args) {
        String text;
        System.out.println("Programmstart!");
    // Change the arrays to arraylists ?!
        ArrayList<Integer> childrenIds = new ArrayList<>();
        ArrayList<Animals> animals = new ArrayList<>();
        animals.add(new Animals(1, 5, 'm', "Säugetier",
                "Löwe", 1, 0, childrenIds));

        text = animals.get(0).display();
        System.out.println(text);
        System.out.println("---------------------------------");

        ArrayList<Staff> mitarbeiter = new ArrayList<>();
        mitarbeiter.add(new Staff(1, 24,'m',"Tom",
                "Schneider", "Reinigung"));
        text = mitarbeiter.get(0).display();
        System.out.println(text);
        System.out.println("---------------------------------");

        ArrayList<String> cares = new ArrayList<>();
        cares.add("Pflege");
        cares.add("Fütterung");
        ArrayList<Compound> compounds = new ArrayList<>();
        compounds.add(new Compound(1, "Raubtierhaus",
                1, 5, cares));
        text = compounds.get(0).display();
        System.out.println(text);
        System.out.println("Programmende!");
    }
}
