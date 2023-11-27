import java.util.Scanner;
import java.util.Random;
public class numberGame{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int lowerBound =1;
        int upperBound =100;
        int attemptsLimit =10;
        int score =0;
        do{
            int generatedNumber = random.nextInt(upperBound-lowerBound+1)+lowerBound;
            int attempts =0;
            boolean guessedCorrectly = false;
            System.out.println("guess the number between " + lowerBound +" and "+ upperBound +":");
            while(attempts < attemptsLimit){
                int userGuess=sc.nextInt();
                attempts++;
                if(userGuess == generatedNumber){
                    guessedCorrectly = true;
                    break;
                }
                else if(userGuess < generatedNumber){
                    System.out.println("too low! try again.");
                }
                else {
                    System.out.println("too high! try again.");
                }
            }
            if(guessedCorrectly){
                System.out.println("Congratulations! you guessed the number in " + attempts+"attempts.");
                score +=attempts;
            }
            else{
                System.out.println("Sorry,you've reached the maximum number of attempts.the correct number was:"+generatedNumber);
            }
            System.out.println("your current score:"+score);
            System.out.println("Do you want to play again?(yes/no):");
        }
        while(sc.next().equalsIgnoreCase("yes"));
        System.out.println("Game over.Your final score:"+score);
        sc.close();
    }
}
