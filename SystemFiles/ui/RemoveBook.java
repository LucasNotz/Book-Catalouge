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

public class RemoveBook extends JFrame{
	
	private JList<String> chooseBookList = new JList<String>();
	private DefaultListModel<String> dlm = new DefaultListModel<String>();
	private JScrollPane listScroll = new JScrollPane(chooseBookList);
	
	private JButton removeButton = new JButton("Delete Book");
	
	public RemoveBook(DefaultListModel<String> booksDLM, JList<String> booksList) {
		setTitle("Delete Book");
		setSize(300, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		listScroll.setBounds(20,20,260, 280);
		for(String book : BooksDAO.getAllBooksTitle()) {
			dlm.addElement(book);
		}
		chooseBookList.setModel(dlm);
		add(listScroll);
		
		removeButton.setBounds(100, 320, 100, 30);
		add(removeButton);
		
		removeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				
				int confirmDeleteBook = JOptionPane.showConfirmDialog(null, "Delete Book?", "Confirm", JOptionPane.YES_NO_OPTION);
				if (confirmDeleteBook == JOptionPane.YES_OPTION) {
					BooksDAO.removeBook(chooseBookList.getSelectedValue().toString());
				}
				
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
