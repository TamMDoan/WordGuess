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
        // if the letter is in the actual word
        if(Arrays.toString(wordToGuess).contains(letter)){
            // loop through the word to find out  what position it's at
            for(int i = 0; i < wordToGuess.length; i++){
                if(letter.charAt(0) == wordToGuess[i]){
                    playersGuesses[i] = letter.charAt(0);
                }
            }
        }

        counter--;

    }

    public void runGame(){
        // while keepPlaying
        Scanner in = new Scanner(System.in);
        String input;
        boolean keepPlaying = true;

        boolean wordGuessed = false;
        setUpGame();

        while(keepPlaying) {
            while (!wordGuessed) {

                System.out.println("Current Guesses: ");
                // removing commas and brackets from the printout
                System.out.println(Arrays.toString(playersGuesses).replace(",", " ").replace("[", "").replace("]", ""));

                if (Arrays.toString(playersGuesses).equals(Arrays.toString(wordToGuess))) {
                    System.out.println("YAY! YOU WIN!");
                    wordGuessed = true;
                } else if (counter == 0) {
                    System.out.println("YOU LOSE!!!");
                    break;
                } else {
                    System.out.println("You have " + counter + " tries left.");
                    System.out.println("Enter a guess (a single letter): ");
                    input = in.nextLine();

                    checkIfGuessIsValid(input);
                }


            }

            System.out.println("Would you like to continue playing? ");
            input = in.nextLine();

            if(input.equalsIgnoreCase("no")){
                keepPlaying = false;
                System.out.println("Bye Bye....");
            }
            else{
                wordGuessed = false;
                setUpGame();
            }
        }
    }
}
