import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Baza{
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                date.LOCALIZARE,
                date.NUMEUTILIZATOR,
                date.PAROLA
        );
    }
}