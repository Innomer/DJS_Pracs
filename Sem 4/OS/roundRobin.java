import java.lang.*;
import java.util.*;

class LLData {
    int n;
    int cpuTime;
    int arrivalTime;
    int ogCpuTime=0;

    public LLData(int a, int b, int c) {
        n = a;
        cpuTime = b;
        arrivalTime = c;
        ogCpuTime=cpuTime;
    }
}

public class roundRobin {

    static boolean checkAT(LinkedList<LLData> ll,int time){
        for(int i=0;i<ll.size();i++){
            if(time<=ll.get(i).arrivalTime)
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<LLData> ll = new LinkedList<LLData>();
        Queue<LLData> queue = new LinkedList<LLData>();
        int ans = 1;
        int n = 0;
        int time_quantum;
        int i;
        
        while (ans == 1) {
            System.out.println("Enter Process Number, Cpu Time and Arrival Time");
            LLData lldata = new LLData(sc.nextInt(), sc.nextInt(), sc.nextInt());
            ll.add(lldata);
            n = n + 1;
            System.out.println("Enter 1 to add a process data and 0 to exit");
            ans = sc.nextInt();
        }
        int current = 0;
        int index = 0;
        while (current != ll.size()) {
            index = current + 1;
            while (index != ll.size()) {
                if (ll.get(index).arrivalTime < ll.get(current).arrivalTime) {
                    LLData temp;
                    LLData temp2;
                    temp = ll.get(index);
                    temp2 = ll.get(current);
                    ll.remove(index);
                    ll.remove(current);
                    ll.add(current, temp);
                    ll.add(index, temp2);
                }
                index += 1;
            }
            current += 1;
        }
        
        System.out.println("Enter the Time Quantum");
        time_quantum = sc.nextInt();
        
        int completionTimes[] = new int[ll.size()];
        int turnaroundTimes[] = new int[ll.size()];
        int waitingTimes[] = new int[ll.size()];
        int pidsCompleted[]=new int[ll.size()];
        float atat=0.0f,awat=0.0f;
        
        System.out.println();
        int time = 0;
        int processesCounter=0;
        do {
            // Getting arrived
            for (i = 0; i < ll.size(); i++) {
                if (ll.get(i).arrivalTime == time) {
                    queue.add(ll.get(i));
                }
            }
            if(!queue.isEmpty()){
                LLData temp = queue.remove();
                time+=time_quantum;
                temp.cpuTime -= time_quantum;
                if (temp.cpuTime <= 0) {
                    time-=Math.abs(temp.cpuTime);
                    completionTimes[processesCounter]=time;
                    turnaroundTimes[processesCounter]=time-temp.arrivalTime;
                    waitingTimes[processesCounter]=turnaroundTimes[processesCounter]-temp.ogCpuTime;
                    pidsCompleted[processesCounter]=temp.n;
                    atat+=turnaroundTimes[processesCounter];
                    awat+=waitingTimes[processesCounter];
                    processesCounter+=1;
                } else {
                    queue.add(temp);
                }
                System.out.print("\t P"+temp.n+" \t"+time+" \t");
            }
            else{
                System.out.print("\t "+time+" \t Idle "+"\t");
                time=ll.get(0).arrivalTime;
                System.out.print(time+"\t");
            }
        } while (!queue.isEmpty() || checkAT(ll, time));



        System.out.println();
        System.out.println("\n");
        System.out.println("Process \t Turnaround Time \t Waiting Time");
        for (i = 0; i < n; i++) {
            System.out.println("P" + pidsCompleted[i] + "\t\t\t" + turnaroundTimes[i] + "\t\t\t" + waitingTimes[i]);
        }
        System.out.println();
        System.out.println("Average Turnaround Time is "+(atat/ll.size()));
        System.out.println("Average Waiting Time is "+(awat/ll.size()));
        sc.close();

    }
}
