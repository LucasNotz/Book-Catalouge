package logical;
//didnt even use
public class Books {
	//Class attributes
	private String bookName = "";
	private String isbn = "";
	private String bookDescription = "";
	private String timesRead = "";
	private String timesReadDescription = "";
	
	//Constructors
	public Books() {
		super();
	}

	public Books(String bookName, String isbn, String bookDescription, String timesRead, String timesReadDescription) {
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

	public String getTimesRead() {
		return timesRead;
	}

	public void setTimesRead(String timesRead) {
		this.timesRead = timesRead;
	}

	public String getTimesReadDescription() {
		return timesReadDescription;
	}

	public void setTimesReadDescription(String timesReadDescription) {
		this.timesReadDescription = timesReadDescription;
	}
	
	
}
