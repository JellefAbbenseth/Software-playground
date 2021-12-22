import classes.Animals;
import classes.Compound;
import classes.Staff;
import connectors.SQLZooData;
import connectors.UserSystemInterface;
import interfaces.ZooAdmDAO;

import java.util.ArrayList;

public class ZooAdministration {

    private static ZooAdmDAO zooAdmin = new SQLZooData();
    private static connectors.UserSystemInterface userInterface;

    public static void main(String[] args) {
        System.out.println("Programmstart!");

        ArrayList<classes.Animals> animals = zooAdmin.getAnimals();
        ArrayList<classes.Compound> compounds = zooAdmin.getCompound();
        ArrayList<classes.Staff> staff = zooAdmin.getStaff();
        userInterface = new UserSystemInterface(animals, staff, compounds, zooAdmin);
        userInterface.menu();

        System.out.println("Programmende!");
    }
}
