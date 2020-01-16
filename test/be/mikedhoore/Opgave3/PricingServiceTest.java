package be.mikedhoore.Opgave3;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

public class PricingServiceTest {

    private String correcteID = "15";
    private String fouteID = "16";
    private PricingService pricingService;
    private IDataAccess dataAccess;

    @Before
    public void setUp() throws Exception {
        dataAccess = createMock(IDataAccess.class);
        pricingService = new PricingService(dataAccess);
    }

    @Test
    public void getPrice() throws ProductNotFoundException {
        expect(dataAccess.getPriceByID(correcteID)).andReturn(new BigDecimal(12.5));
        replay(dataAccess);
        assertNotNull(pricingService.getPrice(correcteID));
        verify(dataAccess);
    }

    @Test(expected = ProductNotFoundException.class)
    public void getPriceError() throws ProductNotFoundException{
        expect(dataAccess.getPriceByID(fouteID)).andReturn(null);
        replay(dataAccess);
        pricingService.getPrice(fouteID);
        verify(dataAccess);
    }

    @Test
    public void getPriceThrowRunTime() throws ProductNotFoundException{
        expect(dataAccess.getPriceByID(correcteID)).andThrow(new RuntimeException("FOUT"));
        replay(dataAccess);

    }
}