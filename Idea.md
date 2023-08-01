# Test to add/delete product from dB
---
1. Create a Product model class representing the product structure:
```java
public class Product {
    private int id;
    private String name;
    private String type;
    private String image;
    private String description;

    // Constructors, getters, setters, etc.
}

```
---
2. Create a ProductDAO class to handle CRUD operations for products:

```java
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private Connection connection;

    public ProductDAO(Connection connection) {
        this.connection = connection;
    }

    public void addProduct(Product product) throws SQLException {
        String sql = "INSERT INTO products (name, type, image, description) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, product.getName());
            pstmt.setString(2, product.getType());
            pstmt.setString(3, product.getImage());
            pstmt.setString(4, product.getDescription());
            pstmt.executeUpdate();
        }
    }

    public void deleteProduct(int productId) throws SQLException {
        String sql = "DELETE FROM products WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, productId);
            pstmt.executeUpdate();
        }
    }

    public List<Product> getAllProducts() throws SQLException {
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM products";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setType(rs.getString("type"));
                product.setImage(rs.getString("image"));
                product.setDescription(rs.getString("description"));
                productList.add(product);
            }
        }
        return productList;
    }
}
```
---
3. Create a ProductService class to handle business logic and API integration:
```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ProductService {
    private ProductDAO productDAO;

    public ProductService(Connection connection) {
        this.productDAO = new ProductDAO(connection);
    }

    public void addProduct(Product product) throws SQLException {
        productDAO.addProduct(product);
    }

    public void deleteProduct(int productId) throws SQLException {
        productDAO.deleteProduct(productId);
    }

    public List<Product> getAllProducts() throws SQLException {
        return productDAO.getAllProducts();
    }

    // You can add other business logic and API integration methods here as needed
}

```
---
4. Finally, create a main class to test the functionality:
```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String dbURL = "jdbc:hsqldb:file:/path/to/your/database";
        String username = "your_username";
        String password = "your_password";

        try (Connection connection = DriverManager.getConnection(dbURL, username, password)) {
            ProductService productService = new ProductService(connection);

            // Add a new product
            Product newProduct = new Product();
            newProduct.setName("Product Name");
            newProduct.setType("Product Type");
            newProduct.setImage("product_image.jpg");
            newProduct.setDescription("Product Description");
            productService.addProduct(newProduct);

            // Get all products
            List<Product> products = productService.getAllProducts();
            for (Product product : products) {
                System.out.println(product.getName() + " - " + product.getDescription());
            }

            // Delete a product (assuming product with ID 1 exists)
            productService.deleteProduct(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```
---
