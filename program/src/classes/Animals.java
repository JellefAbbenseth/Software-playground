package classes;

import java.util.ArrayList;

public class Animals extends Creatures {
    private String information;
    private String species;
    private String type;
    private int compound;
    private int paID;            // PartnerID
    private ArrayList<Integer> chId;          // KinderID

    public Animals(int anId, int age, char sex, String species, String type, int coId,
                   int paId, ArrayList<Integer> chId) {
        super(anId, age, sex);
        this.species = species;
        this.type = type;
        this.compound = coId;
        this.paID = paId;
        this.chId = chId;
        this.information = "";
    }

    @Override
    public String display() {
//        System.out.println("Tier: " +super.getCrId());
//        System.out.println("Tierart: " +type);
//        System.out.println("Spezies: " +species);
//        System.out.println("Geburtsdatum: " +super.getBirthDate());
//        System.out.println("Alter: " +super.getAge());
//        System.out.println("Geschlecht: " +super.getSex());
//        System.out.println("Unterbringung: " + compound);
//        if(paID == 0){
//            System.out.println("Partner:\n - kein Partner");
//        } else {
//            System.out.println("Partner: " + paID);
//        }
//        System.out.println("Kinder:");
//        if (chId.size() == 0) {
//            System.out.println(" - keine Kinder");
//        }
//        for (int child  : chId) {
//            System.out.println(" - " +child);
//        }
        information = String.format("Tier: %s\n" +
                                    "Tierart: %d\n" +
                                    "Spezies: %s\n" +
                                    "Geburtsdatum: %d\n" +
                                    "Alter: %d\n" +
                                    "Geschlecht: %s" +
                                    "Unterbringung: %d\n",
                                    super.getCrId(), type, species, super.getBirthDate(),
                                    super.getAge(), super.getSex(), compound);
        if(paID == 0){
            information += "Partner:\n - kein Partner\n";
        } else {
            information += String.format("Partner: %d\n", paID);
        }
        information += "Kinder:\n";
        if (chId.size() == 0) {
            information += " - keine Kinder\n";
        }
        for (int child  : chId) {
            information += String.format(" - %d", child);
        }
        return information;
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
