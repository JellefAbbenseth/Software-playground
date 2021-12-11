package classes;

public class compound {
    private int coId;
    private String type;
    private int habitat;
    private String[] cares;

    public compound(int coId, String type, int habitat, String[] cares) {
        this.coId = coId;
        this.type = type;
        this.habitat = habitat;
        this.cares = cares;
    }

    public void display() {
        System.out.println("Unterbringung: " +coId);
        System.out.println("Art der Unterbringung: " +type);
        System.out.println("Lebensraum: " + habitat);
        System.out.println("Pflegeart:");
        for (String care : cares) {
            System.out.println(" - " +care);
        }
    }
}
