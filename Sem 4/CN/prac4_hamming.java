import java.util.Scanner;

public class prac4_hamming {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 1;
        int size = 4;
        int data[] = new int[size];
        System.out.println("Enter 1 for Even Parity Hamming Code and 2 for Odd Parity Hamming Code");
        choice = sc.nextInt();
        for (int i = 0; i < size; i++) {
            System.out.println("Enter " + (size - i) + "-bit:");
            data[size - i - 1] = sc.nextInt();
        }

        int noOfParity = 0, i = 0, j = 0, m = 0;
        while (i < size) {
            if (Math.pow(2, noOfParity) == (i + noOfParity + 1)) {
                noOfParity++;
            } else {
                i++;
            }
        }
        int parity[] = new int[size + noOfParity];
        for (i = 1; i <= parity.length; i++) {
            if (Math.pow(2, j) == i) {
                parity[i - 1] = 2;
                j++;
            } else {
                parity[(m + j)] = data[m++];
            }
        }
        j = 0;
        for (i = 1; i <= parity.length; i++) {
            if (Math.pow(2, j) == i) {
                int steps = (int) Math.pow(2, j);
                int k;
                int noOf1s = 0;
                int l;
                for (k = 0; k < parity.length; k = l + steps) {
                    for (l = k; l <= k + steps - 1; l++) {
                        if (parity[l] == 1) {
                            noOf1s++;
                        }
                    }
                }
                if (noOf1s % 2 == 0) {
                    if (choice == 1) {
                        parity[i - 1] = 0;
                    } else {
                        parity[i - 1] = 1;
                    }

                } else {
                    if (choice == 1) {
                        parity[i - 1] = 1;
                    } else {
                        parity[i - 1] = 0;
                    }
                }
                j++;
            }
        }
        for (i = 0; i < parity.length; i++) {
            System.out.print(parity[i]);
        }
        sc.close();
    }
}