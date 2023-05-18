package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modell.Exercise;
import java.io.File;
import java.io.IOException;

public class ExerciseController {
    private ObservableList<Exercise> exerciseList = FXCollections.observableArrayList();

    public void addExercise(Exercise exercise) {
        exerciseList.add(exercise); //Edzés hozzáadása a listához
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("exercise.json"); // Edzés lista mentése JSON fájlba
        try {
            objectMapper.writeValue(file, exerciseList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeExercise(Exercise exercise) { //Edzés eltávolítása a listából
        exerciseList.remove(exercise);
    }

    public ObservableList<Exercise> getExerciseList() { //Getter metódus az edzés listához
        return exerciseList;
    }

    public void setExerciseList(ObservableList<Exercise> ExerciseList) { //Setter metódus az edzés listához
        exerciseList = ExerciseList;
    }

    public void setSelectedExercise(Exercise selectedExercise) { //Kiválasztott edzés beállítása
    }
}