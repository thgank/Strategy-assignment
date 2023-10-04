import java.util.Scanner;
public class Demochka {

    public static void main(String[] args) {
        process();
    }

    public static void process(){
        ShoppingCart cart = new ShoppingCart();
        Scanner sc = new Scanner(System.in);

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

            System.out.print("Select a payment method (1 for Card, 2 for Qiwi, 3 for Cash, 4 to exit): ");
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

            } else if(paymentMethod == 3){
                System.out.print("Enter how much money do you have: ");
                double amountInWallet = sc.nextInt();
                if (amountInWallet < cart.calcTotPrice()) {
                    System.out.println("Insufficient funds. You have " + amountInWallet + " in your wallet, " +
                            "but the amount to be paid is " + cart.calcTotPrice());
                    process();
                }
                cart.setPaymentStrategy(new CashPayment(amountInWallet));

            } else if (paymentMethod == 4) {
                System.exit(0);

            } else {
                System.out.println("Invalid payment method.");
            }

            cart.check();
            process();

        sc.close();
    }
}
