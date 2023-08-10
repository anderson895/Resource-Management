import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javax.swing.JComboBox;

public class AddItems extends JFrame {
    private JPanel contentPane;
    private JTextField textField_ItemName;
    private JTextField textField_ItemStatus;
    private JTextField textField_ItemDate;
    private JTextField textField_ItemDescription;
    private JLabel lblDisplayImage;
    private JLabel lblBgImg;
    private JLabel lblMAGLogo;
    private JLabel lblHomeTab;
    private JLabel lblToolsTab;
    private JLabel lblReportsTab;
    private JLabel lblLogoutTab;
    private JLabel lblInsertImage;
    private JLabel lblClear;
    private JLabel lblSave;
    private JLabel lblBg;
    private String insertedImage;
    
    private JTextField textField_ItemCategory;
    private JComboBox<String> comboBox_ItemCategory;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddItems frame = new AddItems();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AddItems() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 780);
		setResizable(false); // Set frame not resizable
		setLocationRelativeTo(null); // Set frame to launch at the center of the screen

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int frameWidth = 1280;
        int frameHeight = 800;
        setBounds((screenWidth - frameWidth) / 2, (screenHeight - frameHeight) / 2, frameWidth, frameHeight);

        comboBox_ItemCategory = new JComboBox<>(new String[]{"Laying out the tools", "Laying out the tools", "Metal cutting tools","Holding tools","Sharpening and grinding tools"});
        comboBox_ItemCategory.setBounds(642, 300, 263, 46);
        contentPane.add(comboBox_ItemCategory);
        
        
        
        lblDisplayImage = new JLabel("");
        lblDisplayImage.setBounds(277, 181, 306, 399);
        contentPane.add(lblDisplayImage);

        textField_ItemName = new JTextField("name");
        textField_ItemName.setBounds(640, 239, 263, 46);
        textField_ItemName.setBorder(null);
        contentPane.add(textField_ItemName);
        textField_ItemName.setColumns(10);

        textField_ItemStatus = new JTextField("status");
        textField_ItemStatus.setColumns(10);
        textField_ItemStatus.setBounds(642, 358, 263, 46);
        textField_ItemStatus.setBorder(null);
        contentPane.add(textField_ItemStatus);

        textField_ItemDate = new JTextField("date");
        textField_ItemDate.setColumns(10);
        textField_ItemDate.setBounds(642, 480, 263, 46);
        textField_ItemDate.setBorder(null);
        contentPane.add(textField_ItemDate);

        textField_ItemDescription = new JTextField("descrip");
        textField_ItemDescription.setColumns(10);
        textField_ItemDescription.setBounds(937, 239, 263, 46);
        textField_ItemDescription.setBorder(null);
        contentPane.add(textField_ItemDescription);

        lblMAGLogo = new JLabel("");
        lblMAGLogo.setBounds(25, 37, 148, 64);
        contentPane.add(lblMAGLogo);
        lblMAGLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomePage homePage = new HomePage();
                homePage.setVisible(true);
                dispose();
            }
        });

        lblHomeTab = new JLabel("");
        lblHomeTab.setBounds(25, 194, 112, 41);
        contentPane.add(lblHomeTab);
        lblHomeTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomePage homePage = new HomePage();
                homePage.setVisible(true);
                dispose();
            }
        });

        lblToolsTab = new JLabel("");
        lblToolsTab.setBounds(25, 245, 119, 42);
        contentPane.add(lblToolsTab);
        lblToolsTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ToolsGUI toolsPage = new ToolsGUI();
                toolsPage.setVisible(true);
                dispose();
            }
        });

        lblReportsTab = new JLabel("");
        lblReportsTab.setBounds(23, 310, 139, 46);
        contentPane.add(lblReportsTab);
        lblReportsTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LossAndDamageList lossAndDamageList = new LossAndDamageList();
                lossAndDamageList.setVisible(true);
                dispose();
            }
        });

        lblLogoutTab = new JLabel("");
        lblLogoutTab.setBounds(25, 371, 127, 46);
        contentPane.add(lblLogoutTab);
        lblLogoutTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int choice = JOptionPane.showConfirmDialog(null, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    AdminLogin adminLogin = new AdminLogin();
                    adminLogin.setVisible(true);
                    dispose();
                    // Clear the displayed image and text fields
                    lblDisplayImage.setIcon(null);
                    textField_ItemName.setText("");
                    textField_ItemStatus.setText("");
                    textField_ItemDate.setText("");
                    textField_ItemDescription.setText("");
                } else {
                    // Do nothing and stay in the program
                }
            }
        });

        lblInsertImage = new JLabel("");
        lblInsertImage.setBounds(332, 623, 198, 51);
        contentPane.add(lblInsertImage);
        lblInsertImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    insertedImage = fileChooser.getSelectedFile().getAbsolutePath();
                    try {
                        Image img = ImageIO.read(selectedFile);
                        Image scaledImg = img.getScaledInstance(lblDisplayImage.getWidth(),
                        lblDisplayImage.getHeight(), Image.SCALE_SMOOTH);
                        lblDisplayImage.setIcon(new ImageIcon(scaledImg));
                        lblDisplayImage.setBounds(275, 180, 300, 399);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        lblSave = new JLabel("");
        lblSave.setBounds(784, 623, 198, 46);
        contentPane.add(lblSave);
        lblSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                String itemName = textField_ItemName.getText();
                String itemImage = getInsertedImagePath();
                String itemStatus = textField_ItemStatus.getText();
                String itemDate = textField_ItemDate.getText();
                String itemDescription = textField_ItemDescription.getText();
                String itemCategory = (String) comboBox_ItemCategory.getSelectedItem();
                
                

                if (!itemName.isEmpty() && !itemStatus.isEmpty() && !itemDate.isEmpty() && 
                	    !itemDescription.isEmpty() && lblDisplayImage.getIcon() != null && itemCategory != null) {
                	    int choice = JOptionPane.showConfirmDialog(null, "Do you want to save this information?", "Save",
                	        JOptionPane.YES_NO_OPTION);
                	    if (choice == JOptionPane.YES_OPTION) {
                	        saveItem(itemName, itemImage, itemDate, itemDescription, itemStatus, itemCategory);
                	           JOptionPane.showMessageDialog(null, "Information Saved!", "Saved",
                            JOptionPane.INFORMATION_MESSAGE);
                        lblDisplayImage.setIcon(null);
                        textField_ItemName.setText("");
                        textField_ItemStatus.setText("");
                        textField_ItemDate.setText("");
                        textField_ItemDescription.setText("");
                        
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter all information!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        lblClear = new JLabel("");
        lblClear.setBounds(992, 623, 204, 46);
        contentPane.add(lblClear);
        lblClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               
                        lblDisplayImage.setIcon(null);
                        textField_ItemName.setText("");
                        textField_ItemStatus.setText("");
                        textField_ItemDate.setText("");
                        textField_ItemDescription.setText("");
                        
            }
        });
        
        
        lblBg = new JLabel("");
        lblBg.setIcon(new ImageIcon("C:\\\\Users\\\\Padilla\\\\Downloads\\\\0client\\\\java\\\\New-Compressed-zipped-Folder\\\\AddItemsGUI.png"));
        lblBg.setBounds(0, 0, 1280, 790);
        contentPane.add(lblBg);
    }
    
    
    public void saveItem(String name, String image, String date, String description, String status, String category) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Padilla\\Downloads\\0client\\java\\RentalSys\\src\\Tools", true));
            writer.write(name + "|" + image + "|" + date + "|" + description + "|" + status + "|" + category);
            writer.newLine();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    
    public String getInsertedImagePath() {
        return insertedImage;
    }
    
    
}