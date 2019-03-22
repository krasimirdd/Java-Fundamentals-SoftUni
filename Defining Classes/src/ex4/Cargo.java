package ex4;

public class Cargo {
    private Integer weight;
    private String type;

    public Cargo() {
    }

    public Cargo(Integer weight, String type) {
        setWeight(weight);
        setType(type);
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
