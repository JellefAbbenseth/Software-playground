import java.util.ArrayList;

public class zoo_administration {
    public static void main(String[] args) {
        System.out.println("Programmstart!");
    // Change the arrays to arraylists ?!
        ArrayList<Integer> childrenIds = new ArrayList<>();
        ArrayList<classes.animals> animals = new ArrayList<>();
        animals.add(new classes.animals(1, 5, 'm', "Säugetier",
                "Löwe", 1, 0, childrenIds));

        animals.get(0).display();
        System.out.println("---------------------------------");

        ArrayList<classes.staff> mitarbeiter = new ArrayList<>();
        mitarbeiter.add(new classes.staff(1, 24,'m',"Tom",
                "Schneider", "Reinigung"));
        mitarbeiter.get(0).display();

        System.out.println("---------------------------------");

        ArrayList<String> cares = new ArrayList<>();
        cares.add("Pflege");
        cares.add("Fütterung");
        ArrayList<classes.compound> compounds = new ArrayList<>();
        compounds.add(new classes.compound(1, "Raubtierhaus",
                1, 5, cares));
        compounds.get(0).display();

        System.out.println("Programmende!");
    }
}
