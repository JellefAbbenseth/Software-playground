package interfaces;

public interface UserInterfaceDAO {
    // Create UserInterface (System output or GUI, ... )
    /*
        Headline and Start of program
        Create interface / "open" system output
        Show menu
        Wait for User action
    */
    // Introduction
    /*
        Show Menu:
            1 Show all
            2 Add animals/compounds/staff
            3 change compound
            4 delete animals/compounds/staff
     */
    public void menu();

    // Create
    public void insertAnimal();
    public void insertCompound();
    public void insertStaff();

    // Read
    public void objectRead(String type);

    // Update
    public void updateObject(String type);

    // Delete
    public void deleteObject(String type);
}
