import java.math.BigDecimal;
import java.sql.*;

public class HsqlDatabaseExample2 {
    public static final String DB_URL = "jdbc:hsqldb:hsql://localhost/xdb"; // Replace "xdb" with your database name
    public static final String DB_USER = "SA";
    public static final String DB_PASSWORD = "";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Step 1: Establish a connection
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Step 2: Create an update query
            String updateDataQuery = "UPDATE products SET price = ? WHERE product_id = ?";

            // Step 3: Prepare the statement and set the parameters
            try (PreparedStatement updateStatement = connection.prepareStatement(updateDataQuery)) {
                // Set the new price and product ID for the update
                BigDecimal newPrice = new BigDecimal("1900.99");
                int productIdToUpdate = 1; // Replace with the actual product ID you want to update

                updateStatement.setBigDecimal(1, newPrice);
                updateStatement.setInt(2, productIdToUpdate);

                // Step 4: Execute the update
                int rowsAffected = updateStatement.executeUpdate();

                System.out.println(rowsAffected + " row(s) updated.");
            }

            // Step 5: Retrieve data from the table (same as in the original code)
            String selectDataQuery = "SELECT * FROM products";
            try (Statement selectStatement = connection.createStatement()) {
                ResultSet resultSet = selectStatement.executeQuery(selectDataQuery);
                while (resultSet.next()) {
                    // ... (same code as before to display the data)
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
            // Step 6: Close the connection after use
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