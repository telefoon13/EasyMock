package be.mikedhoore.Opgave3;

import java.math.BigDecimal;

public interface IPricingService {
    void setDataAccess(IDataAccess dataAccess);
    BigDecimal getPrice(String id) throws ProductNotFoundException;
}
