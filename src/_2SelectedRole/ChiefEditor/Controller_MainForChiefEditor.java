package _2SelectedRole.ChiefEditor;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import static _1Authorization.Main.openNewScene;

public class Controller_MainForChiefEditor {

    @FXML Button Back;
    @FXML Button Authors;
    @FXML Button Manuscripts;
    @FXML Button Books;
    @FXML Button Book_edition;
    @FXML Button Stages;

    @FXML void initialize(){
        Back.setOnAction(event -> {
            openNewScene("/_1Authorization/Authorization.fxml", "Авторизация/", "/assets/book.png");
            Back.getScene().getWindow().hide();
        });
        Authors.setOnAction(event -> {
            openNewScene("/_3ButtonsForSelectedRole/InsertUpdateDelete/ChiefEditor/IUD_Authors.fxml",
                    "Главный редактор/Авторы", "/assets/option.png");
            Authors.getScene().getWindow().hide();
        });
        Manuscripts.setOnAction(event -> {
            openNewScene("/_3ButtonsForSelectedRole/InsertUpdateDelete/ChiefEditor/IUD_Manuscripts.fxml",
                    "Главный редактор/Рукописи", "/assets/option.png");
            Manuscripts.getScene().getWindow().hide();
        });
        Books.setOnAction(event -> {
            openNewScene("/_3ButtonsForSelectedRole/InsertUpdateDelete/ChiefEditor/IUD_Books.fxml",
                    "Главный редактор/Книги", "/assets/option.png");
            Books.getScene().getWindow().hide();
        });
        Book_edition.setOnAction(event -> {
            openNewScene("/_3ButtonsForSelectedRole/InsertUpdateDelete/ChiefEditor/IUD_Book_edition.fxml",
                    "Главный редактор/Издание книги", "/assets/option.png");
            Book_edition.getScene().getWindow().hide();
        });
        Stages.setOnAction(event -> {
            openNewScene("/_3ButtonsForSelectedRole/InsertUpdateDelete/ChiefEditor/IUD_Stages.fxml",
                    "Главный редактор/Этапы", "/assets/option.png");
            Stages.getScene().getWindow().hide();
        });
    }
}

