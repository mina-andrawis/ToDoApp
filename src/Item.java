public class Item {


    public int i;
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

    public int getPriority() {
        return priority;
    }

    //used in order to overload indexOf() method
    //*****************************************************
    @Override
    public boolean equals(Object o) {
        if (o instanceof Item) {
            //item comparison
            Item mo = (Item)o;
            return mo.item.equals(item);
        }
        return false;
    }

    public int hashCode() {
        return java.util.Objects.hashCode(item);
    }

    // *****************************************************

    public String translatePriority()
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



    @Override
    public String toString() {
        return new StringBuilder("").append(category).append(", ")
                .append(translatePriority()).append(", ").append(item)
                .toString();
    }





}
