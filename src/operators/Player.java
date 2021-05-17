package operators;

/**
 * Esta clase define el objeto Player el cual representa una persona que jugara a la maquina de Pinball.
 * @author David Cesar Fernandez Aliseda
 * @version 14/05/21/A
 */

public class Player extends Person {
    private long personalRecord;

    /**
     * Constructor de player
     * @param name Parametro que representa el nombre del jugador
     * @param age  Parametro que representa la edad del jugador
     */

    public Player(String name, int age) {
        super(name, age);
        setPersonalRecord(personalRecord);
    }

    public long getPersonalRecord() {
        return personalRecord;
    }

    public void setPersonalRecord(long personalRecord) {
        this.personalRecord = personalRecord;
    }
    public void setNewPersonalRecord(long points){
        if (points>personalRecord){
            setPersonalRecord(points);
            System.out.println(getName()+" has conseguido un nuevo record personal!!!");
        }
    }
}