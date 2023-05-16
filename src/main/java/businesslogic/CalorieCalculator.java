package businesslogic;

import modell.Calorie;
import java.util.List;

public class CalorieCalculator {
    public int calculateTotalCalories(List<Calorie> calorieList) {
        int totalCalories = 0;
        for (Calorie calorie : calorieList) {
            totalCalories += calorie.getKcal();
        }
        return totalCalories;
    }
}
