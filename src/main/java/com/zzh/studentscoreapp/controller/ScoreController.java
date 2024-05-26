package com.zzh.studentscoreapp.controller;

import com.zzh.studentscoreapp.model.ScoreFileHandler;
import com.zzh.studentscoreapp.model.Student;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import java.util.Optional;

/**
 * projectName: StudentScoreApp
 *
 * @author: Eternity
 * time: 2024/5/26 0026 16:47
 * description:
 */
public class ScoreController {
    @FXML
    private TextField inputField;

    @FXML
    private Button searchButton;

    @FXML
    private Label chineseScore;

    @FXML
    private Label mathScore;

    @FXML
    private Label englishScore;

    @FXML
    private Label averageScore;

    @FXML
    private Label errorMessage;

    private ScoreFileHandler scoreFileHandler;

    public ScoreController() {
        scoreFileHandler = new ScoreFileHandler("src/main/resources/score.txt");
    }

    @FXML
    private void initialize() {
        // 取消焦点请求
        inputField.setFocusTraversable(false);
        /*// 当用户点击文本框时，将调用clear()方法清空文本框中的内容
        inputField.setOnMouseClicked(event -> {
            inputField.clear();
        });*/
        inputField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                String input = inputField.getText().trim();
                // 在这里执行查询逻辑
                searchStudent();
            }
        });
        searchButton.setOnAction(event -> searchStudent());
    }

    private void searchStudent() {
        String input = inputField.getText();
        Optional<Student> studentOptional = scoreFileHandler.findStudent(input);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            chineseScore.setText(String.valueOf(student.getChineseScore()));
            mathScore.setText(String.valueOf(student.getMathScore()));
            englishScore.setText(String.valueOf(student.getEnglishScore()));
            averageScore.setText(String.format("%.2f", student.calculateAverage()));
            errorMessage.setText("");
        } else {
            chineseScore.setText(null);
            mathScore.setText(null);
            englishScore.setText(null);
            averageScore.setText(null);
            errorMessage.setText("未找到该学生的信息");
        }
    }
}
