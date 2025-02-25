import java.util.ArrayList;

public class Honda{
    public void printHondaCars(ArrayList<Car> cars){
        System.out.println("\nHondák adatai: ");
        for(Car car:cars){
            if(car.brand.equals("Honda")){
                String hasClimateStr;
                if(car.hasClimate){
                    hasClimateStr="van klíma";
                }else{
                    hasClimateStr="nincs klíma";
                }
                System.out.println(car.licensePlate+"\t"+car.brand+"\t"+car.modelYear+"\t"+car.fuelType+"\t"+car.sellingPrice+"\t"+hasClimateStr+"\t"+car.validUntil);
            }
        }
        System.out.println();
    }
    
}