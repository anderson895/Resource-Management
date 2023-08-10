import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.border.*;

public class LossAndDamageList extends JFrame {
	
	
    private DefaultListModel<String> damageListModel;
    private DefaultListModel<String> lossListModel;
    private String filePath = "LossAndDamageList.txt";
    private JTextField nametextField; // Declare nametextField as an instance variable



    public LossAndDamageList() {
        setBounds(new Rectangle(0, 0, 1280, 761));
        setTitle("Damage & Loss Reports");
        setSize(1280, 761);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        JPanel damagePanel = new JPanel(new BorderLayout());
        damagePanel.setForeground(Color.WHITE);
        damagePanel.setBackground(Color.LIGHT_GRAY);
        damagePanel.setBorder(BorderFactory.createTitledBorder("Damage Reports"));
        damagePanel.setBounds(247, 94, 480, 515);

        damageListModel = new DefaultListModel<>();
        JScrollPane damageScrollPane = new JScrollPane();
        damagePanel.add(damageScrollPane, BorderLayout.CENTER);
        JList<String> damageList = new JList<>(damageListModel);
        damageScrollPane.setViewportView(damageList);

        lossListModel = new DefaultListModel<>();

        loadReportsFromFile();

        JPanel lossPanel = new JPanel((LayoutManager) null);
        lossPanel.setBackground(Color.LIGHT_GRAY);
        lossPanel.setBorder(BorderFactory.createTitledBorder("Loss Reports"));
        lossPanel.setBounds(759, 94, 480, 515);
        mainPanel.add(lossPanel);
        lossPanel.setLayout(new BorderLayout());

        JScrollPane lossScrollPane = new JScrollPane();
        lossPanel.add(lossScrollPane, BorderLayout.CENTER);
        JList<String> lossList = new JList<>(lossListModel);
        lossScrollPane.setViewportView(lossList);

        JButton deleteLossButton = new JButton("Delete Loss Report");
        deleteLossButton.setBounds(1011, 633, 193, 51);
        mainPanel.add(deleteLossButton);

        JButton deleteDamageButton = new JButton("Delete Damage Report");
        deleteDamageButton.setBounds(499, 633, 193, 51);
        mainPanel.add(deleteDamageButton);

        JButton addLossButton = new JButton("Add Loss Report");
        addLossButton.setBounds(794, 633, 193, 51);
        mainPanel.add(addLossButton);

        JButton addDamageButton = new JButton("Add Damage Report");
        addDamageButton.setBounds(284, 633, 193, 51);
        mainPanel.add(addDamageButton);

        mainPanel.add(damagePanel);
        mainPanel.add(lossPanel);
        mainPanel.add(deleteLossButton);
        mainPanel.add(deleteDamageButton);
        mainPanel.add(addLossButton);
        mainPanel.add(addDamageButton);
        
        nametextField = new JTextField();
        nametextField.setBounds(0, 0, 0, 0);
        mainPanel.add(nametextField);

        getContentPane().add(mainPanel);
        
        

        JButton Homebtn = new JButton("");
        Homebtn.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
        Homebtn.setBounds(39, 183, 133, 29);
        Homebtn.setOpaque(false);
        Homebtn.setContentAreaFilled(false);
        Homebtn.setBorderPainted(false);
        mainPanel.add(Homebtn);
        
        // Action listener for the Home button
        Homebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(
                    LossAndDamageList.this,
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
                int option = JOptionPane.showConfirmDialog(
                    LossAndDamageList.this,
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
                int option = JOptionPane.showConfirmDialog(LossAndDamageList.this, "Do you want to logout?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
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

        

        JLabel backgroundLbl = new JLabel();
        backgroundLbl.setIcon(new ImageIcon("C:\\Users\\Padilla\\Downloads\\0client\\java\\New-Compressed-zipped-Folder\\Reports.png"));
        backgroundLbl.setBounds(0, 0, 1280, 761);
        mainPanel.add(backgroundLbl);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(1073, 46, 2, 2);
        mainPanel.add(scrollPane);

        addDamageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> toolsComboBox = new JComboBox<>(new String[]{"Gloves", "Flat/Slotted Screwdriver", "Philips Screwdriver", "Torx Screwdriver", "Slip Joint Pliers", "Linesman Pliers", "Long Nose Pliers", "Locking Pliers", "Wire Strippers", "Cutting Pliers"});
                JTextField causeTextField = new JTextField();
                Object[] message = {
                        "Tools:", toolsComboBox,
                        "Cause of Damage:", causeTextField
                };

                int option = JOptionPane.showConfirmDialog(LossAndDamageList.this, message, "Add Damage Report", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    int confirmation = JOptionPane.showConfirmDialog(LossAndDamageList.this, "Are you sure you want to update the list?", "Confirmation", JOptionPane.YES_NO_OPTION);
                    if (confirmation == JOptionPane.YES_OPTION) {
                        String selectedTool = (String) toolsComboBox.getSelectedItem();
                        String cause = causeTextField.getText();
                        String report = "Equipment: " + selectedTool + " - Cause: " + cause;
                        damageListModel.addElement(report);
                        saveReportsToFile();
                    }
                }
            }
        });

        addLossButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> equipmentComboBox = new JComboBox<>(new String[]{
                        "Gloves", "Flat/Slotted Screwdriver", "Philips Screwdriver", "Torx Screwdriver",
                        "Slip Joint Pliers", "Linesman Pliers", "Long Nose Pliers", "Locking Pliers",
                        "Wire Strippers", "Cutting Pliers"
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

                JPanel panel = new JPanel(new GridLayout(5, 2));
                panel.add(new JLabel("Equipment Name:"));
                panel.add(equipmentComboBox);
                panel.add(new JLabel("Month:"));
                panel.add(monthComboBox);
                panel.add(new JLabel("Day:"));
                panel.add(dayComboBox);
                panel.add(new JLabel("Year:"));
                panel.add(yearComboBox);
                panel.add(new JLabel("Name:"));
                panel.add(nametextField);

                int option = JOptionPane.showConfirmDialog(
                        LossAndDamageList.this,
                        panel,
                        "Add Loss Report",
                        JOptionPane.OK_CANCEL_OPTION
                );

                if (option == JOptionPane.OK_OPTION) {
                    int confirmation = JOptionPane.showConfirmDialog(LossAndDamageList.this, "Are you sure you want to update the list?", "Confirmation", JOptionPane.YES_NO_OPTION);
                    if (confirmation == JOptionPane.YES_OPTION) {
                        String equipment = (String) equipmentComboBox.getSelectedItem();
                        String day = (String) dayComboBox.getSelectedItem();
                        String month = (String) monthComboBox.getSelectedItem();
                        String year = (String) yearComboBox.getSelectedItem();
                        String name = nametextField.getText();
                        String report = "Equipment: " + equipment + " - Date Last Used: " + month + "/ " + day + "/ " + year + " - Name: " + name;
                        lossListModel.addElement(report);
                        saveReportsToFile();
                    }
                }
            }
        });




        deleteDamageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = damageList.getSelectedIndex();
                if (selectedIndex != -1) {
                    int dialogResult = JOptionPane.showConfirmDialog(LossAndDamageList.this,
                            "Are you sure you want to delete this report?",
                            "Delete Damage Report",
                            JOptionPane.YES_NO_OPTION);
                    if (dialogResult == JOptionPane.YES_OPTION) {
                        damageListModel.remove(selectedIndex);
                        saveReportsToFile();
                    }
                } else {
                    JOptionPane.showMessageDialog(LossAndDamageList.this,
                            "Please select a damage report to delete.");
                }
            }
        });

        deleteLossButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = lossList.getSelectedIndex();
                if (selectedIndex != -1) {
                    int dialogResult = JOptionPane.showConfirmDialog(LossAndDamageList.this,
                            "Are you sure you want to delete this report?",
                            "Delete Loss Report",
                            JOptionPane.YES_NO_OPTION);
                    if (dialogResult == JOptionPane.YES_OPTION) {
                        lossListModel.remove(selectedIndex);
                        saveReportsToFile();
                    }
                } else {
                    JOptionPane.showMessageDialog(LossAndDamageList.this,
                            "Please select a loss report to delete.");
                }
            }
        });
    }

    public void saveReportsToFile() {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Damage Reports:\n");
            for (int i = 0; i < damageListModel.getSize(); i++) {
                writer.write(damageListModel.getElementAt(i) + "\n");
            }
            writer.write("\nLoss Reports:\n");
            for (int i = 0; i < lossListModel.getSize(); i++) {
                writer.write(lossListModel.getElementAt(i) + "\n");
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
                if (line.equals("Damage Reports:")) {
                    currentSection = "Damage";
                } else if (line.equals("Loss Reports:")) {
                    currentSection = "Loss";
                } else if (!line.isEmpty()) {
                    if (currentSection.equals("Damage")) {
                        damageListModel.addElement(line);
                    } else if (currentSection.equals("Loss")) {
                        lossListModel.addElement(line);
                    }
                }
            }
        } catch (IOException e) {
           
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LossAndDamageList gui = new LossAndDamageList();
                gui.setVisible(true);
            }
        });
    }
}