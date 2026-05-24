import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ComenziSQL {
    public static void clearIngredients() {
        try (Connection conn = Baza.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("DELETE FROM inserare");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addIngredient(String ingredient) {
        try (Connection conn = Baza.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO inserare(ingredient) VALUES (?)")) {
            ps.setString(1, ingredient);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
