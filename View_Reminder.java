import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTable;
import java.awt.Button;

public class ViewReminder extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewReminder frame = new ViewReminder();
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
	public ViewReminder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 624, 434);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 608, 72);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblCreateNewReminder = new JLabel("Delete Existing Reminder");
		lblCreateNewReminder.setForeground(Color.WHITE);
		lblCreateNewReminder.setFont(new Font("Wide Latin", Font.BOLD, 18));
		lblCreateNewReminder.setBounds(101, 11, 480, 50);
		panel.add(lblCreateNewReminder);

		table = new JTable();
		table.setBounds(50, 115, 501, 253);
		contentPane.add(table);


		Connection con = null;
		Statement st=null;
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reminder","root","");
			st = con.createStatement();
			ResultSet rs=st.executeQuery("select id,date,time,notes from reminderlist");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception e)
		{
		}
	}
}
