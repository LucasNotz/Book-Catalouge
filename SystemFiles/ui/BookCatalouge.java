package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import data.BooksDAO;
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
		
		//test if book table exists
		try {
			BooksDAO.createBookTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Start gui
		new BookCatalouge().setVisible(true);
		
		
		
	}
	
	//Class attributes
	private JLabel booksCatalougeLabel = new JLabel("Books Owned: ");
	private JLabel booksOptionsLabel = new JLabel("Options: ");
	
	private JList<String> booksList = new JList<String>();
	private JScrollPane booksScrollPane = new JScrollPane(booksList);
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
		
		for(String book : BooksDAO.getAllBooksTitle()) {
			booksDLM.addElement(book);
		}
		
		booksScrollPane.setBounds(50, 50, 500, 500);
		booksList.setModel(booksDLM);
		add(booksScrollPane);
		
		booksOptionsLabel.setBounds(50,570, 200,20);
		add(booksOptionsLabel);
		
		//add
		addBooksButton.setBounds(50, 610, 100, 20);
		add(addBooksButton);
		
		addBooksButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddBook(booksDLM, booksList).setVisible(true);
				
			}
		});
		
		//remove
		removeBooksButton.setBounds(170, 610, 100, 20);
		add(removeBooksButton);
		
		removeBooksButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new RemoveBook(booksDLM, booksList).setVisible(true);
				
			}
		});
		
		//edit
		editBooksButon.setBounds(290, 610, 100, 20);
		add(editBooksButon);
		
		editBooksButon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(String book : BooksDAO.getAllBooksTitle()) {
					booksDLM.addElement(book);
				}
				
				new EditBook(booksDLM, booksList,booksDLM.getElementAt(booksList.getSelectedIndex())).setVisible(true);
				
			}
		});
	}
}
