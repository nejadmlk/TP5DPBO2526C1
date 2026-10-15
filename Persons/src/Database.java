import java.sql.*;

public class Database {
    private Connection connection;
    private Statement statement;

    // constructor
    public Database() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_people",
                    "root",
                    ""
            );
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // digunakan untuk SELECT
    public ResultSet selectQuery(String sql) {
        try {
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // digunakan untuk UPDATE, INSERT, DELETE
    public int insertUpdateDeleteQuery(String sql) {
        try {
            return statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // getter connection
    public Connection getConnection() {
        return connection;
    }

    // getter statement
    public Statement getStatement() {
        return statement;
    }
}