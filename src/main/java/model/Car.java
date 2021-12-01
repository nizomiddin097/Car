package model;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Car {
    private String model;
    private boolean state;       //mashinani uchiq yoki yoqiq holati
    private double bakVolume;    //Bak sig'imi
    private double insidePetrol; //Bak ichidagi benzin miqdori
    private double consumption;  //100 km ga benzin sarfi
    private int probeg;          //mashinaning yurgan yuli


    public Car() {
    }

    public Car(String model, double bakVolume, double insidePetrol, double consumption) {
        this.model = model;
        this.bakVolume = bakVolume;
        this.insidePetrol = insidePetrol;
        this.consumption = consumption;
    }

    public void start() {
        if (!state) {
            if (insidePetrol > 0) {
                state = true;
                System.out.println("Mashina ut oldi");
                System.out.println(insidePetrol * 100 / consumption + " km ga yetadigan benzin bor ");
            } else {
                System.out.println("Mashinada benzin yuq");
            }
        } else {
            state = false;
            System.out.println("Mashina uchdi");
        }
    }

    public void drive(double distance) {
        Scanner scanner = new Scanner(System.in);
        double spentPetrol = distance * consumption / 100;

            if (spentPetrol > insidePetrol) {
                spentPetrol = insidePetrol;
                System.out.println("manzilgacha borish uchun zapravka qilish kerak ");
                System.out.println(" 0 => Yurish , 1 => Zapravka ");
                if (scanner.nextInt() == 1) {
                    // todo zapravka
                    reFuel(scanner.nextDouble());
                }


                insidePetrol -= spentPetrol;
                System.out.println(distance + " km yurildi.");
                if (insidePetrol == 0){
                    state = false;
                    System.out.println(" mashina uchdi");
                }
                probeg += distance;
            }
        }


    public void reFuel(double fuelPrice){        //zapravka qilish metodi
        Scanner scanner = new Scanner(System.in);
        System.out.println("0=> Exit , 1=> Bakni tuldirish , 2=> Summani aytish , 3=> Litrni aytish ");
        switch (scanner.nextInt()){
            case 0:
                return;
            case 1:
              double soldFuel = bakVolume - insidePetrol;
                      insidePetrol = bakVolume;
                System.out.println(" bak tuldi" + soldFuel + " litr quyildi , summa = " + soldFuel*fuelPrice + " buldi ");
                break;
            case 2:
                System.out.println(" necha pullik ");
                double sum = scanner.nextDouble();
                if (sum/fuelPrice > bakVolume - insidePetrol){
                        soldFuel = bakVolume - insidePetrol;
                        insidePetrol+=soldFuel;
                    System.out.println(" bak tuldi" + soldFuel + " litr quyildi , summa = " + soldFuel*fuelPrice + " buldi ");
                    break;
                }
                else{
                    soldFuel =  sum / fuelPrice;
                    insidePetrol+= soldFuel;
                    System.out.println(soldFuel + " litr quyildi ");
                    break;
                }

        }

        System.out.println(" Zapravka ");
    }

    public void about(){
        System.out.println(toString());
    }


    public void toGetPetrol() {

    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public double getBakVolume() {
        return bakVolume;
    }

    public void setBakVolume(double bakVolume) {
        this.bakVolume = bakVolume;
    }

    public double getInsidePetrol() {
        return insidePetrol;
    }

    public void setInsidePetrol(double insidePetrol) {
        this.insidePetrol = insidePetrol;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("#0,00");
        return "Car{" +
                "model='" + model + '\'' +
                ", state=" + state +
                ", bakVolume=" + bakVolume +
                ", insidePetrol=" + formatter.format(insidePetrol) +
                ", consumption=" + consumption +
                '}';
    }

}
