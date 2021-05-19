package fpdualeveris;

import operators.City;
import operators.Operator;
import operators.Pinball;
import operators.Player;

/**
 * Clase principal donde se ejecuta el programa.
 * @author David César Fernández Aliseda
 */

public class FPDual {
    public static void main(String[] args) {
        operatorsChallenge();
    }

    /**
     * Método para ejecutar el programa.
     */

    private static void operatorsChallenge(){
    	//Instanciacion de operator
        Operator o1 = new Operator("Pepe",52, City.MALAGA);
        
        //Instanciacion de jugador y pinball
        Player player1 = new Player("Tellez",18);
        Pinball p1 = new Pinball();
        
        //Operator no podrá jugar 
        p1.playGame(o1);
        //Ejecución del método playGame para jugar
        p1.playGame(player1);
        p1.playGame(player1);
    }
}