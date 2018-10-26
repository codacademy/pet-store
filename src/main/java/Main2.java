import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.io.*;
import java.io.IOException;
import java.util.Scanner;
import java.lang.Double;

public class Main2 {

    public static void main(String args[]){

    ArrayList<Pet> pets = new ArrayList<>();

    DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try{
            Scanner input = new Scanner(new File("petsdatabase.db"));

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

        for(int i = 0; i < pets.size(); i++) {
            System.out.println("#================================");
            System.out.println(pets.get(i));
        }

        try{
            File file = new File("outputpets.db");
            PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));

            for(int i = 0; i < pets.size(); i++) {
                pw.append("\n" + pets.get(i).getName());
            }

            pw.close();

        }catch(Exception e){

        }

    }
}