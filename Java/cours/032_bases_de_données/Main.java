import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/*
jdbc:mysql://localhost:3306/fv_database?useSSL=false
*/

public class Main
{
    public static void main(String args[])
    {
        try
        {
            Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/fv_database?useSSL=false", "root", "");
            PreparedStatement stmt = co.prepareStatement("UPDATE products SET product_name = ? WHERE product_name = ?");

            stmt.setString(1,"Ordinateur portable Lenovo");
            stmt.setString(2,"Nikon D5600"); 
            stmt.executeUpdate();

            co.close();
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
    }
}