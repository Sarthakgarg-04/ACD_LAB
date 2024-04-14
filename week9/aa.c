%{
#include <stdio.h>
%}

%%

[a-zA-Z]*a[a-zA-Z]*a {
    printf("Word beginning and ending with 'a': %s\n", yytext);
}

[a-zA-Z]+ {
    // Ignore other words
}

. {
    // Ignore non-alphabet characters
}

%%

int main() {
    yylex();
    return 0;
}
