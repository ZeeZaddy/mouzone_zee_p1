package com.revature.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * <p>This ConnectionFactory class follows the Singleton Design Pattern and facilitates obtaining a connection to a Database for the ERS application.</p>
 * <p>Following the Singleton Design Pattern, the provided Constructor is private, and you obtain an instance via the {@link ConnectionFactory#getInstance()} method.</p>
 */
public class ConnectionFactory {

    private static ConnectionFactory instance = null;
    private static Properties dbProps;
    private ConnectionFactory() {
        super();


        dbProps =  new Properties();
        InputStream props = ConnectionFactory.class.getClassLoader().getResourceAsStream("connection.properties");


        // to test this we have to have a try and catch statement

        try {
            dbProps.load(props);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
    /**
     *
     * <p>This method follows the Singleton Design Pattern to restrict this class to only having 1 instance.</p>
     * <p>It is invoked via:</p>
     *
     * {@code ConnectionFactory.getInstance()}
     *  “Synchronized” is the keyword that provides your code with the ability to allow only a single thread to operate on it without interference from any other thread during that period.
     */
    public static synchronized ConnectionFactory getInstance() {
        if(instance == null) {
            instance = new ConnectionFactory();
        }

        return instance;
    }

    /**
     * <p>The {@link ConnectionFactory#getConnection()} method is responsible for leveraging a specific Database Driver to obtain an instance of the {@link java.sql.Connection} interface.</p>
     * <p>Typically, this is accomplished via the use of the {@link java.sql.DriverManager} class.</p>
     */
    public Connection getConnection() {


        Connection conn = null;
        try {
            Class.forName(dbProps.getProperty("driver"));
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        // Get the credentials needed to access the DB from the Properties Object we created above (which gets those from the connection.properties)
        String url = dbProps.getProperty("url");
        String username = dbProps.getProperty("username");
        String password = dbProps.getProperty("password");

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    // the below code is to manually test - don't put this in your project or keep it here.
//    public static void main(String[] args) {
//
//        Connection connection = getInstance().getConnection();
//        try {
//            if (connection != null) {
//                System.out.println("Connection Successful");
//                connection.close();
//            }
//            else {
//                System.out.println("Something went wrong..");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

}