package classes;

public class staff extends creatures {
    private String firstName;
    private String lastName;
    private String responsibility;

    public staff(int stId, int actualDate, int age, char sex, String firstName, String lastName,
                 String responsibility) {
        super(stId, actualDate, age, sex);
        this.firstName = firstName;
        this.lastName = lastName;
        this.responsibility = responsibility;
    }

    @Override
    public void display() {
        System.out.println("Mitarbeiter!");
    }
}
