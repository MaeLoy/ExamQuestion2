public class Data {
    private final String Product;
    private final String CustomerName;
    private final String productPrice;
    private final String Commission;
    private final String VAT;

    public Data(String location, String agentName, String propertyPrice,
                String commissionPercentage) {
        this.Product =location;
        this.CustomerName = agentName;
        this.productPrice = propertyPrice;
        this.Commission = commissionPercentage;
        this.VAT = VAT;
    }
    public String getLocation() {return Product; }
    public String getAgentName() {return  CustomerName; }
    public String getPropertyPrice() {return productPrice; }
    public String getCommissionPercentage() {return commissionPercentage; }
}
