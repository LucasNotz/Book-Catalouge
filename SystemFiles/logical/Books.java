package logical;

public class Books {
	//Class attributes
	private String bookName = "";
	private String isbn = "";
	private String bookDescription = "";
	private int timesRead = 0;
	private String timesReadDescription = "";
	
	//Constructors
	public Books() {
		super();
	}

	public Books(String bookName, String isbn, String bookDescription, int timesRead, String timesReadDescription) {
		super();
		this.bookName = bookName;
		this.isbn = isbn;
		this.bookDescription = bookDescription;
		this.timesRead = timesRead;
		this.timesReadDescription = timesReadDescription;
	}

	//Access methods
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public int getTimesRead() {
		return timesRead;
	}

	public void setTimesRead(int timesRead) {
		this.timesRead = timesRead;
	}

	public String getTimesReadDescription() {
		return timesReadDescription;
	}

	public void setTimesReadDescription(String timesReadDescription) {
		this.timesReadDescription = timesReadDescription;
	}
	
	
}
