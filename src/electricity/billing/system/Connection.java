package electricity.billing.system;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connection {

    java.sql.Connection connection;
    Statement statement;

    public Connection(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/electric","root","");
            statement = connection.createStatement();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
