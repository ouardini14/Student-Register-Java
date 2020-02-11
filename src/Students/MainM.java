package Students;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
import javax.swing.border.LineBorder;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.awt.event.ActionEvent;

public class MainM extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Date d1 = new Date();
					MainM frame = new MainM("cin","cne","nom","prenom","ville",d1);
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
	public MainM(String cin,String cne,String nom,String prenom,String ville,Date date) {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 449);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, -19, 771, 219);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(-405, -56, 1536, 1084);
		label.setIgnoreRepaint(true);
		label.setIcon(new ImageIcon(MainM.class.getResource("/images/The-First-Few-Weeks-Of-University-Life.jpg")));
		panel.add(label);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 189, 637, 242);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblName = new JLabel("Nom :");
		lblName.setBounds(23, 52, 66, 15);
		panel_1.add(lblName);

		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setBounds(23, 79, 66, 15);
		panel_1.add(lblPrenom);

		JLabel lblDateDeNaissance = new JLabel("Date de Naissance :");
		lblDateDeNaissance.setBounds(23, 106, 151, 15);
		panel_1.add(lblDateDeNaissance);

		JLabel lblIdentifion = new JLabel("CIN :");
		lblIdentifion.setBounds(23, 32, 86, 15);
		panel_1.add(lblIdentifion);

		JLabel lblCne = new JLabel("CNE :");
		lblCne.setBounds(23, 133, 66, 15);
		panel_1.add(lblCne);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.GRAY));
		panel_2.setBounds(12, 22, 602, 208);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_3.setBounds(300, 12, 290, 142);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		JRadioButton rdbtnDevelopmentWeb = new JRadioButton("Ingénierie et Qualité logicielles");
		rdbtnDevelopmentWeb.setBounds(8, 8, 253, 23);
		buttonGroup.add(rdbtnDevelopmentWeb);
		panel_3.add(rdbtnDevelopmentWeb);

		JRadioButton rdbtnSystmesDinformation = new JRadioButton("Systèmes d’Information");
		rdbtnSystmesDinformation.setBounds(8, 41, 200, 23);
		buttonGroup.add(rdbtnSystmesDinformation);
		panel_3.add(rdbtnSystmesDinformation);

		JRadioButton rdbtntechDinformation = new JRadioButton("Technologie de l’information");
		rdbtntechDinformation.setBounds(8, 76, 253, 23);
		buttonGroup.add(rdbtntechDinformation);
		panel_3.add(rdbtntechDinformation);

		JRadioButton rdbtnScuritSystmesDinformation = new JRadioButton("Sécurité Systèmes d’Information");
		rdbtnScuritSystmesDinformation.setBounds(8, 111, 274, 23);
		buttonGroup.add(rdbtnScuritSystmesDinformation);
		panel_3.add(rdbtnScuritSystmesDinformation);

		JLabel lblBienvenueALa = new JLabel("Votre Filliere est :");
		lblBienvenueALa.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenueALa.setFont(new Font("Dialog", Font.BOLD, 17));
		lblBienvenueALa.setBounds(0, 44, 290, 15);
		panel_3.add(lblBienvenueALa);
		lblBienvenueALa.setVisible(false);

		JButton btnSeDeconnecter = new JButton("Se Deconnecter ");
		btnSeDeconnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				LoginM frames = new LoginM();
				frames.setVisible(true);
				dispose();

			}
		});
		btnSeDeconnecter.setBounds(97, 158, 151, 34);
		panel_2.add(btnSeDeconnecter);
		btnSeDeconnecter.setForeground(Color.WHITE);
		btnSeDeconnecter.setFont(new Font("Dialog", Font.BOLD, 14));
		btnSeDeconnecter.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		btnSeDeconnecter.setBorder(new LineBorder(UIManager.getColor("OptionPane.errorDialog.titlePane.shadow"), 2, true));
		btnSeDeconnecter.setBackground(Color.DARK_GRAY);

		JButton btnValiderLesChoix = new JButton("Valider les Choix");
		btnValiderLesChoix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Connection conn = null;
				PreparedStatement pst = null;
				ResultSet rs = null;
				PreparedStatement pst5 = null;

				try {

					Class.forName("oracle.jdbc.OracleDriver");
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "anass_2018");
					String a = "not";
					if(rdbtnDevelopmentWeb.isSelected()==true){
						JOptionPane.showMessageDialog(panel,rdbtnDevelopmentWeb.getText() +"is Selected");
						a=rdbtnDevelopmentWeb.getText();}
					if(rdbtnSystmesDinformation.isSelected()==true){
						JOptionPane.showMessageDialog(panel,rdbtnSystmesDinformation.getText() +"is Selected");
						a=rdbtnSystmesDinformation.getText();
					}
					if(rdbtntechDinformation.isSelected()==true){
						JOptionPane.showMessageDialog(panel,rdbtntechDinformation.getText() +"is Selected");
						a=rdbtntechDinformation.getText();}

					if(rdbtnScuritSystmesDinformation.isSelected()==true){
						JOptionPane.showMessageDialog(panel,rdbtnScuritSystmesDinformation.getText() +"is Selected");
						a=rdbtnScuritSystmesDinformation.getText();}

					String sql = "update etudiant set filliere='"+a+"' where CIN='"+cin+"'";
					String sql5 = "COMMIT";

					pst = conn.prepareStatement(sql);
					rs = pst.executeQuery();

					pst5 = conn.prepareStatement(sql5);
					pst5.executeQuery();



					JOptionPane.showMessageDialog(panel,"vous avez choisi la filliere ");

					rdbtnScuritSystmesDinformation.setVisible(false);
					rdbtntechDinformation.setVisible(false);
					rdbtnSystmesDinformation.setVisible(false);
					rdbtnDevelopmentWeb.setVisible(false);
					lblBienvenueALa.setVisible(true);

					JLabel labels = new JLabel(a);
					labels.setHorizontalAlignment(SwingConstants.CENTER);
					labels.setFont(new Font("Dialog", Font.BOLD, 17));
					labels.setBounds(0, 80, 290, 42);
					panel_3.add(labels);
					labels.setVisible(true);


				} catch (Exception e) {
					JOptionPane.showMessageDialog(panel,e);
				}


			}

		});
		btnValiderLesChoix.setForeground(Color.WHITE);
		btnValiderLesChoix.setFont(new Font("Dialog", Font.BOLD, 14));
		btnValiderLesChoix.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		btnValiderLesChoix.setBorder(new LineBorder(UIManager.getColor("OptionPane.errorDialog.titlePane.shadow"), 2, true));
		btnValiderLesChoix.setBackground(Color.DARK_GRAY);
		btnValiderLesChoix.setBounds(362, 158, 151, 34);
		panel_2.add(btnValiderLesChoix);

		JLabel lblVille = new JLabel("Ville :");
		lblVille.setBounds(12, 135, 66, 15);
		panel_2.add(lblVille);

		JLabel CIN = new JLabel(cin);
		CIN.setBounds(55, 10, 137, 15);
		panel_2.add(CIN);

		JLabel Nom = new JLabel(nom);
		Nom.setBounds(60, 29, 137, 15);
		panel_2.add(Nom);

		JLabel Prenom = new JLabel(prenom);
		Prenom.setBounds(80, 55, 137, 15);
		panel_2.add(Prenom);

		JLabel Date = new JLabel(date.toString());
		Date.setBounds(147, 83, 151, 15);
		panel_2.add(Date);

		JLabel CNE = new JLabel(cne);
		CNE.setBounds(50, 110, 167, 15);
		panel_2.add(CNE);

		JLabel Ville = new JLabel(ville);
		Ville.setBounds(50, 135, 136, 15);
		panel_2.add(Ville);


	}
}