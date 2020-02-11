package Students;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.ComponentOrientation;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class RegisterM extends JFrame {

	private JPanel contentPane;
	private JPasswordField PasswordField;
	private JTextField Nom;
	private JTextField Prenom;
	private JTextField Date;
	private JTextField Ville;
	private JTextField CIN;
	private JTextField CNE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterM frame = new RegisterM();
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
	public RegisterM() {
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 746, 495);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, -28, 377, 501);
		contentPane.add(panel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(RegisterM.class.getResource("/images/259-matriculacio-uoc-ver1.jpg")));
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, -28, 746, 501);
		contentPane.add(panel_1);
		
		JButton btnSinscrire = new JButton("Valider l'Inscription ");
		btnSinscrire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

						Connection conn = null;
						PreparedStatement pst = null;
						PreparedStatement pst3 = null;
						ResultSet rs = null;
						PreparedStatement pst4 = null;
						PreparedStatement pst5 = null;

						try {
							Class.forName("oracle.jdbc.OracleDriver");
							conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "anass_2018");
							String sql3 = "select  *from etudiant where CIN='"+CIN.getText()+"'OR CNE='"+CNE.getText()+"'";
							pst3 = conn.prepareStatement(sql3);
							ResultSet  rs3 = pst3.executeQuery();
							if (rs3.next() == true)
							{
								JOptionPane.showMessageDialog(panel,"cet etudiant est déja inscrit!!");
							}
							else{

							String sql4 = "insert into etudiant values('"+Nom.getText()+"','"+Prenom.getText()+"','"+CIN.getText()+"','"+CNE.getText()+"','"+Ville.getText()+"',TO_DATE('"+Date.getText()+"', 'yyyy/mm/dd'),'"+PasswordField.getText()+"' ,'NOT chosen yet',"+0+")";
							String sql5 = "COMMIT";
							pst4 = conn.prepareStatement(sql4);
							pst4.executeQuery();

							pst5 = conn.prepareStatement(sql5);
							pst5.executeQuery();
								JOptionPane.showMessageDialog(panel,"vous etes incrit");
								LoginM frames = new LoginM();
								frames.setVisible(true);
								dispose();
							}


						} catch (Exception e) {
							JOptionPane.showMessageDialog(panel,e);
						}



					}
				});
		btnSinscrire.setForeground(Color.WHITE);
		btnSinscrire.setFont(new Font("Dialog", Font.BOLD, 14));
		btnSinscrire.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		btnSinscrire.setBorder(new LineBorder(UIManager.getColor("OptionPane.errorDialog.titlePane.shadow"), 2, true));
		btnSinscrire.setBackground(new Color(204, 102, 102));
		btnSinscrire.setBounds(443, 414, 234, 48);
		panel_1.add(btnSinscrire);
		
		JLabel lblMotDePasse = new JLabel("Mot de Passe :");
		lblMotDePasse.setVerticalTextPosition(SwingConstants.TOP);
		lblMotDePasse.setVerticalAlignment(SwingConstants.TOP);
		lblMotDePasse.setHorizontalAlignment(SwingConstants.LEFT);
		lblMotDePasse.setForeground(Color.BLACK);
		lblMotDePasse.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblMotDePasse.setBounds(445, 171, 111, 15);
		panel_1.add(lblMotDePasse);
		
		PasswordField = new JPasswordField();
		PasswordField.setBounds(443, 198, 236, 36);
		panel_1.add(PasswordField);
		
		JLabel label_4 = new JLabel("Platform d'Inscription");
		label_4.setFont(new Font("Dialog", Font.BOLD, 16));
		label_4.setBounds(456, 0, 208, 15);
		panel_1.add(label_4);
		
		JLabel lblNom = new JLabel("      Nom :                            Prenom :");
		lblNom.setHorizontalAlignment(SwingConstants.LEFT);
		lblNom.setForeground(Color.BLACK);
		lblNom.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNom.setBounds(443, 105, 302, 15);
		panel_1.add(lblNom);
		
		Nom = new JTextField();
		Nom.setColumns(10);
		Nom.setBounds(429, 132, 127, 36);
		panel_1.add(Nom);
		
		JLabel lblConfirmerLeMot = new JLabel("Date de Naissance :  (aaaa/mm/jj)");
		lblConfirmerLeMot.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfirmerLeMot.setForeground(Color.BLACK);
		lblConfirmerLeMot.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblConfirmerLeMot.setBounds(441, 246, 223, 15);
		panel_1.add(lblConfirmerLeMot);
		
		Prenom = new JTextField();
		Prenom.setColumns(10);
		Prenom.setBounds(568, 132, 127, 36);
		panel_1.add(Prenom);
		
		Date = new JTextField();
		Date.setColumns(10);
		Date.setBounds(441, 273, 236, 36);
		panel_1.add(Date);
		
		JButton btnSeConnecter = new JButton("Se Connecter ?");
		btnSeConnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					LoginM frames = new LoginM();
					frames.setVisible(true);
					dispose();
					
				
			}
		});
		btnSeConnecter.setBounds(493, 464, 127, 25);
		panel_1.add(btnSeConnecter);
		btnSeConnecter.setForeground(UIManager.getColor("OptionPane.errorDialog.titlePane.shadow"));
		btnSeConnecter.setFont(new Font("Dialog", Font.ITALIC, 11));
		btnSeConnecter.setBorderPainted(false);
		btnSeConnecter.setBackground(Color.WHITE);
		
		Ville = new JTextField();
		Ville.setColumns(10);
		Ville.setBounds(443, 337, 236, 36);
		panel_1.add(Ville);
		
		JLabel lblVille = new JLabel("Ville :");
		lblVille.setHorizontalAlignment(SwingConstants.LEFT);
		lblVille.setForeground(Color.BLACK);
		lblVille.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblVille.setBounds(443, 310, 194, 15);
		panel_1.add(lblVille);
		
		CIN = new JTextField();
		CIN.setColumns(10);
		CIN.setBounds(568, 54, 127, 36);
		panel_1.add(CIN);
		
		CNE = new JTextField();
		CNE.setColumns(10);
		CNE.setBounds(429, 54, 127, 36);
		panel_1.add(CNE);
		
		JLabel lblCneCin = new JLabel("      CNE :                            CIN :");
		lblCneCin.setHorizontalAlignment(SwingConstants.LEFT);
		lblCneCin.setForeground(Color.BLACK);
		lblCneCin.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblCneCin.setBounds(443, 27, 302, 15);
		panel_1.add(lblCneCin);
	}
}
