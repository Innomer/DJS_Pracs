import java.lang.*;
import java.util.*;

class LLData {
    int n;
    int cpuTime;
    int arrivalTime;
    int ogCpuTime;

    public LLData(int a, int b, int c) {
        n = a;
        cpuTime = b;
        arrivalTime = c;
        ogCpuTime = b;
    }
}

public class sjf_pre {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<LLData> ll = new LinkedList<LLData>();
        int ans = 1;
        int n = 0;
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

        int completionTimes[] = new int[ll.size()];
        int turnaroundTimes[] = new int[ll.size()];
        int waitingTimes[] = new int[ll.size()];
        int pidsCompleted[] = new int[ll.size()];
        float atat = 0.0f, awat = 0.0f;

        System.out.println();
        int time = 0;
        int processesCounter = 0;
        LLData currentRunningProcess = null;
        while (processesCounter != ll.size()) {
            for (i = 0; i < ll.size(); i++) {
                if (ll.get(i).arrivalTime <= time && ll.get(i).cpuTime > 0) {
                    if (currentRunningProcess == null) {
                        currentRunningProcess = ll.get(i);
                        System.out.print(time + "\t P" + ll.get(i).n + "\t");
                        break;
                    }
                    if (ll.get(i).cpuTime < currentRunningProcess.cpuTime) {
                        System.out.print(time + "\t P" + ll.get(i).n + "\t");
                        currentRunningProcess = ll.get(i);
                        break;
                    }
                }
            }
            if (currentRunningProcess == null) {
                System.out.print(time + "\t Idle \t");
            } else {
                currentRunningProcess.cpuTime -= 1;
                if (currentRunningProcess.cpuTime <= 0) {
                    System.out.print(time + "\t P" + currentRunningProcess.n + "\t");
                    completionTimes[processesCounter] = time+1;
                    turnaroundTimes[processesCounter] = time+1 - currentRunningProcess.arrivalTime;
                    waitingTimes[processesCounter] = turnaroundTimes[processesCounter] - currentRunningProcess.ogCpuTime;
                    pidsCompleted[processesCounter] = currentRunningProcess.n;
                    atat += turnaroundTimes[processesCounter];
                    awat += waitingTimes[processesCounter];
                    currentRunningProcess = null;
                    processesCounter += 1;
                }
            }
            time += 1;
        }
        System.out.println(time);

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
