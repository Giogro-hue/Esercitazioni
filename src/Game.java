import java.util.Scanner;
import java.util.Random;

public class Game {

    //attributes
    private Move currentMovePlayer;
    private Move currentMoveComputer;
    private Move[] moveSet = Move.values() ;

    //wrapper for game logic and ui
    public void start() {
        Scanner scan = new Scanner(System.in);
        System.out.println("BEST OF 3 !\n\n");
        for(int i=0 ; i<3 ; i++){

            System.out.println("Inserisci la tua mossa (ROCK, PAPER, SCISSORS) : ");
            String input = scan.nextLine();

            currentMovePlayer = Move.valueOf(input);
            currentMoveComputer = getRandoMove() ;

            System.out.println("\n\nUser played : " + currentMovePlayer.name() + "\nComputer played : " + currentMoveComputer.name());

            Outcome result = Battle(currentMovePlayer, currentMoveComputer) ;
            result.increment();

            printScore(result) ;

        }
    }

    //handles battle results
    private Outcome Battle(Move pmove, Move cmove){
        if(pmove == cmove) return Outcome.DRAW ;
        if(pmove == Move.ROCK && cmove == Move.SCISSORS) return Outcome.WIN ;
        if(pmove == Move.PAPER && cmove == Move.ROCK) return Outcome.WIN ;
        if(pmove == Move.SCISSORS && cmove == Move.PAPER) return Outcome.WIN ;
        else return Outcome.LOSE ;
    }
    //generates random computer move
    private Move getRandoMove(){
        Random r = new Random();
        return moveSet[r.nextInt(moveSet.length)];
    }

    private void printScore(Outcome result){
        System.out.println("\n\nIT'S A " + result.name());
        System.out.println("\n\nCurrent score is");
        System.out.println("\nWINS: " + Outcome.WIN.getCount());
        System.out.println("\nLOSS: " + Outcome.LOSE.getCount());
        System.out.println("\nDRAW: " + Outcome.DRAW.getCount());
    }


}
