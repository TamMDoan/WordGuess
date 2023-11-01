package com.github.zipcodewilmington;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Wordguess {

    String[] listOfWordsToGuess;
    char[] wordToGuess;

    //instantiate it with underscores, the number is whatever
    //random word gets chosen's # of letters
    char[] playersGuesses;
    boolean keepPlaying = true;
    int counter;

    public Wordguess(){
        listOfWordsToGuess = new String[]{"jazz", "bread", "zipcode", "dolio"};
        // randomly select one of the words in the list
        // set it to wordToGuess & create playersGuesses with _ _ _

    }

    public String[] getListOfWordsToGuess(){
        return this.listOfWordsToGuess;
    }

    public void setListOfWordsToGuess(String[] list){
        this.listOfWordsToGuess = list;
    }

    public char[] getWordToGuess() {
        return wordToGuess;
    }

    public void setWordToGuess(char[] wordToGuess) {
        this.wordToGuess = wordToGuess;
    }

    public char[] getPlayersGuesses() {
        return playersGuesses;
    }

    public void setPlayersGuesses(char[] playersGuesses) {
        this.playersGuesses = playersGuesses;
    }

    public void setUpGame(){
        Random random = new Random();
        int randomIndex = random.nextInt(4 - 1 + 1) + 1;
        wordToGuess = listOfWordsToGuess[randomIndex - 1].toCharArray();
        playersGuesses = new char[wordToGuess.length];
        Arrays.fill(playersGuesses, '_');
        counter = wordToGuess.length;
    }

    public void checkIfGuessIsValid(String letter){
        if(Arrays.toString(wordToGuess).contains(letter)){
            for(int i = 0; i < wordToGuess.length - 1; i++){
                if(letter.charAt(0) == wordToGuess[i]){
                    playersGuesses[i] = letter.charAt(0);
                }
            }
        }

        counter++;

    }

    public void runGame(){
        // while keepPlaying

        boolean wordGuessed = false;
        setUpGame();

        while(wordGuessed){

            System.out.println("Current Guesses: ");
            // removing commas and brackets from the printout
            System.out.println(Arrays.toString(playersGuesses).replace(",", " ").replace("[","").replace("]",""));
            System.out.println("You have " + counter + " tries left.");
            System.out.println("Enter a guess (a single letter): ");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();

            checkIfGuessIsValid(input);

            if(wordToGuess == playersGuesses){
                System.out.println("YAY! YOU WIN!");
                wordGuessed = true;
            }
        }
    }
}
