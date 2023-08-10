import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import javax.swing.JComboBox;	

public class ToolsGUI extends JFrame {


		private JComboBox<String> categoryComboBox;
		private JPanel contentPane;
        private JPanel pnlTools;
        private JButton Homebtn; 
        private JButton Toolsbtn;
        private JButton ReportListbtn;
        private JButton Logoutbtn;
        private JButton AddBtn;
        private JLabel Imagelbl;
        
        public static JPanel itemPanel;
	/**
	 * Launch the application.
	 */
        
     public void refreshGUI() {
       revalidate(); // Ensure that the components are laid out correctly
   		repaint();   
    }    
        
	public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                    public void run() {
                            try {
                                    ToolsGUI frame = new ToolsGUI();
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
        
	public ToolsGUI() {
            
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 780);
		setResizable(false); // Set frame not resizable
		setLocationRelativeTo(null); // Set frame to launch at the center of the screen

            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

            setContentPane(contentPane);
            contentPane.setLayout(null);


            
            // Create and add the JComboBox for category filtering
            String[] categories = {"All", "Laying out the tools", "Metal cutting tools", "Holding tools", "Sharpening and grinding tools"};
            categoryComboBox = new JComboBox<>(categories);
            categoryComboBox.setBounds(39, 420, 133, 29);
            contentPane.add(categoryComboBox);
            
            // Home button
            Homebtn = new JButton("");
            Homebtn.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
            Homebtn.setBounds(39, 183, 133, 29);
            Homebtn.setOpaque(false);
            Homebtn.setContentAreaFilled(false);
            Homebtn.setBorderPainted(false);
            contentPane.add(Homebtn);

            // Add an action listener to the categoryComboBox
            categoryComboBox.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String selectedCategory = (String) categoryComboBox.getSelectedItem();
                    filterItemsByCategory(selectedCategory);
                }
            });
        
        
        // Tools button
        Toolsbtn = new JButton("");
        Toolsbtn.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
        Toolsbtn.setBounds(39, 241, 133, 29);
        Toolsbtn.setOpaque(false);
        Toolsbtn.setContentAreaFilled(false);
        Toolsbtn.setBorderPainted(false);
        contentPane.add(Toolsbtn);
        
		
            // Loss and Damage button
            ReportListbtn = new JButton("");
            ReportListbtn.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
            ReportListbtn.setBounds(39, 300, 133, 29);
            ReportListbtn.setOpaque(false);
            ReportListbtn.setContentAreaFilled(false);
            ReportListbtn.setBorderPainted(false);
            contentPane.add(ReportListbtn);

            ReportListbtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose(); // Close the HomeGUI

                    // Open the LossAndDamageListGUI class
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


            // Logout button
            Logoutbtn = new JButton("");
            Logoutbtn.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
            Logoutbtn.setBounds(39, 360, 133, 29);
            Logoutbtn.setOpaque(false);
            Logoutbtn.setContentAreaFilled(false);
            Logoutbtn.setBorderPainted(false);
            contentPane.add(Logoutbtn);

            Logoutbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the LoginGUI class
                AdminLogin loginGUI = new AdminLogin();
                loginGUI.setVisible(true);
                dispose(); // Close the current window
            }
        });

            AddBtn = new JButton("");
            AddBtn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                            AddItems contentPane = new AddItems();
                            contentPane.setVisible(true);
                            dispose();
                    }
            });


            AddBtn.setBounds(1006, 21, 61, 69);
            AddBtn.setOpaque(false);
            AddBtn.setContentAreaFilled(false);
            AddBtn.setBorderPainted(false);
            contentPane.add(AddBtn);
            

            AddBtn = new JButton("");
            AddBtn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                            ItemTracker contentPane = new ItemTracker();
                            contentPane.setVisible(true);
                            dispose();
                    }
            });


            AddBtn.setBounds(1150, 21, 55, 62);
            AddBtn.setOpaque(false);
            AddBtn.setContentAreaFilled(false);
            AddBtn.setBorderPainted(false);
            contentPane.add(AddBtn);
            



            Imagelbl = new JLabel("");
            Imagelbl.setIcon(new ImageIcon("C:\\\\Users\\\\Padilla\\\\Downloads\\\\0client\\\\java\\\\New-Compressed-zipped-Folder\\\\TOOLS (2).png"));
            Imagelbl.setBounds(1, 0, 1280, 761);
            contentPane.add(Imagelbl);


            itemPanel = new JPanel();
            itemPanel.setBounds(274, 124, 964, 615);
            contentPane.add(itemPanel);
            contentPane.setBackground(Color.BLACK);

        //displayContents

        showToolsPanel();

        }

        // displays the items

        public void  showToolsPanel() {

        	ToolsInformationReader dataHolder = new ToolsInformationReader();
            ArrayList<Tools> itemsList = dataHolder.getItemsList();

            int numRows = (int) Math.ceil((double) itemsList.size() / 4); // Number of rows in the table
            pnlTools = new JPanel(new GridLayout(numRows, 4));

            try {
                for (int i = 0; i < itemsList.size(); i++) {
                    JPanel singleItemPanel = createToolsPanel("Item" + i); // Create a custom panel for the cell
                    singleItemPanel.setPreferredSize(new Dimension(100, 340));

                    // Single Panel Contents

                    ImageIcon icon = new ImageIcon(itemsList.get(i).getItemImage());
                    Image img = icon.getImage();
                    Image imgScale = img.getScaledInstance(160, 230, Image.SCALE_SMOOTH);
                    ImageIcon scaledIcon = new ImageIcon(imgScale);

                    JLabel labelImage = new JLabel(scaledIcon); // Item Image
                    JLabel spacer = new JLabel("  ");
                    JLabel labelName = new JLabel(itemsList.get(i).getItemName()); // Item Name
                    JLabel labelStatus = new JLabel(itemsList.get(i).getItemStatus()); // Item Status
                    JLabel spacer2 = new JLabel("  ");
                    JLabel spacer3 = new JLabel("  ");
                          
                    // Changes Unclaimed label color to red
                    if ("Unclaimed".equals(itemsList.get(i).getItemStatus())) {
                        labelStatus.setForeground(Color.red);
                    } else {
                        labelStatus.setForeground(Color.green);
                    }

                    labelName.setFont(new Font("", Font.PLAIN, 14));
                    labelName.setAlignmentX(Component.CENTER_ALIGNMENT);
                    labelName.setForeground(new Color(0xFFFFFF));
                    labelImage.setAlignmentX(Component.CENTER_ALIGNMENT);
                    spacer.setAlignmentX(Component.CENTER_ALIGNMENT);
                    labelStatus.setFont(new Font("", Font.PLAIN, 16));
                    labelStatus.setAlignmentX(Component.CENTER_ALIGNMENT);
                    spacer2.setAlignmentX(Component.CENTER_ALIGNMENT);

                    singleItemPanel.setLayout(new BoxLayout(singleItemPanel, BoxLayout.Y_AXIS)); // Set vertical BoxLayout

                    singleItemPanel.add(spacer3);
                    singleItemPanel.add(labelImage);
                    singleItemPanel.add(spacer);
                    singleItemPanel.add(labelName);
                    singleItemPanel.add(labelStatus);
                    singleItemPanel.add(spacer2);
                          
                    // Create a JLabel for displaying the category
                    JLabel labelCategory = new JLabel(itemsList.get(i).getItemCategory());
                    labelCategory.setFont(new Font("", Font.PLAIN, 12));
                    labelCategory.setAlignmentX(Component.CENTER_ALIGNMENT);
                    labelCategory.setForeground(new Color(0xFFFFFF));
                    singleItemPanel.add(labelCategory); // Add category label

                    singleItemPanel.add(spacer2);



                    // Attach a MouseListener to the panel
                    singleItemPanel.addMouseListener(new MouseAdapter() {

                   

                      @Override
                      public void mouseEntered(MouseEvent e) {
                          JPanel sourcePanel = (JPanel) e.getSource();                         
                          sourcePanel.setBorder(BorderFactory.createLineBorder(Color.BLUE,4));
                         
                      }

                      @Override
                      public void mouseExited(MouseEvent e) {
                          JPanel sourcePanel = (JPanel) e.getSource();
                          Color originalNameColor =new Color(0xFFFFFF); // Store the original name color

                          labelName.setForeground(originalNameColor); // Restore the name color
                          labelStatus.setForeground(Color.BLACK);
                          String status = labelStatus.getText();
                            if ("Unclaimed".equals(status)){
                            labelStatus.setForeground(Color.red);
                            } else {
                            labelStatus.setForeground(Color.green);
                            }
                          sourcePanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,4));
                          sourcePanel.setBackground(new Color(0x292744));
                      }

                      @Override
                      public void mouseClicked(MouseEvent e) {
                          JPanel sourcePanel = (JPanel) e.getSource();
                          Component[] components = sourcePanel.getComponents();

                          for (Component component : components) {
                              if (component instanceof JLabel label) {
                                  String labelText = label.getText();
                                  labelText = labelText.replace("Item", "");
                                  try {
                                      int index = Integer.parseInt(labelText); // Convert the modified labelText to an integer
                                      System.out.println(index);
                                      new ToolsInformationFrame(index);

                                  } catch (NumberFormatException ex) {
                                      System.out.println("Invalid number format");
                                  }
                                  break;
                              }
                          }
                      }
                  });
                  pnlTools.add(singleItemPanel); // Add the custom panel to the table cell
              }

          } catch (ArrayIndexOutOfBoundsException e) {
              ImageIcon icon = new ImageIcon("");
              Image img = icon.getImage();
              Image imgScale = img.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
              ImageIcon scaledIcon = new ImageIcon(imgScale);
              JOptionPane.showMessageDialog(null, "Error!", "Error", JOptionPane.ERROR_MESSAGE, scaledIcon);
          }

            // Fill the remaining cells with empty panels
            int remainingCells = numRows * 4 - itemsList.size();
            for (int i = 1; i <= remainingCells; i++) {
                JPanel emptyPanel = createEmptyPanel(); // Create an empty panel
                pnlTools.add(emptyPanel); // Add the empty panel to the table cell
            }
            JScrollPane scrollPane = new JScrollPane(pnlTools);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setBounds(0, 0, 964, 615);
            scrollPane.setPreferredSize(new Dimension(964, 615));
            scrollPane.setBorder(null);
            itemPanel.add(scrollPane);
          
        }

    
		
            // create custompanels
        public static JPanel createToolsPanel(String itemText) {

            // create custompanels
            JPanel panel = new JPanel();
            panel.setBackground(new Color(0x292744));
            panel.setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
            panel.setLayout(new BorderLayout());

            // Add your custom components and layout within the panel
            JLabel label = new JLabel(itemText);
            label.setForeground(new Color(0, 0, 0, 0)); // Remove the foreground color
            label.setOpaque(false); // Set label background to be transparent
            panel.add(label, BorderLayout.CENTER);

            return panel;
        }
        
        

        // Create an empty panel for the cell
        public static JPanel createEmptyPanel() {
            JPanel panel = new JPanel();
            panel.setBackground(new Color(0x000000));
            panel.setBorder(BorderFactory.createLineBorder(Color.WHITE,3));

            return panel;
        }
        
     // Add this method to filter items by category
        private void filterItemsByCategory(String category) {
            pnlTools.removeAll(); // Remove the existing items from the panel

            ToolsInformationReader dataHolder = new ToolsInformationReader();
            ArrayList<Tools> itemsList = dataHolder.getItemsList();

            for (Tools item : itemsList) {
                if ("All".equals(category) || category.equals(item.getItemCategory())) {
                    JPanel singleItemPanel = createToolsPanel("Item" + itemsList.indexOf(item));
                    ImageIcon icon = new ImageIcon(item.getItemImage());
                    Image img = icon.getImage();
                    Image imgScale = img.getScaledInstance(160, 230, Image.SCALE_SMOOTH);
                    ImageIcon scaledIcon = new ImageIcon(imgScale);

                    JLabel labelImage = new JLabel(scaledIcon); // Item Image
                    JLabel spacer = new JLabel("  ");
                    JLabel labelName = new JLabel(item.getItemName()); // Item Name
                    JLabel labelStatus = new JLabel(item.getItemStatus()); // Item Status
                    JLabel spacer2 = new JLabel("  ");
                    JLabel spacer3 = new JLabel("  ");
                    
                    
                    if ("Unclaimed".equals(item.getItemStatus())) {
                        labelStatus.setForeground(Color.red);
                    } else {
                        labelStatus.setForeground(Color.green);
                    }
                    
                    labelName.setFont(new Font("", Font.PLAIN, 14));
                    labelName.setAlignmentX(Component.CENTER_ALIGNMENT);
                    labelName.setForeground(new Color(0xFFFFFF));
                    labelImage.setAlignmentX(Component.CENTER_ALIGNMENT);
                    spacer.setAlignmentX(Component.CENTER_ALIGNMENT);
                    labelStatus.setFont(new Font("", Font.PLAIN, 16));
                    labelStatus.setAlignmentX(Component.CENTER_ALIGNMENT);
                    spacer2.setAlignmentX(Component.CENTER_ALIGNMENT);

                    singleItemPanel.setLayout(new BoxLayout(singleItemPanel, BoxLayout.Y_AXIS));
                    singleItemPanel.add(spacer3);
                    singleItemPanel.add(labelImage);
                    singleItemPanel.add(spacer);
                    singleItemPanel.add(labelName);
                    singleItemPanel.add(labelStatus);
                    singleItemPanel.add(spacer2);

                    JLabel labelCategory = new JLabel(item.getItemCategory());
                    labelCategory.setFont(new Font("", Font.PLAIN, 12));
                    labelCategory.setAlignmentX(Component.CENTER_ALIGNMENT);
                    labelCategory.setForeground(new Color(0xFFFFFF));
                    singleItemPanel.add(labelCategory);

                    singleItemPanel.addMouseListener(new MouseAdapter() {
                    	 @Override
                    	    public void mouseEntered(MouseEvent e) {
                    	        JPanel sourcePanel = (JPanel) e.getSource();
                    	        sourcePanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
                    	    }

                    	    @Override
                    	    public void mouseExited(MouseEvent e) {
                    	        JPanel sourcePanel = (JPanel) e.getSource();
                    	        sourcePanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
                    	        sourcePanel.setBackground(new Color(0x292744));
                    	    }

                    	    @Override
                    	    public void mouseClicked(MouseEvent e) {
                    	        JPanel sourcePanel = (JPanel) e.getSource();
                    	        Component[] components = sourcePanel.getComponents();

                    	        for (Component component : components) {
                    	            if (component instanceof JLabel label) {
                    	                String labelText = label.getText();
                    	                labelText = labelText.replace("Item", "");
                    	                try {
                    	                    int index = Integer.parseInt(labelText);
                    	                    System.out.println(index);
                    	                    
                    	                    // Open a new frame to display more information about the selected tool
                    	                    ToolsInformationFrame toolInfoFrame = new ToolsInformationFrame(index);
                    	                    toolInfoFrame.setVisible(true);
                    	                    
                    	                } catch (NumberFormatException ex) {
                    	                    System.out.println("Invalid number format");
                    	                }
                    	                break;
                    	            }
                    	        }
                    	    }
                    });
                    
                    
                    pnlTools.add(singleItemPanel);
                }
            }

            pnlTools.revalidate(); // Refresh the panel
        }


    }