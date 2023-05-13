package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modell.Exercise;

public class ExerciseController {
    private ObservableList<Exercise> exerciseList = FXCollections.observableArrayList();

    public void addExercise(Exercise exercise) {
        exerciseList.add(exercise);
    }

    public void removeExercise(Exercise exercise) {
        exerciseList.remove(exercise);
    }

    public ObservableList<Exercise> getExerciseList() {
        return exerciseList;
    }
}