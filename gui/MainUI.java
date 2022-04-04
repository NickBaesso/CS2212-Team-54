package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import utils.DataVisualizationCreator;
import infrastructure.*;
import strategy.*;
import utils.*;

/**
 * The main window/UI for the program. This is where
 * all the trade information will be displayed to the
 * user throught the program execution. This will also
 * be how the user interacts with the program.
 *
 * @author Jiangqi
 */
public class MainUI extends GenericUI implements ActionListener {
    private static final long serialVersionUID = 1L;

    private static MainUI instance;
    private JPanel stats, chartPanel, tablePanel;

    // Should be a reference to a separate object in actual implementation
    private List<String> selectedList;

    private JTextArea selectedTickerList;
    //	private JTextArea tickerList;
    private JTextArea tickerText;
    private JTextArea BrokerText;
    private JComboBox<String> strategyList;
    private Map<String, List<String>> brokersTickers = new HashMap<>();
    private Map<String, String> brokersStrategies = new HashMap<>();
    private List<String> selectedTickers = new ArrayList<>();
    private String selectedStrategy = "";
    private DefaultTableModel dtm;
    private JTable table;

    private ArrayList<Trader> traderList = new ArrayList<Trader>();
    private ArrayList<String> traderTracker = new ArrayList<String>();
    private AvailableCryptoList availableCryptoList = AvailableCryptoList.getInstance();
    private HashMap<String, Coin> hmap = availableCryptoList.getMap();

    /**
     * Proxy design method for situations when the user
     * @return an instance of the MainUI class
     */
    public static MainUI getInstance() {
        if (instance == null)
            instance = new MainUI();

        return instance;
    }

    public void setTraderList(ArrayList<Trader> tlist) {
        traderList = tlist;
    }

    /**
     * This constructor creates initializes all the UI elements used in the main method.
     */
    public MainUI() {
        // Set window title
        setTitle("Crypto Trading Tool");

        // Set top bar
        JPanel north = new JPanel();

        JButton trade = new JButton("Perform utils.Trade");
        trade.setActionCommand("refresh");
        trade.addActionListener(this);


        JPanel south = new JPanel();

        south.add(trade);

        dtm = new DefaultTableModel(new Object[]{"Trading Client", "Coin List", "Strategy Name"}, 1);
        table = new JTable(dtm);
        // table.setPreferredSize(new Dimension(600, 300));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Trading Client Actions",
                TitledBorder.CENTER, TitledBorder.TOP));
        Vector<String> strategyNames = new Vector<String>();
        strategyNames.add("None");
        strategyNames.add("Strategy-A");
        strategyNames.add("Strategy-B");
        strategyNames.add("Strategy-C");
        strategyNames.add("Strategy-D");
        TableColumn strategyColumn = table.getColumnModel().getColumn(2);
        JComboBox comboBox = new JComboBox(strategyNames);
        strategyColumn.setCellEditor(new DefaultCellEditor(comboBox));
        JButton addRow = new JButton("Add Row");
        JButton remRow = new JButton("Remove Row");
        addRow.setActionCommand("addTableRow");
        addRow.addActionListener(this);
        remRow.setActionCommand("remTableRow");
        remRow.addActionListener(this);

        scrollPane.setPreferredSize(new Dimension(800, 300));
        table.setFillsViewportHeight(true);


        JPanel east = new JPanel();
//		east.setLayout();
        east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
//		east.add(table);
        east.add(scrollPane);
        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
        buttons.add(addRow);
        buttons.add(remRow);
        east.add(buttons);
//		east.add(selectedTickerListLabel);
//		east.add(selectedTickersScrollPane);

        // Set charts region
        JPanel west = new JPanel();
        west.setPreferredSize(new Dimension(1250, 650));
        stats = new JPanel();
        stats.setLayout(new GridLayout(2, 2));

        west.add(stats);

        getContentPane().add(north, BorderLayout.NORTH);
        getContentPane().add(east, BorderLayout.EAST);
        getContentPane().add(west, BorderLayout.CENTER);
        getContentPane().add(south, BorderLayout.SOUTH);
//		getContentPane().add(west, BorderLayout.WEST);
    }

    /**
     * Updates the UI compoonent with new information.
     * @param component
     */
    public void updateStats(JComponent component) {
        stats.add(component);
        stats.revalidate();
    }

    /**
     * Creates an instance of the Main Window UI and provides the window constraints.
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = MainUI.getInstance();
        frame.setSize(900, 600);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * This method handles the insertion of UI object
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if ("refresh".equals(command)) {  // this is actually performing trade
            for (int count = 0; count < dtm.getRowCount(); count++) {
                Object traderObject = dtm.getValueAt(count, 0);
                if (traderObject == null) {
                    JOptionPane.showMessageDialog(this, "please fill in Trader name on line " + (count + 1));
                    return;
                }
                String traderName = traderObject.toString();

                Object coinObject = dtm.getValueAt(count, 1);
                if (coinObject == null) {
                    JOptionPane.showMessageDialog(this, "please fill in cryptocoin list on line " + (count + 1));
                    return;
                }
                String[] coinNames = coinObject.toString().split(",");
                ArrayList<Coin> clist = new ArrayList<Coin>();

                for (String cname : coinNames) {
                    String csymbol = cname.toLowerCase();
                    if (hmap.containsKey(csymbol)) {
                        clist.add(hmap.get(csymbol));  // add coin to trader's interests
                    }
                }

                Object strategyObject = dtm.getValueAt(count, 2);
                if (strategyObject == null) {
                    JOptionPane.showMessageDialog(this, "please fill in strategy name on line " + (count + 1));
                    return;
                }
                String strategyName = strategyObject.toString();
                AbstractStrategy strategy;
                if (strategyName.equals("Strategy-A")) {
                    strategy = Strategy_A.getInstance();
                }
                else if (strategyName.equals("Strategy-A")) {
                    strategy = Strategy_A.getInstance();
                }
                else if (strategyName.equals("Strategy-A")) {
                    strategy = Strategy_A.getInstance();
                }
                else {
                    strategy = Strategy_A.getInstance();
                }
                System.out.println(traderName + " " + Arrays.toString(coinNames) + " " + strategyName);
                Trader t = new Trader(traderName, clist, strategy);
                traderList.add(t);
            }
            stats.removeAll();

            Trade trade = new Trade(traderList);

            DataVisualizationCreator creator = new DataVisualizationCreator(Strategy_A.getInstance().trade(), traderList);
            creator.createCharts();
        }
        else if ("addTableRow".equals(command)) {
            // trader already existed
            Object traderObject = dtm.getValueAt(dtm.getRowCount() - 1, 0);
            String traderName = traderObject.toString();
            if (traderTracker.contains(traderName)) {
                JOptionPane.showMessageDialog(this, "trader already existed");
            }
            else {
                traderTracker.add(traderName);
                dtm.addRow(new String[3]);
            }
        }
        else if ("remTableRow".equals(command)) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1)
                dtm.removeRow(selectedRow);
        }
    }

    @Override
    public void request() {

    }
}
