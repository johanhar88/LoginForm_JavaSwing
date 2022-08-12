import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class FrameLogin extends JFrame {

	private Image img_logo = new ImageIcon(FrameLogin.class.getResource("res/login.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
	private Image img_username = new ImageIcon(FrameLogin.class.getResource("res/user.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
	private Image img_password = new ImageIcon(FrameLogin.class.getResource("res/padlock.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
	
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel lblLoginMessage = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLogin frame = new FrameLogin();
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
	public FrameLogin() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new LineBorder(Color.PINK, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(175, 133, 250, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// Focus Event Handler Username
		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUsername.getText().equals("Username")) {
					txtUsername.setText("");
				} else {
					txtUsername.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUsername.getText().equals("")) {
					txtUsername.setText("Username");
				}
			}
		});
		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtUsername.setText("Username");
		txtUsername.setBounds(10, 11, 190, 20);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblIconUsername = new JLabel("");
		lblIconUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconUsername.setBounds(210, 0, 40, 40);
		lblIconUsername.setIcon(new ImageIcon(img_username));
		panel.add(lblIconUsername);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(175, 194, 250, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		// Focus Event Handler Password
		txtPassword = new JPasswordField();
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtPassword.getText().equals("Password")) {
					txtPassword.setEchoChar('●');
					txtPassword.setText("");
				} else {
					txtPassword.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtPassword.getText().equals("")) {
					txtPassword.setText("Password");
					txtPassword.setEchoChar((char)0);
				}
			}
		});
		txtPassword.setBorder(null);
		txtPassword.setEchoChar((char)0);
		txtPassword.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtPassword.setText("Password");
		txtPassword.setBounds(10, 11, 190, 20);
		panel_1.add(txtPassword);
		
		JLabel lblIconPassword = new JLabel("");
		lblIconPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconPassword.setBounds(210, 0, 40, 40);
		lblIconPassword.setIcon(new ImageIcon(img_password));
		panel_1.add(lblIconPassword);
		
		JPanel pnlBtnLogin = new JPanel();
		pnlBtnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtUsername.getText().equals("admin") && txtPassword.getText().equals("admin123")) {
					//if user inputs are correct
					lblLoginMessage.setText("");
					JOptionPane.showMessageDialog(null, "Login Succesfull");
				} else if (txtUsername.getText().equals("") || txtUsername.getText().equals("Username") ||
							txtPassword.getText().equals("") || txtPassword.getText().equals("Password")){
					lblLoginMessage.setText("Please input all requirements!");
				} else {
					lblLoginMessage.setText("Invalid Username and Password!");
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlBtnLogin.setBackground(new Color(30, 60 ,60));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlBtnLogin.setBackground(new Color(47, 79, 79));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				pnlBtnLogin.setBackground(new Color(60, 80, 80));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				pnlBtnLogin.setBackground(new Color(30, 60 ,60));
			}
		});
		pnlBtnLogin.setBackground(new Color(47, 79, 79));
		pnlBtnLogin.setBounds(175, 273, 250, 50);
		contentPane.add(pnlBtnLogin);
		pnlBtnLogin.setLayout(null);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setForeground(new Color(255, 255, 255));
		lblLogin.setFont(new Font("Poppins", Font.BOLD, 16));
		lblLogin.setBounds(98, 11, 53, 28);
		pnlBtnLogin.add(lblLogin);
		
		// Close
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					FrameLogin.this.dispose();
				}
			}
			// Mouse Hover
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.WHITE);
			}
		});
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setHorizontalTextPosition(SwingConstants.CENTER);
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setFont(new Font("Poppins", Font.BOLD, 16));
		lblX.setBounds(570, 11, 20, 20);
		contentPane.add(lblX);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblIconLogo.setForeground(new Color(255, 255, 255));
		lblIconLogo.setFont(new Font("Poppins", Font.BOLD, 20));
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setBounds(175, 22, 250, 100);
		contentPane.add(lblIconLogo);
		lblIconLogo.setIcon(new ImageIcon(img_logo));
		
		lblLoginMessage.setForeground(new Color(139, 0, 0));
		lblLoginMessage.setFont(new Font("Poppins", Font.PLAIN, 11));
		lblLoginMessage.setBounds(175, 245, 250, 14);
		contentPane.add(lblLoginMessage);
		setLocationRelativeTo(null);
	}
}
