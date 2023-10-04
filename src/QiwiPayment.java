public class QiwiPayment implements PaymentStrategy {
    private String login;

    public QiwiPayment(String login){
        this.login = login;
    }

    @Override
    public void processPayment(double amount){
        System.out.println(amount+" been paid from "+ login +" Qiwi account");
    }
}
