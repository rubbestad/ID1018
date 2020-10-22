package OU1;

import java.util.*;

public class OU1 {

    public static void main(String[] args) {

        System.out.println ("TEMPERATURER\n");

        //Inmatningsverktyg
        Scanner in = new Scanner (System.in);
        in.useLocale (Locale.US);

        //Mata in uppgifter om antalet veckor och antalet mätningar
        System.out.print ("Antal veckor: ");
        int antalVeckor = in.nextInt();

        System.out.print ("Antal mätningar per vecka: ");
        int antalMatningarPerVecka = in.nextInt();

        //Plats att lagra temperaturer
        double[][] t = new double[antalVeckor + 1][antalMatningarPerVecka + 1];

        //Mata in temperaturerna
        for (int vecka = 1; vecka <= antalVeckor; vecka++) {

            System.out.println("Temperaturer vecka " + vecka+ ":");

            for (int matning = 1;matning <= antalMatningarPerVecka; matning++)
                t[vecka][matning] = in.nextDouble ();
        }

        System.out.println();

        //Visa temperaturerna
        System.out.println("Temperaturerna:");

        for (int vecka = 1; vecka <= antalVeckor; vecka++) {

            for (int matning = 1;matning <= antalMatningarPerVecka; matning++)

                System.out.print(t[vecka][matning] + " ");

            System.out.println();
        }

        System.out.println();
        /*--------------------------------------------------------------
        Den minsta, den största och medeltemperaturen – Veckovis

		double[] minT = new double[antalVeckor + 1];
		double[] maxT = new double[antalVeckor + 1];
		double[] sumT = new double[antalVeckor + 1];
		double[] medelT = new double[antalVeckor + 1];
		--------------------------------------------------------------*/


        for (int vecka = 1; vecka <= antalVeckor; vecka++) {

            double minT = t[vecka][1];
            double maxT = t[vecka][1];
            double sumT = t[vecka][1];
            double medT = 0;
            double tWeek = 0;

            System.out.println("\nVecka " + vecka + "\n");
            System.out.println("Alla värden: ");

            System.out.print(t[vecka][1] + " ");

            for (int matning = 2; matning <= antalMatningarPerVecka; matning++) {

                tWeek = t[vecka][matning];

                sumT += tWeek;

                if (tWeek > maxT)
                    maxT = tWeek;

                if (tWeek < minT)
                    minT = tWeek;

                System.out.print(tWeek + " ");
            }

            medT = sumT / antalMatningarPerVecka;

            System.out.println("\n\nMax: " + maxT);
            System.out.println("Min: " + minT);
            System.out.println("Medel: " + medT);
            System.out.println("------------");
        }

        /*--------------------------------------------------------------
        Den minsta, den största och medeltemperaturen - Hela mätperioden

		double minTemp = minT[1];
		double maxTemp = maxT[1];
		double sumTemp = sumT[1];
		double medeltemp = 0;
		---------------------------------------------------------------*/

        double sumAll = 0;
        double medAll = 0;
        double maxAll = t[1][1];
        double minAll = t[1][1];

        System.out.println("\nVärden för alla veckor: ");

        for (int vecka = 1; vecka <= antalVeckor; vecka++) {

            for (int matning = 1; matning <= antalMatningarPerVecka; matning++) {

                double tAll = t[vecka][matning];

                sumAll += tAll;

                if (tAll > maxAll)
                    maxAll = tAll;

                if (tAll < minAll)
                    minAll = tAll;

                System.out.print(tAll + " ");
            }
        }

        medAll = sumAll / (antalVeckor * antalMatningarPerVecka);

        System.out.println("\n\nMax: " + maxAll);
        System.out.println("Min: " + minAll);
        System.out.println("Medel: " + medAll);
    }
}
