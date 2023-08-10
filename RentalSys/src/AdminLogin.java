import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField PasswordInput;
	private JTextField UsernameInput;
	private JLabel AdminLoginExit;
	private JButton adminLoginBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 780);
		setResizable(false); // Set frame not resizable
		setLocationRelativeTo(null); // Set frame to launch at the center of the screen

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		UsernameInput = new JTextField();
		UsernameInput.setForeground(Color.WHITE);
		UsernameInput.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		UsernameInput.setBounds(752, 218, 431, 37);
		UsernameInput.setBackground(null);
		UsernameInput.setBorder(null);
		UsernameInput.setOpaque(false);
		contentPane.add(UsernameInput);
		UsernameInput.setColumns(10);
		
		PasswordInput = new JPasswordField();
		PasswordInput.setForeground(Color.WHITE);
		PasswordInput.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		PasswordInput.setBackground(null);
		PasswordInput.setBorder(null);
		PasswordInput.setOpaque(false);
		PasswordInput.setBounds(752, 311, 431, 37);
		contentPane.add(PasswordInput);
		PasswordInput.setColumns(10);
		
        
		adminLoginBtn = new JButton("");
		
		adminLoginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	                
				
				boolean userExists = false; 
				
				String UserInput = UsernameInput.getText();
		        String PassInput = new String(PasswordInput.getPassword());
		        String[] username = {"Admin"};
                String[] password = {"Admin123"};
                
                   for (int i = 0; i < password.length; i++) {
                	
                	
					if (UserInput.equals("Admin") && PassInput.equals("Admin123")) {
						JOptionPane.showMessageDialog(null, "Login successful!");
                        HomePage AdmPg = new HomePage();
                        AdmPg.setVisible(true);
                        new HomePage();
                        dispose();
                        userExists = true;
                        break;
                  
                    } 
					else if (!UserInput.equals("Admin") && PassInput.equals("Admin123")) {
                        JOptionPane.showMessageDialog(null, "Incorrect username.");
                    }
					else if (UserInput.equals("Admin") && !PassInput.equals("Admin123")) {
                        JOptionPane.showMessageDialog(null, "Incorrect password.");	
                }
					else {
						JOptionPane.showMessageDialog(null, "Incorrect username and password.");
					}
                   }
			}
        });
		adminLoginBtn.setBounds(769, 413, 400, 50);
		adminLoginBtn.setOpaque(false);
		adminLoginBtn.setContentAreaFilled(false);
		adminLoginBtn.setBorderPainted(false);
		contentPane.add(adminLoginBtn);	
		
		AdminLoginExit = new JLabel("");
		AdminLoginExit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		AdminLoginExit.setBounds(151, 109, 26, 26);
		contentPane.add(AdminLoginExit);
		
		JLabel AdminPic = new JLabel("");
		AdminPic.setIcon(new ImageIcon("C:\\Users\\Padilla\\Downloads\\0client\\java\\New-Compressed-zipped-Folder\\1.png"));
		AdminPic.setBounds(0, 0, 1280, 761);
		contentPane.add(AdminPic);
	}

	}