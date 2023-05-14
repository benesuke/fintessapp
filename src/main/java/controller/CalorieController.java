package controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modell.Calorie;
import java.io.File;
import java.io.IOException;

public class CalorieController {
    private ObservableList<Calorie> calorieList = FXCollections.observableArrayList();

    public void addCalorie(Calorie calorie) {
        calorieList.add(calorie);
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("calorie.json");
         try {
         objectMapper.writeValue(file, calorieList);
         } catch (IOException e) {
           e.printStackTrace();
         }
    }

    public void removeCalorie(Calorie calorie) {
        calorieList.remove(calorie);
    }

    public ObservableList<Calorie> getCalorieList() {
        return calorieList;
    }

    public void setCalorieList(ObservableList<Calorie> CalorieList) {
        calorieList = CalorieList;
    }

    public void setSelectedCalorie(Calorie selectedCalorie) {
    }
}