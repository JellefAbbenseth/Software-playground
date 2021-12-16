package connectors;

import classes.Animals;
import classes.Compound;
import classes.Staff;
import interfaces.ZooAdmDAO;

import java.sql.*;
import java.util.List;

public class SQLZooData implements ZooAdmDAO {
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
    public boolean insertAnimal(Animals animals) {
        return false;
    }

    @Override
    public boolean insertCompound(Compound compound) {
        return false;
    }

    @Override
    public boolean insertStaff(Staff staff) {
        return false;
    }

    @Override
    public Animals getAnimalsById(int Id) {
        return null;
    }

    @Override
    public Staff getStaffById(int Id) {
        return null;
    }

    @Override
    public Compound getCompoundById(int Id) {
        return null;
    }

    @Override
    public List<Object> getAll() {
        return null;
    }

    @Override
    public void updateAnimals(int Id, Animals animals) {

    }

    @Override
    public void updateStaff(int Id, Staff staff) {

    }

    @Override
    public void updateCompound(int Id, Compound compound) {

    }

    @Override
    public void deleteCompound(int Id) {

    }

    @Override
    public void deleteAnimalsResident(int Id) {

    }

    @Override
    public void deleteStaff(int Id) {

    }
}
