public class Item {



    private String item;
    private String category;
    private int priority;

    //default constructor to initialize
    public Item(String item, String category, int priority){
        this.item = item;
        this.category = category;
        this.priority = priority;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getPriority()
    {
        if (priority == 1)
            return "low";
        else if (priority == 2)
            return "medium";
        else if (priority == 3)
            return "high";
        else if (priority == 4)
            return "urgent";
        else
            return "invalid priority";

    }

    public String toString() {
        return  "Category : " + category + " || Priority Level: " + getPriority() + "\nTask : " + item + "\n";
    }





}
