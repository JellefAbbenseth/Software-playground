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
    public ArrayList<Animals> getAnimals() {
        animals = new ArrayList<>();

        String insertQuery = "SELECT * FROM animals";
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
                        type, coId));
            }
            selectCommand.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return animals;
    }

    @Override
    public ArrayList<Staff> getStaff() {
        staff = new ArrayList<>();

        String insertQuery = "SELECT * FROM staff";
        try {
            PreparedStatement selectCommand = sqlConnection.prepareStatement(insertQuery);
            ResultSet ergebnisZeile = selectCommand.executeQuery();
            while (ergebnisZeile.next()) {
                int stId = ergebnisZeile.getInt("stId");
                int age = ergebnisZeile.getInt("age");
                char sex = ergebnisZeile.getString("sex").charAt(0);
                String firstName = ergebnisZeile.getString("firstName");
                String lastName = ergebnisZeile.getString("lastName");
                String responsibility = ergebnisZeile.getString("responsibility");
                // new animal
                staff.add(new Staff(stId, age, sex, firstName,
                        lastName, responsibility));
            }
            selectCommand.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return staff;
    }

    @Override
    public ArrayList<Compound> getCompound() {
        compounds = new ArrayList<>();

        String insertQuery = "SELECT * FROM compounds";
        try {
            PreparedStatement selectCommand = sqlConnection.prepareStatement(insertQuery);
            ResultSet ergebnisZeile = selectCommand.executeQuery();
            while (ergebnisZeile.next()) {
                int coId = ergebnisZeile.getInt("coId");
                String type = ergebnisZeile.getString("type");
                int haId = ergebnisZeile.getInt("haId");
                int maxResidents = ergebnisZeile.getInt("maxResidents");
                int stId = ergebnisZeile.getInt("stId");
                // new animal
                compounds.add(new Compound(coId, type, haId, maxResidents, stId));
            }
            selectCommand.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return compounds;
    }

    @Override
    public void writeAll(ArrayList<Animals> animals, ArrayList<Compound> compounds,
            ArrayList<Staff> staff) {
        String[] tableNames = {"animals", "compounds", "staff"};
        Savepoint deleteTransaction = null;
        try {
            deleteTransaction = sqlConnection.setSavepoint();
            for (String tableName : tableNames) {
                PreparedStatement deleteCommand = sqlConnection.prepareStatement(
                        "DELETE FROM " +  tableName);
                deleteCommand.executeUpdate();
            }
            sqlConnection.commit();
        } catch (SQLException e) {
            handleException(deleteTransaction, e, "Löschen");
        }

        writeAnimals(animals);
        writeCompounds(compounds);
        writeStaff(staff);
    }

    public void writeAnimals(ArrayList<Animals> animals) {
        List<String> insertQuery = new ArrayList<>();

        for (int i = 0; i < animals.size(); i++) {
            insertQuery.add("INSERT INTO animals (anId, age, sex, species, type, coId) VALUES ("
                    + animals.get(i).getCrId() +", " + animals.get(i).getAge() +", '"
                    + animals.get(i).getSex() +"', '" + animals.get(i).getSpecies() +"', '"
                    + animals.get(i).getType() +"', " + animals.get(i).getCoId() +")");
        }

        insert(insertQuery);
    }

    public void writeCompounds(ArrayList<Compound> compounds) {
        List<String> insertQuery = new ArrayList<>();

        for (int i = 0; i < compounds.size(); i++) {
            insertQuery.add("INSERT INTO compounds (coId, type, haId, maxResidents, stId) VALUES ("
                    + compounds.get(i).getId() +", '" + compounds.get(i).getType() +"', "
                    + compounds.get(i).getHaId() +", " + compounds.get(i).getMaxResidents() +", "
                    + compounds.get(i).getStId() +")");
        }

        insert(insertQuery);
    }

    public void writeStaff(ArrayList<Staff> staff) {
                List<String> insertQuery = new ArrayList<>();

        for (int i = 0; i < staff.size(); i++) {
            insertQuery.add("INSERT INTO staff (stId, age, sex, firstName, lastName, responsibility) VALUES ("
                    + staff.get(i).getCrId() +", " + staff.get(i).getAge() +", '"
                    + staff.get(i).getSex() +"', '" + staff.get(i).getFirstName() +"', '"
                    + staff.get(i).getLastName() +"', '" + staff.get(i).getResponsibility() +"')");
        }

        insert(insertQuery);
    }

    private void insert(List<String> insertQuery) {
        Savepoint insertTransaction = null;
        try {
            insertTransaction = sqlConnection.setSavepoint();
            Statement insertCommand = sqlConnection.createStatement();
            for (String cmd : insertQuery)
                insertCommand.execute(cmd);
            insertCommand.close();
            sqlConnection.commit();
        }
        catch (SQLException e) {
            handleException(insertTransaction, e, "Einfügen");
        }
    }

    private void handleException(Savepoint myTransaction, SQLException e, String msg) {
        System.err.println("Problem beim " + msg + " der Datensätze");
        e.printStackTrace();
        if (myTransaction != null) {
            try {
                sqlConnection.rollback(myTransaction);
            }
            catch (SQLException ignored) {}
        }
    }
}
