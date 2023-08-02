import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MSSQLConnectionExample {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:sqlserver://DESKTOP-6HHM08L:1433;databaseName=ecommerceapp";

        try (Connection connection = DriverManager.getConnection(jdbcUrl)) {
            System.out.println("Connected to Microsoft SQL Server successfully!");

            // Perform database operations here...
            // Example: Selecting data from a table
            String sqlQuery = "SELECT * FROM products;";
            try (Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(sqlQuery)) {
                while (resultSet.next()) {
                    // Process the data here
                    int product_id = resultSet.getInt("id");
                    String product_name = resultSet.getString("name");
                    // ... (assuming 'id' and 'name' are columns in your_table_name)
                    System.out.println("id: " + product_id + ", name: " + product_name);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
