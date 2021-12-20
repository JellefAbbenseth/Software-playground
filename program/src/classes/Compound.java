package classes;

import java.util.ArrayList;

public class Compound {
    private int coId;
    private String type;
    private int habitat;
    private int maxResidents;
    private ArrayList<Integer> residents;
    private ArrayList<String> cares;
    private String information;

    public Compound(int coId, String type, int habitat, int maxResidents,ArrayList<Integer> residents, ArrayList<String> cares) {
        this.coId = coId;
        this.type = type;
        this.habitat = habitat;
        this.maxResidents = maxResidents;
        this.residents = residents;
        this.cares = cares;
        information = "";
    }

    public String display() {
        information = String.format("""
                                    Unterbringung: %s
                                    Art der Unterbringung: %s
                                    Lebensraum: %s
                                    Bewohner:
                                    """,
                coId,
                type,
                habitat);
        if(!residents.isEmpty()){
            for (Integer resident : residents){
                information += " - " + resident +"\n";
            }
        } else {
            information += " - keine Bewohner\n";
        }
        information += "Pflegeart:\n";
        if(!cares.isEmpty()){
            for (String care : cares) {
                information += " - " + care +"\n";
            }
        } else {
            information += " - aktuell nicht gepflegt/genutzt!";
        }
        return information;
    }

    public int getId() {
        return coId;
    }

    public boolean newResident(int anID) {
        if (residents.size() < maxResidents) {
            residents.add(anID);
            return true;
        }
        return false;
    }

    public ArrayList<Integer> getResidents() {
        return residents;
    }

    public boolean deleteResident(int anID){
        for (int i = 0; i < residents.size(); i++){
            if (residents.get(i).equals(anID)) {
                residents.remove(i);
                return true;
            }
        }
        return false;
    }

    public void newCares(String care) {
        cares.add(care);
    }

    public ArrayList<String> getCares() {
        return cares;
    }
}
