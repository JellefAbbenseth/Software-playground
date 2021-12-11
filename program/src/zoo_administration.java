import java.util.ArrayList;

public class zoo_administration {
    public static void main(String[] args) {
        System.out.println("Programmstart!");
    // Change the arrays to arraylists ?!
        classes.animals[] animals = {new classes.animals(1, 5, 'm', "Säugetier",
                "Löwe", 5, 0, new int[]{})};

        animals[0].display();
        System.out.println("---------------------------------");

        classes.staff[] mitarbeiter = {new classes.staff(1, 24,'m',"Tom",
                "Schneider", "Pflege")};
        mitarbeiter[0].display();
        System.out.println("---------------------------------");

        ArrayList<String> cares = new ArrayList<>();
        cares.add("Pflege");
        cares.add("Fütterung");
        classes.compound[] compounds = new classes.compound[10];
        compounds[0] = new classes.compound(1, "Raubtierhaus",
                5, 5, cares);
        compounds[0].display();

        System.out.println("Programmende!");
    }
}
