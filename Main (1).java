package electricitybillingsystem;

import java.util.*;

public class Main {

    //class variable to store count of number of entries in record
    private static int n = 0;

    public static void main(String[] args) throws InvalidNameException {

        Scanner sc = new Scanner(System.in);

        System.out.println("-----------ELECTRICITY BILLING SYSTEM------------");

        int k = 0;
        boolean correct = false;
        while (!correct) {
            try {
                System.out.println("Enter capacity of storing records");
                k = sc.nextInt();
                correct = true;
            } catch (InputMismatchException e) {
                System.out.println("Enter integer only.");
            }
        }

        //Allocating memory to array of object
        Admin obj[];
        obj = new Admin[k];

        for (int i = 0; i < k; i++) {
            obj[i] = new Admin();
        }

        boolean t = true;

        //menu driven code
        while (t) {

            System.out.println("Enter your choice");
            System.out.println("1.Add new customer entry in record");
            System.out.println("2.Delete existing customer record");
            System.out.println("3.Add new bill entry");
            System.out.println("4.Update customer record");
            System.out.println("5.Didplay customer list");
            System.out.println("6.User Login");
            System.out.println("7.Payment Approval list");
            System.out.println("8.Exit the program");

            correct = false;
            int ch = 0;
            while (!correct) {
                try {
                    ch = sc.nextInt();
                    correct = true;
                } catch (InputMismatchException e) {
                    System.out.println("Enter integer only.");
                }
            }

            switch (ch) {

                case 1 -> {

                    obj[n].newentry();
                    n++;
                    break;
                }

                case 2 -> {

                    //searchig of name in record
                    System.out.println("Enter a name of a customer");
                    String s;
                    sc.nextLine();
                    s = sc.nextLine();

                    int i;
                    for (i = 0; i < n; i++) {

                        if (obj[i].getName().equals(s)) {
                            break;
                        }

                    }

                    if (i != n) {

                        //2.For deleting existing record by swapping data and decreasing n by 1
                        for (int j = i; j < n - 1; j++) {

                            obj[j] = obj[j + 1];

                        }
                        n--;
                        System.out.println("Entered name is deleted");
                    } else {
                        System.out.println("Entered name does not exist in record");
                    }
                    break;
                }

                case 3 -> {
                    //3.For adding bill entry

                    //searchig of name in record
                    System.out.println("Enter a name of a customer");
                    String s;
                    sc.nextLine();
                    s = sc.nextLine();

                    int i;
                    for (i = 0; i < n; i++) {
                        if (obj[i].getName().equals(s)) {
                            break;
                        }

                    }
                    if (i != n) {

                        boolean wrong = true;
                        while (wrong) {
                            try {
                                System.out.println("Enter bill amount");
                                double payam;
                                //sc.nextLine();
                                payam = sc.nextDouble();
                                sc.nextLine();
                                obj[i].setBill(payam + obj[i].getBill());
                                wrong = false;
                            } catch (InputMismatchException e) {
                                System.out.println("Enter ineger or double value only");
                            }
                        }
                    } else {
                        System.out.println("Entered name is not in the record");
                    }

//case 3 end        
                    break;
                }

                case 4 -> {
                    //4.For updating customer record

                    System.out.println("Enter a name of a customer");
                    String s;
                    String p;
                    sc.nextLine();
                    s = sc.nextLine();
                    System.out.println("Enter a password of a customer");
                    //sc.nextLine();
                    p = sc.nextLine();
                    int i;
                    for (i = 0; i < n; i++) {
                        if (obj[i].getName().equals(s) && obj[i].getPassword().equals(p)) {
                            break;
                        }

                    }
                    if (i != n) {

                        System.out.println(obj[i].getName() + "  " + obj[i].getId() + "  " + obj[i].getBill());

                        System.out.println("choose what you want to update  "
                                + "1.Name " + " 2.password");
                        correct = false;
                        int uch = 0;
                        while (!correct) {
                            try {
                                // sc.nextLine();
                                uch = sc.nextInt();
                                correct = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Enter integer only.");
                            }
                        }
                        switch (uch) {
                            case 1 -> {
                                String un;
                                sc.nextLine();

                                boolean wrong = true;
                                while (wrong) {
                                    try {
                                        System.out.println("Enter new name");
                                        un = sc.nextLine();
                                        for (i = 0; i < un.length(); i++) {
                                            if (un.charAt(i) < 'A' || (un.charAt(i) > 'Z' && un.charAt(i) < 'a') || un.charAt(i) > 'z') {
                                                throw new InvalidNameException();
                                            }
                                        }
                                        wrong = false;
                                        obj[i].setName(un);
                                        obj[i].setId(un + "2020");
                                    } catch (InvalidNameException e) {
                                        System.out.println("Only characters are valid in user name");
                                    }
                                }
                                break;
                            }
                            case 2 -> {

                                String up;
                                boolean right = false;
                                while (!right) {

                                    System.out.println("Enter new password");
                                    sc.nextLine();
                                    up = sc.nextLine();
                                    obj[i].setPassword(up);
                                    right = obj[i].isPasswordCorrect(up);

                                }
                                break;

                            }
                            default -> {

                                System.out.println("Enter valid choice");

                            }

                        }
                        System.out.println("updated info"); //print updated info
                        System.out.println(obj[i].getName() + "  " + obj[i].getPassword());

                    } else {
                        System.out.println("Entered name or password is wrong.please try again.");
                    }
                    break;
                }

                case 5 -> {
                    //5.Displaying customer list
                    for (int i = 0; i < n; i++) {
                        System.out.println(obj[i].getName() + "  " + obj[i].getId() + "  " + obj[i].getBill());
                    }

                    break;
                }

                case 6 -> {
                    //6.User login

                    String name, p;
                    System.out.println("Enter your name");
                    sc.nextLine();
                    name = sc.nextLine();
                    System.out.println("Enter password");
                    //sc.nextLine();
                    p = sc.nextLine();

                    int i;
                    correct = false;
                    for (i = 0; i < n; i++) {
                        if (obj[i].getName().equals(name)) {
                            if (p.equals(obj[i].getPassword())) {
                                correct = true;
                                break;
                            }
                        }
                    }

                    if (correct) {
                        System.out.println(obj[i].getName() + "  " + obj[i].getId() + "  " + obj[i].getBill());
                        System.out.println("Do you want to request a payment? Enter Yes or No");
                        String s1;
                        s1 = sc.nextLine();

                        if ("Yes".equals(s1)) {
                            System.out.println("Payment approval request has been sent successfully");
                            obj[i].setPayment(true);
                        }

                    } else {
                        System.out.println("Wrong user name or password. please try again.");
                    }
                    break;
                }

                case 7 -> {

                    //7.Payment approval list which will contain payment accepted requests
                    //The list for approval requests
                    for (int i = 0; i < n; i++) {

                        if (obj[i].isPayment() == true) {
                            System.out.println(obj[i].getName() + "  " + obj[i].getBill());
                        }

                    }

                    System.out.println("Enter a name from above list to approve payment");
                    String s;
                    sc.nextLine();
                    s = sc.nextLine();

                    int i;
                    for (i = 0; i < n; i++) {

                        if (obj[i].getName().equals(s)) {
                            break;
                        }

                    }

                    if (i != n) {

                        obj[i].setBill(0);
                        obj[i].setPayment(false);
                        System.out.println("Payment accepted successfully of " + obj[i].getName());

                    } else {

                        System.out.println("Entered name is not from approval list");

                    }
                    break;

                }

                case 8 -> {

                    t = false;
                }

                default -> {

                    System.out.println("Enter valid choice");

                }

            }

        }

    }

}
