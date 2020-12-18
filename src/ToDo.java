
import java.util.*;
import java.lang.*;


public class ToDo {

    ArrayList<Item> TodoList = new ArrayList<>();


    public void addItem(String itemName, String itemCategory, int itemPriority)
    {
        TodoList.add(new Item(itemName,itemCategory,itemPriority));

    }

    public void getList()
    {
        for (Item item : TodoList)
        {
            System.out.println(item.toString());
        }
    }


    public void print() {
        System.out.println("To-do List:");
        System.out.println("-----------");
        getList();
        if (TodoList == null) {
            System.out.println("You're all done for today! #TodoZero");
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

    }

}

