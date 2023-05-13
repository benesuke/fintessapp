package Database;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class JsonExerciseDAO extends ExerciseDAO {
    private final String fileName = "exercises.json";
    private List<Exercise> exercises = new ArrayList<>();

    // constructor to load exercises from JSON file
    public JsonExerciseDAO() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            exercises = mapper.readValue(new File(fileName), new TypeReference<List<Exercise>>(){});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // implementation of ExerciseDAO interface methods (add, update, delete, getById, getAll)

    // method to save exercises to JSON file
    private void saveExercises() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(fileName), exercises);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
