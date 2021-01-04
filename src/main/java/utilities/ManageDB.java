package utilities;

import java.sql.DriverManager;

public class ManageDB extends CommonOps
{
        /*
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    Method name: openConnection
    Method description: This method initiate the connection to the DB
    Method parameters: String (3)
    Method return: null */
    public static void openConnection(String dbURL, String user, String password)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbURL, user, password);
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error occurred while connecting to DB. See details: "+e);
        }
    }

        /*
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    Method name: closeConnection
    Method description: This method stop the connection to the DB
    Method parameters: null
    Method return: null */

    public static void closeConnection()
    {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Error occurred while closing connecting to DB. See details: "+e);
        }
    }
}
