package _2SelectedRole.TechnicalEditor;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import static _1Authorization.Main.openNewScene;

public class Controller_MainForTechnicalEditor {

    @FXML Button Back;
    @FXML Button Authors;
    @FXML Button Books;
    @FXML Button Stages;

    @FXML void initialize(){
        Back.setOnAction(event -> {
            openNewScene("/_1Authorization/Authorization.fxml", "Авторизация/", "/assets/book.png");
            Back.getScene().getWindow().hide();
        });
        Authors.setOnAction(event -> {
            openNewScene("/_3ButtonsForSelectedRole/Watch/TechnicalEditor/Watch_Authors.fxml",
                    "Технический редактор/Авторы", "/assets/option.png");
            Authors.getScene().getWindow().hide();
        });
        Books.setOnAction(event -> {
            openNewScene("/_3ButtonsForSelectedRole/Watch/TechnicalEditor/Watch_Books.fxml",
                    "Технический редактор/Книги", "/assets/option.png");
            Books.getScene().getWindow().hide();
        });
        Stages.setOnAction(event -> {
            openNewScene("/_3ButtonsForSelectedRole/Watch/TechnicalEditor/Update_Stages.fxml",
                    "Технический редактор/Этапы", "/assets/option.png");
            Stages.getScene().getWindow().hide();
        });
    }
}
