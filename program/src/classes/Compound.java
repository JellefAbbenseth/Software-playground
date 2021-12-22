package classes;

public class Compound {
    private int coId;
    private String type;
    private int habitat;
    private int maxResidents;
    private int stId;
    private String information = "";

    public Compound(int coId, String type, int habitat, int maxResidents, int stId) {
        this.coId = coId;
        this.type = type;
        this.habitat = habitat;
        this.maxResidents = maxResidents;
        this.stId = stId;
    }

    public String display() {
        information = String.format("""
                                    Unterbringung: %s
                                    Art der Unterbringung: %s
                                    Lebensraum: %s
                                    Maximale Bewohner: %s
                                    Pfleger: %s
                                    """,
                coId,
                type,
                habitat,
                maxResidents,
                stId);
        return information;
    }

    public void setStId(int stId) {
        this.stId = stId;
    }

    public int getId() {
        return coId;
    }
}
