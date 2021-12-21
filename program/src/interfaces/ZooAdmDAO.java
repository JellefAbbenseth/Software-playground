package interfaces;

import java.util.List;

public interface ZooAdmDAO {
    // Read
    public classes.Animals getAnimals();
    public classes.Staff getStaff();
    public classes.Compound getCompound();

    // Write
    public boolean writeAll(classes.Animals animals, classes.Compound compounds, classes.Staff staff);
}
