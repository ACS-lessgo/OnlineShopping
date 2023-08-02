import java.math.BigDecimal;
import java.sql.*;

public class HsqlDatabaseExample {
    public static final String DB_URL = "jdbc:hsqldb:hsql://localhost/xdb"; // Replace "xdb" with your database name
    public static final String DB_USER = "SA";
    public static final String DB_PASSWORD = "";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Step 1: Establish a connection
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);


            // Step 4: Retrieve data from the table
            String selectDataQuery = "SELECT * FROM products";
            try (Statement selectStatement = connection.createStatement()) {
                ResultSet resultSet = selectStatement.executeQuery(selectDataQuery);
                while (resultSet.next()) {
                    int productId = resultSet.getInt("product_id");
                    String productName = resultSet.getString("product_name");
                    String description = resultSet.getString("description");
                    String category = resultSet.getString("category");
                    BigDecimal price = resultSet.getBigDecimal("price");
                    int quantityInStock = resultSet.getInt("quantity_in_stock");
                    String brand = resultSet.getString("brand");
                    String imageUrl = resultSet.getString("image_url");
                    BigDecimal rating = resultSet.getBigDecimal("rating");

                    System.out.println("Product ID: " + productId);
                    System.out.println("Product Name: " + productName);
                    System.out.println("Description: " + description);
                    System.out.println("Category: " + category);
                    System.out.println("Price: " + price);
                    System.out.println("Quantity in Stock: " + quantityInStock);
                    System.out.println("Brand: " + brand);
                    System.out.println("Image URL: " + imageUrl);
                    System.out.println("Rating: " + rating);
                    System.out.println();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the connection after use
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
