#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int prefix[100];
char pattern[100];
char text[100];

void compute_prefix_function()
{
    int k = 0, q;
    prefix[1] = 0;
    int n = strlen(pattern);
    for (q = 2; q <= n; q++)
    {
        while (k > 0 && pattern[k + 1] != pattern[q])
        {
            k = prefix[k];
        }
        if (pattern[k + 1] == pattern[q])
        {
            k++;
        }
        prefix[q] = k;
    }
}

void matcher()
{
    compute_prefix_function();
    int N = strlen(text);
    int n = strlen(pattern);
    int q = 0, i;
    for (i = 0; i <= N; i++)
    {
        while (q > 0 && pattern[q] != text[i])
        {
            q = prefix[q];
        }
        if (pattern[q] == text[i])
        {
            q++;
        }
        if (q == n)
        {
            printf("Pattern found with shift %d\n", (i - n+1));
            q = prefix[q];
        }
    }
}

int main()
{
    printf("Enter Pattern\n");
    gets(pattern);
    printf("Enter text\n");
    gets(text);

    matcher();
    return 0;
}
