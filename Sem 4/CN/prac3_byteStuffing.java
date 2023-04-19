import java.util.Scanner;

public class prac3_byteStuffing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char start_flag, end_flag, escape_flag;
        String stuffed = new String();
        System.out.println("Enter the Message to be Sent : ");
        String message = sc.nextLine();
        System.out.println("Enter Start Flag");
        start_flag = sc.next().charAt(0);
        System.out.println("Enter End Flag");
        end_flag = sc.next().charAt(0);
        System.out.println("Enter Escape Flag");
        escape_flag = sc.next().charAt(0);

        message = start_flag + message + end_flag;
        for (int i = 0; i < message.length(); i++) {
            if ((message.charAt(i) == start_flag && i != 0 && i != (message.length() - 1))
                    || (message.charAt(i) == end_flag && i != (message.length() - 1)))
                stuffed = stuffed + escape_flag + message.charAt(i);

            else if (message.charAt(i) == escape_flag)
                stuffed = stuffed + escape_flag + message.charAt(i);
            else
                stuffed = stuffed + message.charAt(i);
        }
        System.out.println("Stuffed String : " + stuffed);
        sc.close();
    }
}
