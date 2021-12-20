package classes;

public class Staff extends Creatures {
    private String firstName;
    private String lastName;
    private String responsibility;
    private String information;

    public Staff(int stId, int age, char sex, String firstName, String lastName,
                 String responsibility) {
        super(stId, age, sex);
        this.firstName = firstName;
        this.lastName = lastName;
        this.responsibility = responsibility;
        this.information = "";
    }

    @Override
    public String display() {
        information = String.format("""
                                    Pflege/r: %s
                                    Vorname: %s
                                    Nachname: %s
                                    Geburtsdatum: %s
                                    Alter: %s
                                    Geschlecht: %s
                                    Pflegeart: %s
                                    """,
                super.getCrId(),
                firstName,
                lastName,
                super.getBirthDate(),
                super.getAge(),
                super.getSex(),
                responsibility);
        return information;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }
}
