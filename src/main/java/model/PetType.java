package model;

public class PetType {

    private String typeName;

    public PetType(String typeName){
        this.setTypeName(typeName);
    }

    public PetType(){
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
