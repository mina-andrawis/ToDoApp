
import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;


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

    //remove item at specified index spot
    private void removeItem(int i )
    {
        i--;        // to avoid index out of bound where i = size
        TodoList.remove(i);
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

    public String taskToString(int i)
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


        /*
        todo.addItem("Get pickles", "Shopping", 2);
        todo.addItem("Read book", "School", 3);
        todo.addItem("Send letter", "Other", 1);
        todo.addItem("Buy planner", "School", 4);
        todo.addItem("Get potatoes", "Shopping", 3);
        todo.addItem("Get things", "Shopping", 3);

         */

        //initialize data array to hold items
        String[] data = new String[100];

        for (int i = 0; i < size; i++) {
            //sort items and populate data array with items converted to string
            todo.sortItems();
            data[i] = todo.taskToString(i);
        }

        ///declare components of panels
        //JCheckBox[] checkbox = new JCheckBox[size];
        ArrayList<JCheckBox> checkbox = new ArrayList<>();

        JButton resetButton = new JButton("Reset List");

        JButton addButton = new JButton("Add Task");

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel headerPanel = new JPanel();
        JPanel contentPane = new JPanel();
        JPanel footerPanel = new JPanel();

        JLabel title = new JLabel("TO-DO");
        headerPanel.add(title, BorderLayout.PAGE_START);


        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(5, 5));


        //array to hold checkboxes


        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(0, 1, 5, 5));

        for (int i = 0; i < size; i++) {
            checkbox.set(i,new JCheckBox(data[i]));
            centerPanel.add(checkbox.get(i));
        }

        contentPane.add(headerPanel, BorderLayout.NORTH);
        contentPane.add(centerPanel, BorderLayout.CENTER);


        footerPanel.add(resetButton);
        footerPanel.add(addButton);

        contentPane.add(footerPanel, BorderLayout.SOUTH);

        // Action listener of add button

        addButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {

               String category = JOptionPane.showInputDialog(footerPanel,"Category? (e.g., shopping, school, other, etc.)");
               String item = JOptionPane.showInputDialog(footerPanel,"Task?");
               String p = JOptionPane.showInputDialog(footerPanel,"Priority? (1 -> low priority, 4 -> urgent");

               int priority = Integer.parseInt(p);      //convert to an int

               // ADD ERROR HANDLING

               while (priority < 0 || priority > 4)
               {
                   String newP = JOptionPane.showInputDialog(footerPanel,"Please enter a valid number. (1 -> low priority, 4 -> urgent");
                   priority = Integer.parseInt(newP);      //convert to an int
               }

               todo.addItem(item,category,priority);

               todo.print();        // to console

               //decalre new checkbox arraylist
               ArrayList<JCheckBox> newCheckbox = new ArrayList<>();

               centerPanel.removeAll();
               centerPanel.repaint();       // indicates the window is dirty -> allows for removal

               //sort items, populate data array, copy data array to checkbox array, add to panel
               for (int i = 0; i < size; i++) {
                   todo.sortItems();
                   data[i] = todo.taskToString(i);

                   centerPanel.add(new JCheckBox(data[i]));

               }

               contentPane.add(centerPanel, BorderLayout.CENTER);
               contentPane.revalidate();        // indicates new components are available to repaint


           }
       });


        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                centerPanel.removeAll();
                centerPanel.repaint();       // indicates the window is dirty -> allows for removal


                // removes list items
                for (int i = size; i > 0; i--) {
                    todo.removeItem(i);  //delete from todo list
                }

                contentPane.add(centerPanel, BorderLayout.CENTER);
                contentPane.revalidate();        // indicates new components are available to repaint




            }
        });
        frame.setContentPane(contentPane);
        frame.setSize(400,500);
        frame.setResizable(false);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);


        todo.print();




    }
}

