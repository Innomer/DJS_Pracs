#include <stdlib.h>
#include <time.h>
#include <stdio.h>

void insertionSort(int arr[], int n)
{
    int i, key, j;
    for (i = 1; i < n; i++)
    {
        key = arr[i];
        j = i - 1;
        while (j >= 0 && arr[j] > key)
        {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = key;
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
    insertionSort(arr, n);
    t = clock() - t;
    double time_taken = ((double)t);

    printf("insertion sort took %f seconds to execute \n", time_taken);
    return 0;
}