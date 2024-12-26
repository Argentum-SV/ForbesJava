import java.sql.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class CapitalByCountry {
    public static void get() {
    	// Запрос SQL, который группирует строки по country и считает сумму networth
        String sql = "SELECT country, SUM(networth) AS TotalCapital FROM Billionaires GROUP BY country";
        
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:forbes.db");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
        	
        	// Датасет откуда буду брать данные для графика
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            
            // Заполняю датасет
            while (rs.next()) {
                dataset.addValue(rs.getDouble("TotalCapital"), "networth", rs.getString("country"));
            }
            
            // График
            JFreeChart barChart = ChartFactory.createBarChart(
                "Капитал по стране",
                "Страна",
                "Капитал, млрд",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false
            );
            
            // Отображаем график (к сожалению названия стран не будут видны из-за их количества)
            ChartPanel chartPanel = new ChartPanel(barChart);
            javax.swing.JFrame frame = new javax.swing.JFrame();
            
            // Параметры для графика
            frame.setContentPane(chartPanel);
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
