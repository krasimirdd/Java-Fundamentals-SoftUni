package ex4;

public class Engine {
    private Integer speed;
    private Integer power;

    public Engine() {
    }

    public Engine(Integer speed, Integer power) {
        setSpeed(speed);
        setPower(power);
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }
}
