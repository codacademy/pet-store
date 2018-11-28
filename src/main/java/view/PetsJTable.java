package view;

import model.Pet;
import model.PetTableModel;
import model.PetType;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

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

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400,300);
        setVisible(true);

    }

}
