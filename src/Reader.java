import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    public ArrayList<Car> fileReader() {
        ArrayList<Car> cars = new ArrayList<>();
        try {
            File file = new File("jaribt.txt");
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNext()) {
                String row = fileScanner.nextLine();
                String[] car = row.split(row);
                Car carData = new Car();
                carData.plate = car[0];
                carData.brand = car[1];
                carData.year = Integer.parseInt(car[2]);
                carData.fuelType = car[3];
                carData.price = Double.parseDouble(car[4]);
                carData.climate = Integer.parseInt(car[5]);
                carData.licenseDate = LocalDate.parse(car[6]);
                cars.add(carData);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Hiba! A fájl nem található! ");
            e.getMessage();
        }
        System.out.println(cars.get(0).plate);
        return cars;

    }
}