package bodyWeight;

import java.util.Scanner;

public class BodyWeight {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("**********************************************************************\n"
                           + "* IDEAL BODY WEIGHT                                    © Joan Sèculi *\n"
                           + "*                                                                    *\n"
                           + "* There are several formulas to calculate your ideal body weight.    *\n"
                           + "* This program uses 3 different formulas:                            *\n"
                           + "* Creff Formula                                                      *\n"
                           + "* Lorentz Formula                                                    *\n"
                           + "* Berthean Formula                                                   *\n"
                           + "**********************************************************************");

        System.out.println("\nWhat formula do you want to use:\n"
                           + "1. Creff Formula\n"
                           + "2. Lorentz Formula\n"
                           + "3. Berthean Formula");
        System.out.print("\nEnter your option? ");
        byte option = sc.nextByte();

        switch (option) {
            case 1:
                String text = "\nSelect morphology: 1. small, 2. medium, 3. broad ? ";
                System.out.print(text);
                int morphology = 0;
                boolean isValid = false;
                while (!isValid) {
                    if (sc.hasNextInt()) {
                        morphology = sc.nextInt();
                        isValid = true;
                    } else {
                        sc.next();
                        System.out.println("\nError: " + text);
                    }
                }
                text = "Enter your height in cm: ";
                System.out.print(text);
                int height = 0;
                isValid = false;
                while (!isValid) {
                    if (sc.hasNextInt()) {
                        height = sc.nextInt();
                        isValid = true;
                    } else {
                        sc.next();
                        System.out.println("\nError: " + text);
                    }
                }
                text = "Enter your age: ";
                System.out.print(text);
                int age = 0;
                isValid = false;
                while (!isValid) {
                    if (sc.hasNextInt()) {
                        age = sc.nextInt();
                        isValid = true;
                    } else {
                        sc.next();
                        System.out.println("\nError: " + text);
                    }
                }
                double creff = 0;
                if (morphology == 2) {
                    creff = (height - 100 + age / 10.0) * 0.9; // medium (normal)
                } else if (morphology == 1) {
                    creff = (height - 100 + age / 10.0) * Math.pow(0.9, 2); // small (fina)
                } else {
                    creff = (height - 100 + age / 10.0) * 0.9 * 1.1; // broad (gran)
                }
                double creffRound = Math.round(creff * 100) / 100.0;
                System.out.println("Creff = " + creffRound + "kg");
                break;
            case 2:
                text = "Enter your height in cm: ";
                System.out.print(text);
                height = 0;
                isValid = false;
                while (!isValid) {
                    if (sc.hasNextInt()) {
                        height = sc.nextInt();
                        isValid = true;
                    } else {
                        sc.next();
                        System.out.println("\nError: " + text);
                    }
                }
                text = "Enter your age: ";
                System.out.print(text);
                age = 0;
                isValid = false;
                while (!isValid) {
                    if (sc.hasNextInt()) {
                        age = sc.nextInt();
                        isValid = true;
                    } else {
                        sc.next();
                        System.out.println("\nError: " + text);
                    }
                }
                text = "Enter your gender (Men = 1, Women = 2): ";
                System.out.print(text);
                int gender = 0;
                isValid = false;
                while (!isValid) {
                    if (sc.hasNextInt()) {
                        gender = sc.nextInt();
                        isValid = true;
                    } else {
                        sc.next();
                        System.out.println("\nError: " + text);
                    }
                }

                double lorentz = 0;
                if (gender == 1) {
                    lorentz = height - 100 - (height - 150.0) / 4 + (age - 20.0) / 4;
                } else {
                    lorentz = height - 100 - (height - 150.0) / 4 + (age - 20) / 2.5;
                }
                double lorentzRound = Math.round(lorentz * 100) / 100.0;

                System.out.println("Lorentz = " + lorentzRound + "kg");
                break;

            case 3:

                text = "Enter your height in cm: ";
                System.out.print(text);
                height = 0;
                isValid = false;
                while (!isValid) {
                    if (sc.hasNextInt()) {
                        height = sc.nextInt();
                        isValid = true;
                    } else {
                        sc.next();
                        System.out.println("\nError: " + text);
                    }
                }

                text = "Enter your age: ";
                System.out.print(text);
                age = 0;
                isValid = false;
                while (!isValid) {
                    if (sc.hasNextInt()) {
                        age = sc.nextInt();
                        isValid = true;
                    } else {
                        sc.next();
                        System.out.println("\nError: " + text);
                    }
                }
                double berthan = 0;
                berthan = 0.8 * (height - 100) + age / 2.0;
                double berthanRound = Math.round(berthan * 100) / 100.0;
                System.out.print("Berthan = " + berthanRound + " kg");
                break;
        }
        sc.close();
    }
}