package com.zzh.studentscoreapp.model;

/**
 * projectName: StudentScoreApp
 *
 * @author: Eternity
 * time: 2024/5/26 0026 16:48
 * description:
 */
public class Student {
    private String studentId;
    private String name;
    private double chineseScore;
    private double mathScore;
    private double englishScore;

    public Student(String studentId, String name, double chineseScore, double mathScore, double englishScore) {
        this.studentId = studentId;
        this.name = name;
        this.chineseScore = chineseScore;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public double getChineseScore() {
        return chineseScore;
    }

    public double getMathScore() {
        return mathScore;
    }

    public double getEnglishScore() {
        return englishScore;
    }

    public double calculateAverage() {
        return (chineseScore + mathScore + englishScore) / 3;
    }
}
