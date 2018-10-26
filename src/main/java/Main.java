import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String args[]){

        //# Creating an ArrayList and adding new elements to it
        System.out.println("========= # Creating an ArrayList and adding new elements to it");

        ArrayList<Pet> pets = new ArrayList<>();

        // Adding new elements to the ArrayList
        Pet dog = new Pet();
        dog.setName("Dog");
        PetType labrador = new PetType("Labrador");
        dog.setPetType(labrador);
        LocalDate dogBirthDate = LocalDate.of(2018,1,10);
        dog.setBirthDate(dogBirthDate);
        dog.setNickname("Taimas");
        dog.setAge(5);
        dog.setWeight(20);
        dog.addSpecialSign("white");
        dog.addSpecialSign("not bite");
        dog.addSpecialSign("likes to play");
        System.out.println(dog);

        Pet cat = new Pet();
        cat.setName("Cat");
        PetType sphinks = new PetType("Sphinks");
        cat.setPetType(sphinks);
        LocalDate catBirthDate = LocalDate.of(2016,2,10);
        cat.setBirthDate(catBirthDate);
        cat.setNickname("Musya");
        cat.setAge(3);
        cat.setWeight(3);
        cat.addSpecialSign("white and black");
        cat.addSpecialSign("not bite");
        cat.addSpecialSign("likes to play");
        System.out.println(cat);

        Pet horse = new Pet();
        horse.setName("Horse");
        PetType ahalteke = new PetType("Ahalteke");
        horse.setPetType(ahalteke);
        LocalDate horseBirthDate = LocalDate.of(2013,6,10);
        horse.setBirthDate(horseBirthDate);
        horse.setNickname("Acebest");
        horse.setAge(4);
        horse.setWeight(500);
        horse.addSpecialSign("brown and black");
        horse.addSpecialSign("quick");
        horse.addSpecialSign("likes to play");
        System.out.println(horse);

        pets.add(dog);
        pets.add(cat);
        pets.add(horse);

        //#Accessing elements from an ArrayList
        System.out.println("========= #Accessing elements from an ArrayList");
        System.out.println("First pet: " + pets.get(0));
        System.out.println("Second pet: " + pets.get(1));
        System.out.println("Last pet: " + pets.get(pets.size()-1));

        //#Removing elements from an ArrayList
        System.out.println("========= #Removing elements from an ArrayList");
        pets.remove(2);
        System.out.println("Pets size: " + pets.size());

        //#Iterating over an ArrayList
        System.out.println("========= #Iterating over an ArrayList");
        for(int i = 0; i < pets.size(); i++) {
            System.out.println(pets.get(i));
        }

        //#Sort an ArrayList of Objects using custom Comparator
        System.out.println("========= #Sort an ArrayList of Objects using custom Comparator");
        pets.sort(new Comparator<Pet>() {
            @Override
            public int compare(Pet pet1, Pet pet2) {
                double pet1Weight = pet1.getWeight();
                double pet2Weight = pet2.getWeight();
                return (int)((pet1Weight - pet2Weight)*100);
            }
        });

        for(int i = 0; i < pets.size(); i++) {
            System.out.println(pets.get(i));
        }


    }

}
