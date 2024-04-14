%{
#include <stdio.h>
#include <string.h>

int keyword_count = 0;
int identifier_count = 0;
%}

%%

// Define keywords
int|float|char|if|else|while|for {
    printf("Keyword: %s\n", yytext);
    keyword_count++;
}

// Match identifiers
[a-zA-Z][a-zA-Z0-9]* {
    printf("Identifier: %s\n", yytext);
    identifier_count++;
}

// Skip whitespace and comments
[ \t\n] ;
\/\/.* ;

. {
    printf("Invalid character: %s\n", yytext);
}

%%

int main() {
    yylex();
    printf("Total Keywords: %d\n", keyword_count);
    printf("Total Identifiers: %d\n", identifier_count);
    return 0;
}
