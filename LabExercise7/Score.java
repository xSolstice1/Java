package lab7;

public class Score {
    private String name;
    private int score;
    
    public Score(String name, int score){
        this.name = name;
        this.score = score;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getScore(){
        return this.score;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setScore(int score){
        this.score = score;
    }
    
    public double getAverage(Score[] arr){
        int total = 0;
        int count = 0;
        double average = 0;
        for (int i = 0; i < arr.length; i++){
            total += arr[i].getScore();
            count += 1;
        }
        average = (double) total/count;
        return average;        
    }
    
    public int getLowest(Score[] arr){
        int lowest = arr[0].getScore();
        for (int i=0; i<arr.length; i++){
            if (lowest>arr[i].getScore()){
                lowest = arr[i].getScore();
            }
        }
        return lowest;
    }
    
    public int getHighest(Score[] arr){
        int highest = arr[0].getScore();
        for (int i=0; i<arr.length; i++){
            if (highest<arr[i].getScore()){
                highest = arr[i].getScore();
            }
        }
        return highest;
    }
    
    public String getData(Score[] arr){
        String data = "";
        for (int i=0; i<arr.length; i++){
            data += arr[i].getName() + "," + arr[i].getScore() + "\n";
        }
        return data;
    }
} //end of score class
