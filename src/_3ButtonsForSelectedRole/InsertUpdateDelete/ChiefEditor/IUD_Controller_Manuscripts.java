package _3ButtonsForSelectedRole.InsertUpdateDelete.ChiefEditor;
import _1Authorization.DatabaseHandler;
import _3ButtonsForSelectedRole.skeleton.Books;
import _3ButtonsForSelectedRole.skeleton.Manuscripts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

import static _1Authorization.Main.executeQuery;
import static _1Authorization.Main.openNewScene;

public class IUD_Controller_Manuscripts{
    @FXML Button Back, btnInsert, btnUpdate, btnDelete;
    @FXML TableView<Manuscripts> tvManuscripts;
    @FXML TableColumn<Manuscripts, Integer> col_id, col_id_author, col_circulation, col_list;
    @FXML TableColumn<Manuscripts, String> col_manuscript_name, col_genre;
    @FXML TextField tf_id, tf_author, tf_manuscript_name, tf_genre, tf_circulation, tf_list;
    @FXML void handleButtonAction(ActionEvent event) {
        if(event.getSource() == btnInsert){
            insertRecord();
        } else if(event.getSource() == btnUpdate){
            updateRecord();
        } else if(event.getSource() == btnDelete){
            deleteButton();
        }
    }
    public void handleClick(MouseEvent event) {
        try {
            Manuscripts manuscript = tvManuscripts.getSelectionModel().getSelectedItem();
            tf_id.setText("" + manuscript.getId());
            tf_author.setText("" + manuscript.getId_author());
            tf_manuscript_name.setText(manuscript.getManuscript_name());
            tf_genre.setText(manuscript.getGenre());
            tf_circulation.setText("" + manuscript.getCirculation());
            tf_list.setText("" + manuscript.getList());
        }catch (Exception e){}
    }
    @FXML
    void initialize(){
        Back.setOnAction(event -> {
            openNewScene("/_2SelectedRole/ChiefEditor/MainForChiefEditor.fxml", "Авторизация/Главный редактор", "/assets/employee.png");
            Back.getScene().getWindow().hide();
        });
        showManuscripts();
    }
    public ObservableList<Manuscripts> getManuscriptList(){
        ObservableList<Manuscripts> manuscriptList = FXCollections.observableArrayList();
        Connection conn = DatabaseHandler.getConnection();
        String query = "SELECT * FROM `literary_publishing_house`.manuscripts;";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Manuscripts Manuscripts;
            while (rs.next()){
                Manuscripts = new Manuscripts(
                        rs.getInt("id"),
                        rs.getInt("id_author"),
                        rs.getString("manuscript_name"),
                        rs.getString("genre"),
                        rs.getInt("circulation"),
                        rs.getInt("list")
                );
                manuscriptList.add(Manuscripts);
            }
        } catch (Exception e){
            System.out.println("getBooksList " + e);
        }
        return manuscriptList;
    }
    public void showManuscripts(){
        ObservableList<Manuscripts> list = getManuscriptList();
        col_id.setCellValueFactory(new PropertyValueFactory<Manuscripts, Integer>("id"));
        col_id_author.setCellValueFactory(new PropertyValueFactory<Manuscripts, Integer>("id_author"));
        col_manuscript_name.setCellValueFactory(new PropertyValueFactory<Manuscripts, String>("manuscript_name"));
        col_genre.setCellValueFactory(new PropertyValueFactory<Manuscripts, String>("genre"));
        col_circulation.setCellValueFactory(new PropertyValueFactory<Manuscripts, Integer>("circulation"));
        col_list.setCellValueFactory(new PropertyValueFactory<Manuscripts, Integer>("list"));
        tvManuscripts.setItems(list);
    }
    void insertRecord(){
        String query = "INSERT INTO manuscripts VALUES (" +
                Integer.parseInt(tf_id.getText()) + "," +
                Integer.parseInt(tf_author.getText()) + "," + "'" +
                tf_manuscript_name.getText() + "'" + "," +
                "'" + tf_genre.getText() + "'" + "," +
                Integer.parseInt(tf_circulation.getText()) + "," +
                Integer.parseInt(tf_list.getText()) + ")";
        executeQuery(query);
        showManuscripts();
    }
    void updateRecord(){
        try {
            /* UPDATE `literary_publishing_house`.Manuscripts SET id_author = 1, manuscript_name = 'a', genre = 'a', circulation = 1, list = 1 WHERE id = 1 */
            String query = "UPDATE manuscripts SET id_author = " + Integer.parseInt(tf_author.getText()) + "," +
                    "manuscript_name = '" + tf_manuscript_name.getText() + "'," +
                    "genre = '" + tf_genre.getText() + "'," +
                    "circulation = " + Integer.parseInt(tf_circulation.getText()) + "," +
                    "list = " + Integer.parseInt(tf_list.getText()) + " WHERE id = " + Integer.parseInt(tf_id.getText()) + " ";
            executeQuery(query);
            showManuscripts();
        } catch (NumberFormatException numberFormatException) {
            System.out.print("\nИсключение формата числа: Для входной строки: ' ' ");
        }
    }
    void deleteButton(){
        try {
            String query = "DELETE FROM manuscripts WHERE id = " + Integer.parseInt(tf_id.getText()) + " ";
            executeQuery(query);
            showManuscripts();
        } catch (NumberFormatException e) {
            System.out.println("Не указан id");
        }
    }
}
