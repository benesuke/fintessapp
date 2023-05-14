package modell;

public class Calorie {
    private String name;
    private int kcal;
    private int fat;
    private int carbohydrate;
    private int protein;

    public Calorie(String name, int kcal, int fat, int carbohydrate, int protein) {
        this.name = name;
        this.kcal = kcal;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
    }

    public Calorie(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }
    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }
}


