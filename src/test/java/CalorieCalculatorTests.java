import businesslogic.CalorieCalculator;
import modell.Calorie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class CalorieCalculatorTests {
    @Test
    public void testCalculateTotalCalories_EmptyList_ReturnsZero() {
        // Arrange
        CalorieCalculator calorieCalculator = new CalorieCalculator();
        List<Calorie> calorieList = new ArrayList<>();

        // Act
        int totalCalories = calorieCalculator.calculateTotalCalories(calorieList);

        // Assert
        Assertions.assertEquals(0, totalCalories);
    }//Ez a teszt ellenőrzi, hogy a metódus helyesen kezeli az üres kalória lista esetét.
    // Az elvárt eredmény az, hogy a metódus visszaadja a 0-t, amikor nincsenek kalóriák a listában.

    @Test
    public void testCalculateTotalCalories_SingleCalorie_ReturnsCorrectTotal() {
        // Arrange
        CalorieCalculator calorieCalculator = new CalorieCalculator();
        List<Calorie> calorieList = new ArrayList<>();
        Calorie calorie = new Calorie("Apple", 52, 0, 14, 0);
        calorieList.add(calorie);

        // Act
        int totalCalories = calorieCalculator.calculateTotalCalories(calorieList);

        // Assert
        Assertions.assertEquals(52, totalCalories);
    }//Ez a teszt ellenőrzi, hogy a metódus helyesen számolja ki az összesített kalóriát egyetlen kalória esetén.
    // A teszt létrehoz egy kalória listát egyetlen kalóriával, majd ellenőrzi, hogy a metódus helyesen adja vissza a kalória értékét.

    @Test
    public void testCalculateTotalCalories_MultipleCalories_ReturnsCorrectTotal() {
        // Arrange
        CalorieCalculator calorieCalculator = new CalorieCalculator();
        List<Calorie> calorieList = new ArrayList<>();
        calorieList.add(new Calorie("Apple", 52, 0, 14, 0));
        calorieList.add(new Calorie("Banana", 96, 0, 23, 1));
        calorieList.add(new Calorie("Orange", 62, 0, 15, 1));

        // Act
        int totalCalories = calorieCalculator.calculateTotalCalories(calorieList);

        // Assert
        Assertions.assertEquals(210, totalCalories);
    } //Ez a teszt ellenőrzi, hogy a metódus helyesen számolja ki az összesített kalóriát több kalória esetén.
    // A teszt létrehoz egy kalória listát több kalóriával, majd ellenőrzi, hogy a metódus helyesen adja vissza az összesített kalóriaértéket.
}
