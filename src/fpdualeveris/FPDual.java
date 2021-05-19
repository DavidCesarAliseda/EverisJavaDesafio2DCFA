package fpdualeveris;

import operators.City;
import operators.Operator;
import operators.Pinball;
import operators.Player;

/**
 * Clase principal donde se ejecuta el programa.
 * @author David C�sar Fern�ndez Aliseda
 */

public class FPDual {
    public static void main(String[] args) {
        operatorsChallenge();
    }

    /**
     * M�todo para ejecutar el programa.
     */

    private static void operatorsChallenge(){
    	//Instanciacion de operator
        Operator o1 = new Operator("Pepe",52, City.MALAGA);
        
        //Instanciacion de jugador y pinball
        Player player1 = new Player("Tellez",18);
        Pinball p1 = new Pinball();
        
        //Operator no podr� jugar 
        p1.playGame(o1);
        //Ejecuci�n del m�todo playGame para jugar
        p1.playGame(player1);
        p1.playGame(player1);
    }
}