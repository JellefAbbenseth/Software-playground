package classes;

import java.util.ArrayList;

public class animals extends creatures{
    private String species;
    private String type;
    private int compound;
    private int paID;            // PartnerID
    private ArrayList<Integer> chId;          // KinderID

    public animals(int anId, int age, char sex, String species, String type, int coId,
                   int paId, ArrayList<Integer> chId) {
        super(anId, age, sex);
        this.species = species;
        this.type = type;
        this.compound = coId;
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
        System.out.println("Unterbringung: " + compound);
        if(paID == 0){
            System.out.println("Partner:\n - kein Partner");
        } else {
            System.out.println("Partner: " + paID);
        }
        System.out.println("Kinder:");
        if (chId.size() == 0) {
            System.out.println(" - keine Kinder");
        }
        for (int child  : chId) {
            System.out.println(" - " +child);
        }
    }

    public void setCompound(int compound) {
        this.compound = compound;
    }

    public int getCompound() {
        return compound;
    }

    public void setPaID(int paID) {
        this.paID = paID;
    }

    public int getPaID() {
        return paID;
    }

    public void newChild(int chId) {
        this.chId.add(chId);
    }

    public ArrayList<Integer> getChId() {
        return chId;
    }
}
