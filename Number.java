import java.util.Random;
import java.lang.Math;
import java.util.Scanner;
class Number{
    static void game(){
        Random rand = new Random();
        int num = rand.nextInt(1000);
        int numGuesses = (int)Math.ceil(Math.log(num)/Math.log(10));
        System.out.println(num + " " + numGuesses);
        System.out.println("You have " + numGuesses + " to guess: ");
        Scanner scan;
        int guess;
        boolean success;
        while(numGuesses>0){
            System.out.print("Guess: ");
            scan = new Scanner(System.in);
            guess = scan.nextInt();
            System.out.println();
            if(guess == num){
                success = true;
                break;
            }
            else if(guess>num){
                System.out.println("Too high");
            }
            else{
                System.out.println("Too Low");
            }
            numGuesses--;
        }
        if(numGuesses==0){
            System.out.println("You failed");
        }
    }
    public static void main(String[] args) {
        Number.game();
    }
}