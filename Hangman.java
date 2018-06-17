// Alec Messer
//CSIS - 2450
package hangman;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Hangman {
	public static void main(String args[]) {
	Scanner scanner = new Scanner(System.in);
	Random rand = new Random();
	String[] guess = {"utah"};
	boolean keepPlaying = true;
			
	while (keepPlaying) {
		System.out.print("Hangman");
		char[] randomGuess = guess[rand.nextInt(guess.length)].toCharArray();
		//int lives = randomGuess.length;
		int lives = 6;
		char[] playerLives = new char[lives];
		
		for (int i = 0; i < randomGuess.length; i++){
			playerLives[i] = '_';
		}
		
		boolean donePlaying = false;
		int tries = 0;
		
		while (!donePlaying && tries != lives){
			System.out.print("Current guesses: ");
			printArray(playerLives);
			System.out.printf("You have %d lives left.", lives - tries);
			System.out.println("Enter a character");
			char input = scanner.nextLine().charAt(0);
			tries++;
			
			System.out.printf("\nYour previous guess: " + input + " \n");
			if (input == '-') {
				keepPlaying = false;
				donePlaying = true;
			} else {
				for (int i = 0; i < randomGuess.length; i++){
					if (randomGuess[i] == input){
						playerLives[i] = input;
						tries--;
						System.out.println("Good Guess!\n");		 
					}
				}
				
				if (wordIsGuessed(playerLives)){
					donePlaying = true;
					System.out.println("You win!");
				}
			}
		}
		if (!donePlaying) System.out.printf("You ran out of guesses, the word was %s \n", Arrays.toString(guess));
		System.out.println("Do you want to play again? (y/n)");
		String playAgain = scanner.nextLine();
		if (playAgain.equals("n")) keepPlaying = false;
	}
	
	System.out.println("Game Over");
	
	}
	
	public static void printArray(char[] array){
		for (int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	public static boolean wordIsGuessed(char[] array) {
		for (int i = 0; i < array.length; i++){
			if (array[i] == '_') return false;
		}
		return true;
	}

}
