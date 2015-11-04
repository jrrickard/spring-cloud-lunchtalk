package demo.model;

public class Whiskey {

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Double getProof() {
        return proof;
    }

    public void setProof(Double proof) {
        this.proof = proof;
    }

    public void setInventory(Integer inventory) { this.inventory = inventory; }

    public Integer getInventory() { return this.inventory; }

    private String key;

    private String name;
    private String age;
    private Double proof;

    private Integer inventory;




}
