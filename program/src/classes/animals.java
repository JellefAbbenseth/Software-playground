package classes;

public class animals extends creatures{
    private String species;
    private String type;
    private String habitat;
    private int pid;
    private int[] did;

    public animals(int cid, int actualDate, int age, char sex, String species, String type, String habitat,
                   int pid, int[] did) {
        super(cid, actualDate, age, sex);
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
