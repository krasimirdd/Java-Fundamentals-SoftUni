package ex5;

public class Engine {
    private String model;
    private Integer power;
    private Integer displacement;
    private String efficiency;

    public Engine(String model, Integer power) {
        this.model = model;
        this.power = power;
        this.displacement = Constants.getNotStatedNumeric();
        this.efficiency = Constants.getNotStatedString();
    }

    public Engine(String model, Integer power, Integer displacement) {
        this(model, power);
        this.displacement = displacement;
    }

    public Engine(String model, Integer power, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
    }

    public Engine(String model, Integer power, Integer displacement, String efficiency) {
        this(model, power);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getDisplacement() {
        return displacement;
    }

    public void setDisplacement(Integer displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }
}
