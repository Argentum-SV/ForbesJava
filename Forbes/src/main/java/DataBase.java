import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Класс DataBase взял из ранее созданного проекта Users (работа, которую делали в течении семестра)
class DataBase {
    private static final String dbUrl = "jdbc:sqlite:forbes.db";
    
    // Если научным языком, то инициализируем, а так создаем Базу Данных с полями rank, name, networth, age, country, source, industry
    public void initializeDatabase() throws SQLException {
        try (Connection connection = DriverManager.getConnection(dbUrl); 
             Statement statement = connection.createStatement()) {
        	String createTableSQL = "CREATE TABLE IF NOT EXISTS Billionaires (" +
                                     "rank INTEGER, " +
                                     "name TEXT, " +
                                     "networth REAL, " +
                                     "age INTEGER, " +
                                     "country TEXT, " +
                                     "source TEXT, " +
                                     "industry TEXT);";
        	
        	statement.execute(createTableSQL);
        }
    }
    
    // Добавление Billionaire в базу данных
    public void insertBillionaire(Billionaire billionaire) throws SQLException {
        try (Connection connection = DriverManager.getConnection(dbUrl);
             PreparedStatement preparedStatement = connection.prepareStatement(
            		 "INSERT INTO Billionaires (rank, name, networth, age, country, source, industry) VALUES (?, ?, ?, ?, ?, ?, ?)"
            	);
        	) {
        	
        	// Добавляем данные в БД
            preparedStatement.setInt(1, billionaire.getRank());
            preparedStatement.setString(2, billionaire.getName());
            preparedStatement.setDouble(3, billionaire.getNetworth());
            preparedStatement.setInt(4, billionaire.getAge());
            preparedStatement.setString(5, billionaire.getCountry());
            preparedStatement.setString(6, billionaire.getSource());
            preparedStatement.setString(7, billionaire.getIndustry());
            
            // Обновляем БД, чтобы добавить данные в БД
            preparedStatement.executeUpdate();
        }
    }
    
    // Извлекаем записи из таблицы, преобразуя в список
    public List<Billionaire> fetchUsers() throws SQLException {
    	// Список миллиардеров
        List<Billionaire> billionaires = new ArrayList<>();
        
        try (Connection connection = DriverManager.getConnection(dbUrl);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Billionaires")) {

        	while (resultSet.next()) {
        		int rank = resultSet.getInt("rank");
        		String name = resultSet.getString("name");
        		double networth = resultSet.getDouble("networth");
        		int age = resultSet.getInt("age");
        		String country = resultSet.getString("country");
        		String source = resultSet.getString("source");
        		String industry = resultSet.getString("industry");

        		billionaires.add(new Billionaire(rank, name, networth, age, country, source, industry));
            }
        }
        
        return billionaires;
    }
}