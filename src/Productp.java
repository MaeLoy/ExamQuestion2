public class Productp implements IProductCalculations {

    //Commission = price x (0,05 / 100), e.g. 800000 and 10 -> 80000.0
    @Override
    public double CalculateCommission(String ProductPrice, String commission) {
        double price = Double.parseDouble(ProductPrice.trim());
        double Com = Double.parseDouble(commission.trim());
        return price * (Com / 100);
    }


    @Override
    public boolean ValidateData(Data datatoValidate) {
        //Location and name cannit be empty
        if (datatoValidate.getProduct() == null
                || datatoValidate.getProduct().trim().isEmpty()) {
            return false;
        }
        if (datatoValidate.getCustomerName() == null
                || datatoValidate.getCustomerName().trim().isEmpty()) {
            return false;
        }
    }

    //Commission = price x (percantage / 100), e.g. 800000 and 10 -> 80000.0
    @Override
    public double CalculateCommission(String propertyPrice, String agentCommission) {
        double price = Double.parseDouble(propertyPrice.trim());
        double percantage = Double.parseDouble(agentCommission.trim());
        return price * (percantage / 100);
    }


    @Override
    public boolean ValidateData(Data datatoValidate) {
        //Location and name cannit be empty
        if (datatoValidate.getLocation() == null
                || datatoValidate.getLocation().trim().isEmpty()) {
            return false;
        }
        if (datatoValidate.getAgentName() == null
                || datatoValidate.getAgentName().trim().isEmpty()) {
            return false;
        }


    }

}


