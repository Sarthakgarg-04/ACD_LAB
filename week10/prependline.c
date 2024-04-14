%{
#include <stdio.h>
int line_number = 1;
%}

%%

\n {
    printf("%d: %s", line_number++, yytext);
}

.|\n {
    printf("%d: %s", line_number, yytext);
}

%%

int main() {
    yylex();
    return 0;
}
