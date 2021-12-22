package interfaces;

import classes.Animals;
import classes.Compound;
import classes.Staff;

import java.util.ArrayList;

public interface ZooAdmDAO {
    // Read
    public ArrayList<Animals> getAnimals();
    public ArrayList<Staff> getStaff();
    public ArrayList<Compound> getCompound();

    // Write
    public boolean writeAll(classes.Animals animals, classes.Compound compounds, classes.Staff staff);
}
