package ztp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {

    private int width = 500, height = 500, suppliers = 7;
    private JPanel pTableFactory, pTableSuplier, pOutput;
    private JTable tableFactory, tableSuplier;
    private JScrollPane scrollTableFactory, scrollTableSuplier, scrollOutput;
    private JButton btnFactoryAddRows, btnFactoryRemoveRows, btnSuplierRemoveRows, btnSuplierAddRows, btnCalculate;
    private JTextArea txtOutput;

    public GUI() {
        setSize(width, height);
        setTitle("ZTP");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(200, 100);
        setResizable(false);
        setLayout(null);
        addComponents();
    }

    private void addComponents() {
        addPanelTableFactory();
        addPanelTableSuplier();
        addPanelOutput();
    }

    private void addPanelTableFactory() {
        pTableFactory = new JPanel();
        pTableFactory.setBounds(10, 10, 180, 120);
        add(pTableFactory);
        String[] columns = {"Zapotrzebowanie zakładów:"};
        Object[] r;
        final DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        tableFactory = new JTable();
        tableFactory.setModel(model);
        tableFactory.setPreferredScrollableViewportSize(new Dimension(160, 48));
        //tableFactory.setFillsViewportHeight(true);
        scrollTableFactory = new JScrollPane(tableFactory);
        pTableFactory.add(scrollTableFactory);
        btnFactoryAddRows = new JButton("Dodaj wiersz");
        btnFactoryAddRows.setFont(new Font("Helvetica", Font.BOLD, 11));
        btnFactoryAddRows.setMargin(new Insets(0, 0, 0, 0));
        btnFactoryAddRows.setPreferredSize(new Dimension(80, 20));
        btnFactoryAddRows.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.addRow(new Object[]{"4.4"});
            }
        });
        pTableFactory.add(btnFactoryAddRows);
        btnFactoryRemoveRows = new JButton("Usuń wiersz");
        btnFactoryRemoveRows.setFont(new Font("Helvetica", Font.BOLD, 11));
        btnFactoryRemoveRows.setMargin(new Insets(0, 0, 0, 0));
        btnFactoryRemoveRows.setPreferredSize(new Dimension(80, 20));
        btnFactoryRemoveRows.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = tableFactory.getRowCount() - 1;
                if (i >= 0)
                    model.removeRow(i);
            }
        });
        pTableFactory.add(btnFactoryRemoveRows);
    }

    private void addPanelTableSuplier() {
        pTableSuplier = new JPanel();
        pTableSuplier.setBounds(pTableFactory.getX() + pTableFactory.getWidth() + 10, pTableFactory.getY(), 280, 120);
        add(pTableSuplier);
        String[] columns = new String[suppliers];
        final DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        tableSuplier = new JTable();
        tableSuplier.setModel(model);
        tableSuplier.setPreferredScrollableViewportSize(new Dimension(260, 48));
        //tableSuplier.setFillsViewportHeight(true);
        scrollTableSuplier = new JScrollPane(tableSuplier);
        pTableSuplier.add(scrollTableSuplier);
        btnSuplierAddRows = new JButton("Dodaj wiersz");
        btnSuplierAddRows.setFont(new Font("Helvetica", Font.BOLD, 11));
        btnSuplierAddRows.setMargin(new Insets(0, 0, 0, 0));
        btnSuplierAddRows.setPreferredSize(new Dimension(80, 20));
        btnSuplierAddRows.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.addRow(new Object[]{"Koszt", "..."});
            }
        });
        pTableSuplier.add(btnSuplierAddRows);
        btnSuplierRemoveRows = new JButton("Usuń wiersz");
        btnSuplierRemoveRows.setFont(new Font("Helvetica", Font.BOLD, 11));
        btnSuplierRemoveRows.setMargin(new Insets(0, 0, 0, 0));
        btnSuplierRemoveRows.setPreferredSize(new Dimension(80, 20));
        btnSuplierRemoveRows.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = tableSuplier.getRowCount() - 1;
                if (i >= 0)
                    model.removeRow(i);
            }
        });
        pTableSuplier.add(btnSuplierRemoveRows);
    }

    private void addPanelOutput() {
        pOutput = new JPanel();
        pOutput.setBounds(pTableFactory.getX(), pTableFactory.getY() + pTableFactory.getHeight() + 10, width - 30, 320);
        add(pOutput);
        btnCalculate = new JButton("OBLICZ");
        getRootPane().setDefaultButton(btnCalculate);
        pOutput.add(btnCalculate);
        txtOutput = new JTextArea(17, 42);
        txtOutput.setLineWrap(true);
        txtOutput.setEditable(false);
        scrollOutput = new JScrollPane(txtOutput);
        pOutput.add(scrollOutput);
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.setVisible(true);
    }

    public JTextArea getTxtOutput() {
        return txtOutput;
    }

    public void actionPerformed(ActionEvent e) {
        if (((JButton) e.getSource()).equals(btnCalculate)) {

        }
    }
}
