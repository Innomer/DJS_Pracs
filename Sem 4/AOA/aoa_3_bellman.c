#include <stdlib.h>
#include <stdio.h>
#include <math.h>

int graph[5][5] = {{0, 6, 0, 0, 7},
                   {0, 0, 5, -4, 8},
                   {0, -2, 0, 0, 0},
                   {2, 0, 7, 0, 0},
                   {0, 0, -3, 9, 0}};

void printGraph(int distanceMatrix[], int n)
{
    for (int i = 0; i < n; i++)
    {
        printf("%d - %d\n", i, distanceMatrix[i]);
    }
}
void initializeSingleSource(int da[], int pm[], int n)
{
    for (int i = 0; i < n; i++)
    {
        da[i] = INFINITY;
        pm[i] = 0;
    }
}
void relax(int vertex, int innerVertex, int distanceArr[], int parentMatrix[])
{
    if (graph[vertex][innerVertex] != 0)
    {
        if (distanceArr[innerVertex] > distanceArr[vertex] + graph[vertex][innerVertex])
        {
            distanceArr[innerVertex] = distanceArr[vertex] + graph[vertex][innerVertex];
            parentMatrix[innerVertex] = vertex;
        }
    }
}

int bellmanFord(int parentMatrix[], int distanceArr[], int n)
{
    int source = 0;
    int k, i, j;
    initializeSingleSource(distanceArr, parentMatrix, n);
    distanceArr[source] = 0;
    for (k = 1; k < n; k++)
    {
        printf("ITERATION %d\n",k);
        for (i = 0; i < n; i++)
        {
            for (j = 0; j < n; j++)
            {
                relax(i, j, distanceArr, parentMatrix);
            }
        }
        printGraph(distanceArr,n);
        printf("-------------------------------------------\n");
    }
    for (i = 0; i < n; i++)
    {
        for (j = 0; j < n; j++)
        {
            if (distanceArr[j] > distanceArr[i] + graph[i][j])
            {
                printf("%d-%d",i,j);
                return 0;
            }
        }
    }
    return 1;
}

int main()
{
    int i, j;
    int n = 5;
    int distanceArr[n];
    int parentMatrix[n];
    // printf("Enter Total Number of Nodes in the Graph\n");
    // scanf("%d", &n);

    // for (i = 0; i < n; i++)
    // {
    //     for (j = 0; j < n; j++)
    //     {
    //         printf("Enter Weight for Edge between %d and %d (0 for no edge)\n", i, j);
    //         scanf("%d", &graph[i][j]);
    //     }
    // }

    n = bellmanFord(parentMatrix, distanceArr, n);
    if (n == 1)
    {
        printGraph(distanceArr, n);
    }
    else
    {
        printf("Negative Cycle Exists!");
    }
    return 0;
}