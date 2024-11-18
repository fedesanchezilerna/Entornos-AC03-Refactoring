package bodyWeightCalculator;

import java.util.Scanner;

public class BodyWeightCalculator {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        init();

        byte choice = menu();

        switch (choice) {
            case 1:
                String str = "\nSelect morphology: 1. small, 2. medium, 3. broad ? ";

                int morphology = dataEntry(str);

                str = "Enter your height in cm: ";
                int height = dataEntry(str);

                str = "Enter your age: ";
                int age = dataEntry(str);

                double creffRound = creff(morphology, height, age);
                System.out.println("Creff = " + creffRound + "kg");
                break;

            case 2:
                str = "Enter your height in cm: ";
                height = dataEntry(str);

                str = "Enter your age: ";
                age = dataEntry(str);

                str = "Enter your gender (Men = 1, Women = 2): ";
                int gender = dataEntry(str);

                double lorentzRound = getLorentzRound(gender, height, age);
                System.out.println("Lorentz = " + lorentzRound + "kg");
                break;

            case 3:

                str = "Enter your height in cm: ";
                height = dataEntry(str);

                str = "Enter your age: ";
                age = dataEntry(str);

                double berthanRound = berthan(height, age);
                System.out.print("Berthan = " + berthanRound + " kg");
                break;
        }
        sc.close();
    }

    private static double round(double value) {
        return Math.round(value * 100) / 100.0;
    }

    private static double berthan(int height, int age) {
        double berthan;
        berthan = 0.8 * (height - 100) + age / 2.0;
        return round(berthan);
    }

    private static double getLorentzRound(int gender, int height, int age) {
        double lorentz;
        if (gender == 1) {
            lorentz = height - 100 - (height - 150.0) / 4 + (age - 20.0) / 4;
        } else {
            lorentz = height - 100 - (height - 150.0) / 4 + (age - 20) / 2.5;
        }
        return round(lorentz);
    }

    private static double creff(int morphology, int h, int a) {
        double creff;
        if (morphology == 2) {
            creff = (h - 100 + a / 10.0) * 0.9; // medium (normal)
        } else if (morphology == 1) {
            creff = (h - 100 + a / 10.0) * Math.pow(0.9, 2); // small (fina)
        } else {
            creff = (h - 100 + a / 10.0) * 0.9 * 1.1; // broad (gran)
        }
        return round(creff);
    }

    private static int dataEntry(String text) {
        System.out.print(text);
        int data = 0;
        boolean isValid = false;
        while (!isValid) {
            if (sc.hasNextInt()) {
                data = sc.nextInt();
                isValid = true;
            } else {
                sc.next();
                System.out.println("\nError: " + text);
            }
        }
        return data;
    }

    private static byte menu() {
        System.out.println("\nWhat formula do you want to use:\n"
                           + "1. Creff Formula\n"
                           + "2. Lorentz Formula\n"
                           + "3. Berthean Formula");
        System.out.print("\nEnter your option? ");
        return sc.nextByte();
    }

    private static void init() {
        System.out.println("**********************************************************************"
                           + "* IDEAL BODY WEIGHT                       © Federico Sánchez Vidarte *"
                           + "*                                                                    *"
                           + "* There are several formulas to calculate your ideal body weight.    *"
                           + "* This program uses 3 different formulas:                            *"
                           + "* Creff Formula                                                      *"
                           + "* Lorentz Formula                                                    *"
                           + "* Berthean Formula                                                   *"
                           + "**********************************************************************");
    }
}