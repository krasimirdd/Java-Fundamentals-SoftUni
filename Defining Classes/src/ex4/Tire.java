package ex4;

public class Tire {

    private Integer age;
    private Double pressure;

    public Tire() {
    }

    public Tire(Double pressure, Integer age) {
        setAge(age);
        setPressure(pressure);
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }
}

