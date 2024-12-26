import java.sql.SQLException;
import java.util.List;

public class Main {
	public static void main(String[] args) throws SQLException {
		// Путь к файлу и БД
		String path = "Forbes.csv";
		DataBase db = new DataBase();
		
		// Извлекаем из CSV файла список миллиардеров
        List<Billionaire> billionaires = Parser.parseCSV(path);
        
        // Создаем БД
        db.initializeDatabase();
        
        // Добавляем в БД данные
        for (Billionaire billionaire : billionaires) {
        	db.insertBillionaire(billionaire);
        }
        
        // Рещение 3 задач
        CapitalByCountry.get();
        System.out.println(YoungestBillionaireFromFrance.get());
        System.out.println(LargestCapitalUsaEnergy.get());
    }
}
