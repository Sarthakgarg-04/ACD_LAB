%{
    #include<stdio.h>
%}

%%
. ECHO;
\N ECHO;
%%

int yywrap();
{return 1;}

int main()
{
    yylex();
    return 0;
}