%{
    #include<stdio.h>
    int vowels=0;
    int cons=0;
    int digits=0;
%}

%%
[aeiouAEIOU]{vowels++}
[a-zA-Z]{cons++}
[0-9]{digits++}
%%

int yywrap(){
    return 1;
}

int main(){
    printf("Enter a string:");
    yylex();
    printf("Vowels= %d \n Consonants= %d \n Digits= %d \n", vowels,cons,digits );
    return 0;

}