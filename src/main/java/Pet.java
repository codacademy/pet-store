import java.time.LocalDate;
import java.util.ArrayList;

public class Pet {

    private String name;
    private PetType petType;
    private LocalDate birthDate;
    private String nickname;
    private int age;
    private double weight;
    private ArrayList<String> specialSigns = new ArrayList<>();

    public Pet(String name, PetType petType, LocalDate birthDate, String nickname, int age, double weight) {
        this.name = name;
        this.petType = petType;
        this.birthDate = birthDate;
        this.nickname = nickname;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public ArrayList<String> getSpecialSigns() {
        return specialSigns;
    }

    public void addSpecialSign(String specialSign) {

        this.specialSigns.add(specialSign);
    }

}
