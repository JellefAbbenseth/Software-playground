package connectors;

import classes.Animals;
import classes.Compound;
import classes.Staff;
import interfaces.ZooAdmDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    public Animals getAnimals() {
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

        insertQuery = "SELECT * FROM family";
        try {
            PreparedStatement selectCommand = sqlConnection.prepareStatement(insertQuery);
            ResultSet ergebnisZeile = selectCommand.executeQuery();
            while (ergebnisZeile.next()) {
                faIds.add(ergebnisZeile.getInt("faId"));
                anIds.add(ergebnisZeile.getInt("anId"));
                hierarchies.add(ergebnisZeile.getString("hierarchy"));
            }
            selectCommand.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        // Lösung finden für das Problem der Zuteilung der Familienmitglieder!!

        int fId = 0;
        int fatherId = 0;
        int motherId = 0;
        for (int i = 0; i < faIds.size(); i++) {
            fId = faIds.get(i);
            for (int j = 0; j < faIds.size(); j++) {
                if (fId == faIds.get(j)) {
                    if (hierarchies.equals("father")) {
                        fatherId = anIds.get(j);
                    } else if (hierarchies.equals("mother")) {
                        motherId = anIds.get(j);
                    }
                } else {
                    break;
                }
            }
            for (int j = 0; j < animals.size(); j++) {
                if (animals.get(j).getCrId() == anIds.get(i)) {
                    if ("m".equals(animals.get(j).getSex())) {
                        animals.get(j).setPaID(motherId);
                    }
                    if ("w".equals(animals.get(j).getSex())) {
                        animals.get(j).setPaID(fatherId);
                    }
                }
            }
        }


        return null;
    }

    @Override
    public Staff getStaff() {
        return null;
    }

    @Override
    public Compound getCompound() {
        return null;
    }

    @Override
    public boolean writeAll(Animals animals, Compound compounds, Staff staff) {
        return false;
    }
}
