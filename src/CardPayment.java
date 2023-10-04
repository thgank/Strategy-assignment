public class CardPayment implements PaymentStrategy{
    private String number;
    private String owner;

    public CardPayment(String number, String owner){
        this.number = number;
        this.owner = owner;
    }

    @Override
    public void processPayment(double amount){
        System.out.println(amount+" been paid from "+number+" card of "+owner);
    }
}
