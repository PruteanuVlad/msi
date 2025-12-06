#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void unsafe_copy(char *input) {
    char buffer[16];

    strcpy(buffer, input);
    printf("You entered: %s\n", buffer);
}

int dangerous_calc(int divisor) {
    int x;
    int result = 100 / divisor;
    return result + x;
}

int *return_pointer_to_local() {
    int local = 5;
    return &local;
}

int main(int argc, char **argv) {
    char *leak = malloc(128);
    if (argc < 2) {
        printf("Usage: %s <input>\n", argv[0]);
        return 1;
    }

    unsafe_copy(argv[1]);
    printf("Dangerous calc result: %d\n", dangerous_calc(0));

    int *ptr = return_pointer_to_local();
    printf("Pointer value: %d\n", *ptr);

    return 0;
}
