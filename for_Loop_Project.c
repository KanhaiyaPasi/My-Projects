#include <stdio.h>

int main() {
    int enteredPin;
    int attempt = 0;
    const int maxAttempts = 3;
    float balance = 1000.0; // Initial balance

   printf("Welcome To The ATM!\n");

    // PIN entry loop
    while (attempt < maxAttempts) {
        printf("Enter your PIN: ");
        scanf("%d", &enteredPin);

        if (enteredPin) {
            int option;
            do {
                printf("\nATM Menu:\n");
                printf("1. Enter PIN\n");
                printf("2. Check Balance\n");
                printf("3. Deposit\n");
                printf("4. Withdraw\n");
                printf("5. Exit\n");
                printf("Select an option: ");
                scanf("%d", &option);

                switch (option) {
                    case 1:
                        printf("You are already logged in.\n");
                        break;
                    case 2:
                        printf("Your balance is: $%.2f\n", balance);
                        break;

                    case 3: {
                        float depositAmount;
                        printf("Enter amount to deposit: ");
                        scanf("%f", &depositAmount);
                        if (depositAmount <= 0) {
                            printf("Invalid deposit amount. Please enter a positive value.\n");
                        } else {
                            balance += depositAmount;
                            printf("You have deposited: $%.2f\n", depositAmount);
                            printf("New balance: $%.2f\n", balance);
                        }
                        break;
                    }
                    case 4: {
                        float withdrawalAmount;
                        printf("Enter amount to withdraw: ");
                        scanf("%f", &withdrawalAmount);
                        if (withdrawalAmount > balance) {
                            printf("Insufficient funds.\n");
                        } else {
                            balance -= withdrawalAmount;
                            printf("You have withdrawn: $%.2f\n", withdrawalAmount);
                            printf("New balance: $%.2f\n", balance);
                        }
                        break;
                    }
                    case 5:
                        printf("Thank you for using the ATM. Goodbye!\n");
                        break;
                    default:
                        printf("Invalid option. Please try again.\n");
                }
            } while (option != 4); // Repeat until the user chooses to exit

            break; // Exit the PIN entry loop after successful login
        } else {
            printf("Incorrect PIN. Please try again.\n");
            attempt++;
        }

        if (attempt == maxAttempts) {
            printf("Too many failed attempts. Please try again later.\n");
        }
    }

    return 0;
}
