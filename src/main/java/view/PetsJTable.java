package view;

import model.PetTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PetsJTable extends JFrame {

    private PetTableModel pets;
    private JTable table;

    public PetsJTable() {

        super("My pets store");

        pets = new PetTableModel();

        table = new JTable(pets);

        JButton addButton = new JButton("Add pet");

        addButton.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String[] pet = {"", "", "", "", "", "", ""};
                        //pets.addRow(pet);

                    }
                }
        );

        JButton removeButton = new JButton("Remove selected pet");

        removeButton.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        //pets.removeRow(table.getSelectedRow());

                    }
                }
        );

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();


                    JInternalFrame editorPopup = new JInternalFrame(
                            "Edit Record", true, true, true, true);

                    GridLayout gridLayout = new GridLayout(0, 2);
                    gridLayout.setHgap(5);
                    gridLayout.setVgap(5);

                    editorPopup.setLayout(gridLayout);

                    editorPopup.add(new JLabel(getColumnTitle(0)));
                    JTextField name = new JTextField(20);
                    name.setText(target.getValueAt(row, 0).toString());
                    editorPopup.add(name);

                    editorPopup.add(new JLabel(getColumnTitle(1)));
                    JTextField type = new JTextField(20);
                    type.setText(target.getValueAt(row, 1).toString());
                    editorPopup.add(type);

                    editorPopup.add(new JLabel(getColumnTitle(2)));
                    JTextField birthDate = new JTextField(20);
                    birthDate.setText(target.getValueAt(row, 2).toString());
                    editorPopup.add(birthDate);

                    editorPopup.add(new JLabel(getColumnTitle(3)));
                    JTextField nickname = new JTextField(20);
                    nickname.setText(target.getValueAt(row, 3).toString());
                    editorPopup.add(nickname);

                    editorPopup.add(new JLabel(getColumnTitle(4)));
                    JTextField age = new JTextField(20);
                    age.setText(target.getValueAt(row, 4).toString());
                    editorPopup.add(age);

                    editorPopup.add(new JLabel(getColumnTitle(5)));
                    JTextField weight = new JTextField(20);
                    weight.setText(target.getValueAt(row, 6).toString());
                    editorPopup.add(weight);

                    editorPopup.add(new JLabel(getColumnTitle(6)));
                    JTextField specialSigns = new JTextField(20);
                    specialSigns.setText(target.getValueAt(row, 6).toString());
                    editorPopup.add(specialSigns);

                    JButton okButton = new JButton("Ok");
                    okButton.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {

                            table.getModel().setValueAt(name.getText(), row, 0);
                            table.getModel().setValueAt(type.getText(), row, 1);
                            table.getModel().setValueAt(birthDate.getText(), row, 2);
                            table.getModel().setValueAt(nickname.getText(), row, 3);
                            table.getModel().setValueAt(age.getText(), row, 4);
                            table.getModel().setValueAt(weight.getText(), row, 5);
                            table.getModel().setValueAt(specialSigns.getText(), row, 6);

                            JOptionPane.showMessageDialog(((JButton) e
                                    .getSource()).getParent(), "Record Saved!");
                        }
                    });

                    editorPopup.add(okButton);

                    JButton cancelButton = new JButton("Cancel");
                    cancelButton.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                            editorPopup.hide();
                        }
                    });

                    editorPopup.add(cancelButton);

                    editorPopup.pack();

                    target.add(editorPopup);
                    editorPopup.setVisible(true);
                    editorPopup.setClosable(true);
                }

            }
        });

        table.setPreferredScrollableViewportSize(new Dimension(400, 400));
        table.setFillsViewportHeight(true);

        JPanel inputPanel = new JPanel();
        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        Container container = getContentPane();
        container.add(new JScrollPane(table), BorderLayout.CENTER);
        container.add(inputPanel, BorderLayout.NORTH);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);

    }

    private String getColumnTitle(int index) {

        String title = null;

        switch (index) {
            case 0:
                title = "Name";
                break;
            case 1:
                title = "Type";
                break;
            case 2:
                title = "Birth date";
                break;
            case 3:
                title = "Nickname";
                break;
            case 4:
                title = "Age";
                break;
            case 5:
                title = "Weight";
                break;
            case 6:
                title = "Special signs";
                break;
        }

        return title;
    }

}
