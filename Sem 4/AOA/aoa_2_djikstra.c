#include <stdlib.h>
#include <stdio.h>
#include <math.h>

int graph[100][100];

void printGraph(int distanceMatrix[], int n)
{
    for (int i = 0; i < n; i++)
    {
        printf("%d - %d\n", i, distanceMatrix[i]);
    }
}

void initializeSingleSource(int vd[], int da[], int pm[], int n)
{
    for (int i = 0; i < n; i++)
    {
        da[i] = INFINITY;
        vd[i] = 0;
        pm[i] = 0;
    }
}

int extract_min(int distanceArr[], int vertexDone[], int n)
{
    int minVal = INFINITY;
    int minVertex;
    for (int i = 0; i < n; i++)
    {
        if (distanceArr[i] < minVal && vertexDone[i] == 0)
        {
            minVal = distanceArr[i];
            minVertex = i;
        }
    }
    return minVertex;
}

void relax(int minVertex, int currentVertex, int vertexDone[], int distanceArr[], int parentMatrix[])
{
    if (graph[minVertex][currentVertex] != 0 && vertexDone[currentVertex] == 0)
    {
        if (distanceArr[currentVertex] > distanceArr[minVertex] + graph[minVertex][currentVertex])
        {
            distanceArr[currentVertex] = distanceArr[minVertex] + graph[minVertex][currentVertex];
            parentMatrix[currentVertex] = minVertex;
        }
    }
}

void djikstraAlgo(int n)
{
    int source = 0;
    int vertexDone[n];
    int distanceArr[n];
    int parentMatrix[n];

    initializeSingleSource(vertexDone, distanceArr, parentMatrix, n);
    distanceArr[source] = 0;

    int counter = 0;
    int minVertex;
    while (counter != 9)
    {
        minVertex = extract_min(distanceArr, vertexDone, n);

        vertexDone[minVertex] = 1;

        for (int i = 0; i < n; i++)
        {
            relax(minVertex, i, vertexDone, distanceArr, parentMatrix);
        }
        counter += 1;
    }
    printGraph(distanceArr, n);
}
int main()
{
    int i, j;
    int n;
    printf("Enter Total Number of Nodes in the Graph\n");
    scanf("%d", &n);

    for (i = 0; i < n; i++)
    {
        for (j = 0; j < n; j++)
        {
            printf("Enter Weight for Edge between %d and %d (0 for no edge)\n", i, j);
            scanf("%d", &graph[i][j]);
        }
    }

    djikstraAlgo(n);
    return 0;
}