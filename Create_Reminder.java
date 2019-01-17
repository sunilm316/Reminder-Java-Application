import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class CreateReminder extends JFrame {

	private JPanel contentPane;
	private JTextField textdate;
	private JTextField texttime;
	private JTextField textid;
	private JTextField rembef;
	private JTextField textnote;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateReminder frame = new CreateReminder();
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
	public CreateReminder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 624, 434);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 608, 72);
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblCreateNewReminder = new JLabel("Create New Reminder");
		lblCreateNewReminder.setForeground(Color.WHITE);
		lblCreateNewReminder.setFont(new Font("Wide Latin", Font.BOLD, 18));
		lblCreateNewReminder.setBounds(108, 11, 465, 50);
		panel.add(lblCreateNewReminder);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 72, 608, 323);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Time");
		lblNewLabel.setBounds(41, 130, 133, 38);
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 27));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel_1.add(lblNewLabel);

		JLabel label = new JLabel("Date");
		label.setBounds(41, 63, 133, 38);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Sylfaen", Font.BOLD, 27));
		panel_1.add(label);

		JLabel lblRemindBefore = new JLabel("Remind Before");
		lblRemindBefore.setBounds(41, 205, 193, 38);
		lblRemindBefore.setForeground(Color.WHITE);
		lblRemindBefore.setFont(new Font("Sylfaen", Font.BOLD, 27));
		panel_1.add(lblRemindBefore);

		JLabel lblNotes = new JLabel("Notes");
		lblNotes.setBounds(310, 63, 133, 38);
		lblNotes.setForeground(Color.WHITE);
		lblNotes.setFont(new Font("Sylfaen", Font.BOLD, 27));
		panel_1.add(lblNotes);

		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reminder","root","");  
					PreparedStatement ps=con.prepareStatement("insert into reminderlist values(?,?,?,?,?)");
					ps.setString(1, textid.getText());
					ps.setString(2, textdate.getText());
					ps.setString(3, texttime.getText());
					ps.setString(4, rembef.getText());
					ps.setString(5, textnote.getText());
					ps.execute();
					JOptionPane.showMessageDialog(null, "Saved Successfully","Reminder",JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					// TODO: handle exception
				}

			}
		});
		btnNewButton.setBounds(485, 272, 102, 40);
		panel_1.add(btnNewButton);

		textdate = new JTextField();
		textdate.setBounds(127, 74, 133, 20);
		panel_1.add(textdate);
		textdate.setColumns(10);

		texttime = new JTextField();
		texttime.setColumns(10);
		texttime.setBounds(127, 141, 133, 20);
		panel_1.add(texttime);

		JLabel lblId = new JLabel("ID");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Sylfaen", Font.BOLD, 27));
		lblId.setBounds(41, 11, 133, 38);
		panel_1.add(lblId);

		textid = new JTextField();
		textid.setColumns(10);
		textid.setBounds(127, 22, 133, 20);
		panel_1.add(textid);

		rembef = new JTextField();
		rembef.setBounds(233, 216, 56, 20);
		panel_1.add(rembef);
		rembef.setColumns(10);

		textnote = new JTextField();
		textnote.setBounds(309, 103, 278, 146);
		panel_1.add(textnote);
		textnote.setColumns(10);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Reminds();
			}

		});
		btnBack.setBounds(355, 272, 102, 40);
		panel_1.add(btnBack);
	}
}
