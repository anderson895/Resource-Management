import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 780);
		setResizable(false); // Set frame not resizable
		setLocationRelativeTo(null); // Set frame to launch at the center of the screen

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton Homebtn = new JButton("");
        Homebtn.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
        Homebtn.setBounds(39, 183, 133, 29);
        Homebtn.setOpaque(false);
        Homebtn.setContentAreaFilled(false);
        Homebtn.setBorderPainted(false);
        contentPane.add(Homebtn);
        
        
		
		
		JButton Toolsbtn = new JButton("");
		Toolsbtn.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		Toolsbtn.setBounds(39, 241, 133, 29);
		Toolsbtn.setOpaque(false);
		Toolsbtn.setContentAreaFilled(false);
		Toolsbtn.setBorderPainted(false);
		contentPane.add(Toolsbtn);
		
		// Action listener for the Tools button	
        Toolsbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to navigate to the ToolsGUI class
                ToolsGUI toolsGUI = new ToolsGUI();
                toolsGUI.setVisible(true);
                dispose(); // Close the current window
            }
        });
		
		JButton ReportListbtn = new JButton("");
		ReportListbtn.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		ReportListbtn.setBounds(39, 300, 133, 29);
		ReportListbtn.setOpaque(false);
		ReportListbtn.setContentAreaFilled(false);
		ReportListbtn.setBorderPainted(false);
		contentPane.add(ReportListbtn);
		
		ReportListbtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        dispose(); // Close the HomeGUI

		        // Open the LossAndDamageListGUI
		        EventQueue.invokeLater(new Runnable() {
		            public void run() {
		                try {
		                    LossAndDamageList frame = new LossAndDamageList();
		                    frame.setVisible(true);
		                } catch (Exception e) {
		                    e.printStackTrace();
		                }
		            }
		        });
		    }
		});

		
		JButton Logoutbtn = new JButton("");
		Logoutbtn.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		Logoutbtn.setOpaque(false);
		Logoutbtn.setContentAreaFilled(false);
		Logoutbtn.setBorderPainted(false);
		Logoutbtn.setBounds(39, 360, 133, 29);
		contentPane.add(Logoutbtn);
		
		Logoutbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to navigate to the LoginGUI class
                AdminLogin loginGUI = new AdminLogin();
                loginGUI.setVisible(true);
                dispose(); // Close the current window
            }
        });
		
		
		
		JLabel Imagelbl = new JLabel("");
		Imagelbl.setIcon(new ImageIcon("C:\\\\Users\\\\Padilla\\\\Downloads\\\\0client\\\\java\\\\New-Compressed-zipped-Folder\\\\Homepage.png"));
		Imagelbl.setBounds(0, 0, 1280, 761);
		contentPane.add(Imagelbl);
		
		
	}
}