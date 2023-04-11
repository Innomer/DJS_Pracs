#include <stdlib.h>
#include <time.h>
#include <stdio.h>
void selection(int arr[], int n)  
{  
    int i, j, small;  
      
    for (i = 0; i < n-1; i++)  
    {  
        small = i;  
          
        for (j = i+1; j < n; j++)  
        if (arr[j] < arr[small])  
            small = j;  
    int temp = arr[small];  
    arr[small] = arr[i];  
    arr[i] = temp;  
    }  
}  

int main()
{
    int arr[50000];
    int n = 50000;
    int i = 0;
    int choice = 0;
    printf("Enter 1 for Average Case Time, 2 for Best Case Time,3 for Worst Case Time\n");
    scanf("%d", &choice);
    switch (choice)
    {
    case 1:
        for (i = 0; i < n; i++)
        {
            arr[i] = rand() % n;
        }
        break;
    case 2:
        for (i = 0; i < n; i++)
        {
            arr[i] = i;
        }
        break;
    case 3:
        for (i = 0; i < n; i++)
        {
            arr[i] = n - i;
        }
        break;
    default:
        printf("Wrong Choice!\n");
    }

    clock_t t;
    t = clock();
    selection(arr, n);
    t = clock() - t;
    double time_taken = ((double)t);

    printf("selection sort took %f seconds to execute \n", time_taken);
    return 0;
}