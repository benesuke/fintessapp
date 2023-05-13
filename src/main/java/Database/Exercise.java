package Database;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Exercise {
    private int id;
    private String name;
    private int duration;

    // getters and setters for id, name, duration

    // constructor for Exercise

    // method to return JSON representation of Exercise object
    public String toJson() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(this);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

