package classes;

public class compound {
    private int coId;
    private String type;
    private int habitat;
    private String[] care;

    public compound(int coId, String type, int habitat, String[] care) {
        this.coId = coId;
        this.type = type;
        this.habitat = habitat;
        this.care = care;
    }


    public void display() {
        System.out.println("Unterbringung!");
    }

}
