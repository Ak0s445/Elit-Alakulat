import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("--> 824-es feladat <--");

        Reader reader = new Reader();
        ArrayList<Car> cars = reader.fileReader();

        if(cars.size()>0){
            Honda honda = new Honda();
            honda.printHondaCars(cars);
        }
        Sumdata sumdata = new Sumdata();
        sumdata.processAllData(cars);
    }
}