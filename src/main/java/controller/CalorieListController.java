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
import modell.Calorie;
import javafx.scene.layout.GridPane;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public class CalorieListController {
    @FXML private TableView<Calorie> calorieTable;
    private CalorieController calorieController;

    @FXML private Label totalKcalLabel;
    @FXML private Label totalFatLabel;
    @FXML private Label totalCarbohydrateLabel;
    @FXML private Label totalProteinLabel;

    public CalorieListController() {
        calorieController = new CalorieController();
    }

    @FXML
    private void initialize() {
        calorieController.setCalorieList(FXCollections.observableList(getJson()));
        calorieTable.setItems(calorieController.getCalorieList());
        // Add a mouse click listener to the table to track the selected row
        calorieTable.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() > 0) {
                Calorie selectedCalorie = calorieTable.getSelectionModel().getSelectedItem();
                calorieController.setSelectedCalorie(selectedCalorie);
            }
        });
        calculateTotals();
    }

    private void calculateTotals() {
        int totalKcal = 0;
        int totalFat = 0;
        int totalCarbohydrate = 0;
        int totalProtein = 0;

        for (Calorie calorie : calorieController.getCalorieList()) {
            totalKcal += calorie.getKcal();
            totalFat += calorie.getFat();
            totalCarbohydrate += calorie.getCarbohydrate();
            totalProtein += calorie.getProtein();
        }

        totalKcalLabel.setText(String.valueOf(totalKcal));
        totalFatLabel.setText(String.valueOf(totalFat));
        totalCarbohydrateLabel.setText(String.valueOf(totalCarbohydrate));
        totalProteinLabel.setText(String.valueOf(totalProtein));
    }

    private List<Calorie> loadJson(InputStream is){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Calorie> calories = objectMapper.readValue(is, new TypeReference<List<Calorie>>() {});
            return calories;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of();
    }

    public List<Calorie> getJson() {
        try {
            List<Calorie> Calories = loadJson(new FileInputStream("calorie.json"));
            return Calories;
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

    @FXML
    private void addCalorieButtonClicked(ActionEvent event) {
        Dialog<Calorie> dialog = new Dialog<>();
        dialog.setTitle("Új tálálék hozzáadása");

        // Create the username and password labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField nameField = new TextField();
        nameField.setPromptText("Táplálék neve");
        TextField kcalField = new TextField();
        kcalField.setPromptText("Kcal mennyisége");
        TextField fatField = new TextField();
        fatField.setPromptText("Zsírok mennyisége");
        TextField carbohydrateField = new TextField();
        carbohydrateField.setPromptText("Szénhidrátok mennyisége");
        TextField proteinField = new TextField();
        proteinField.setPromptText("Fehérjék mennyisége");

        grid.add(new Label("Táplálék neve:"), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(new Label("Kcal mennyisége:"), 0, 1);
        grid.add(kcalField, 1, 1);
        grid.add(new Label("Zsírok mennyisége:"), 0, 2);
        grid.add(fatField, 1, 2);
        grid.add(new Label("Szénhidrátok mennyisége:"), 0, 3);
        grid.add(carbohydrateField, 1, 3);
        grid.add(new Label("Fehérjék mennyisége:"), 0, 4);
        grid.add(proteinField, 1, 4);

        // Set the dialog buttons.
        ButtonType addButton = new ButtonType("Hozzáadás", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addButton, ButtonType.CANCEL);

        dialog.getDialogPane().setContent(grid);

        // Convert the result to an Exercise object when the login button is clicked.
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == addButton) {
                String name = nameField.getText();
                int kcal = Integer.parseInt(kcalField.getText());
                int fat = Integer.parseInt(fatField.getText());
                int carbohydrate = Integer.parseInt(carbohydrateField.getText());
                int protein = Integer.parseInt(proteinField.getText());
                return new Calorie(name,kcal,fat,carbohydrate,protein);
            }
            return null;
        });

        Optional<Calorie> result = dialog.showAndWait();

        result.ifPresent(calorie -> {
            calorieController.addCalorie(calorie);
            calculateTotals(); // Összesítés frissítése
        });
    }

    @FXML
    private void removeCalorieButtonClicked(ActionEvent event) {
        Calorie selectedCalorie = calorieTable.getSelectionModel().getSelectedItem();
        if (selectedCalorie != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Táplálék törlése");
            alert.setHeaderText("Biztosan törölni szeretné ezt az táplálékot?");
            alert.setContentText(selectedCalorie.getName());

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                calorieController.removeCalorie(selectedCalorie);
                calculateTotals(); // Összesítés frissítése
            }
        }
    }

    @FXML
    private void backButtonClicked(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("menu.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

}
