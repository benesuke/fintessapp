package Database;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExerciseDAO {
    private final String FILE_PATH = "exercises.json";

    public void saveExercises(List<Exercise> exercises) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            objectMapper.writeValue(new File(FILE_PATH), exercises);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Exercise> loadExercises() {
        ObjectMapper objectMapper = new ObjectMapper();
        CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Exercise.class);
        try {
            return objectMapper.readValue(new File(FILE_PATH), listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        List<Exercise> exercises = loadExercises();
        exercises.add(exercise);
        saveExercises(exercises);
    }

    public void deleteExercise(Exercise exercise) {
        List<Exercise> exercises = loadExercises();
        exercises.remove(exercise);
        saveExercises(exercises);
    }

    public void updateExercise(Exercise oldExercise, Exercise newExercise) {
        List<Exercise> exercises = loadExercises();
        exercises.remove(oldExercise);
        exercises.add(newExercise);
        saveExercises(exercises);
    }
}
