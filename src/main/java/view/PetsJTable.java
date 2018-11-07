package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PetsJTable extends JFrame {

    private DefaultTableModel pets;
    private JTable table;

    public PetsJTable(){

        super("My pets store");

        pets = new DefaultTableModel();

        pets.addColumn("Name");
        pets.addColumn("Pet type");
        pets.addColumn("Birth date");
        pets.addColumn("Nickname");
        pets.addColumn("Age");
        pets.addColumn("Weight");
        pets.addColumn("Special signs");

        String[] dog = {"Cat", "Sphinks", "2016-02-10", "3", "Musya", "3.0", "white and black,not bite,likes to play,"};

        pets.addRow(dog);

        table = new JTable(pets);

        JButton addButton = new JButton("Add pet");

        addButton.addActionListener(
                new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String[] pet = {"","","","","","",""};
                        pets.addRow(pet);

                    }
                }
        );

        JButton removeButton = new JButton("Remove selected pet");

        removeButton.addActionListener(
                new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        pets.removeRow(table.getSelectedRow());

                    }
                }
        );

        JPanel inputPanel = new JPanel();
        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        Container container = getContentPane();
        container.add(new JScrollPane(table), BorderLayout.CENTER);
        container.add(inputPanel, BorderLayout.NORTH);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400,300);
        setVisible(true);

    }

}
