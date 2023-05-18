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
        calorieList.add(calorie); //Kalória hozzáadása a listához
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("calorie.json"); // Kalória lista mentése JSON fájlba
         try {
         objectMapper.writeValue(file, calorieList);
         } catch (IOException e) {
           e.printStackTrace();
         }
    }

    public void removeCalorie(Calorie calorie) {
        calorieList.remove(calorie); //Kalória eltávolítása a listából
    }

    public ObservableList<Calorie> getCalorieList() {
        return calorieList; //Getter metódus a kalória listához
    }

    public void setCalorieList(ObservableList<Calorie> CalorieList) {
        calorieList = CalorieList;
    } //Setter metódus a kalória listához

    public void setSelectedCalorie(Calorie selectedCalorie) {
    } //Kiválasztott kalória beállítása
}