package interfaces;

public interface UserInterfaceDAO {
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
