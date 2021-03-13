import java.util.Scanner;
import java.util.InputMismatchException;
//import java.lang.NumberFormatException;

public class Functions {

    public static void main(String[] args) {
        int nb;
        int[] arr = new int[3];
        for (int i = 100000000; i != 0; --i) {
            nb = nbRandom(1, 3);
            switch (nb) {
                case 1:
                    arr[0] += 1;
                    break;
                case 2:
                    arr[1] += 1;
                    break;
                case 3:
                    arr[2] += 1;
                    break;
            }
        }
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
    }

    public static int askInt() {
        Scanner sc = new Scanner(System.in);
        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            sc.next();
            System.out.println("You have to choose an integer");
            return askInt();
        }
    }

    public static int askInt(int inf, int sup) {
        Scanner sc = new Scanner(System.in);
        try {
            int nb = sc.nextInt();
            if (nb < inf || nb > sup) {
                System.out.println("You have to choose a number between " + inf + " et " + sup);
                return askInt(inf, sup);
            }
            return nb;
        } catch (InputMismatchException e) {
            sc.next();
            System.out.println("You have to choose an integer");
            return askInt(inf, sup);
        }
    }

    public static int nbRandom(int nbInf, int nbSup) {
        return nbInf + (int)(Math.random() * (nbSup - nbInf + 1));
    }

    /*
    public static String decToBin(int dec) {
        boolean negative = false;
        StringBuilder str = new StringBuilder();
        if (dec < 0) {
            dec = -dec;
            negative = true;
        }
        while (dec > 1) {
            str.append(dec % 2);
            dec /= 2;
        }
        str.append(dec);
        if (negative) {
            str.append("-");
            str.reverse();
            return String.valueOf(str);
        } else {
            return String.valueOf(str.reverse());
        }
    }

    public static int binToDec(String str) {
        try {
            return Integer.parseInt(str, 2);
        } catch (NumberFormatException e) {
            System.err.println("The word is not a number (return 0)");
            return 0;
        }
    }
    */
}