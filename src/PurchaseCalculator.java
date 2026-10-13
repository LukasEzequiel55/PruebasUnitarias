public class PurchaseCalculator {

    double descuento = 0.10;
    double minimodescuento = 1000.0;

    public double calculateSubtotal(double price, int quantity){
        return price * quantity;
    }//subtotal

    public boolean isValidPurchase(double price, int quantity) {
        return price > 0 && quantity > 0;
    }//Compra invalida

    public double calculateDiscount(double subtotal){
        if (subtotal >= minimodescuento){
            return subtotal * descuento;
        }//else
        return 0.0;
    }//discount

    public double calculateFinalPrice(double subtotal) {
        return subtotal - calculateDiscount(subtotal);
    }
}//class
