%{
#include <stdio.h>
int letter_count = 0;
int digit_count = 0;
int space_count = 0;
int tab_count = 0;
int line_count = 0;
%}

%%

[a-zA-Z] {
    letter_count++;
}

[0-9] {
    digit_count++;
}

[ \t] {
    if (*yytext == ' ') {
        space_count++;
    } else if (*yytext == '\t') {
        tab_count++;
    }
}

\n {
    line_count++;
}

. {
    // Ignore other characters
}

%%

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <input_file>\n", argv[0]);
        return 1;
    }

    FILE *input_file = fopen(argv[1], "r");
    if (input_file == NULL) {
        perror("Error opening file");
        return 1;
    }

    yyin = input_file;
    yylex();

    fclose(input_file);

    printf("Total letters: %d\n", letter_count);
    printf("Total digits: %d\n", digit_count);
    printf("Total spaces: %d\n", space_count);
    printf("Total tabs: %d\n", tab_count);
    printf("Total lines: %d\n", line_count);

    return 0;
}
