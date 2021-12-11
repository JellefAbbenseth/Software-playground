public class zoo_administration {
    public static void main(String[] args) {
        System.out.println("Programmstart!");

        classes.animals[] animals = {new classes.animals(1, 5, 'm', "Säugetier",
                "Löwe", 5, 0, new int[]{})};

        animals[0].display();
        System.out.println("---------------------------------");

        classes.staff[] mitarbeiter = {new classes.staff(1, 24,'m',"Tom",
                "Schneider", "Pflege")};
        mitarbeiter[0].display();
        System.out.println("---------------------------------");

        classes.compound[] compounds = {new classes.compound(1, "Raubtierhaus",
                5, new String[]{"Pflege", "Fütterung"})};
        compounds[0].display();

        System.out.println("Programmende!");
    }
}
