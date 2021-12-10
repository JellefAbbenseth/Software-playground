package classes;

public class animals extends creatures{
    private String species;
    private String type;
    private int habitat;
    private int pid;
    private int[] did;

    public animals(int anId, int actualDate, int age, char sex, String species, String type, int habitat,
                   int pid, int[] did) {
        super(anId, actualDate, age, sex);
        this.species = species;
        this.type = type;
        this.habitat = habitat;
        this.pid = pid;
        this.did = did;
    }

    @Override
    public void display() {
        System.out.println("Tier!");
    }
}
