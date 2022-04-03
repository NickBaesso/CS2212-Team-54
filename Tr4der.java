import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class TraderTableModel extends AbstractTableModel {
    String[] columnNames = {
            "Trading Client",
            "structure.Coin List",
            "Strategy Name"
    };
    List<String[]> data;

    public TraderTableModel(List<String[]> list) {
        super();
        data = list;
    }

    public void addRow(String[] rowData) {
        data.add((String[]) rowData);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        //all cells false
        if (row == getRowCount() - 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public void setValueAt(Object value, int row, int col) {
        data.get(row)[col] = (String)value;
        fireTableCellUpdated(row, col);
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public Object getValueAt(int row, int col) {
        return data.get(row)[col];
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

}

class ActionTableModel extends AbstractTableModel {
    String[] columnNames = {
            "Trader",
            "Strategy",
            "CryptoCoin",
            "Action",
            "structure.Quantity",
            "Price",
            "Date"
    };
    List<String[]> data;

    public ActionTableModel(List<String[]> list) {
        super();
        data = list;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public Object getValueAt(int row, int col) {
        return data.get(row)[col];
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    public void setValueAt(String value, int row, int col) {
        data.get(row)[col] = value;
        fireTableCellUpdated(row, col);
    }

}

class MainWindow extends JFrame implements ActionListener {
    JButton performTrade, addRow, removeRow;
    List<String[]> traderData = new ArrayList<String[]>();
    List<String[]> actionData = new ArrayList<String[]>();
    TraderTableModel traderModel;
    ActionTableModel actionModel;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(addRow)) {
            traderModel.addRow(new String[]{"", "", ""});
        }
    }

    MainWindow() {

        // Trader Table
        JPanel traderPanel = new JPanel(new BorderLayout());
        JPanel actionPanel = new JPanel(new GridLayout(1, 1));

        traderData.add(new String[]{"", "", ""});
        actionData.add(new String[]{"", "", "", "", "", "", ""});

        traderModel = new TraderTableModel(traderData);
        actionModel = new ActionTableModel(actionData);
        JTable table = new JTable(traderModel);
        JTable actionTable = new JTable(actionModel);
        traderPanel.add(new JScrollPane(table));
        actionPanel.add(new JScrollPane(actionTable));

        addRow = new JButton("Add Row");
        addRow.addActionListener(this);
        removeRow = new JButton("Remove Row");
        JPanel opsPanel = new JPanel();
        opsPanel.add(addRow);
        opsPanel.add(removeRow);
        traderPanel.add(opsPanel, BorderLayout.PAGE_END);

        JPanel middlePanel = new JPanel(new GridLayout(1, 2));
        if (actionData.isEmpty()) {  // No traderesult yet
            middlePanel.add(new JPanel());
        }
        else {
            middlePanel.add(actionPanel);
        }
        middlePanel.add(traderPanel);
        add(middlePanel, BorderLayout.CENTER);

        // Bottom: Perform Trade button
        JPanel panel = new JPanel();
        performTrade = new JButton("Perform Trade");
        panel.add(performTrade);
        add(panel, BorderLayout.PAGE_END);
    }
}

public class Tr4der {
    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        mainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //mainWindow.setUndecorated(true);
        mainWindow.setVisible(true);
    }
}
