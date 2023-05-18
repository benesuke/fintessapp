package modell;

public class Exercise {
    private String name; // Az gyakorlat neve
    private int sets; // Az sorozatok száma
    private int reps; // Az ismétlések száma
    private int weight; // A súly nehézsége kilogrammban

    public Exercise(String name, int sets, int reps, int weight) {
        this.name = name;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
    } //Exercise osztály konstruktora

    public Exercise(){}; //Üres konstruktor az Exercise osztálynak

    public String getName() {
        return name;
    } //Getter metódus az edzés nevének lekérdezéséhez

    public void setName(String name) {
        this.name = name;
    } //Setter metódus az edzés nevének beállításához

    public int getSets() {
        return sets;
    } //Getter metódus a szettek számának lekérdezéséhez

    public void setSets(int sets) {
        this.sets = sets;
    } //Setter metódus a szettek számának beállításához

    public int getReps() {
        return reps;
    } //Getter metódus az ismétlések számának lekérdezéséhez

    public void setReps(int reps) {
        this.reps = reps;
    } //Setter metódus az ismétlések számának beállításához

    public int getWeight() {
        return weight;
    } //Getter metódus a súly nehézségének lekérdezéséhez

    public void setWeight(int weight) {
        this.weight = weight;
    } //Setter metódus a súly nehézségének  beállításához
}
