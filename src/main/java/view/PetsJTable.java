package view;

import model.PetTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PetsJTable extends JFrame {

    private PetTableModel pets;
    private JTable table;

    public PetsJTable(){

        super("My pets store");

        pets = new PetTableModel();

        table = new JTable(pets);

        JButton addButton = new JButton("Add pet");

        addButton.addActionListener(
                new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String[] pet = {"","","","","","",""};
                        //pets.addRow(pet);

                    }
                }
        );

        JButton removeButton = new JButton("Remove selected pet");

        removeButton.addActionListener(
                new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        //pets.removeRow(table.getSelectedRow());

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
