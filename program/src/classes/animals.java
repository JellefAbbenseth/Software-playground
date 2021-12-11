package classes;

public class animals extends creatures{
    private String species;
    private String type;
    private int habitat;
    private int paID;            // PartnerID
    private int[] chId;          // KinderID

    public animals(int anId, int age, char sex, String species, String type, int habitat,
                   int paId, int[] chId) {
        super(anId, age, sex);
        this.species = species;
        this.type = type;
        this.habitat = habitat;
        this.paID = paId;
        this.chId = chId;
    }

    @Override
    public void display() {
        System.out.println("Tier: " +super.getCrId());
        System.out.println("Tierart: " +type);
        System.out.println("Spezies: " +species);
        System.out.println("Geburtsdatum: " +super.getBirthDate());
        System.out.println("Alter: " +super.getAge());
        System.out.println("Geschlecht: " +super.getSex());
        System.out.println("Lebensraum: " + habitat);
        if(paID == 0){
            System.out.println("Partner:");
        } else {
            System.out.println("Partner: " + paID);
        }
        System.out.println("Kinder:");
        for (int child  : chId) {
            System.out.println(" - " +child);
        }
    }
}
