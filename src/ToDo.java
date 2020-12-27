
import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class ToDo{

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
        size--;

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
        //return -1 if not found  ,  \\s+ => more than one white space
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

    public String getItemString(int i)
    {
        return TodoList.get(i).toString();
    }

    public void sortItems()
    {
        TodoList.sort(Item.priorityComparator);
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
        todo.addItem("Get things", "Shopping", 3);

        //initialize data array to hold items
        String[] data = new String[100];

        for (int i = 0; i < size; i++) {
            //sort items and populate data array with items converted to string
            todo.sortItems();
            data[i] = todo.getItemString(i);
        }

        ///declare components of panels
        final JCheckBox[][] checkBox = new JCheckBox[1][1];
        JButton resetButton = new JButton("Reset List");

        JButton addButton = new JButton("Add Task");

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel headerPanel = new JPanel();
        JPanel contentPane = new JPanel();
        JPanel footerPanel = new JPanel();

        JLabel title = new JLabel("TO-DO");
        headerPanel.add(title);


        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(5, 5));

        //array to hold checkboxes
        JCheckBox[] checkbox = new JCheckBox[size];

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(0, 1, 5, 5));

        for (int i = 0; i < size; i++) {
            checkbox[i] = new JCheckBox(data[i]);
            centerPanel.add(checkbox[i]);
        }

        contentPane.add(headerPanel, BorderLayout.NORTH);
        contentPane.add(centerPanel, BorderLayout.CENTER);


        footerPanel.add(resetButton);
        footerPanel.add(addButton);

        contentPane.add(footerPanel, BorderLayout.SOUTH);


        addButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               //footerPanel.removeAll();

               String category = JOptionPane.showInputDialog(footerPanel,"Category? (e.g., shopping, school, other, etc.)");
               String item = JOptionPane.showInputDialog(footerPanel,"Task?");
               String p = JOptionPane.showInputDialog(footerPanel,"Priority? (1 -> low priority, 4 -> urgent");

               int priority = Integer.parseInt(p);      //convert to an int

               while (priority < 0 || priority > 4)
               {
                   String newP = JOptionPane.showInputDialog(footerPanel,"Please enter a valid number. (1 -> low priority, 4 -> urgent");
                   priority = Integer.parseInt(newP);      //convert to an int
               }

               todo.addItem(item,category,priority);

               todo.print();


               for (int i = 0; i < size; i++) {
                   //sort items and populate data array with items converted to string
                   todo.sortItems();
                   data[i] = todo.getItemString(i);
               }

               contentPane.removeAll();

               // add items to content panel
               for (int i = 0; i < size; i++) {
                   checkBox[0][i] = new JCheckBox(data[i]);
                   centerPanel.add(checkBox[0][i]);
               }

               contentPane.add(centerPanel, BorderLayout.CENTER);

               //frame.add(contentPane);

               frame.revalidate();
               contentPane.repaint();




           }
       });


        frame.setContentPane(contentPane);
        frame.setSize(400,500);
        frame.setResizable(false);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);




        todo.print();

        System.out.println("-----------------\n");

        todo.removeItem("Get pickles");

        todo.sortItems();


        todo.print();




    }
}

