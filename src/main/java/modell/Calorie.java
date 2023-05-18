package modell;

public class Calorie {
    private String name; // A táplálék neve
    private int kcal; // A táplálék kalóriaértéke
    private int fat; // A táplálék zsírtartalma
    private int carbohydrate; // A táplálék szénhidráttartalma
    private int protein; // A táplálék fehérjetartalma

    public Calorie(String name, int kcal, int fat, int carbohydrate, int protein) {
        this.name = name;
        this.kcal = kcal;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
    }//Calorie osztály konstruktora

    public Calorie(){}; //Üres konstruktor a Calorie osztálynak

    public String getName() {
        return name;
    } //Getter metódus a táplálék nevének lekérdezéséhez

    public void setName(String name) {
        this.name = name;
    } //Setter metódus a táplálék nevének beállításához

    public int getKcal() {
        return kcal;
    } //Getter metódus a táplálék kalóriaértékének lekérdezéséhez

    public void setKcal(int kcal) {
        this.kcal = kcal;
    } //Setter metódus a táplálék kalóriaértékének beállításához

    public int getFat() {
        return fat;
    } //Getter metódus a táplálék zsírtatralmának lekérdezéséhez

    public void setFat(int fat) {
        this.fat = fat;
    } //Setter metódus a táplálék zsírtatralmának beállításához

    public int getCarbohydrate() {
        return carbohydrate;
    } //Getter metódus a táplálék szénhidráttartalmának lekérdezéséhez

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    } //Setter metódus a táplálék szénhidráttartalmának beállításához

    public int getProtein() {
        return protein;
    } //Getter metódus a táplálék fehérjetartalmának lekérdezéséhez

    public void setProtein(int protein) {
        this.protein = protein;
    } //Setter metódus a táplálék fehérjetartalmának beállításához
}


