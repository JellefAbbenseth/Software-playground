package connectors;

import classes.Animals;
import classes.Compound;
import classes.Staff;
import interfaces.ZooAdmDAO;

import java.sql.*;
import java.util.ArrayList;

public class SQLZooData implements ZooAdmDAO {
    ArrayList<Animals> animals;
    ArrayList<Compound> compounds;
    ArrayList<Staff> staff;

    private String sqlDriver     = "com.mysql.cj.jdbc.Driver";
    private String sqlServer     = "localhost";
    private String sqlServerPort = "3306";
    private String sqlUser       = "zooverwaltung";
    private String sqlPassword   = "zooverwaltung";
    private String sqlDatabase   = "java_zooverwaltung";

    private Connection sqlConnection = null;

    public SQLZooData() {
        try {
            Class.forName(sqlDriver);
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Treiber konnte nicht gefunden werden :(");
            System.exit(-1);
        }
        openConnection();
    }

    private void openConnection() {
        try {
            closeConnection();
            sqlConnection = DriverManager.getConnection(
                    "jdbc:mysql://" + sqlServer + ":" + sqlServerPort + "/" + sqlDatabase,
                    sqlUser, sqlPassword
            );
            sqlConnection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println("Problem beim Aufbau der Datenbankverbindung");
        }
    }

    private void closeConnection() {
        try {
            if (sqlConnection != null)
                sqlConnection.close();
        } catch (SQLException e) {
            // do nothing
        }
        sqlConnection = null;
    }

    @Override
    public ArrayList<Animals> getAnimals() {
        animals = new ArrayList<>();
        ArrayList<Integer> childrenIds = new ArrayList<>();
        ArrayList<Integer> faIds = new ArrayList<>();
        ArrayList<Integer> anIds = new ArrayList<>();
        ArrayList<String> hierarchies = new ArrayList<>();

        /*
            Arraylist<Animals>:
            - animals (anId, age, sex, species, type, coId, paId, children)
            DB:
            - animals (anId, age, sex, species, type, coId)
                -> erstellen des neuen Eintrags
            - family (faId, anId, hierarchy)
                -> hinzufügen in bestehende Arraylist
         */

        String insertQuery = "SELECT * FROM animals";
        int x = 0;
        try {
            PreparedStatement selectCommand = sqlConnection.prepareStatement(insertQuery);
            ResultSet ergebnisZeile = selectCommand.executeQuery();
            while (ergebnisZeile.next()) {
                int anId = ergebnisZeile.getInt("anId");
                int age = ergebnisZeile.getInt("age");
                char sex = ergebnisZeile.getString("sex").charAt(0);
                String species = ergebnisZeile.getString("species");
                String type = ergebnisZeile.getString("type");
                int coId = ergebnisZeile.getInt("coId");
                // new animal
                animals.add(new Animals(anId, age, sex, species,
                        type, coId, 0, childrenIds));
                x++;
            }
            selectCommand.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("TestAnimals:");
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i).display());
        }
        System.out.println(x);

        insertQuery = "SELECT faId FROM family";
        try {
            x = 0;
            PreparedStatement selectCommand = sqlConnection.prepareStatement(insertQuery);
            ResultSet ergebnisZeile = selectCommand.executeQuery();
            while (ergebnisZeile.next()) {
                if (x < ergebnisZeile.getInt("faId")) {
                    x = ergebnisZeile.getInt("faId");
                }
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        System.out.println("Anzahl: " + x);
        if (x > 0) {
            for (int i = 0; i < x; i++) {
                ArrayList<Integer> children = new ArrayList<>();
                int fatherId = 0;
                int motherId = 0;
                String text = "SELECT anId, hierarchy FROM family WHERE faId = " + (i + 1);
                insertQuery = text;
                try {
                    PreparedStatement selectCommand = sqlConnection.prepareStatement(insertQuery);
                    ResultSet ergebnisZeile = selectCommand.executeQuery();
                    while (ergebnisZeile.next()) {
                        if (ergebnisZeile.getString("hierarchy").equals("father")) {
                            fatherId = ergebnisZeile.getInt("anId");
                        } else if (ergebnisZeile.getString("hierarchy").equals("mother")) {
                            motherId = ergebnisZeile.getInt("anId");
                        } else {
                            children.add(ergebnisZeile.getInt("anId"));
                        }
                    }
                    selectCommand.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                System.out.println(children);

                for (int j = 0; j < animals.size(); j++) {
                    if (fatherId == animals.get(j).getCrId()) {
                        animals.get(j).setPaID(motherId);
                        System.out.println("wife added");
                        for (int k = 0; k < children.size(); k++) {
                            System.out.println("child added");
                            animals.get(j).newChild(children.get(k));
                        }
                    }
                    else if (motherId == animals.get(j).getCrId()) {
                        animals.get(j).setPaID(fatherId);
                        System.out.println("husband added");
                        for (int k = 0; k < children.size(); k++) {
                            animals.get(j).newChild(children.get(k));
                        }
                    }
                }
            }
        }
        System.out.println("TestAnimals after adding children:");
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i).display());
        }
        return null;
    }

    @Override
    public ArrayList<Staff> getStaff() {
        return null;
    }

    @Override
    public ArrayList<Compound> getCompound() {
        return null;
    }

    @Override
    public boolean writeAll(Animals animals, Compound compounds, Staff staff) {
        return false;
    }
}
