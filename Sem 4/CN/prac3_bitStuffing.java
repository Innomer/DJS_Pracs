import java.util.Scanner;

public class prac3_bitStuffing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Message (in form of 0s and 1s) to be Sent : ");
        String message = sc.nextLine();
        String stuffed = new String();
        int j;
        for (int i = 0; i < message.length(); i++) {
            if(message.charAt(i)=='0'){
                stuffed+='0';
            }
            else{
                int counter=1;
                stuffed+=message.charAt(i);
                for(j=i+1;j<message.length() && counter<5 && message.charAt(j)=='1';j++){
                    stuffed+=message.charAt(j);
                    counter+=1;
                    if(counter==5){
                        stuffed+='0';
                    }
                    i=j;
                }
            }
        }
        System.out.println("Stuffed String is " + stuffed);
        sc.close();
    }
}
