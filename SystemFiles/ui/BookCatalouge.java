package ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import data.database;
import logical.User;

public class BookCatalouge extends JFrame {
	
	//Main 
	public static void main(String[] args) throws IOException {
		
		//set up storage place for all files
		File theFolder = new File("/home/" + User.getUser() + "/JavaApps/BookCatalouge");
		System.out.println("/home/" + User.getUser() + "/JavaApps/BookCatalouge");
			if (!theFolder.exists()){
				theFolder.mkdirs();
			}
			
		//db files
		File databaseFile = new File("/home/" + User.getUser() + "/JavaApps/BookCatalouge/database.db");
		if (!databaseFile.exists()) {
			databaseFile.createNewFile();
		}
		
		//Set looks for project
		for(LookAndFeelInfo lafInfo : UIManager.getInstalledLookAndFeels()) {
			System.out.println(lafInfo.getClassName());
		}
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//connect to database
		database.connect();
		
		//Start gui
		new BookCatalouge().setVisible(true);
		
	}
	
	//Class attributes
	private JLabel booksCatalougeLabel = new JLabel("Books Owned: ");
	private JLabel booksOptionsLabel = new JLabel("Options: ");
	
	private JList<String> booksList = new JList<String>();
	private JScrollPane booksScrollPane = new JScrollPane();
	private DefaultListModel<String> booksDLM = new DefaultListModel<String>();
	
	private JButton addBooksButton = new JButton("Add");
	private JButton removeBooksButton = new JButton("Remove");
	private JButton editBooksButon = new JButton("Edit");
	private JButton filterBooksButton= new JButton("Filter");
	
	//main gui constructor
	public BookCatalouge(){
		setTitle("Book Catalogue App");
		setSize(600, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		booksCatalougeLabel.setBounds(50,20,200,20);
		add(booksCatalougeLabel);
		
		booksList.setBounds(50, 50, 500, 500);
		add(booksList);
		
		booksOptionsLabel.setBounds(50,570, 200,20);
		add(booksOptionsLabel);
		
		addBooksButton.setBounds(50, 610, 100, 20);
		add(addBooksButton);
		
		removeBooksButton.setBounds(170, 610, 100, 20);
		add(removeBooksButton);
		
		editBooksButon.setBounds(290, 610, 100, 20);
		add(editBooksButon);
		
		filterBooksButton.setBounds(410, 610, 100, 20);
		add(filterBooksButton);
		
	}
}
