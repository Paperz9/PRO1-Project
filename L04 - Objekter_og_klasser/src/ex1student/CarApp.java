package ex1student;

public class CarApp {

    public static void main(String[] args) {
        Car myCar = new Car("VW UP", "White", "AB 12.345");
        System.out.println("***********************");
        System.out.println("* Brand:  " + myCar.getBrand() + "       *");
        System.out.println("* Color:  " + myCar.getColor() + "       *");
        System.out.println("* Reg-nr:  " + myCar.getRegistrationNumber() + "  *");
        myCar.setKm(5000);
        System.out.println("* Km:  " + myCar.getKm() + "           *");
        System.out.println("***********************");
    }
}
