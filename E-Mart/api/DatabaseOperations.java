import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseOperations {
    public static void main(String[] args) {
        String dbURL = "jdbc:sqlserver://DESKTOP-6HHM08L:1433;databaseName=ecommerceapp";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(dbURL);

            if (connection != null) {
                System.out.println("Connected to the database!");

                // Example: Execute a simple query to fetch data from the products table
                String sqlQuery = "SELECT * FROM products";
                PreparedStatement statement = connection.prepareStatement(sqlQuery);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    int productId = resultSet.getInt("product_id");
                    String productName = resultSet.getString("product_name");
                    double price = resultSet.getDouble("price");

                    System.out.println("Product ID: " + productId + ", Name: " + productName + ", Price: " + price);
                }

                resultSet.close();
                statement.close();
                connection.close();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error connecting to the database.");
            e.printStackTrace();
        }
    }
}
