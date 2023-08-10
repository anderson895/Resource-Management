import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ToolsInformationReader {

    private ArrayList<Tools> itemsList; 
    FileReader fileReader;
    BufferedReader bufferedReader;
    
    

    public ToolsInformationReader(){

    	
    itemsList = new ArrayList<Tools>();

    
    try {
    	
    	
      fileReader = new FileReader("C:\\Users\\Padilla\\Downloads\\0client\\java\\RentalSys\\src\\Tools");
      bufferedReader = new BufferedReader(fileReader);
      String line;
      while ((line = bufferedReader.readLine()) != null) {

        if (line.trim().isEmpty()) {
          continue;
        }
        String[] split = line.split("\\|");
        if (split.length >= 6) {
            
          String itemName = split[0];
          String itemImage = split[1];
          String itemDate = split[2];
          String itemDescription = split[3];
          String itemStatus = split[4];
          String itemCategory = split[5]; // Assuming category is the fifth element in the split array
          Tools item = new Tools(itemName, itemImage, itemDate, itemDescription, itemStatus, itemCategory);
          itemsList.add(item);
        }
      }
      bufferedReader.close();
      fileReader.close();
    } catch (IOException | ArrayIndexOutOfBoundsException e) {
      e.printStackTrace();
    }

   }

    public ArrayList<Tools> getItemsList() {
    	
    	
        return itemsList;
    }

} 
