
import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;


public class ToDo {

    ArrayList<Item> TodoList = new ArrayList<>();


    static int size=0;

    public void addItem(String item, String category, int priority)
    {
        TodoList.add(new Item(item,category,priority));

        size++;
    }

    //remove item at specified index spot
    private void removeItem(String item )
    {

        TodoList.remove(getIndex(item));

    }

    public void getList()
    {
        for (Item item : TodoList)
        {
            System.out.println(item.toString());
        }
    }

    // Return the index of the searched item, accounts for differences in white spaces and cases
    public int getIndex(String item)
    {
        //return -1 if not found
        int index = -1;
        String itemString = item.replaceAll("\\s+", "").toLowerCase();
        for (int i = 0; i < TodoList.size(); i++) {
            String listItem = TodoList.get(i).getItem().replaceAll("\\s+", "").toLowerCase();
            if (listItem.contains(itemString)) {
                index = i;
                break;
            }
        }
        return index;
    }




    public void print() {
        System.out.println("To-do List: ");
        System.out.println("-----------");
        getList();
        if (TodoList == null) {
            System.out.println("You're all done for today!");
        }
    }



    public static void main(String[] args) {

        ToDo todo = new ToDo();


        todo.addItem("Get pickles", "Shopping", 2);
        todo.addItem("Read book", "School", 3);
        todo.addItem("Send letter", "Other", 1);
        todo.addItem("Buy planner", "School", 4);
        todo.addItem("Get potatoes", "Shopping", 3);
        todo.print();

        System.out.println("------------");
        //todo.removeItem("Read book","School","3");
        todo.removeItem("Buy planner");

        //System.out.println("INDEX OF READ BOOK (1) :" + todo.getIndex("Send letter"));

        //todo.removeItem(todo.getIndex("ReadBook"));
        todo.print();

        //System.out.println("SIZE: " + size);

    }

}

