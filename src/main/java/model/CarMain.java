package model;

import java.util.Scanner;

public class CarMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car car = new Car("malibu",65.0,10,8);
        while (true){
            System.out.println(" 0 => Exit, 1 => Start , 2 => Drive , 3 => Zapravka , 4 => About");
            switch (scanner.nextInt()){
                case 0:
                    return;
                case 1:
                    car.start();
                    break;
                case 2:
                    if (car.isState()) {
                        System.out.println("masofani kiriting");
                        car.drive(scanner.nextDouble());
                    }
                    else {
                        System.out.println(" Mashina yoqilmagan ");
                    }
                    break;
                case 3:
                    car.reFuel(scanner.nextDouble());
                    break;
                case 4:
                    car.about();
                    break;
            }
        }
    }
}
