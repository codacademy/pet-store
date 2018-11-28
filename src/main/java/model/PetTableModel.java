package model;

import javax.swing.table.AbstractTableModel;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class PetTableModel extends AbstractTableModel {

    String[] columnNames;
    Object[][] data;

    public PetTableModel() {

        columnNames = new String[] {"Name", "Type", "Birth date", "Nickname", "Age", "Weight", "Special signs"};

        ArrayList<Pet> pets = new ArrayList<>();

        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try{
            Scanner input = new Scanner(new File("C:\\Users\\Astana\\IdeaProjects\\pet-store\\src\\main\\java\\petsdatabase.db"));

            while(input.hasNextLine()){
                String line;
                Pet pet = new Pet();

                line = input.nextLine();

                try{
                    Scanner data = new Scanner(line);
                    if(data.hasNext()){
                        String name = data.next().trim();
                        pet.setName(name);
                    }

                    if(data.hasNext()){
                        PetType petType = new PetType();
                        petType.setTypeName(data.next().trim());
                        pet.setPetType(petType);
                    }

                    if(data.hasNext()){
                        LocalDate birthDate = LocalDate.parse(data.next(), f);
                        pet.setBirthDate(birthDate);
                    }

                    if(data.hasNextInt()){
                        int age = data.nextInt();
                        pet.setAge(age);
                    }

                    if(data.hasNext()){
                        String nickname = data.next().trim();
                        pet.setNickname(nickname);
                    }

                    if(data.hasNext()){
                        double weight = Double.parseDouble(data.next());
                        pet.setWeight(weight);
                    }

                    if(data.hasNext()){
                        String signs = data.next();
                        for(int i = 0; i < signs.split(",").length; i++){
                            pet.addSpecialSign(signs.split(",")[i]);
                        }
                    }

                }catch(Exception e){
                    System.out.println(e);
                }

                pets.add(pet);

            }

        }catch(IOException e){
            System.out.println(e);
        }

        data = new Object[pets.size()][7];

        for (int i = 0; i < pets.size(); i++) {

            data[i][0] = pets.get(i).getName();
            data[i][1] = pets.get(i).getPetType().getTypeName();
            data[i][2] = pets.get(i).getBirthDate().toString();
            data[i][3] = pets.get(i).getNickname();
            data[i][4] = pets.get(i).getAge();
            data[i][5] = pets.get(i).getWeight();
            data[i][6] = pets.get(i).getSpecialSigns();

        }
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        super.setValueAt(aValue, rowIndex, columnIndex);
        fireTableCellUpdated(rowIndex,columnIndex);
    }

    public void addPet(Pet pet){

        Object[][]  newData = new Object[data.length + 1][columnNames.length];

        for(int i = 0; i<data.length; i++){
            newData[i][0] = data[i][0];
            newData[i][1] = data[i][1];
            newData[i][2] = data[i][2];
            newData[i][3] = data[i][3];
            newData[i][4] = data[i][4];
            newData[i][5] = data[i][5];
            newData[i][6] = data[i][6];
        }

        newData[newData.length - 1 ][0] = pet.getName();
        newData[newData.length - 1][1] = pet.getPetType().getTypeName();
        newData[newData.length - 1][2] = pet.getBirthDate();
        newData[newData.length - 1][3] = pet.getNickname();
        newData[newData.length - 1][4] = pet.getAge();
        newData[newData.length - 1][5] = pet.getWeight();
        newData[newData.length - 1][6] = pet.getSpecialSigns();

        data = newData;

    }

    public void deletePet(int rowId){

    }

}
