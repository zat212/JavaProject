import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class TableSortingExample extends JFrame
{
    private JTable table;
    private JScrollPane scrollPane;
    private TableRowSorter<DefaultTableModel> sorter;

    public TableSortingExample() {
        setTitle("Table Sorting Example");
        setSize(400, 300);

        // Create the table and add data to it
        String[] columnNames = {"Name", "Age", "Gender"};
        Object[][] data = {
                {"John", 10, "Male"},
                {"Alice", 2, "Female"},
                {"Bob", 4, "Male"},
                {"Jane", 35, "Female"}
        };
        DefaultTableModel tmodel = new DefaultTableModel(data, columnNames);
        table = new JTable(tmodel);

        // Add a row sorter to the table
        sorter = new TableRowSorter<>(tmodel);
        table.setRowSorter(sorter);

        // Sort the table in descending order by age
        sorter.setSortKeys(java.util.List.of(new RowSorter.SortKey(1, SortOrder.ASCENDING)));
        sorter.sort();

        // Add the table to a scroll pane
        scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        TableSortingExample frame = new TableSortingExample();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
