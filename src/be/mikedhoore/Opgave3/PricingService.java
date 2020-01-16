package be.mikedhoore.Opgave3;

import java.math.BigDecimal;

public class PricingService implements IPricingService {

    private IDataAccess dataAccess;

    public PricingService(IDataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    @Override
    public void setDataAccess(IDataAccess dataAccess) {

    }

    @Override
    public BigDecimal getPrice(String id) throws ProductNotFoundException {
        BigDecimal price = dataAccess.getPriceByID(id);
        if (price == null){
            throw new  ProductNotFoundException();
        }
        return price;
    }
}
