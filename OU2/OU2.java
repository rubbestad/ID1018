package OU2;

public class OU2 {

    public static void main(String[] args) {

        double sideA = 3;
        double sideB = 4;
        double sideC = Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2));
        double base = sideB;
        double height = sideA;
        double angleAB = Math.PI / 2;
        double angleAC = Math.PI / 4;
        double angleBC = Math.PI / 4;
        double area = ((base * height) / 2);
        double omkrets = Triangel.omkrets(sideA, sideB, sideC);


        System.out.println("Tringelns omkrets: " + Triangel.omkrets(sideA, sideB, sideC));
        System.out.println("Bisektris för sidan A och B: " + Triangel.bis(sideA, sideB, angleAB));
        System.out.println("Bisektris för sidan A och C: " + Triangel.bis(sideA, sideC, angleAC));
        System.out.println("Bisektris för sidan B och C: " + Triangel.bis(sideB, sideC, angleBC));
        System.out.println("Radien för triangelns inskrivna cirkel: " + Triangel.inSkr(omkrets, area));
        System.out.println("Radien för triangelns omskrivna cirkel: " + Triangel.omSkr(sideA, sideB, sideC, area));
    }
}
