import java.util.Scanner;

public class prac3_characterCount {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String stuffed = new String();
        System.out.println("Enter Number of Frames to Send");
        int n=sc.nextInt();
        int i;
        String frames[]=new String[n];
        for(i=0;i<n;i++){
            System.out.println("Enter "+i+" Frame");
            frames[i]=sc.next();
        }
        for(i=0;i<n;i++){
            int j;
            int len=frames[i].length();
            stuffed+=Integer.toString(len+1);
            for(j=0;j<len;j++){
                stuffed+=frames[i].charAt(j);
            }
        }
        System.out.println("Stuffed String is " + stuffed);
        sc.close();
    }
}
