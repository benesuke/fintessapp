package businesslogic;

import modell.Calorie;
import java.util.List;

public class CalorieCalculator {
    public int calculateTotalCalories(List<Calorie> calorieList) {
        //Kiszámítja a bevitt kalóriák összegét a kalórialista alapján.
        int totalCalories = 0;
        for (Calorie calorie : calorieList) {
            totalCalories += calorie.getKcal();
        }
        return totalCalories;
    }
}
