import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    public ArrayList<Car> fileReader() {
        ArrayList<Car> cars = new ArrayList<>();
        File file = new File("jaribt.txt");
        try(Scanner fileScanner = new Scanner(file, "utf-8")) {
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                String[] row = line.split(":");
                Car car = new Car();
                car.licensePlate = row[0];
                car.brand = row[1];
                car.modelYear = Integer.parseInt(row[2]);
                car.fuelType = row[3];
                car.sellingPrice = Double.parseDouble(row[4]);
                car.hasClimate = Integer.parseInt(row[5]) == 1;
                try {
                    car.validUntil = LocalDate.parse(row[6]);
                } catch (DateTimeParseException e) {
                    car.validUntil = null; //hibás dátum esetén
                }
                cars.add(car);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Hiba! A fájl nem található!\n");
            e.getMessage();
            e.printStackTrace();
        }

        // System.out.println(cars.get(0).licensePlate);

        System.out.println();
        for (Car car : cars) {
            System.out.println(car.licensePlate+"\t"+car.brand+"\t"+car.modelYear+"\t"+car.fuelType+"\t"+car.sellingPrice+"\t"+car.hasClimate+"\t"+car.validUntil);
        }
        System.out.println();

        return cars;
    }
}