package electricitybillingsystem;

import java.util.Scanner;

public class Admin extends Customer {

    private double bill;
    private boolean payment;

    public Admin() {

        payment = false;

    }

    //getter's and setter's
    public void setBill(double bill) {
        this.bill = bill;
    }

    public void setPayment(boolean payment) {
        this.payment = payment;
    }

    public double getBill() {
        return bill;
    }

    public boolean isPayment() {
        return payment;
    }

    //1.For entering new record
    public void newentry() {

        Scanner sc = new Scanner(System.in);
        String n = null;
        String p = null;

        boolean wrong = true;

        while (wrong) {
            try {
                System.out.println("Enter name of customer");
                n = sc.nextLine();
                //sc.nextInt();

                for (int i = 0; i < n.length(); i++) {
                    if (n.charAt(i) < 'A' || (n.charAt(i) > 'Z' && n.charAt(i) < 'a') || n.charAt(i) > 'z') {
                        throw new InvalidNameException();
                    }
                }
                wrong = false;
            } catch (InvalidNameException e) {
                System.out.println("only characters are valid in user name");
            }
        }

        boolean right = false;

        while (!right) {

            System.out.println("Enter password");
            //sc.nextLine();
            p = sc.nextLine();

            right = isPasswordCorrect(p);

        }

        setName(n);
        setPassword(p);
        setId(getName() + "2020");

    }

    //sub 1. for verification if entered password is correct or not
    public boolean isPasswordCorrect(String s) {

        boolean right = false;

        int flag = 0;

        if (((s.length() >= 8) && (s.length() <= 15))) {
            int lower = 0;
            int upper = 0;
            int space = 0;
            int sp = 0;
            int digit = 0;

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (ch >= 'a' && ch <= 'z') {
                    lower++;
                } else if (ch >= 'A' && ch <= 'Z') {
                    upper++;
                } else if (ch == ' ') {
                    space++;
                } else if (ch >= '0' && ch <= '9') {
                    digit++;
                } else {
                    sp++;
                }

            }

            //password must contain atleast 1 upper case
            //1 lower case
            //no space
            //at least one special char
            if (lower >= 1 && upper >= 1 && digit >= 1 && sp >= 1 && space == 0) {
                flag = 1;
            }
        }

        if (flag == 1) {
            right = true;
        }

        if (right == false) {
            System.out.println("password must contain at least one capital,one small and one special character and it must contain at least one digit and legth must be greater than 7");
        }
        return right;

    }

}
