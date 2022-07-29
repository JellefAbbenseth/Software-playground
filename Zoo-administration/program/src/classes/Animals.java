package classes;

public class Animals extends Creatures {
    private String information;
    private String species;
    private String type;
    private int coId;

    public Animals(int anId, int age, char sex, String species, String type, int coId) {
        super(anId, age, sex);
        this.species = species;
        this.type = type;
        this.coId = coId;
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
                coId);
        return information;
    }

    public void setCoId(int coId) {
        this.coId = coId;
    }

    public int getCoId() {
        return coId;
    }

    public String getSpecies() {
        return species;
    }

    public String getType() {
        return type;
    }
}
