package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import modell.Exercise;
import javafx.scene.layout.GridPane;
import java.util.Optional;

public class ExerciseListController {
    @FXML private TableView<Exercise> exerciseTable;
    private ExerciseController exerciseController;

    public ExerciseListController() {
        exerciseController = new ExerciseController();
    }

    @FXML
    private void initialize() {
        exerciseTable.setItems(exerciseController.getExerciseList());
    }

    @FXML
    private void addExerciseButtonClicked(ActionEvent event) {
        Dialog<Exercise> dialog = new Dialog<>();
        dialog.setTitle("Új edzés hozzáadása");

        // Create the username and password labels and fields.
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

        // Set the dialog buttons.
        ButtonType addButton = new ButtonType("Hozzáadás", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addButton, ButtonType.CANCEL);

        dialog.getDialogPane().setContent(grid);

        // Convert the result to an Exercise object when the login button is clicked.
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
    private void removeExerciseButtonClicked(ActionEvent event) {
        // Check if there is at least one exercise in the list
        if (exerciseController.getExerciseList().size() > 0) {
            // Remove the first exercise in the list
            Exercise exerciseToRemove = exerciseController.getExerciseList().get(0);
            exerciseController.removeExercise(exerciseToRemove);
        }
    }
}
