package dao.impl;


import dao.ContactDao;
import model.Contact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBContactDao implements ContactDao {

    private static final String DB_URL = "jdbc:h2:tcp://localhost/~/Program";
    private static final String USER = "Test";
    private static final String PASSWORD = "";

    public DBContactDao() {

        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't connect to DB");

        }
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement st = connection.createStatement()) {
            st.execute(
                    "CREATE TABLE IF NOT  EXISTS CLIENT(ID INT AUTO_INCREMENT PRIMARY KEY, NAME VARCHAR(255), AGE INT);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void saveContact(Contact contact) {
        try (Connection connection = DriverManager
                .getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement st = connection.prepareStatement("INSERT INTO CLIENT(NAME, AGE) VALUES(?, ?);")) {

            st.setString(1, contact.getName());
            st.setInt(2, contact.getAge());
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteContact() {
    }


    @Override
    public void editContact(Contact contact){
        try (Connection connection = DriverManager
                .getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement st = connection.prepareStatement(
                             "UPDATE " + TABLE +" NAME = ?, PHONENUMBER = ?, AGE = ?, ADDRESS = ?;")){
            st.setString(1, contact.getName());
            st.setString(2, contact.getPhoneNumber());
            st.setInt(2, contact.getAge());
            st.setString(4, contact.getAddress());
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }


    @Override
    public ArrayList<Contact> findContact(String searchName){
        if (!contactList.isEmpty()) contactList.clear();

        int lengthSearch = searchName.length();
        String query = "SELECT * FROM " + 
                " WHERE UPPER(SUBSTR(NAME,1," + lengthSearch + ")) =  '" + searchName.toUpperCase() + "';";

        selectContact(query);
        return contactList;
    }


    @Override
    public List<Contact> showAll() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement st = connection.createStatement()) {
            List<Contact> clients = new ArrayList<>();
            try (ResultSet resultSet = st.executeQuery("SELECT * FROM CLIENT;")) {
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    clients.add(new Contact(name, age));
                }
            }
            return clients;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
