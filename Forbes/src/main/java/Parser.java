import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class Parser {
	public static List<Billionaire> parseCSV(String path) {
		// Список миллиардеров
		List<Billionaire> billionaires = new ArrayList<Billionaire>();
		
		// Создаю reader для чтения csv файла
		try (CSVReader reader = new CSVReader(new FileReader(path))) {
			// Список значений по каждому столбцу
            String[] nextLine;
            // Пропуск заголовков
            reader.readNext();
            
            while ((nextLine = reader.readNext()) != null) {
            	// Преобразуем данные из списка в нужный формат
                Billionaire billionaire = new Billionaire(
                    Integer.parseInt(nextLine[0]),
                    nextLine[1],
                    Double.parseDouble(nextLine[2]),
                    Integer.parseInt(nextLine[3]),
                    nextLine[4],
                    nextLine[5],
                    nextLine[6]
                );
                
                // Добавляем Billionaire в список
                billionaires.add(billionaire);
            }
        } 
		catch (Exception e) {
            e.printStackTrace();
        }
		
        return billionaires;
	}
}
