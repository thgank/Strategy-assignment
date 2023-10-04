import java.util.ArrayList;
import java.util.List;
public class ShoppingCart {
    private List<Product> cartItems = new ArrayList<>();
    private PaymentStrategy paymentStrategy;

    public void addProd(Product product){
        cartItems.add(product);
    }

    public double calcTotPrice(){
        double total = 0;
        for(Product product : cartItems){
            total += product.countTotPrice();
        }
        return total;
    }

    public List<Product> getCartItems() {
        return cartItems;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void check(){
        double totalAmo = calcTotPrice();
        if(paymentStrategy != null) {
            paymentStrategy.processPayment(totalAmo);
            System.out.println("Successful");
        }
        else{
            System.out.println("Set Payment Strategy");
        }
    }
}
