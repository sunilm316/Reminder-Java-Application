import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class UpdateReminder extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateReminder frame = new UpdateReminder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UpdateReminder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 624, 434);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 608, 72);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblCreateNewReminder = new JLabel("Update Reminder");
		lblCreateNewReminder.setForeground(Color.WHITE);
		lblCreateNewReminder.setFont(new Font("Wide Latin", Font.BOLD, 18));
		lblCreateNewReminder.setBounds(143, 11, 465, 50);
		panel.add(lblCreateNewReminder);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 72, 608, 323);
		contentPane.add(panel_1);

		JLabel label = new JLabel("Time");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Sylfaen", Font.BOLD, 27));
		label.setBounds(41, 130, 133, 38);
		panel_1.add(label);

		JLabel label_1 = new JLabel("Date");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Sylfaen", Font.BOLD, 27));
		label_1.setBounds(41, 63, 133, 38);
		panel_1.add(label_1);

		JLabel label_3 = new JLabel("Notes");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Sylfaen", Font.BOLD, 27));
		label_3.setBounds(310, 63, 133, 38);
		panel_1.add(label_3);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql= null;
					sql= textField_2.getText();
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reminder","root","");   
					Statement stmt=con.createStatement();
					String updateTableSQL = "UPDATE reminderlist SET date = ? WHERE id= ?";
					PreparedStatement preparedStatement = con.prepareStatement(updateTableSQL);
					preparedStatement.setString(1, textField.getText());
					preparedStatement.setString(2,sql);

					String updateTableSQL1 = "UPDATE reminderlist SET time = ? WHERE id= ?";
					PreparedStatement preparedStatement1 = con.prepareStatement(updateTableSQL1);
					preparedStatement1.setString(1, textField_1.getText());
					preparedStatement1.setString(2,sql);

					String updateTableSQL2 = "UPDATE reminderlist SET date = ? WHERE id= ?";
					PreparedStatement preparedStatement2 = con.prepareStatement(updateTableSQL2);
					preparedStatement2.setString(1, textField.getText());
					preparedStatement2.setString(2,sql);


					preparedStatement .executeUpdate();
					preparedStatement1 .executeUpdate();
					preparedStatement2 .executeUpdate();

					JOptionPane.showMessageDialog(null, "Updated Successfully","Voting System",JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}});
		btnUpdate.setBounds(485, 272, 102, 40);
		panel_1.add(btnUpdate);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(127, 74, 133, 20);
		panel_1.add(textField);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(127, 141, 133, 20);
		panel_1.add(textField_1);

		JLabel label_4 = new JLabel("ID");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Sylfaen", Font.BOLD, 27));
		label_4.setBounds(41, 11, 133, 38);
		panel_1.add(label_4);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(127, 22, 133, 20);
		panel_1.add(textField_2);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(309, 103, 278, 146);
		panel_1.add(textField_4);
	}

}
