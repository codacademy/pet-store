package view;

import model.Pet;
import model.PetTableModel;
import model.PetType;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class PetsJTable extends JFrame {

    private PetTableModel pets;
    private JTable table;
    private TableRowSorter<TableModel> rowSorter;
    public PetsJTable(){

        super("My pets store");

        pets = new PetTableModel();

        table = new JTable(pets);

        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

        JTextField jtfFilter = new JTextField();
        JButton jbtFilter = new JButton("Filter");

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Specify a word to match:"),
                BorderLayout.WEST);
        panel.add(jtfFilter, BorderLayout.CENTER);

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

        JButton addButton = new JButton("Add pet");

        addButton.addActionListener(
                new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        Pet pet = new Pet();

                        pet.setName("Tigr");
                        pet.setAge(3);
                        pet.setBirthDate(LocalDate.of(2015, 01, 10));
                        pet.setNickname("Tayson");
                        PetType pt = new PetType();
                        pt.setTypeName("Wild");
                        pet.setPetType(pt);
                        pet.setWeight(200.0);
                        pet.addSpecialSign("polosati");

                        pets.addPet(pet);

                    }
                }
        );

        JButton removeButton = new JButton("Remove selected pet");

        removeButton.addActionListener(
                new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        pets.deletePet(table.getSelectedRow());

                    }
                }
        );

        JPanel inputPanel = new JPanel();
        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        Container container = getContentPane();
        container.add(new JScrollPane(table), BorderLayout.CENTER);
        container.add(inputPanel, BorderLayout.NORTH);
        container.add(panel, BorderLayout.SOUTH);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400,300);
        setVisible(true);

    }

}
