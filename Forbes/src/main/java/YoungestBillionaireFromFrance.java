import java.sql.*;

public class YoungestBillionaireFromFrance {
	public static String get() {
		// Запрос SQL для поиска самого молодого миллиардера из Франции
		String sql = "SELECT name FROM Billionaires WHERE country = 'France' AND networth > 10 ORDER BY age ASC LIMIT 1";
		String name = null;
		
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:forbes.db");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                name = rs.getString("name");
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        
		return name;
	}
}
