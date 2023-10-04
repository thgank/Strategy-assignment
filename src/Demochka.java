import java.util.Scanner;
public class Demochka {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner sc = new Scanner(System.in);

        boolean continueShopping = true; // Initialize a boolean to control the loop

        while (continueShopping) { // Start a loop
            Product prod1 = new Product("Phone", 300.50, 5);
            Product prod2 = new Product("Tablet", 600.30, 2);
            Product prod3 = new Product("TV", 800.0, 1);
            Product prod4 = new Product("Laptop", 700.0, 4);

            cart.addProd(prod1);
            cart.addProd(prod2);
            cart.addProd(prod3);
            cart.addProd(prod4);

            System.out.println("Currently in cart:");
            for (Product product : cart.getCartItems()) {
                System.out.println(product.getName() + " - price: $" + product.getPrice() +
                        " amount - " + product.getQuantity());
            }

            System.out.print("Select a payment method (1 for Credit Card, 2 for PayPal, 3 to exit): ");
            int paymentMethod = sc.nextInt();

            if (paymentMethod == 1) {
                System.out.print("Enter credit card number: ");
                String cardNumber = sc.next();
                System.out.print("Enter name of owner: ");
                String cardName = sc.next();
                cart.setPaymentStrategy(new CardPayment(cardNumber, cardName));
            } else if (paymentMethod == 2) {
                System.out.print("Enter Qiwi login: ");
                String login = sc.next();
                cart.setPaymentStrategy(new QiwiPayment(login));
            } else if (paymentMethod == 3) {
                continueShopping = false; // Exit the loop if the user selects option 3
            } else {
                System.out.println("Invalid payment method.");
            }

            cart.check();
        }

        sc.close(); // Close the scanner when done
    }
}
