#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int partition(int arr[], int low, int high)
{
    int pivot = arr[low];
    int i = low, j = high, temp;
    while (i < j)
    {
        do
        {
            i++;
        } while (arr[i] <= pivot);
        do
        {
            j--;
        } while (arr[j] > pivot);
        if (i < j)
        {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    arr[low] = arr[j];
    arr[j] = pivot;
    return j;
}

void quickSort(int arr[], int low, int high)
{
    if (low < high)
    {
        int p = partition(arr, low, high);
        quickSort(arr, low, p);
        quickSort(arr, p + 1, high);
    }
}
int main()
{
    int arr[50000], n = 50000;
    int i;
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
    quickSort(arr, 0, n);
    t = clock() - t;
    double time_taken = ((double)t);

    printf("Quicksort took %f seconds to execute \n", time_taken);

    return 0;
}