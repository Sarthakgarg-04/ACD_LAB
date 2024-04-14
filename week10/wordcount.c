%{
#include <stdio.h>
int word_count = 0;
%}

%%

[a-zA-Z]+ {
    word_count++;
}

.|\n {
    // Ignore other characters
}

%%

int main() {
    yylex();
    printf("Total Words: %d\n", word_count);
    return 0;
}
