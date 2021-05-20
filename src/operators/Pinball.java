package operators;

import java.util.Scanner;

/**
 * Esta clase define el objeto Pinball el cual representa una maquina para jugar al Pinball.
 * @author David César Fernández Aliseda
 * @version 14/05/21/A
 */

public class Pinball {
    private static long RECORD = Constant.INITIAL_SCORE;
    private long score;
    private boolean isGaming;
    private static Scanner sc;

    /**
     * Constructor para Pinball
     */

    public Pinball() {
        setScore(Constant.INITIAL_SCORE);
        setGaming(false);
    }

    public static long getRECORD() {
        return RECORD;
    }

    public long getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isGaming() {
        return isGaming;
    }

    public void setGaming(boolean gaming) {
        isGaming = gaming;
    }

    /**
     * Método para jugar en la maqiona
     * @param player el parámetro representa la persona que va a jugar
     */

    public void playGame(Person player){
        setScore(Constant.INITIAL_SCORE);
        
        startGame(player);

        if (isGaming){
            gaming();
            Player player1 = (Player) player;
            player1.setNewPersonalRecord(score);
        }
       
    }

    /**
     * Método para iniciar la partida
     * @param player el parámetro representa la persona que va a jugar
     */

    private void startGame(Person player) {
    	sc = new Scanner(System.in);
        try {
        	
            if (player instanceof Player){
                System.out.println(player.getName()+" ¿Quiere comenzar la partida? s/n");
                String answer = sc.nextLine();

                if (answer.equals("s")) {
                    setGaming(true);
                    System.out.println("La partida a comenzado.");

                }else {
                    System.out.println("La partida no ha comenzado. Hasta pronto!!");
                }
                
            }else{
                System.out.println("Deja de jugar y a trabajar!!");
            }
            	
        } catch (Exception e) {
            System.out.println("Entrada no valida.");
        }
       
    }
    //Jugando

    /**
     * Método con la evolución del juego
     */

    private void gaming(){
        while(isGaming){
            midGame();
            showScore();
            
            botGame();
            showScore();
            
            topGame();
            showScore();
        }

        System.out.print("GAME OVER. ");
        System.out.println("Has conseguido: "+score+" puntos.");
        checkRecord();

    }

    /**
     * Método con la parte superior del juego
     */

    private void topGame(){
        int randomNum=generateRandomNumber(Constant.CERO,Constant.CIEN);

       if (randomNum<=Constant.SETENTAYCINCO){
           score+=Constant.MIN_POINT_TOP;
           System.out.println("+25");
           
       }else if(randomNum<=Constant.NOVENTAYCINCO){
           score+=Constant.MAX_POINT_TOP;
           System.out.println("+50");
           
       }else{
           int points;
           
           for (int i = Constant.CERO; i < generateRandomNumber(Constant.CERO,Constant.CINCUENTA); i++) {
               points=generateRandomNumber(Constant.DIEZ,Constant.CINCUENTA);
               score+=points;
               
               System.out.println("+"+points);
           }
       }
    }

    /**
     * Método con la parte central del juego
     */

    private void midGame(){
        int result = generateRandomNumber(Constant.CERO, Constant.CINCO);

        if (result<=Constant.UNO){//20% posibilidad de caer
            System.out.println("+200");
           score+=Constant.MIN_POINT_MID;
           
        }else if(result>=Constant.CUATRO){//80% posibilidad de caer
            score+=Constant.MAX_POINT_MID;
            System.out.println("+500");
        }
    }

    /**
     * Método con la parte inferior del tablero
     */

    private void botGame(){
        int result = generateRandomNumber(Constant.CERO, Constant.CINCO);
        String side;

        if (result<=Constant.CUATRO){//80% posibilidad de caer
            System.out.println("+40");
            score+=Constant.MIN_POINT_BOT;
            
        }else{
            System.out.println("+250");
            score+=Constant.MAX_POINT_BOT;
        }
        
        showScore();
        
        //Palancas
        
        result = generateRandomNumber(Constant.CERO, Constant.UNO);
        side = (result<1?"izquierda":"derecha");//izquierda=0

        switch (side){
        
            case "izquierda":
                System.out.println("La bola viene por la izquierda.");
                break;
                
            case "derecha":
                System.out.println("La bola viene por la derecha.");
                break;
        }

        if (!playerReaction().equals(side) || generateRandomNumber(Constant.CERO, Constant.CINCO)<Constant.UNO) {
            setGaming(false);
            System.out.println("Has fallado!!");
            
        }else{
            int point;
            
            for (int i = 0; i < generateRandomNumber(Constant.CERO, Constant.DIEZ); i++) {
                point =+generateRandomNumber(Constant.UNO, Constant.TRES)*Constant.CINCO;
                score+=point;
                
                System.out.println("+"+point);
            }
            System.out.println("Le has dado!!");
        }
    }

    /**
     * Método para que el jugador accione las palancas
     * @return palanca que acciona
     */

    private String playerReaction(){
        String side = "";
    
        try {
        	
            do{
                System.out.println("Inserte la palanca que desea accionar: izq/der");
                side = sc.nextLine();
                
            }while(!side.equals("izq") && !side.equals("der"));
            side = (side.equals("izq")?"izquierda":"derecha");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return side;
    }

    /**
     * Método para generar numeros enteros aleatorios entre dos limites dados
     * @param minNum Párametro que representa el limite inferior
     * @param maxNumber Párametro que representa el limite superior
     * @return número entero aleatorio
     */

    private int generateRandomNumber(int minNum, int maxNumber){
        return (int)(Math.round((Math.random() * (maxNumber-minNum)+minNum)));
    }

    /**
     * Metodo para enseñar la puntuación de la partida al jugador
     */

    private void showScore(){
        System.out.println("Puntuacion: "+score);
    }

    /**
     * Método para comprobar si se ha superado el record local
     * @return si ha superado o no el record.
     */
    private boolean checkRecord(){
        boolean newRecord = Boolean.FALSE;
        if (score>RECORD){
            newRecord= Boolean.TRUE;
            changeRecord(score);
            System.out.println("Has conseguido un nuevo record local!!!");
        }else{
            System.out.println("Te has quedado a "+(RECORD-score)+" puntos del record.");
        }

        return newRecord;
    }
    /**
     * Método que cambia el valor del record 
     * @param score puntuacion del nuevo record personal
     */
    private static void changeRecord(long score){
        RECORD=score;
    }
}