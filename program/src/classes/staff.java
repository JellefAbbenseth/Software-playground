package classes;

public class staff extends creatures {
    private String firstName;
    private String lastName;
    private String responsibility;

    public staff(int stId, int age, char sex, String firstName, String lastName,
                 String responsibility) {
        super(stId, age, sex);
        this.firstName = firstName;
        this.lastName = lastName;
        this.responsibility = responsibility;
    }

    @Override
    public void display() {
        System.out.println("Pflege/r: " +super.getCrId());
        System.out.println("Vorname: " +firstName);
        System.out.println("Nachname: " +lastName);
        System.out.println("Geburtsdatum: " +super.getBirthDate());
        System.out.println("Alter: " +super.getAge());
        System.out.println("Geschlecht: " +super.getSex());
        System.out.println("Pflegeart: " + responsibility);
    }
}
