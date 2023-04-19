import java.util.Scanner;
public class bankersAlgo {

    static int A = 10;
    static int B = 5;
    static int C = 7;

    public static void main(String[] args) {
        int n=5;
        Scanner sc = new Scanner(System.in);
        int availRes[] = { 3, 3, 2 };

        int maxRes[][] = { { 7, 5, 3 },
                { 3, 2, 2 },
                { 9, 0, 2 },
                { 2, 2, 2 },
                { 4, 3, 3 } };

        int allotedRes[][] = { { 0, 1, 0 },
                { 2, 0, 0 },
                { 3, 0, 2 },
                { 2, 1, 1 },
                { 0, 0, 2 } };

        int[][] need = new int[n][3];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 3; j++)
                need[i][j] = maxRes[i][j] - allotedRes[i][j];
        
        boolean[] finished = new boolean[n];
        int[] safe=new int[n];
        int count = 0,i,j;
        int flag2=0;
        while(count!=n){
            int flag=0;
            for(i=0;i<n;i++){
                if(finished[i]==false){
                    for(j=0;j<3;j++){
                        if(need[i][j]>availRes[j]){
                            break;
                        }
                    }
                    if(j==3){
                        for(int k=0;k<3;k++){
                            availRes[k]=availRes[k]+allotedRes[i][k];
                        }
                        safe[count]=i;
                        count+=1;
                        finished[i]=true;
                        flag=1;
                    }
                }
            }
            if(flag==0){
                System.out.println("No Safe Sequence Found");
                flag2=1;
                break;
            }
        }
        if(flag2==0){
            System.out.println("Safe Sequence");
            for(i=0;i<safe.length;i++){
                System.out.print("P");
                System.out.println(safe[i]);
            }
        }
        sc.close();
    }
}
