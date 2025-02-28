import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Sumdata {

    public void printBenzinCars(ArrayList<Car> cars) {
        System.out.println("\nBenzines autók adatai:");
        for (Car car : cars) {
            if (car.fuelType.equals("benzin")) {
                printCar(car);
            }
        }
        System.out.println();
    }

    public void printCheapCars(ArrayList<Car> cars) {
        System.out.println("\n1 milliónál olcsóbb járművek:");
        for (Car car : cars) {
            if (car.sellingPrice < 1000000) {
                printCar(car);
            }
        }
        System.out.println();
    }

    public void printExpiredCars(ArrayList<Car> cars) {
        System.out.println("\nLejárt műszakis autók (több mint 1 éve):");
        LocalDate today = LocalDate.now();
        for (Car car : cars) {
            if (car.validUntil != null && ChronoUnit.YEARS.between(car.validUntil, today) > 1) {
                printCar(car);
            }
        }
        System.out.println();
    }

    public void saveToFile(ArrayList<Car> cars) {
        try (FileWriter writer = new FileWriter("jari.txt")) {
            for (Car car : cars) {
                writer.write(car.licensePlate + ":" + car.brand + ":" + car.modelYear + ":" + car.fuelType + ":" + car.sellingPrice + ":" + (car.hasClimate ? "1" : "0") + ":" + car.validUntil + "\n");
            }
            System.out.println("\nAz adatok sikeresen elmentve a 'jari.txt' fájlba.");
        } catch (IOException e) {
            System.err.println("Hiba történt a fájl írásakor!");
            e.printStackTrace();
        }
    }

    private void printCar(Car car) {
        String hasClimateStr = car.hasClimate ? "van klíma" : "nincs klíma";
        System.out.println(car.licensePlate + "\t" + car.brand + "\t" + car.modelYear + "\t" + car.fuelType + "\t" + car.sellingPrice + "\t" + hasClimateStr + "\t" + car.validUntil);
    }
    public void processAllData(ArrayList<Car> cars) {
        printBenzinCars(cars);
        printCheapCars(cars);
        printExpiredCars(cars);
        saveToFile(cars);
    }
}
