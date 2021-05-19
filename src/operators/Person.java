package operators;

/**
 * Esta clase define el objeto Person el cual representa una persona que tendra una funcián frente a la máquina de Pinball.
 * @author David César Fernández Aliseda
 * @version 14/05/21/A
 */

public abstract class Person {
    private String name;
    private int age;

    /**
     * Constructor de person
     * @param name Parámetro que representa el nombre de la persona
     * @param age  Parámetro que representa la edad de la persona
     */

    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}