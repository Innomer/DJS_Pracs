#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <math.h>

char pattern[100];
char text[100];

void matcher(){
    int n=strlen(text);
    int m=strlen(pattern);
    // int h=pow(10,m-1);
    int h;
    int l=0;
    for(l=1;l<m;l++){
        h*=10;
    }
    int q=10;
    h=h%q;
    int p=0;
    int t[100];
    t[0]=0;
    int i,s;
    int flag=0;
    for(i=0;i<m;i++){
        p=((10*p)+pattern[i])%q;
        t[0]=((10*t[0])+text[i])%q;
    }
    printf("%d - %d\n",p,t[0]);
    for(s=0;s<=(n-m);s++){
        if(p==t[s]){
            flag=0;
            for(i=0;i<m;i++){
                if(pattern[i]!=text[s+i]){
                    printf("Hello %d\n",i);
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                printf("Patter Occurs with Shift %d\n",s);
            }
        }
        if(s<n-m){
            t[s+1]=(10*(t[s]-(text[s+1]*h))+text[s+m+1])%q;
        }
    }
}

int main()
{
    printf("Enter Pattern\n");
    // gets(pattern);
    scanf("%s",pattern);
    printf("Enter text\n");
    // gets(text);
    scanf("%s",text);

    matcher();
    return 0;
}