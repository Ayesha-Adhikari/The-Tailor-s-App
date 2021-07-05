package Tailor_app;
import java.awt.EventQueue;
import java.sql.*;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tailor_app {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tailor_app window = new Tailor_app();
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
	public Tailor_app() {
		initialize();
		Connect();
		table_load();
	}
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public void Connect()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/tailor_db", "root", "");
		}
		catch(ClassNotFoundException ce)
		{
			ce.printStackTrace();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}

	public void table_load()
	{
		try {
			ps = con.prepareStatement("select * from measurement");
			rs = ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}
	


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1101, 599);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1087, 562);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel heading = new JLabel("The Tailor's App");
		heading.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 34));
		heading.setHorizontalAlignment(SwingConstants.CENTER);
		heading.setBounds(10, 0, 1077, 56);
		panel.add(heading);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "MEASUREMENTS", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(0, 146, 438, 380);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Length");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblNewLabel.setBounds(0, 11, 181, 40);
		panel_1.add(lblNewLabel);
		
		JTextPane l = new JTextPane();
		l.setBounds(191, 11, 240, 40);
		panel_1.add(l);
		
		JTextPane c = new JTextPane();
		c.setBounds(191, 70, 240, 40);
		panel_1.add(c);
		
		JTextPane w = new JTextPane();
		w.setBounds(191, 134, 240, 40);
		panel_1.add(w);
		
		JTextPane s = new JTextPane();
		s.setBounds(191, 197, 240, 40);
		panel_1.add(s);
		
		JTextPane a = new JTextPane();
		a.setBounds(191, 259, 240, 40);
		panel_1.add(a);
		
		JTextPane h = new JTextPane();
		h.setBounds(191, 328, 240, 40);
		panel_1.add(h);
		
		JLabel lblNewLabel_1 = new JLabel("Chest");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(0, 70, 181, 40);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Waist");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(0, 134, 181, 40);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Shoulder");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(0, 197, 181, 40);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Arm");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(0, 259, 181, 40);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Hip");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(0, 328, 181, 40);
		panel_1.add(lblNewLabel_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 45, 432, 90);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblName.setBounds(10, 0, 126, 40);
		panel_2.add(lblName);
		
		JTextPane cust_name = new JTextPane();
		cust_name.setBounds(160, 0, 242, 40);
		panel_2.add(cust_name);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setFont(new Font("Rockwell", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String length, chest, waist, shoulder,arm, hip, name;
				
				length = l.getText();
				chest = c.getText();
				waist = w.getText();
				shoulder = s.getText();
				arm = a.getText();
				hip = h.getText();
				
				name = cust_name.getText();
				

				try {
					ps = con.prepareStatement("insert into customers(name) values(?) ");
					ps.setString(1, name);
					ps.executeUpdate();
					
					ps = con.prepareStatement("insert into measurement(name, length, chest, waist, shoulder, arm, hip) values(?,?,?,?,?,?,?)");
					ps.setString(1, name);
					ps.setString(2,length);
					ps.setString(3,chest);
					ps.setString(4,waist);
					ps.setString(5,shoulder);
					ps.setString(6, arm);
					ps.setString(7, hip);
					
					ps.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Details Added!");
					table_load();
					cust_name.setText("");
					l.setText("");
					c.setText("");
					w.setText("");
					s.setText("");
					a.setText("");
					h.setText("");
					
					cust_name.requestFocus();
				}
				catch(SQLException se)
				{
					se.printStackTrace();
				}				
				
			}
		});
		btnNewButton.setBounds(160, 51, 97, 30);
		panel_2.add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = cust_name.getText();
				

				try {
					
					ps = con.prepareStatement("delete from measurement where name = ?");			
					ps.setString(1, name);
					
					ps.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Measurements Deleted!");
					table_load();
					cust_name.setText("");
					l.setText("");
					c.setText("");
					w.setText("");
					s.setText("");
					a.setText("");
					h.setText("");
					
					cust_name.requestFocus();
				}
				catch(SQLException se)
				{
					se.printStackTrace();
				}								
				
				
			}
		});
		btnDelete.setFont(new Font("Rockwell", Font.BOLD, 20));
		btnDelete.setBounds(293, 51, 109, 31);
		panel_2.add(btnDelete);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String name = cust_name.getText();
					ps = con.prepareStatement("select length, chest, waist, shoulder, arm, hip from measurement where name = ?");
					ps.setString(1,name);
					rs = ps.executeQuery();
					
					if( rs.next())
					{
						String len = rs.getString(1);
						String che = rs.getString(2);
						String wai = rs.getString(3);
						String sho = rs.getString(4);
						String arm = rs.getString(5);
						String hip = rs.getString(6);
						
						l.setText(len);
						c.setText(che);
						w.setText(wai);
						s.setText(sho);
						a.setText(arm);
						h.setText(hip);
						
					}
					else
					{
						cust_name.setText("");
						JOptionPane.showMessageDialog(null, "Name does not Exist!");
					}
				}
				catch(SQLException se)
				{
					se.printStackTrace();
				}
				
			}
		});
		btnSearch.setFont(new Font("Rockwell", Font.BOLD, 20));
		btnSearch.setBounds(27, 50, 109, 31);
		panel_2.add(btnSearch);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(448, 458, 629, 68);
		panel.add(panel_4);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					table_load();
					cust_name.setText("");
					l.setText("");
					c.setText("");
					w.setText("");
					s.setText("");
					a.setText("");
					h.setText("");
					JOptionPane.showMessageDialog(null, "Fields Cleareed");
					cust_name.requestFocus();
				
			}
		});
		btnClear.setFont(new Font("Rockwell", Font.BOLD, 20));
		btnClear.setBounds(49, 11, 102, 40);
		panel_4.add(btnClear);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String length, chest, waist, shoulder,arm, hip, name;
				
				length = l.getText();
				chest = c.getText();
				waist = w.getText();
				shoulder = s.getText();
				arm = a.getText();
				hip = h.getText();
				
				name = cust_name.getText();
				

				try {
					
					ps = con.prepareStatement("update measurement set length = ?, chest = ?, waist = ?, shoulder = ?, arm = ?, hip = ? where name = ?");			
					ps.setString(1, length);
					ps.setString(2, chest);
					ps.setString(3, waist);
					ps.setString(4, shoulder);
					ps.setString(5, arm);
					ps.setString(6, hip);
					ps.setString(7, name);
					
					ps.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Measurements Updated");
					table_load();
					cust_name.setText("");
					l.setText("");
					c.setText("");
					w.setText("");
					s.setText("");
					a.setText("");
					h.setText("");
					
					cust_name.requestFocus();
				}
				catch(SQLException se)
				{
					se.printStackTrace();
				}					
				
								
			}
		});
		btnUpdate.setFont(new Font("Rockwell", Font.BOLD, 20));
		btnUpdate.setBounds(233, 11, 126, 40);
		panel_4.add(btnUpdate);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Rockwell", Font.BOLD, 20));
		btnExit.setBounds(437, 11, 126, 40);
		panel_4.add(btnExit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(448, 86, 629, 349);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel unit = new JLabel("*all the measurements are in inches");
		unit.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		unit.setBounds(10, 537, 428, 25);
		panel.add(unit);
		
		JLabel unit_1 = new JLabel("*all the measurements are in inches");
		unit_1.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		unit_1.setBounds(449, 56, 428, 25);
		panel.add(unit_1);
	}
}
