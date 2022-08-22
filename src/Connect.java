import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Connect {
    Scanner sc = new Scanner(System.in);
    private final String url = "jdbc:postgresql://localhost:5432/praktik";
    private final String user = "postgres";
    private final String password = "abdutokt2004";

    public Connection connection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public List<Product> productList() {
        List<Product> products = new ArrayList<>();
        String sql = "select * from \"auction\".products ";
        try (PreparedStatement preparedStatement = connection().prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("ID"));
                product.setName(resultSet.getString("NAME"));
                product.setHonoraryCode(resultSet.getInt("HONORARY_CODE"));
                product.setPrice(resultSet.getInt("PRICE"));
                product.setState(resultSet.getString("STATE"));
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
}
