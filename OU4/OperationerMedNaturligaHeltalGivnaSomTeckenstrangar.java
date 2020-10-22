package OU4;

import java.util.Scanner;

public class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar {

    public static void main(String[] args) {

        System.out.println("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRANGAR\n");

        //Mata in två naturliga heltal
        Scanner in = new Scanner(System.in);

        System.out.println("Två naturliga heltal:");
        String tal1 = in.next();
        String tal2 = in.next();

        System.out.println();

        //Addera heltalen och skriv ut resultatet
        String summa = addera(tal1, tal2);
        visa(tal1, tal2, summa, '+');

        //Subtrahera heltalen och skriv ut resultatet
        String differens = subtrahera(tal1, tal2);
        visa(tal1, tal2, differens, '-');
    }

    /*
    addera tar emot två naturliga heltal givna somteckensträngar,
    och returnerar deras summa somen teckensträng
    */
    public static String addera(String tal1, String tal2) {

        int summaInt = Integer.parseInt(tal1) + Integer.parseInt(tal2);
        String summaString = Integer.toString(summaInt);

        return summaString;
    }

    /*
    subtrahera tar emot två naturliga heltal givna somteckensträngar,
    och returnerar deras differens somen teckensträng.
    Det första heltalet är inte mindre än det andra heltalet.
    */
    public static String subtrahera(String tal1, String tal2) {

        int differensInt = Integer.parseInt(tal1) - Integer.parseInt(tal2);
        String differensString = Integer.toString(differensInt);

        return differensString;
    }

    /*
    visa visar två givna naturliga heltal, och resultatet av
    en aritmetisk operation utförd i samband med hetalen
    */
    public static void visa(String tal1, String tal2, String resultat, char operator) {

        //Sätt en lämplig längd på heltalen och resultatet
        int len1 = tal1.length();
        int len2 = tal2.length();
        int len = resultat.length();
        int maxLen = Math.max(Math.max(len1, len2), len);

        tal1 = sattLen(tal1, maxLen - len1);
        tal2 = sattLen(tal2, maxLen - len2);
        resultat = sattLen(resultat, maxLen - len);

        //Skriv ut heltalen och resultatet
        System.out.println("  " + tal1);
        System.out.println("" + operator + " " + tal2);

        for (int i = 0; i < maxLen + 2; i++)
            System.out.print("-");
        System.out.println();

        System.out.println("  " + resultat + "\n");
    }

    //sattLen lägger till ett angivet antal mellanslagi början av en given sträng
    public static String sattLen(String s, int antal) {

        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < antal; i++)
            sb.insert(0, " ");

        return sb.toString();
    }
}