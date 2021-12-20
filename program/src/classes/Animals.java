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
        information = String.format("""
                                    Tier: %s
                                    Tierart: %s
                                    Spezies: %s
                                    Geburtsdatum: %s
                                    Alter: %s
                                    Geschlecht: %s
                                    Unterbringung: %s
                                    """,
                super.getCrId(),
                type,
                species,
                super.getBirthDate(),
                super.getAge(),
                super.getSex(),
                compound);
        if(paID == 0){
            information += "Partner:\n - kein Partner\n";
        } else {
            information += String.format("Partner: %s\n", paID);
        }
        information += "Kinder:\n";
        if (chId.size() == 0) {
            information += " - keine Kinder\n";
        }
        for (int child  : chId) {
            information += String.format(" - %s", child);
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
