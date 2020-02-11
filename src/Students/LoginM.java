package Students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.ComponentOrientation;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Point;
import java.awt.Rectangle;

public class LoginM extends JFrame {

	private JPanel contentPane;
	private JTextField CIN;
	private JPasswordField PasswordField;

	/*
	 * 
	 * Launch the application.
	 *
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginM frame = new LoginM();
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
	public LoginM() {
		setBounds(new Rectangle(100, 100, 100, 100));
		setResizable(true);
		setLocationByPlatform(true);
		setLocation(new Point(100, 100));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-102, -32, 756, 457);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(-274, -53, 677, 479);
		contentPane.add(panel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LoginM.class.getResource("/images/259-matriculacio-uoc-ver1.jpg")));
		panel.add(label);
		
		JLabel lblIdentifiantOuCin = new JLabel("Identifiant ou CIN :");
		lblIdentifiantOuCin.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdentifiantOuCin.setForeground(Color.BLACK);
		lblIdentifiantOuCin.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblIdentifiantOuCin.setBounds(472, 97, 194, 15);
		contentPane.add(lblIdentifiantOuCin);
		
		CIN = new JTextField();
		CIN.setColumns(10);
		CIN.setBounds(472, 124, 236, 36);
		contentPane.add(CIN);
		
		JLabel lblMotDePasse = new JLabel("Mot de Passe :");
		lblMotDePasse.setVerticalTextPosition(SwingConstants.TOP);
		lblMotDePasse.setVerticalAlignment(SwingConstants.TOP);
		lblMotDePasse.setHorizontalAlignment(SwingConstants.LEFT);
		lblMotDePasse.setForeground(Color.BLACK);
		lblMotDePasse.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblMotDePasse.setBounds(473, 185, 99, 15);
		contentPane.add(lblMotDePasse);
		
		PasswordField = new JPasswordField();
		PasswordField.setBounds(472, 212, 236, 36);
		contentPane.add(PasswordField);
		
		JButton btnN = new JButton("S'inscrire ?");
		btnN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RegisterM frames = new RegisterM();
				frames.setVisible(true);
				dispose();
				
			}
		});
		btnN.setBorderPainted(false);
		btnN.setForeground(UIManager.getColor("OptionPane.errorDialog.titlePane.shadow"));
		btnN.setBackground(Color.WHITE);
		btnN.setFont(new Font("Dialog", Font.ITALIC, 11));
		btnN.setBounds(534, 359, 114, 25);
		contentPane.add(btnN);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new LineBorder(UIManager.getColor("OptionPane.errorDialog.titlePane.shadow"), 2, true));
		panel_1.setBounds(429, 12, 304, 396);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPlatformDinscriptionDe = new JLabel("Platforme de Connexion");
		lblPlatformDinscriptionDe.setBounds(41, 39, 239, 19);
		panel_1.add(lblPlatformDinscriptionDe);
		lblPlatformDinscriptionDe.setForeground(UIManager.getColor("OptionPane.errorDialog.titlePane.shadow"));
		lblPlatformDinscriptionDe.setFont(new Font("Dialog", Font.BOLD, 18));
		
		JButton button = new JButton("Se Connecter");
		button.setBounds(41, 281, 234, 48);
		panel_1.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection conn = null;
		        PreparedStatement pst = null;
		        ResultSet rs = null;
				
		        try {
                    Class.forName("oracle.jdbc.OracleDriver");
                    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "anass_2018");
                    String sql2 = "select  *from etudiant where CIN='"+CIN.getText()+"'AND pwd_et='"+PasswordField.getText()+"'";
                    pst = conn.prepareStatement(sql2);
                    ResultSet  rs2 = pst.executeQuery();
                    if (rs2.next() == true)
                    {	if(rs2.getInt(9)==1){JOptionPane.showMessageDialog(panel,"C'est un admin") ;
						AdminM frame = new AdminM();
						frame.setVisible(true);
						dispose();
                    		}

                    	if(rs2.getInt(9)==0){
                    		    String fname=rs2.getString(1);
                    		    String lname=rs2.getString(2);
                        		String cin=rs2.getString(3);
                        		String cne=rs2.getString(4);
                        		String city=rs2.getString(5);
                        		Date da=rs2.getDate(6);
                        		String pass=rs2.getString(7);
                        
                        		MainM frame = new MainM(cin,cne,lname,fname,city,da);
        						frame.setVisible(true);
        						dispose();}
                        
                    }
                    else{JOptionPane.showMessageDialog(panel,"CIN ou mot de passe est incorrect") ;

                    }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(panel,e);
                }
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Dialog", Font.BOLD, 14));
		button.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		button.setBorder(new LineBorder(UIManager.getColor("OptionPane.errorDialog.titlePane.shadow"), 2, true));
		button.setBackground(new Color(204, 102, 102));
	}
}
