package ex5;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = Constants.getNotStatedNumeric();
        this.color = Constants.getNotStatedString();
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }

    public Car(String model, Engine engine, int weight, String color) {
        this(model, engine);
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

 /**
  @Override
    public String toString() {
        String weight = this.getWeight() == -1 ? "n/a" : String.valueOf(getWeight());
        String displacement = this.getEngine().getDisplacement() == -1 ? "n/a" : String.valueOf(this.getEngine().getDisplacement());

        StringBuilder sb = new StringBuilder();
        return sb
                .append(this.getModel())
                .append(":").append(System.lineSeparator())

                .append(this.getEngine().getModel())
                .append(":").append(System.lineSeparator())

                .append("Power: ").append(this.getEngine().getPower())
                .append(System.lineSeparator())

                .append("Displacement: ").append(displacement)
                .append(System.lineSeparator())

                .append("Efficiency: ").append(this.getEngine().getEfficiency())
                .append(System.lineSeparator())

                .append("Weight: ").append(weight)
                .append(System.lineSeparator())

                .append("Color: ").append(this.getColor())
                .append(System.lineSeparator())
                .toString();
    }*/
    @Override
    public String toString() {
        String newWeight = this.getWeight() == -1 ? "n/a" : String.valueOf(this.getWeight());
        String newDisplacement = this.getEngine().getDisplacement() == -1 ? "n/a" : String.valueOf(this.getEngine().getDisplacement());
        return String.format("%s:%n%s:%nPower: %s%nDisplacement: %s%n" +
                        "Efficiency: %s%n" +
                        "Weight: %s%n" +
                        "Color: %s",
                this.getModel(),
                this.engine.getModel(),
                this.engine.getPower(),
                newDisplacement,
                this.engine.getEfficiency(),
                newWeight,
                this.getColor());
    }
}
