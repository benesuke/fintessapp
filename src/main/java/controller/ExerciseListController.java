package controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modell.Exercise;
import javafx.scene.layout.GridPane;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public class ExerciseListController {
    @FXML private TableView<Exercise> exerciseTable;
    private ExerciseController exerciseController;

    public ExerciseListController() {
        exerciseController = new ExerciseController();
    }

    @FXML
    private void initialize() { //Inicializáló metódus a felület betöltésekor
        exerciseController.setExerciseList(FXCollections.observableList(getJson()));
        exerciseTable.setItems(exerciseController.getExerciseList());
        //Kattintás eseményfigyelő az adattáblán
        exerciseTable.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() > 0) {
                Exercise selectedExercise = exerciseTable.getSelectionModel().getSelectedItem();
                exerciseController.setSelectedExercise(selectedExercise);
            }
        });
    }

    private List<Exercise> loadJson(InputStream is){ //JSON fájl betöltése és deszerializálása edzés objektumok listájává
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Exercise> exercise = objectMapper.readValue(is, new TypeReference<List<Exercise>>() {});
            return exercise;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of();
    }

    public List<Exercise> getJson() { //JSON fájl betöltése és edzés objektumok listájának lekérése
        try {
            List<Exercise> Exercise = loadJson(new FileInputStream("exercise.json"));
            return Exercise;
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

    @FXML
    private void addExerciseButtonClicked(ActionEvent event) { //Gyakorlat hozáadása gomb eseménykezelője
        Dialog<Exercise> dialog = new Dialog<>();
        dialog.setTitle("Új edzés hozzáadása");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField nameField = new TextField();
        nameField.setPromptText("Edzés neve");
        TextField setField = new TextField();
        setField.setPromptText("Szettek száma");
        TextField repsField = new TextField();
        repsField.setPromptText("Ismerétlések száma");
        TextField weightField = new TextField();
        weightField.setPromptText("Súly nehézsége");

        grid.add(new Label("Edzés neve:"), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(new Label("Szettek száma:"), 0, 1);
        grid.add(setField, 1, 1);
        grid.add(new Label("Ismerétlések száma:"), 0, 2);
        grid.add(repsField, 1, 2);
        grid.add(new Label("Súly nehézsége:"), 0, 3);
        grid.add(weightField, 1, 3);

        ButtonType addButton = new ButtonType("Hozzáadás", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addButton, ButtonType.CANCEL);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == addButton) {
                String name = nameField.getText();
                int sets = Integer.parseInt(setField.getText());
                int reps = Integer.parseInt(repsField.getText());
                int weight = Integer.parseInt(weightField.getText());
                return new Exercise(name, sets,reps,weight);
            }
            return null;
        });

        Optional<Exercise> result = dialog.showAndWait();

        result.ifPresent(exercise -> {
            exerciseController.addExercise(exercise);
        });
    }

    @FXML
    private void removeExerciseButtonClicked(ActionEvent event) { //Gyakorlat törlése gomb eseménykezelője
        Exercise selectedExercise = exerciseTable.getSelectionModel().getSelectedItem();
        if (selectedExercise != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Edzés törlése");
            alert.setHeaderText("Biztosan törölni szeretné ezt az edzést?");
            alert.setContentText(selectedExercise.getName());

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                exerciseController.removeExercise(selectedExercise);
            }
        }
    }
    @FXML
    private void backButtonClicked(ActionEvent event) throws IOException { //Vissza gomb eseménykezelője
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("menu.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }
}
