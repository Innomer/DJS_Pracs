#include<stdio.h>
#include<stdlib.h>
#include<math.h>

// int board[100][100];

int Place(int x[100],int k,int i){
    int j;
    for(j=0;j<k;j++){
        if(x[j]==i || abs(x[j]-i)==abs(j-k)){
            return 0;
        }
    }
    return 1;
}

void printArr(int x[100],int n){
    int i=0;
    for(i=0;i<n;i++){
        printf("Queen %d - %d\n",i+1,x[i]);
    }
    printf("\n");
}
void NQueens(int x[100],int k,int n){
    int i;
    for(i=0;i<n;i++){
        if(Place(x,k,i)==1){
            x[k]=i;
            if(k==n-1){
                printArr(x,n);
            }
            else{
                NQueens(x,k+1,n);
            }
        }
    }
}

int main()
{
    int i,n,j;
    int x[100];
    printf("Enter Number of Queens\n");
    scanf("%d",&n);
    for(i=0;i<n;i++){
        x[i]=-1;
    }
    NQueens(x,0,n);
    return 0;
}
