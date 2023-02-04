package entities;

public class Sale {
    private double amount;
    private String region;
    private double commission;
    private double commissionPercentage;
    private boolean isPrimeCustomer;
    private double discountPercentage;

    public Sale(double amount, String region, boolean isPrimeCustomer){
        this.amount = amount;
        this.region = region;
        this.isPrimeCustomer = isPrimeCustomer;
    }

    public String getRegion() {
        return region;
    }

    public double getAmount() {
        return amount;
    }

    public double getCommission() {
        return commission;
    }

    public double getCommissionPercentage() {
        return commissionPercentage;
    }

    public boolean getIsPrimeCustomer(){
        return isPrimeCustomer;
    }

    public double setCommission(double calculatedCommission)
    {
         this.commission = calculatedCommission;
         return commission;
    }

    public double setCommissionPercentage(double calculatedCommissionPercentage)
    {
        this.commissionPercentage = calculatedCommissionPercentage;
        return commissionPercentage;
    }

    public void setAmount(double newAmount){
        this.amount = newAmount;
    }

    public double getDiscountPercentage(){
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage){
        this.discountPercentage = discountPercentage;
    }
}