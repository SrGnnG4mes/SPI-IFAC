#include <stdio.h>

int main(){
    int diaNascimento;
    scanf("%d", diaNascimento);
    printf("%d: ", diaNascimento)
    while(diaNascimento !=1){
        if(diaNascimento%2 == 0){
            diaNascimento /= 2;
        }else{
            diaNascimento = diaNascimento *3 + 1;
        }
        printf("%d ", diaNascimento)
    }
    return 0;
}