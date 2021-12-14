package interfaces;

import java.util.List;

public interface ZooAdmDAO {
    // Create
    public boolean insertAnimal(classes.Animals animals);
    public boolean insertCompound(classes.Compound compound);
    public boolean insertStaff(classes.Staff staff);

    // Read
    public classes.Animals getAnimalsById(int Id);
    public classes.Staff getStaffById(int Id);
    public classes.Compound getCompoundById(int Id);
    public List<Object> getAll();

    // Update
    public void updateAnimals(int Id, classes.Animals animals);
    public void updateStaff(int Id, classes.Staff staff);
    public void updateCompound(int Id, classes.Compound compound);

    // Delete
    public void deleteCompound(int Id);         // Delete compound and change animals to homeless animals
    public void deleteAnimalsResident(int Id);  // Delete the residents and change animals to homeless animals
    public void deleteStaff(int Id);            // Delete the staff
}
