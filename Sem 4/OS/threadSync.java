import java.util.*;
import java.lang.*;

class BookingThread extends Thread {
    int n;
    public BookingThread(int x) {
        n = x;
    }
    
    synchronized public void run() {
        try 
        {
            System.out.println("Thread "+n+" has Started!");
            // System.out.println("Number of Tickets Available:- "+threadSync.T);
            if(threadSync.T==0){
                Thread.sleep(1000);
                System.out.println("No Tickets Available for "+n+" Thread!");
            }
            else{
                threadSync.T-=1;
                System.out.println("Ticket Booked by "+n+" Thread!");
            }
        } 
        catch(InterruptedException e) 
        {
            System.out.println(n + " Thread got " + e);
        }
    }
}

class threadSync {
    public static int T=2;
    public static void main(String args[]) {
        BookingThread t1=new BookingThread(1);
        BookingThread t2=new BookingThread(2);
        BookingThread t3=new BookingThread(3);
        t1.start();
        t2.start();
        t3.start();
    }
}
