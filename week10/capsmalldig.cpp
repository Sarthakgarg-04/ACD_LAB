%{
#include <stdio.h>
%}

%%

[A-Z] {
    printf("Capital Letter: %s\n", yytext);
}

[a-z] {
    printf("Small Letter: %s\n", yytext);
}

[0-9] {
    printf("Digit: %s\n", yytext);
}

[^A-Za-z0-9 \t\n] {
    printf("Special Symbol: %s\n", yytext);
}

[ \t\n] {
    // Ignore whitespace
}

. {
    // Ignore other characters
}

%%

int main() {
    yylex();
    return 0;
}
