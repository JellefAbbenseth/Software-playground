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
    public void writeAll(ArrayList<Animals> animals, ArrayList<Compound> compounds,
                         ArrayList<Staff> staff);
}
