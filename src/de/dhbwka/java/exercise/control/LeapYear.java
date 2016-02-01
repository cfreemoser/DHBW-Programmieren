package de.dhbwka.java.exercise.control;

import java.util.Scanner;

/**
 * Created by cfreimoser on 18.01.16.
 */
public class LeapYear {


    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Jahr eingeben");
        int jahr = myScanner.nextInt();
        /*
        Ein Jahr ist ein Schaltjahr, wenn es durch vier teilbar ist, nicht aber wenn es durch 100 teilbar ist, es
        sei denn, es ist durch 400 teilbar.

         */
        if (jahr % 4 == 0 && jahr % 100 != 0) System.out.println(jahr + " ist ein Schaltjahr");
        else if (jahr % 100 == 0 && jahr % 400 == 0) System.out.println(jahr + " ist ein Schaltjahr");
        else System.out.println(jahr + " ist ein kein Schaltjahr" + "\n");
        main(null);
    }


}

/*
1804
1808
1812
1816
1820
1824
1828
1832
1836
1840
1844
1848
1852
1856
1860
1864
1868
1872
1876
1880
1884
1888
1892
1896
1904
1908
1912
1916
1920
1924
1928
1932
1936
1940
1944
1948
1952
1956
1960
1964
1968
1972
1976
1980
1984
1988
1992
1996
2000
 */