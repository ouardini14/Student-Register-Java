package Students;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.ComponentOrientation;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class AdminM extends JFrame {

	private JPanel contentPane;
	private JTextField CIN;
	private JTextField Name;
	private JTextField Ville;
	private JTextField Prenom;
	private JTextField Date;
	private JTextField CNE;
	private JTextField Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminM frame = new AdminM();
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
	public AdminM() {
		Connection conn = null;
		PreparedStatement pst8 = null;





		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(SystemColor.window);
		panel.setBounds(0, -32, 655, 421);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.controlDkShadow);
		panel_1.setBounds(0, 0, 126, 444);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblWelcomeAdmin = new JLabel("Welcome Admin");
		lblWelcomeAdmin.setForeground(Color.WHITE);
		lblWelcomeAdmin.setBounds(10, 37, 112, 30);
		panel_1.add(lblWelcomeAdmin);

		JButton Disconnect = new JButton("Disconnect");
		Disconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginM frames = new LoginM();
				frames.setVisible(true);
				dispose();



			}
		});
		Disconnect.setBounds(6, 354, 114, 25);
		panel_1.add(Disconnect);
		Disconnect.setForeground(Color.WHITE);
		Disconnect.setFont(new Font("Dialog", Font.BOLD, 14));
		Disconnect.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		Disconnect.setBorder(new LineBorder(UIManager.getColor("OptionPane.errorDialog.titlePane.shadow"), 2, true));
		Disconnect.setBackground(new Color(204, 102, 102));

		JButton Commit = new JButton("Commit");
		Commit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Connection conn = null;
				PreparedStatement pst = null;
				PreparedStatement pst2 = null;
				ResultSet rs = null;

				try {
					Class.forName("oracle.jdbc.OracleDriver");
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "anass_2018");
					String sql = "UPDATE etudiant SET nom='"+ Name.getText()+"' ,CIN='"+CIN.getText()+"',CNE='"+CNE.getText()+"',ville='"+Ville.getText()+"',PWD_et='"+Password.getText()+"', DATE_NAISSANCE=TO_DATE('"+Date.getText()+"','YYYY-MM-DD'), prenom='"+Prenom.getText()+"' where CIN='"+CIN.getText()+"'";
					String sql9 = "commit";
					pst = conn.prepareStatement(sql);
					ResultSet  rs2 = pst.executeQuery();

					pst2 = conn.prepareStatement(sql9);
					ResultSet  rs3 = pst2.executeQuery();

					JOptionPane.showMessageDialog(panel,"Les informations d'etudiant ont été modifié!!");
					Name.setText(" ");
					Prenom.setText(" ");
					Ville.setText(" ");
					Date.setText(" ");
					CNE.setText(" ");
					Password.setText(" ");

				} catch (Exception e) {
					JOptionPane.showMessageDialog(panel,e);
				}










			}
		});
		Commit.setBounds(6, 302, 114, 25);
		panel_1.add(Commit);
		Commit.setForeground(Color.WHITE);
		Commit.setFont(new Font("Dialog", Font.BOLD, 14));
		Commit.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		Commit.setBorder(new LineBorder(UIManager.getColor("OptionPane.errorDialog.titlePane.shadow"), 2, true));
		Commit.setBackground(new Color(204, 102, 102));

		JButton Delete = new JButton("Delete");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn = null;
				PreparedStatement pst7 = null;
				PreparedStatement pst6 = null;


				try {
					Class.forName("oracle.jdbc.OracleDriver");
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "anass_2018");
					String sql6 = "delete from etudiant where CIN='"+CIN.getText()+"'";
					String sql7 = "commit";

					pst6 = conn.prepareStatement(sql6);
					ResultSet  rs6 = pst6.executeQuery();


					pst7=conn.prepareStatement(sql7);
					ResultSet  rs7 = pst7.executeQuery();
					JOptionPane.showMessageDialog(panel,"l'etudiant qui a "+CIN.getText()+" est supprimé");
					conn.close();

				} catch (Exception e) {
					JOptionPane.showMessageDialog(panel,e);
				}


			}
		});
		Delete.setForeground(Color.WHITE);
		Delete.setFont(new Font("Dialog", Font.BOLD, 14));
		Delete.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		Delete.setBorder(new LineBorder(UIManager.getColor("OptionPane.errorDialog.titlePane.shadow"), 2, true));
		Delete.setBackground(new Color(204, 102, 102));
		Delete.setBounds(6, 245, 114, 25);
		panel_1.add(Delete);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(125, 27, 551, 417);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JButton LookUp = new JButton("Look Up");
		LookUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn = null;
				PreparedStatement pst = null;
				ResultSet rs = null;

				try {
					Class.forName("oracle.jdbc.OracleDriver");
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "anass_2018");
					String sql2 = "select  *from etudiant where CIN='"+CIN.getText()+"'";
					pst = conn.prepareStatement(sql2);
					ResultSet  rs2 = pst.executeQuery();
					if (rs2.next() == true)
					{

						String fname=rs2.getString(1);
						String lname=rs2.getString(2);
						String cin=rs2.getString(3);
						String cne=rs2.getString(4);
						String city=rs2.getString(5);
						Date da=rs2.getDate(6);
						String pass=rs2.getString(7);

						Name.setText(fname);
						Prenom.setText(lname);
						Ville.setText(city);
						Date.setText(String.valueOf(da));
						CNE.setText(cne);
						Password.setText(pass);

					}
					else{;

					}

				} catch (Exception e) {
					JOptionPane.showMessageDialog(panel,e);
				}
			}
		});



		LookUp.setForeground(Color.WHITE);
		LookUp.setFont(new Font("Dialog", Font.BOLD, 14));
		LookUp.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		LookUp.setBorder(new LineBorder(UIManager.getColor("OptionPane.errorDialog.titlePane.shadow"), 2, true));
		LookUp.setBackground(new Color(204, 102, 102));
		LookUp.setBounds(280, 44, 114, 25);
		panel_2.add(LookUp);

		CIN = new JTextField();
		CIN.setBounds(25, 39, 195, 35);
		panel_2.add(CIN);
		CIN.setColumns(10);

		JLabel lblCin = new JLabel("CIN :");
		lblCin.setBounds(25, 12, 66, 15);
		panel_2.add(lblCin);

		Name = new JTextField();
		Name.setColumns(10);
		Name.setBounds(35, 124, 195, 35);
		panel_2.add(Name);

		Ville = new JTextField();
		Ville.setColumns(10);
		Ville.setBounds(35, 190, 195, 35);
		panel_2.add(Ville);

		Prenom = new JTextField();
		Prenom.setColumns(10);
		Prenom.setBounds(260, 124, 195, 35);
		panel_2.add(Prenom);

		Date = new JTextField();
		Date.setColumns(10);
		Date.setBounds(260, 190, 195, 35);
		panel_2.add(Date);

		CNE = new JTextField();
		CNE.setColumns(10);
		CNE.setBounds(35, 260, 195, 35);
		panel_2.add(CNE);

		Password = new JTextField();
		Password.setColumns(10);
		Password.setBounds(260, 260, 195, 35);
		panel_2.add(Password);

		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(42, 104, 66, 15);
		panel_2.add(lblNom);

		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setBounds(260, 104, 66, 15);
		panel_2.add(lblPrenom);

		JLabel lblVille = new JLabel("Ville :");
		lblVille.setBounds(42, 165, 66, 15);
		panel_2.add(lblVille);

		JLabel lblDate = new JLabel("Date :");
		lblDate.setBounds(260, 165, 66, 15);
		panel_2.add(lblDate);

		JLabel lblCne = new JLabel("CNE :");
		lblCne.setBounds(42, 237, 66, 15);
		panel_2.add(lblCne);

		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(260, 237, 86, 15);
		panel_2.add(lblPassword);

		JLabel label_1 = new JLabel("Number of Available Students :");
		label_1.setBounds(25, 321, 273, 15);
		panel_2.add(label_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(25, 77, 473, 232);
		panel_2.add(panel_3);

		JLabel NumStudents = new JLabel("0");

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "anass_2018");
			String sql8 = "select count(*) from etudiant";
			pst8 = conn.prepareStatement(sql8);
			ResultSet  rs8 = pst8.executeQuery();
			if (rs8.next() == true){

				NumStudents.setText(String.valueOf(rs8.getInt(1)));
			}
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(null,e);
		}


		NumStudents.setBounds(260, 320, 66, 15);
		panel_2.add(NumStudents);
	}
}
