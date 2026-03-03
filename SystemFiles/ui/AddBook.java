package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import data.BooksDAO;

public class AddBook extends JFrame{
	
	private JLabel isbnLabel = new JLabel("isbn: ");
	private JLabel titleLabel = new JLabel("title: ");
	private JLabel descriptionLabel = new JLabel("description: ");
	private JLabel timesReadLabel = new JLabel("times read: ");
	private JLabel timesReadDescriptionLabel= new JLabel("details: ");
	
	private JTextField isbnField = new JTextField();
	private JTextField titleField = new JTextField();
	private JTextArea descriptionArea = new JTextArea();
	private JTextField timesReadField = new JTextField();
	private JTextArea timesReadDescriptionArea = new JTextArea();
	
	private JScrollPane descriptionScroll = new JScrollPane(descriptionArea);
	private JScrollPane timesReadDescriptionScroll = new JScrollPane(timesReadDescriptionArea);
	
	private JButton addButton = new JButton("Add Book");


	
	public AddBook(DefaultListModel<String> booksDLM, JList<String> booksList) {
		setTitle("New Book");
		setSize(400, 520);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		isbnLabel.setBounds(20,20,150,25);
		add(isbnLabel);
		isbnField.setBounds(60,22,280,25);
		add(isbnField);
		
		titleLabel.setBounds(20,50,150,25);
		add(titleLabel);
		titleField.setBounds(60,52,280,25);
		add(titleField);
		
		descriptionLabel.setBounds(20,80,150,25);
		add(descriptionLabel);
		descriptionScroll.setBounds(30,110,335,120);
		descriptionArea.setLineWrap(true);
		add(descriptionScroll);
		
		timesReadLabel.setBounds(20,240,150,25);
		add(timesReadLabel);
		timesReadField.setBounds(100,242,100,25);
		add(timesReadField);
		
		timesReadDescriptionLabel.setBounds(20,270,150,20);
		add(timesReadDescriptionLabel);
		timesReadDescriptionScroll.setBounds(30,300,335,120);
		timesReadDescriptionArea.setLineWrap(true);
		add(timesReadDescriptionScroll);
		
		addButton.setBounds(140,430, 100, 30);
		add(addButton);
		
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isbnField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Must input isbn");
					return;
				}
				if (titleField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Must input title");
					return;
				}
				if (isbnField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Must input isbn");
					return;
				}
				if (descriptionArea.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Must input book description");
					return;
				}
				if (timesReadField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Must input times read");
					return;
				}
				if (timesReadDescriptionArea.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Must input description for how many times read");
					return;
				}
				BooksDAO.addBooks(isbnField.getText(), titleField.getText(), descriptionArea.getText(), timesReadField.getText(), timesReadDescriptionArea.getText());
				
				booksList.removeAll();
				booksDLM.removeAllElements();
				
				for(String book : BooksDAO.getAllBooksTitle()) {
					booksDLM.addElement(book);
				}
				
				dispose();
			}
		});
	}
}
