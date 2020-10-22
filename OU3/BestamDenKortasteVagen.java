package OU3;

import java.util.Scanner;

public class BestamDenKortasteVagen {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        //Antal vägar från Zon 1 till Zon 2
        System.out.print("m = ");
        int m = in.nextInt() + 1;

        //Antal vägar från Zon 2 till Zon 3
        System.out.print("n = ");
        int n = in.nextInt() + 1;

        double a[] = new double[m];
        double b[][] = new double[m][n];
        double c[] = new double[n];

        for (int i = 1; i < m; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = in.nextDouble();
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                System.out.print("b[" + i + "][" + j + "] = ");
                b[i][j] = in.nextDouble();
            }
        }

        for (int j = 1; j < n; j++) {
            System.out.print("c[" + j + "] = ");
            c[j] = in.nextDouble();
        }

        int r[] = DenKortasteVagen.mellanstationer(a, b, c);
        double lang = DenKortasteVagen.langd(a, b, c);

        System.out.println("\nKortaste vägen är: \n" +
                "Zon 1 till Zon 2 - Station " + r[0] + " är " + a[r[0]] + " lång. \n"
                + "Zon 2 - Station " + r[0] + " till Zon 3 - Station " + r[1] + " är "
                + b[r[0]][r[1]] + " lång. \n" + "Zon 3 - Station " + r[1]
                + " till Zon 4 är " + c[r[1]] + " lång. \nTotal sträcka: " + lang);

    }
}
