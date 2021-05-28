package TestWeb;

import java.sql.*;

public class Database {

    private Connection connection;

    public Database() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:user.db");
    }

    public boolean searchForUser(String email, String password) throws SQLException {
        //select = search from = table name      ? = variable
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email=? AND password=?")) {
            //index of the ? -- starts at 1
            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            //resultSet is like a pointer of rows.
            return resultSet.next();
        }
    }

    public void addUser(String email, String password, String firstName, String lastName) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO users (email, password, firstname, lastname) VALUES(?,?,?,?)")) {
            statement.setString(1, email);
            statement.setString(2, password);
            statement.setString(3, firstName);
            statement.setString(4, lastName);
            statement.executeUpdate();
        }
    }

    public UserData getData(String email) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email=?")) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return new UserData(email, resultSet.getString("password"), resultSet.getString("firstname"), resultSet.getString("lastname"));
        }
    }

    public void editData(String email, String password, String firstName, String lastName) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE users set password=?, firstname=?, lastname=? WHERE email=?")) {
            statement.setString(1, password);
            statement.setString(2, firstName);
            statement.setString(3, lastName);
            statement.setString(4, email);
            statement.executeUpdate();
        }
    }


    public void close() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
