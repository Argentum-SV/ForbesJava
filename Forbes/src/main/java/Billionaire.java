
public class Billionaire {
	private int rank; // Место в топе
	private String name; // Имя
	private double networth; // Состояние в миллиардах
	private int age; // Возраст 
	private String country; // Страна проживания
	private String source; // Компании
	private String industry; // Отрасль
	
	// Конструктор класса Billionaire
	public Billionaire(int rank, String name, double networth, int age, String country, String source, String industry) {
		this.rank = rank;
		this.name = name;
		this.networth = networth;
		this.age = age;
		this.country = country;
		this.source = source;
		this.industry = industry;
	}
	
	// Геттеры и сеттеры
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getNetworth() {
		return networth;
	}

	public void setNetworth(double networth) {
		this.networth = networth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}
}
