import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.border.*;
	
	public class ItemTracker extends JFrame {
		
		
	    private DefaultListModel<String> studentListModel;
	    private DefaultListModel<String> itemListModel;
	    private String filePath = "C:\\\\Users\\\\Padilla\\\\Downloads\\\\0client\\\\java\\\\New-Compressed-zipped-Folder\\\\LossAndDamageList.txt";
	
	
	
	    public ItemTracker() {
	    	setBounds(new Rectangle(0, 0, 1280, 765));
	        setTitle("Item Tracker");
	        setSize(1280, 761);
	        setResizable(false);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	        addWindowListener((WindowListener) new WindowAdapter() {
	            public void windowClosing(WindowEvent e) {
	                int option = JOptionPane.showConfirmDialog(ItemTracker.this, "Do you wish to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
	                if (option == JOptionPane.YES_OPTION) {
	                    HomePage homepage = new HomePage();
	                    homepage.setVisible(true);
	                    dispose();
	                }
	            }
	        });
	        
	
	        JPanel mainPanel = new JPanel();
	        mainPanel.setLayout(null);
	
	        JPanel studentInfoPanel = new JPanel(new BorderLayout());
	        studentInfoPanel.setForeground(Color.WHITE);
	        studentInfoPanel.setBackground(Color.LIGHT_GRAY);
	        studentInfoPanel.setBorder(BorderFactory.createTitledBorder("Student Information"));
	        studentInfoPanel.setBounds(247, 94, 480, 515);
	
	        studentListModel = new DefaultListModel<>();
	        JScrollPane studentInfoScrollPane = new JScrollPane();
	        studentInfoPanel.add(studentInfoScrollPane, BorderLayout.CENTER);
	        JList<String> studentInfoList = new JList<>(studentListModel);
	        studentInfoScrollPane.setViewportView(studentInfoList);
	
	        itemListModel = new DefaultListModel<>();
	
	        loadReportsFromFile();
	
	        JPanel itemTrackerPanel = new JPanel((LayoutManager) null);
	        itemTrackerPanel.setBackground(Color.LIGHT_GRAY);
	        itemTrackerPanel.setBorder(BorderFactory.createTitledBorder("Item Tracker"));
	        itemTrackerPanel.setBounds(759, 94, 480, 515);
	        mainPanel.add(itemTrackerPanel);
	        itemTrackerPanel.setLayout(new BorderLayout());
	
	        JScrollPane itemTrackerScrollPane = new JScrollPane();
	        itemTrackerPanel.add(itemTrackerScrollPane, BorderLayout.CENTER);
	        JList<String> itemTrackerList = new JList<>(itemListModel);
	        itemTrackerScrollPane.setViewportView(itemTrackerList);
	
	        JButton deleteItemButton = new JButton("Delete Item Report");
	        deleteItemButton.setBounds(1011, 633, 193, 51);
	        mainPanel.add(deleteItemButton);
	
	        JButton deleteStudentButton = new JButton("Delete Student");
	        deleteStudentButton.setBounds(499, 633, 193, 51);
	        mainPanel.add(deleteStudentButton);
	
	        JButton addItemButton = new JButton("Add Item Report");
	        addItemButton.setBounds(794, 633, 193, 51);
	        mainPanel.add(addItemButton);
	
	        JButton addStudentButton = new JButton("Add Student");
	        addStudentButton.setBounds(284, 633, 193, 51);
	        mainPanel.add(addStudentButton);
	
	        mainPanel.add(studentInfoPanel);
	        mainPanel.add(itemTrackerPanel);
	        mainPanel.add(deleteItemButton);
	        mainPanel.add(deleteStudentButton);
	        mainPanel.add(addItemButton);
	        mainPanel.add(addStudentButton);
	
	        getContentPane().add(mainPanel);
	        
	        
	
	        JButton Homebtn = new JButton("");
	        Homebtn.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
	        Homebtn.setBounds(29, 183, 143, 29);
	        Homebtn.setOpaque(false);
	        Homebtn.setContentAreaFilled(false);
	        Homebtn.setBorderPainted(false);
	        mainPanel.add(Homebtn);
	        
	        // Action listener for the Home button
	        Homebtn.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                int option = JOptionPane.showConfirmDialog(
	                    ItemTracker.this,
	                    "Do you want to proceed without saving your progress? Any unsaved changes will be lost if you choose to continue.",
	                    "Confirmation",
	                    JOptionPane.YES_NO_OPTION
	                );
	                if (option == JOptionPane.YES_OPTION) {
	                    // Code to navigate to the HomeGUI class
	                    HomePage homepage = new HomePage();
	                    homepage.setVisible(true);
	                    dispose(); // Close the current window
	                }
	            }
	        });
	
	        JButton Toolsbtn = new JButton("");
	        Toolsbtn.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
	        Toolsbtn.setBounds(39, 241, 133, 29);
	        Toolsbtn.setOpaque(false);
			Toolsbtn.setContentAreaFilled(false);
			Toolsbtn.setBorderPainted(false);
	        mainPanel.add(Toolsbtn);
	        
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
	        
	        // Action listener for the Logout button	
	        JButton Logoutbtn = new JButton("");
	        Logoutbtn.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
	        Logoutbtn.setBounds(39, 360, 133, 29);
	        Logoutbtn.setOpaque(false);
			Logoutbtn.setContentAreaFilled(false);
			Logoutbtn.setBorderPainted(false);
	        mainPanel.add(Logoutbtn);
	        
	        Logoutbtn.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                int option = JOptionPane.showConfirmDialog(ItemTracker.this, "Do you want to logout?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
	                if (option == JOptionPane.YES_OPTION) {
	                    // Code to navigate to the AdminLogin class
	                    AdminLogin adminLogin = new AdminLogin();
	                    adminLogin.setVisible(true);
	                    dispose(); // Close the current window
	                }
	            }
	        });
	
	        JButton ReportListbtn = new JButton("");
	        ReportListbtn.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
	        ReportListbtn.setBounds(39, 300, 133, 29);
	        ReportListbtn.setOpaque(false);
			ReportListbtn.setContentAreaFilled(false);
			ReportListbtn.setBorderPainted(false);
	        mainPanel.add(ReportListbtn);
	        
	        ReportListbtn.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                int option = JOptionPane.showConfirmDialog(
	                    ItemTracker.this,
	                    "Do you want to proceed without saving your progress? Any unsaved changes will be lost if you choose to continue.",
	                    "Confirmation",
	                    JOptionPane.YES_NO_OPTION
	                );
	                if (option == JOptionPane.YES_OPTION) {
	                    // Code to navigate to the HomeGUI class
	                	LossAndDamageList lossAndDamageList = new LossAndDamageList();
	                    lossAndDamageList.setVisible(true);
	                    dispose(); // Close the current window
	                }
	            }
	        });
	
	        
	
	        JLabel backgroundLbl = new JLabel();
	        backgroundLbl.setIcon(new ImageIcon("C:\\Users\\Padilla\\Downloads\\0client\\java\\New-Compressed-zipped-Folder\\Tooltracker.png"));
	        backgroundLbl.setBounds(0, 0, 1280, 761);
	        mainPanel.add(backgroundLbl);
	
	        addStudentButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                JTextField firstNameTextField = new JTextField();
	                JTextField middleInitialTextField = new JTextField();
	                JTextField lastNameTextField = new JTextField();
	                JTextField studentNumberTextField = new JTextField();
	
	                Object[] message = {
	                        "First Name:", firstNameTextField,
	                        "Middle Initial:", middleInitialTextField,
	                        "Last Name:", lastNameTextField,
	                        "Student Number:", studentNumberTextField
	                };
	
	                int option = JOptionPane.showConfirmDialog(ItemTracker.this, message, "Add Student", JOptionPane.OK_CANCEL_OPTION);
	                if (option == JOptionPane.OK_OPTION) {
	                    int confirmation = JOptionPane.showConfirmDialog(ItemTracker.this, "Are you sure you want to update the list?", "Confirmation", JOptionPane.YES_NO_OPTION);
	                    if (confirmation == JOptionPane.YES_OPTION) {
	                        String firstName = firstNameTextField.getText();
	                        String middleInitial = middleInitialTextField.getText();
	                        String lastName = lastNameTextField.getText();
	                        String studentNumber = studentNumberTextField.getText();
	                        String report = "Name: " + firstName + " " + middleInitial + " " + lastName + " - Student Number: " + studentNumber;
	                        studentListModel.addElement(report);
	                        saveReportsToFile();
	                    }
	                }
	            }
	        });
	
	        addItemButton.addActionListener(new ActionListener() {
	            @Override
	           public void actionPerformed(ActionEvent e) {
	                JComboBox<String> equipmentComboBox = new JComboBox<>(new String[]{
	                        "Gloves", "Flat/Slotted Screwdriver", "Philips Screwdriver", "Torx Screwdriver",
	                        "Slip Joint Pliers", "Linesman Pliers", "Long Nose Pliers", "Locking Pliers",
	                        "Wire Strippers", "Cutting Pliers"
	                });
	                
	                JComboBox<Integer> quantityComboBox = new JComboBox<>(new Integer[]{
	                        1, 2, 3, 4, 5, 6, 7, 8, 9, 10
	                });
	
	                // Combobox for Month
	                JComboBox<String> monthComboBox = new JComboBox<>(new String[]{
	                        "January", "February", "March", "April", "May", "June", "July", "August", "September",
	                        "October", "November", "December"
	                });
	
	                // Combobox for Day
	                JComboBox<String> dayComboBox = new JComboBox<>(new String[]{
	                        "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12",
	                        "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24",
	                        "25", "26", "27", "28", "29", "30", "31"
	                });
	
	                // Combobox for Year
	                JComboBox<String> yearComboBox = new JComboBox<>(new String[]{
	                        "2023", "2024", "2025", "2026"
	                });
	                
	             // Combobox for Hour
	                JComboBox<String> hourComboBox = new JComboBox<>(new String[]{
	                        "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"
	                });
	
	                // JLabel for colon
	                JLabel colonLabel = new JLabel(":");
	
	                // Combobox for Minute
	                JComboBox<String> minuteComboBox = new JComboBox<>(new String[]{
	                		"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
	                        "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
	                        "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
	                        "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
	                        "41", "42", "43", "44", "45", "46", "47", "48", "49", "50",
	                        "51", "52", "53", "54", "55", "56", "57", "58", "59"
	                });
	
	                // Combobox for AM/PM
	                JComboBox<String> timeComboBox = new JComboBox<>(new String[]{
	                        "AM", "PM"
	                });
	
	                JPanel panel = new JPanel(new GridLayout(8, 6));
	                panel.add(new JLabel("Item:"));
	                panel.add(equipmentComboBox);
	                panel.add(new JLabel("Quantity:"));
	                panel.add(quantityComboBox);
	                panel.add(new JLabel("Day:"));
	                panel.add(dayComboBox);
	                panel.add(new JLabel("Month:"));
	                panel.add(monthComboBox);
	                panel.add(new JLabel("Year:"));
	                panel.add(yearComboBox);
	                panel.add(new JLabel("Hour:"));
	                panel.add(hourComboBox);
	                panel.add(new JLabel("Minutes:"));
	                panel.add(minuteComboBox);
	                panel.add(new JLabel("Time:"));
	                panel.add(timeComboBox);
	
	                int option = JOptionPane.showConfirmDialog(
	                        ItemTracker.this,
	                        panel,
	                        "Add Item Report",
	                        JOptionPane.OK_CANCEL_OPTION
	                );
	
	                if (option == JOptionPane.OK_OPTION) {
	                    int confirmation = JOptionPane.showConfirmDialog(ItemTracker.this, "Are you sure you want to update the list?", "Confirmation", JOptionPane.YES_NO_OPTION);
	                    if (confirmation == JOptionPane.YES_OPTION) {
	                    	String equipment = (String) equipmentComboBox.getSelectedItem();
	                        int quantity = (int) quantityComboBox.getSelectedItem();
	                        String month = (String) monthComboBox.getSelectedItem();
	                        String day = (String) dayComboBox.getSelectedItem();
	                        String year = (String) yearComboBox.getSelectedItem();
	                        String hour = (String) hourComboBox.getSelectedItem();
	                        String minute = (String) minuteComboBox.getSelectedItem();
	                        String time = (String) timeComboBox.getSelectedItem();
	                        String report = "Equipment: " + quantity+ " " +equipment+ " - Date Last Used: " + month + " / " + day + " / " + year + " - Time: " + hour + ":"+minute + " "+ time;
	                        itemListModel.addElement(report);
	                        saveReportsToFile();
	                    }
	                }
	            }
	        });
	
	
	
	
	        deleteStudentButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                int selectedIndex = studentInfoList.getSelectedIndex();
	                if (selectedIndex != -1) {
	                    int dialogResult = JOptionPane.showConfirmDialog(ItemTracker.this,
	                            "Are you sure you want to delete this report?",
	                            "Delete Damage Report",
	                            JOptionPane.YES_NO_OPTION);
	                    if (dialogResult == JOptionPane.YES_OPTION) {
	                    	studentListModel.remove(selectedIndex);
	                        saveReportsToFile();
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(ItemTracker.this,
	                            "Please select a damage report to delete.");
	                }
	            }
	        });
	
	        deleteItemButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                int selectedIndex = itemTrackerList.getSelectedIndex();
	                if (selectedIndex != -1) {
	                    int dialogResult = JOptionPane.showConfirmDialog(ItemTracker.this,
	                            "Are you sure you want to delete this report?",
	                            "Delete Loss Report",
	                            JOptionPane.YES_NO_OPTION);
	                    if (dialogResult == JOptionPane.YES_OPTION) {
	                    	itemListModel.remove(selectedIndex);
	                        saveReportsToFile();
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(ItemTracker.this,
	                            "Please select a loss report to delete.");
	                }
	            }
	        });
	    }
	
	    public void saveReportsToFile() {
	        try (FileWriter writer = new FileWriter(filePath)) {
	            writer.write("Student Information:\n");
	            for (int i = 0; i < studentListModel.getSize(); i++) {
	                writer.write(studentListModel.getElementAt(i) + "\n");
	            }
	            writer.write("\nItem Tracker:\n");
	            for (int i = 0; i < itemListModel.getSize(); i++) {
	                writer.write(itemListModel.getElementAt(i) + "\n");
	            }
	            writer.flush();
	        } catch (IOException e) {
	            
	        }
	    }
	
	    public void loadReportsFromFile() {
	        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            String currentSection = "";
	            while ((line = reader.readLine()) != null) {
	                if (line.equals("Student Information:")) {
	                    currentSection = "Student";
	                } else if (line.equals("Item Tracker:")) {
	                    currentSection = "Item";
	                } else if (!line.isEmpty()) {
	                    if (currentSection.equals("Student")) {
	                        studentListModel.addElement(line);
	                    } else if (currentSection.equals("Item")) {
	                        itemListModel.addElement(line);
	                    }
	                }
	            }
	        } catch (IOException e) {
	            // Handle IOException
	        }
	    }

	
	
	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                ItemTracker gui = new ItemTracker();
	                gui.loadReportsFromFile(); // Load data from the file
	                gui.setVisible(true);
	            }
	        });
	    }

	    
	}