public class CashPayment implements PaymentStrategy{
    private double amountInWallet;

    public CashPayment(double amountInWallet){
        this.amountInWallet = amountInWallet;
    }
    @Override
    public void processPayment(double amount) {
        double change = amountInWallet - amount;

        System.out.println(amount + " is the amount to be paid, you have " + amountInWallet + " in your wallet, " +
                "your change: " + change);
    }

}
