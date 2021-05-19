package operators;

/**
 * Esta clase define el objeto Player el cual representa una persona que esta encargada del mantenimiento del Pinball.
 * @author David C�sar Fern�ndez Aliseda
 * @version 14/05/21/A
 */

public class Operator extends Person {
    private City city;

    /**
     * Constructor de Operator
     * @param name Par�metro que representa el nombre del operario
     * @param age  Par�metro que representa la edad del operario
     * @param city Par�metro que representa la ciudad del operario
     */

    public Operator(String name, int age, City city) {
        super(name, age);
        setCity(city);
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}