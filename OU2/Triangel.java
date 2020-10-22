package OU2;

public class Triangel {

    public static double omkrets(double sideA, double sideB, double sideC) {
        double triangleCircumference = sideA + sideB + sideC;
        return triangleCircumference;
    }

    public static double bis(double side1, double side2, double angle) {
        double numerator = 2 * side1 * side2 * Math.cos(angle / 2);
        double triangleBis = numerator / (side1 + side2);
        return triangleBis;
    }

    public static double inSkr(double omkrets, double area) {
        double inSkr = (area / (omkrets / 2));
        return inSkr;
    }

    public static double omSkr(double sideA, double sideB, double sideC, double area) {
        double omSkr = (sideA * sideB * sideC) / (4 * area);
        return omSkr;
    }
}
