#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct matrix
{
    int b[100][100];
    int c[100][100];
} mat;

void printArr(int arr[][100], int m, int n)
{
    int i, j;
    for (i = 0; i <= m; i++)
    {
        for (j = 0; j <= n; j++)
        {
            printf("%d\t", arr[i][j]);
        }
        printf("\n");
    }
}

void print_lcs(char s1[], int i, int j,int k,char ans[])
{
    if (i == 0 || j == 0)
    {
        while(k>=0){
            printf("%c",ans[k--]);
        }
        printf("\n");
        return;
    }

    if (mat.b[i][j] == 0)
    {
        // printf("%d,%d", i,j);
        ans[k]=s1[i];
        k++;
        print_lcs(s1, i - 1, j - 1,k,ans);
    }

    else if (mat.b[i][j] == 1)
        print_lcs(s1, i - 1, j,k,ans);
    else
        print_lcs(s1, i, j - 1,k,ans);
}

void lcs_length(char s1[], char s2[])
{
    int m = strlen(s1);
    int n = strlen(s2);
    int i, j;
    for (i = 0; i <= m; i++)
    {
        for (j = 0; j <= n; j++)
        {
            mat.c[i][j] = 100;
            mat.b[i][j] = 100;
        }
    }
    for (i = 1; i <=m; i++)
    {
        mat.c[i][0] = 0;
    }
    for (j = 0; j <=n; j++)
    {
        mat.c[0][j] = 0;
    }
    // printArr(mat.c, m, n);
    // printf("______________________________\n");
    // printArr(mat.b, m, n);
    for (i = 1; i <= m; i++)
    {
        for (j = 1; j <= n; j++)
        {
            if (s1[i] == s2[j])
            {
                mat.c[i][j] = mat.c[i - 1][j - 1] + 1;
                mat.b[i][j] = 0;
            }
            else if (mat.c[i - 1][j] >= mat.c[i][j - 1])
            {
                mat.c[i][j] = mat.c[i - 1][j];
                mat.b[i][j] = 1;
            }
            else
            {
                mat.c[i][j] = mat.c[i][j - 1];
                mat.b[i][j] = -1;
            }
        }
    }
    // printf("______________________________\n");
    // printArr(mat.c, m, n);
    // printf("______________________________\n");
    // printArr(mat.b, m, n);
    char ans[100];
    printArr(mat.c,m,n);
    print_lcs(s1, i, j,0,ans);
}

int main()
{
    char s1[100], s2[100];
    // scanf("%s",&s1);
    // scanf("%s",&s2);
    gets(s1);
    gets(s2);
    lcs_length(s1, s2);
    return 0;
}