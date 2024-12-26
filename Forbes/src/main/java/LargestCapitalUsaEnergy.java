import java.sql.*;

public class LargestCapitalUsaEnergy {
	public static String get() {
		// Запрос SQL. Упорядочиваем по убыванию капиатла, фильтруем по стране ()
		String sql = "SELECT name, source FROM Billionaires WHERE country = 'United States' AND industry = 'Energy ' ORDER BY networth DESC LIMIT 1";
		String result = null;
		
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:forbes.db");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                result = "Name: " + rs.getString("name") + "| Source: " + rs.getString("source");
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
	}
}
