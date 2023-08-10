public class Tools {
    private String itemName;
    private String itemImage;
    private String itemDateIssued;
    private String itemDescription;
    private String itemStatus;
    private String itemCategory;

    private static int itemCounter = 0;

    public Tools(String itemName, String itemImage, String itemDateIssued, String itemDescription, String itemStatus, String itemCategory) {
        this.itemName = itemName;
        this.itemImage = itemImage;
        this.itemDateIssued = itemDateIssued;
        this.itemDescription = itemDescription;
        this.itemStatus = itemStatus;
        this.itemCategory = itemCategory;
        addItemCount();
    }

    // Name
    public String getItemName() {
        return itemName;
    }
    
    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    // Image
    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    // Color
    public String getItemDateIssued() {
        return itemDateIssued;
    }

    public void setItemDateIssued(String itemDateIssued) {
        this.itemDateIssued= itemDateIssued;
    }

     // Date Surrendered
    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    // Status 
    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus= itemStatus;
    }

    // Item counter
    public int getItemCounter() {
        return itemCounter;
    }

    public void addItemCount() {
        itemCounter++;
    }
    
    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

}