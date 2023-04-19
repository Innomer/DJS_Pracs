// import java.util.Scanner;

// public class prac4_crc {

//     static char exOR(char bit1, char bit2) {
//         if (bit1 == bit2)
//             return '0';
//         else
//             return '1';
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter Data to be Transferred");
//         String data = sc.nextLine();
//         System.out.println("Enter Generator Value");
//         String generator = sc.nextLine();
//         String dataCopy = data;
//         String remainder = new String();
//         String prevRemainder = new String();
//         int i, j;
//         for (i = 0; i < generator.length(); i++) {
//             dataCopy += '0';
//         }
//         int counter = 0;
//         boolean flag = false;
//         j = 0;
//         int k = 0;
//         while (j < dataCopy.length()) {
//             for (i = 0; i < generator.length(); i++) {
//                 if (counter < generator.length()) {
//                     if (flag == false)
//                         remainder += exOR(dataCopy.charAt(j), generator.charAt(i));
//                     else {
//                         remainder += exOR(prevRemainder.charAt(k), generator.charAt(i));
//                         System.out.println(i);
//                         k+=1;
//                     }
//                     counter += 1;
//                     System.out.println("Remainder " + remainder);
//                 } else {
//                     remainder += dataCopy.charAt(j);
//                     remainder = remainder.substring(1, remainder.length());
//                     System.out.println("Remainder Sub " + remainder);
//                     prevRemainder=remainder;
//                     remainder="";
//                     counter = 0;
//                     k=0;
//                     flag=true;
//                 }
//                 j += 1;
//             }
//             i=0;
//             System.out.println("END");;
//         }
//         sc.close();
//     }
// }
import java.util.*;

class prac4_crc {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Data");
        String dataStr = sc.nextLine();
        System.out.println("Enter Generator");
        String genStr = sc.nextLine();
        int data[] = new int[dataStr.length()];
        int divisor[] = new int[genStr.length()];
        for (int i = 0; i < dataStr.length(); i++) {
            data[i] = Character.getNumericValue(dataStr.charAt(i));
        }
        for (int i = 0; i < genStr.length(); i++) {
            divisor[i] = Character.getNumericValue(genStr.charAt(i));
        }
        int rem[] = division(data, divisor);
        System.out.println("\nGenerated CRC code is: ");

        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
        }
        for (int i = 0; i < rem.length - 1; i++) {
            System.out.print(rem[i]);
        }
        System.out.println();
        sc.close();
    }

    static int[] division(int oldData[], int divisor[]) {
        int rem[] = new int[divisor.length];
        int i;
        int data[] = new int[oldData.length + divisor.length];
        System.arraycopy(oldData, 0, data, 0, oldData.length);
        System.arraycopy(data, 0, rem, 0, divisor.length);
        for (i = 0; i < oldData.length; i++) {
            if (rem[0] == 1) {
                for (int j = 1; j < divisor.length; j++) {
                    rem[j - 1] = exorOperation(rem[j], divisor[j]);
                }
            } else {
                for (int j = 1; j < divisor.length; j++) {
                    rem[j - 1] = exorOperation(rem[j], 0);
                }
            }
            rem[divisor.length - 1] = data[i + divisor.length];
        }
        return rem;
    }

    static int exorOperation(int x, int y) {
        if (x == y) {
            return 0;
        }
        return 1;
    }
}