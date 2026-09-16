import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String rollNumber;
    private List<Double> scores;

    public Student(String name, String rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.scores = new ArrayList<>();
    }

    public void addScore(double score) {
        scores.add(score);
    }

    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public List<Double> getScores() {
        return scores;
    }

    public double getAverage() {
        if (scores.isEmpty()) return 0.0;
        double sum = 0;
        for (double s : scores) sum += s;
        return sum / scores.size();
    }

    public double getHighest() {
        if (scores.isEmpty()) return 0.0;
        double max = scores.get(0);
        for (double s : scores) if (s > max) max = s;
        return max;
    }

    public double getLowest() {
        if (scores.isEmpty()) return 0.0;
        double min = scores.get(0);
        for (double s : scores) if (s < min) min = s;
        return min;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-15s Avg: %-6.2f High: %-6.2f Low: %-6.2f",
                rollNumber, name, getAverage(), getHighest(), getLowest());
    }
}