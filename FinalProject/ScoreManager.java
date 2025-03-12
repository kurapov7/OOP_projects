package FinalProject;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class ScoreManager {
    private static final String FILE_NAME = "highscores.txt";
    private static GameManager gameManager;

    public static void setGameManager(GameManager gm){
        gameManager = gm;
    }
    // Load scores from file
    public static List<ScoreEntry> loadScores(){
        List<ScoreEntry> scores = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] parts = line.split(",");
                if(parts.length == 2){
                    scores.add(new ScoreEntry(parts[0].trim(), Integer.parseInt(parts[1].trim())));
                }
            }
        }catch (IOException e){
            System.out.println("No previous scores found.");
        }
        scores.sort((a,b) -> Integer.compare(b.score, a.score)); // sort in descending order
        return scores;
    }

    // Save top 10 scores to file
    public static void saveScores(List<ScoreEntry> scores) {
        try(PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))){
            for (ScoreEntry entry : scores){
                writer.println(entry.name.trim() +"," + entry.score);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    // add new score to top 10 and save
    public static void saveNewScore(int newScore){
        List<ScoreEntry> scores = loadScores();
        boolean isNewHighScore = scores.isEmpty() || newScore > scores.get(0).score;
        int rank = -1; // Default (not top ten)

        for (int i = 0; i < scores.size(); i++){
            if(newScore > scores.get(i).score){
                rank = i + 1; 
                break;
            }
        }
        
        if(scores.size() < 10 || rank != -1){
            String playerName = JOptionPane.showInputDialog(null,
            (isNewHighScore ? "NEW HIGH SCORE! Enter your name: " : 
            "You placed #"+rank+"! Enter your name: "),
            "High Score!", JOptionPane.PLAIN_MESSAGE);

            if (playerName == null || playerName.trim().isEmpty()) return;
            scores.add(new ScoreEntry(playerName, newScore));
            scores.sort((a,b) -> Integer.compare(b.score, a.score));
            if(scores.size() > 10){
                scores = scores.subList(0, 10); // keep top ten
            }
        }
        saveScores(scores);
        showGameOver(newScore, isNewHighScore, rank);
    }
    public static void showGameOver(int score, boolean isNewHighScore, int rank){
        String message = "Game Over! \nYour Score: " +score;
        if (isNewHighScore){
            message += "\nNEW HIGH SCORE!";
        }else if(rank != -1){
            message += "\nYou placed #"+rank+" on the leaderboard!";
        }else {
            message += "\nYou didn't make the top 10.";
        }

        List<ScoreEntry> scores = loadScores();
        message += "\n\nLEADERBOARD: \n\n";
        for(int i = 0; i < scores.size(); i++){
            message += (i+1) + ". " + scores.get(i).name + " - " + scores.get(i).score +"\n";
        }
        message += "\n\nWould you like to restart or quit?";
    
        int choice = JOptionPane.showOptionDialog(
            null, message, "Game Over",
            JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, new String[]{"Restart", "Quit"}, "Restart"
        );

        if (choice == JOptionPane.YES_OPTION) {
            if (gameManager != null ){
                gameManager.restartGame();  // Restart the game
            }else{
                System.out.println("Error: GameManager is not set");
            }
        } else {
            System.exit(0);  // Exit the game
        }
    }
}
