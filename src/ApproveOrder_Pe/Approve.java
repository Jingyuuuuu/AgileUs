package ApproveOrder_Pe;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Approve extends JPanel {
    private ImageIcon imgLogo = new ImageIcon(getClass().getResource("/Image/Logo.png"));
    private JLabel jlLogo = new JLabel(imgLogo);

    private String[] columnNames
            = {"Order ID", "Quantity", "Status", "Price"};

    private Object[][] data = {
        {"O0001", 2, "Finish", "RM"+30},
        {"O0002", 3, "Finish", "RM"+40},
        {"O0003", 1, "Finish", "RM"+15},
        {"O0004", 5, "Processing", "RM"+65},
        {"O0005", 2, "Processing", "RM"+37},
        {"O0006", 2, "Processing", "RM"+45},
        {"O0007", 3, "Processing", "RM"+66}
    };

    private DefaultTableModel model = new DefaultTableModel(data, columnNames);
    private JTable jTable = new JTable(model);

    private TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(jTable.getModel());

    private JTextField jtfFilter = new JTextField();
    //private JButton jbtFilter = new JButton("Filter");

    public Approve() {
        jTable.setRowSorter(rowSorter);
JButton jbApprove = new JButton("Approve");
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBackground(Color.WHITE);
        
        panel.add(new JLabel("Specify a word to match:"),
                BorderLayout.WEST);
        panel.add(jtfFilter, BorderLayout.CENTER);
        
        panel2.add(new JScrollPane(jTable), BorderLayout.CENTER);
        panel2.add(jbApprove,BorderLayout.SOUTH);
        
        jbApprove.addActionListener(new approveListener());
        jtfFilter.addFocusListener(new orderField());

        setLayout(new BorderLayout());
        add(panel, BorderLayout.SOUTH);
        add(panel2);
        add(jlLogo, BorderLayout.NORTH);
        
        

        jtfFilter.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        
        
    }
    private class approveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int selRow = jTable.getSelectedRow();
            if (selRow != -1) {
                model.removeRow(selRow);
            }

        }
    }
    
    private class orderField implements FocusListener {

        public void focusGained(FocusEvent e) {
            jtfFilter.setBackground(Color.yellow);
        }

        @Override
        public void focusLost(FocusEvent e) {
            jtfFilter.setBackground(Color.white);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
               JFrame frame = new JFrame("Order Approval");
               frame.add(new Approve());
               frame.setSize(700, 500);
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setLocationRelativeTo(null);
               frame.setVisible(true);
            }

        });
    }
}