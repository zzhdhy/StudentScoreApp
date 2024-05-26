package com.zzh.studentscoreapp.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

/**
 * projectName: StudentScoreApp
 *
 * @author: Eternity
 * time: 2024/5/26 0026 16:49
 * description:
 */
public class ScoreFileHandler {
    private String filePath;

    public ScoreFileHandler(String filePath) {
        this.filePath = filePath;
    }

    public Optional<Student> findStudent(String input) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String studentId = parts[0].trim();
                    String name = parts[1].trim();
                    String chineseScoreStr = parts[2].trim();
                    String mathScoreStr = parts[3].trim();
                    String englishScoreStr = parts[4].trim();

                    if (input.equals(studentId) || input.equals(name)) {
                        double chineseScore = convertScore(chineseScoreStr);
                        double mathScore = convertScore(mathScoreStr);
                        double englishScore = convertScore(englishScoreStr);

                        if (isValidScore(chineseScore) && isValidScore(mathScore) && isValidScore(englishScore)) {
                            return Optional.of(new Student(studentId, name, chineseScore, mathScore, englishScore));
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private double convertScore(String scoreStr) {
        switch (scoreStr) {
            case "A": return 90;
            case "B": return 75;
            case "C": return 60;
            case "D": return 45;
            case "E": return 30;
            default: return Double.parseDouble(scoreStr);
        }
    }

    private boolean isValidScore(double score) {
        return score >= 0 && score <= 100;
    }
}
