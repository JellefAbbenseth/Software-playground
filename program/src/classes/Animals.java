package classes;

public class Animals extends Creatures {
    private String information;
    private String species;
    private String type;
    private int compound;

    public Animals(int anId, int age, char sex, String species, String type, int coId) {
        super(anId, age, sex);
        this.species = species;
        this.type = type;
        this.compound = coId;
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
        return information;
    }

    public void setCompound(int compound) {
        this.compound = compound;
    }

    public int getCompound() {
        return compound;
    }
}
