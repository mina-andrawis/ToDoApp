import java.util.Comparator;

public class Item{

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
        return "PRIORITY: " +
                translatePriority() + " || " + category + ", " + item + " ";
    }

    // override Compare method of Comparator in order to reorder based on priority
    public static Comparator<Item> priorityComparator = new Comparator<Item>() {

        public int compare(Item i1, Item i2) {

            int priority1 = i1.getPriority();
            int priority2 = i2.getPriority();

            /*For ascending order*/
            return priority2-priority1;

        }};



}
