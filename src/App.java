import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("--> 824-es feladat <--");

        Reader reader = new Reader();
        ArrayList<Car> cars = reader.fileReader();
    }
}