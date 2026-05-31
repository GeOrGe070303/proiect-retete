import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;

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

    public static ArrayList<Reteta> getTopRetete() {

        ArrayList<Reteta> rezultate = new ArrayList<>();

        try(Connection conn = Baza.getConnection()) {

            Statement st = conn.createStatement();

            ResultSet ingredienteUser =
                    st.executeQuery("SELECT ingredient FROM inserare");

            ArrayList<String> ingrediente = new ArrayList<>();

            while(ingredienteUser.next()) {
                ingrediente.add(
                        ingredienteUser.getString("ingredient")
                );
            }

            ResultSet rs =
                    st.executeQuery("SELECT * FROM retete");

            ArrayList<Reteta> toate = new ArrayList<>();

            while(rs.next()) {

                String[] ingredienteReteta =
                        rs.getString("ingrediente").split(",");

                int scor = 0;

                for(String ingredientUser : ingrediente) {
                    for(String ingredientReteta : ingredienteReteta) {

                        if(ingredientUser.trim().equals(ingredientReteta.trim())) {
                            scor++;
                        }
                    }
                }

                toate.add(
                        new Reteta(
                                rs.getInt("poza"),
                                rs.getString("denumire"),
                                rs.getString("ingrediente"),
                                rs.getString("descriere"),
                                rs.getInt("timp"),
                                rs.getString("pasi"),
                                scor
                        )
                );
            }

            toate.sort((a,b) ->
                    Integer.compare(b.getPotriviri(), a.getPotriviri()));

            for(int i=0;i<Math.min(3,toate.size());i++) {
                rezultate.add(toate.get(i));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return rezultate;
    }
}
