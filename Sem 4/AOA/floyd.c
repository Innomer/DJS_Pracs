#include<stdlib.h>
#include<math.h>
#define V 4
int graph[V][V] = { { 0, 5, INFINITY, 10 },
                        { INFINITY, 0, 3, INFINITY },
                        { INFINITY, INFINITY, 0, 1 },
                        { INFINITY, INFINITY, INFINITY, 0 } };

void floyd(){
    int k,i,j;
    for(k=1;k<=V;k++){
        for(i=1;i<=V;i++){
            for(j=1;j<=V;j++){
                if (graph[i][j]>graph[i][k] + graph[k][j])
                    graph[i][j] = graph[i][k] + graph[k][j];
            }
        }
    }
}
int main()
{
    floyd();
    return 0;
}