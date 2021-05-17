package fpdualeveris;

import operators.City;
import operators.Operator;
import operators.Pinball;
import operators.Player;

/**
 * Clase principal donde se ejecuta el programa.
 * @author David Cesar Fernandez Aliseda
 */

public class FPDual {
    public static void main(String[] args) {
        operatorsChallenge();
    }

    /**
     * Metodo para ejecutar el programa.
     */

    private static void operatorsChallenge(){
        Operator o1 = new Operator("Pepe",52, City.MALAGA);
        Player player1 = new Player("pili",16);
        Pinball p1 = new Pinball();
        p1.playGame(o1);

        p1.playGame(player1);
        p1.playGame(player1);
    }
}