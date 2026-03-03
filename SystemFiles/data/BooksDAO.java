package data;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logical.User;

public class BooksDAO {

	//create table if not exists
	public static void createBookTable() throws SQLException {
        var sql = "CREATE TABLE IF NOT EXISTS book ("
                + "	isbn varchar PRIMARY KEY,"
                + "	title varchar NOT NULL,"
                + "	description varchar,"
                + " times_read varchar,"
                + " times_read_description varchar"
                + ");";
        
        try (var conn = DriverManager.getConnection("jdbc:sqlite:/home/" + User.getUser() + "/JavaApps/BookCatalouge/database.db"); var stmt = conn.createStatement()) {
        	stmt.execute(sql);
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        
	}
	
	public static void addBooks(String isbn,String title,String description,String timesRead,String timesReadDescription) {
		var sql = "INSERT INTO book(isbn, title, description, times_read, times_read_description) VALUES (?,?,?,?,?)";
		
		try (var conn = DriverManager.getConnection("jdbc:sqlite:/home/" + User.getUser() + "/JavaApps/BookCatalouge/database.db"); var stmt = conn.prepareStatement(sql)) {
			
			stmt.setString(1, isbn);
			stmt.setString(2, title);
			stmt.setString(3, description);
			stmt.setString(4, timesRead);
			stmt.setString(5, timesReadDescription);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
        	e.printStackTrace();
        }
	}
	
	public static List<String> getAllBooksTitle() {		
		var sql = "SELECT title, isbn FROM book";
		List<String> books = new ArrayList<String>();
		
		try (var conn = DriverManager.getConnection("jdbc:sqlite:/home/" + User.getUser() + "/JavaApps/BookCatalouge/database.db"); var stmt = conn.createStatement(); 
				var rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				books.add(rs.getString("title").toString());
			} 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}
	
	
	public static void removeBook(String title) {
		var sql =  "DELETE FROM book WHERE title = ?";
		
		try (var conn = DriverManager.getConnection("jdbc:sqlite:/home/" + User.getUser() + "/JavaApps/BookCatalouge/database.db"); var stmt = conn.prepareStatement(sql)) {
			
			stmt.setString(1, title);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void editBook(String isbn,String title,String description,String timesRead,String timesReadDescription) {
		var sql =  "UPDATE book SET title = ?,description = ?,times_read = ?,times_read_description = ? WHERE isbn = ?";
		
		try (var conn = DriverManager.getConnection("jdbc:sqlite:/home/" + User.getUser() + "/JavaApps/BookCatalouge/database.db"); var stmt = conn.prepareStatement(sql)) {
			
			stmt.setString(5, isbn);
			stmt.setString(1, title);
			stmt.setString(2, description);
			stmt.setString(3, timesRead);
			stmt.setString(4, timesReadDescription);
			
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<String> searchBook(String title) {
		var sql = "SELECT * FROM book WHERE title = ?";
		List<String> books = new ArrayList<String>();
		
		try (var conn = DriverManager.getConnection("jdbc:sqlite:/home/" + User.getUser() + "/JavaApps/BookCatalouge/database.db"); var stmt = conn.prepareStatement(sql)) {
			
			stmt.setString(1, title);
			
			var rs = stmt.executeQuery();
			
			while (rs.next()) {
				books.add(rs.getString("isbn"));
				books.add(rs.getString("title"));
				books.add(rs.getString("description"));
				books.add(rs.getString("times_read"));
				books.add(rs.getString("times_read_description"));
			} 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}
}
