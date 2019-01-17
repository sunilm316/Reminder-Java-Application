import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicTreeUI.SelectionModelPropertyChangeHandler;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reminds {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reminds window = new Reminds();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Reminds() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 624, 434);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 608, 72);
		panel.setBackground(Color.gray);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPersonalReminderSetter = new JLabel("Personal Reminder Setter");
		lblPersonalReminderSetter.setForeground(new Color(255, 255, 255));
		lblPersonalReminderSetter.setFont(new Font("Wide Latin", Font.BOLD, 18));
		lblPersonalReminderSetter.setBounds(96, 11, 465, 50);
		panel.add(lblPersonalReminderSetter);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(148, 0, 211));
		panel_1.setBounds(0, 72, 608, 323);
		panel_1.setBackground(Color.BLACK);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnCreateNew = new JButton("Create New");
		btnCreateNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new CreateReminder().setVisible(true);
			}
		});
		btnCreateNew.setBackground(new Color(128, 128, 128));
		btnCreateNew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
				CreateReminder c=new CreateReminder();
				c.setVisible(true);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCreateNew.setBackground(Color.gray);
	
			
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCreateNew.setBackground(Color.white);
			}
		});
		btnCreateNew.setBounds(405, 46, 141, 42);
		btnCreateNew.setFocusable(false);
		panel_1.add(btnCreateNew);
		
		JButton btnUpdateExisting = new JButton("Update Existing");
		btnUpdateExisting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new UpdateReminder().setVisible(true);
			}
		});
		btnUpdateExisting.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				UpdateReminder c=new UpdateReminder();
				c.setVisible(true);
				
			}
		});
		btnUpdateExisting.setBounds(405, 119, 141, 42);
		btnUpdateExisting.setFocusable(false);
		panel_1.add(btnUpdateExisting);
		
		JButton btnDeleteExisting = new JButton("View Existing");
		btnDeleteExisting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new ViewReminder().setVisible(true);
			}
		});
		btnDeleteExisting.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				ViewReminder c=new ViewReminder();
				c.setVisible(true);
			}
		});
		btnDeleteExisting.setBounds(405, 201, 141, 42);
		btnDeleteExisting.setFocusable(false);
		panel_1.add(btnDeleteExisting);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\sourab\\Downloads\\icons8-planner-96.png"));
		lblNewLabel.setBounds(135, 95, 124, 121);
		panel_1.add(lblNewLabel);
	}
}
