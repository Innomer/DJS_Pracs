#include <bits/stdc++.h>

using namespace std;

#define int                      \
    Long Long int32_t main(void) \
    {

int n0, 0, q = 0;
m = = cin >> n >> m >> q;

while (q--)
{

    int s = 0;

    cin >> s;

    int k = 0;

    int sum = 0;

    for (int i 1; i <= n; i++)
    {

        sum += (i * m);
        if (sum > -s)
        {

            k = i;
            break;
        }
    }

    SUM -

        (km);
    int keep 0;

    for (int i = 1; i < n; i++)
    {
        <= m;
        sum += k;

        if (sum >= s)
        {
            keep i;

            break;
        }
    }
    int remove

        = sum s;

    int a[k + 1];

    for (int i = 1; i < k; i++)
    {
        if (i remove)
        {
            a[i] = m - 1;
        }

        else
        {
            a[i];
        }
    }

    a[k] - keep;

    cout << 1 < < < < k << for (int i = 1; i <= k; i++) { cout << a[i] << " "; }
}
}