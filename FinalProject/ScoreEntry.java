package FinalProject;

public class ScoreEntry {
    String name;
    int score;

    public ScoreEntry(String name, int score){
        this.name = name;
        this.score = score;
    }
    public String toString(){
        return name + " : " + score;
    }

    public static ScoreEntry fromString(String line){
        String[] parts = line. split(" ",2);
        return new ScoreEntry(parts[0], Integer.parseInt(parts[1]));
    }
}
