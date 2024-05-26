package com.zzh.studentscoreapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * projectName: StudentScoreApp
 *
 * @author: Eternity
 * time: 2024/5/26 0026 16:46
 * description:
 */
public class StudentScoreApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(StudentScoreApp.class.getResource("/view/ScoreView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("学生成绩查询系统");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
