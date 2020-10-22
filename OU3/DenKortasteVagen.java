package OU3;

public class DenKortasteVagen {

    public static int[] mellanstationer(double[] a, double[][] b, double[] c) {

        int r[] = {1,1};
        double min = a[1]+b[1][1]+c[1];

        for (int i=1; i < a.length; i++) {
            for (int j=1; j < c.length; j++) {
                //För att hitta minsta
                if (min > a[i]+b[i][j]+c[j]) {
                    min = a[i]+b[i][j]+c[j];
                    r[0] = i;
                    r[1] = j;
                }
            }
        }

        return r;
    }

    public static double langd(double[] a, double[][] b, double[] c) {

        int[] r = mellanstationer(a, b, c);
        double lang = ( (a[r[0]]) + (b[r[0]][r[1]]) + (c[r[1]]) );
        return lang;
    }
}
