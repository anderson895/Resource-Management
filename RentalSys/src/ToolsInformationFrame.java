import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ToolsInformationFrame extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JButton removeButton;
    private JLabel lblNewLabel_1;
    private JButton updateButton;
    private JComboBox<String> categoryComboBox;  // Dropdown for category selection
    private List<Tools> itemsList;
    private JTextArea textArea;  // Declare textArea as a class member

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ToolsInformationFrame frame = new ToolsInformationFrame(0);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ToolsInformationFrame(int index) {
    	
    	
    	 ToolsInformationReader dataHolder = new ToolsInformationReader();
         itemsList = dataHolder.getItemsList();

         
         // Get the category of the current tool item
         String currentItemCategory = itemsList.get(index).getItemCategory();

         
        setBounds(100, 100, 749, 475);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        ImageIcon icon = new ImageIcon(itemsList.get(index).getItemImage());
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(225, 299, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        contentPane.setLayout(null);
        JLabel lblNewLabel = new JLabel(scaledIcon);
        lblNewLabel.setBounds(38, 108, 225, 299);
        contentPane.add(lblNewLabel);

        textField = new JTextField(itemsList.get(index).getItemName());
        textField.setBounds(515, 73, 152, 29);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField(itemsList.get(index).getItemStatus());
        textField_1.setBounds(515, 138, 152, 29);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField(itemsList.get(index).getItemDateIssued());
        textField_2.setBounds(515, 208, 152, 29);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        textArea = new JTextArea(itemsList.get(index).getItemDescription());
        textArea.setBounds(288, 268, 409, 139);
        contentPane.add(textArea);
        
        

        // Initialize and add categoryComboBox
        String[] categoryOptions = {"Laying out the tools", "Metal cutting tools", "Holding tools", "Sharpening and grinding tools"};
        categoryComboBox = new JComboBox<>(categoryOptions);
        categoryComboBox.setBounds(515, 7, 152, 29);
        contentPane.add(categoryComboBox);
        
        // Automatically select the category based on the tool item
        categoryComboBox.setSelectedItem(currentItemCategory);


        JButton editCategoryButton = new JButton("Edit Category");
        editCategoryButton.setBounds(515, 313, 152, 29);
        contentPane.add(editCategoryButton);
        editCategoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newCategory = (String) JOptionPane.showInputDialog(
                    null,
                    "Select a new category:",
                    "Edit Category",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    categoryOptions,
                    categoryComboBox.getSelectedItem()
                );
                if (newCategory != null) {
                    categoryComboBox.setSelectedItem(newCategory);
                }
            }
        });

        removeButton = new JButton("REMOVE");
        removeButton.setBounds(38, 43, 100, 30);
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(null, "Do you want to remove this item?", "Remove Item", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    removeItem(index);
                    dispose();
                    ToolsGUI toolsGUI = new ToolsGUI();
                    toolsGUI.refreshGUI(); // Call the refresh method in ToolsGUI
                }
            }
        });

        
        contentPane.add(removeButton);

        updateButton = new JButton("UPDATE");
        updateButton.setBounds(168, 43, 100, 30);
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateItem(index);
                dispose();
                ToolsInformationFrame infoFrame = new ToolsInformationFrame(index);
                ToolsGUI toolsGUI = new ToolsGUI();
                toolsGUI.refreshGUI(); // Call the refresh method in ToolsGUI
            }
        });

        
        
        contentPane.add(updateButton);

        lblNewLabel_1 = new JLabel("a");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Padilla\\Downloads\\0client\\java\\New-Compressed-zipped-Folder\\infobg.png"));
        lblNewLabel_1.setBounds(0, 0, 745, 438);
        contentPane.add(lblNewLabel_1);

        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void updateItem(int i) {
        String newName = textField.getText();
        String newStatus = textField_1.getText();
        String newDateIssued = textField_2.getText();
        String newDescription = textArea.getText();
        String newCategory = categoryComboBox.getSelectedItem().toString();

        Tools updatedItem = itemsList.get(i);
        updatedItem.setItemName(newName);
        updatedItem.setItemStatus(newStatus);
        updatedItem.setItemDateIssued(newDateIssued);
        updatedItem.setItemDescription(newDescription);
        updatedItem.setItemCategory(newCategory);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Padilla\\Downloads\\0client\\java\\RentalSys\\src\\Tools"));
            for (Tools item : itemsList) {
                writer.write(item.getItemName() + "|" + item.getItemImage() + "|" + item.getItemDateIssued() +
                        "|" + item.getItemDescription() + "|" + item.getItemStatus() + "|" + item.getItemCategory());
                writer.newLine();
            }
            writer.close();
            JOptionPane.showMessageDialog(null, "Item Updated Successfully", "Updated Item", JOptionPane.PLAIN_MESSAGE);
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to update item", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void removeItem(int i) {
        ToolsInformationReader dataHolder = new ToolsInformationReader();
        ArrayList<Tools> itemsList = dataHolder.getItemsList();
        ArrayList<String> searchElements = new ArrayList<>();

        searchElements.add(itemsList.get(i).getItemName());
        searchElements.add(itemsList.get(i).getItemImage());
        searchElements.add(itemsList.get(i).getItemDateIssued());
        searchElements.add(itemsList.get(i).getItemDescription());
        searchElements.add(itemsList.get(i).getItemStatus());

        try {
            List<String> lines = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Padilla\\Downloads\\0client\\java\\RentalSys\\src\\Tools"));
            String line;

            while ((line = reader.readLine()) != null) {
                boolean allElementsFound = true;

                for (String element : searchElements) {
                    if (!line.contains(element)) {
                        allElementsFound = false;
                        break;
                    }
                }

                if (!allElementsFound) {
                    lines.add(line);
                }
            }

            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Padilla\\Downloads\\0client\\java\\RentalSys\\src\\Tools"));
            for (String updatedLine : lines) {
                writer.write(updatedLine);
                writer.newLine();
            }
            writer.close();
            JOptionPane.showConfirmDialog(null, "Item Removed Successfully", "Removed Item", JOptionPane.PLAIN_MESSAGE);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
