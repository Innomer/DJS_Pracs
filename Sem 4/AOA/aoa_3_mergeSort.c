#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void merge(int arr[], int left[], int right[], int left_size, int right_size)
{
    int i = 0, j = 0, k = 0;
    while (i < left_size && j < right_size)
    {
        if (left[i] < right[j])
        {
            arr[k++] = left[i++];
        }
        else
        {
            arr[k++] = right[j++];
        }
    }
    while (i < left_size)
    {
        arr[k++] = left[i++];
    }
    while (j < right_size)
    {
        arr[k++] = right[j++];
    }
}

void mergeSort(int arr[], int n)
{
    int mid, i;
    if (n < 2)
        return;
    mid = n / 2;
    int left[mid], right[n - mid];

    for (i = 0; i < mid; i++)
    {
        left[i] = arr[i];
    }
    for (i = mid; i < n; i++)
    {
        right[i - mid] = arr[i];
    }

    mergeSort(left, mid);
    mergeSort(right, n - mid);
    merge(arr, left, right, mid, n - mid);
}

int main()
{
    int arr[15000*2*2], n=15000*2*2;
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
    mergeSort(arr, n);
    t = clock() - t;
    double time_taken = ((double)t);

    printf("Merge sort took %f seconds to execute \n", time_taken);

    return 0;
}