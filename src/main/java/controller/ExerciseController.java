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
        exerciseList.add(exercise);
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("exercise.json");
        try {
            objectMapper.writeValue(file, exerciseList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeExercise(Exercise exercise) {
        exerciseList.remove(exercise);
    }

    public ObservableList<Exercise> getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(ObservableList<Exercise> ExerciseList) {
        exerciseList = ExerciseList;
    }

    public void setSelectedExercise(Exercise selectedExercise) {
    }
}