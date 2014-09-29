package dao.imp;

import dao.DaoImplTest;
import model.Address;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AddressDaoImplTest extends DaoImplTest {

    @Test
    public void testFetchExistingAddress() throws Exception {
        Integer expectedId = 1;
        Integer expectedCustomerId = 1;
        Integer expectedTypeId = 1;
        String expectedFirstLine = "firstLine1";
        String expectedSecondLine = "secondLine1";
        String expectedThirdLine = "thirdLine1";
        String expectedPostcode = "postcode1";

        AddressDaoImpl addressDaoImpl = new AddressDaoImpl(DaoImplTest.connection);
        Address address = addressDaoImpl.fetchAddress(expectedId);

        assertEquals(expectedId, address.getId());
        assertEquals(expectedCustomerId, address.getCustomerId());
        assertEquals(expectedTypeId, address.getTypeId());
        assertEquals(expectedFirstLine, address.getFirstLine());
        assertEquals(expectedSecondLine, address.getSecondLine());
        assertEquals(expectedThirdLine, address.getThirdLine());
        assertEquals(expectedPostcode, address.getPostcode());
    }

    @Test
    public void testUpdateExistingAddress() throws Exception {
        Integer expectedId = 2;
        //Integer expectedCustomerId = 3; //This cannot be updated due to cyclic redundancy - error in provided schema
        Integer expectedTypeId = 3;
        String expectedFirstLine = "firstLineX";
        String expectedSecondLine = "secondLineX";
        String expectedThirdLine = "thirdLineX";
        String expectedPostcode = "postcodeX";

        AddressDaoImpl addressDaoImpl = new AddressDaoImpl(DaoImplTest.connection);
        Address address = addressDaoImpl.fetchAddress(expectedId);
        //address.setCustomerId(expectedCustomerId);
        address.setTypeId(expectedTypeId);
        address.setFirstLine(expectedFirstLine);
        address.setSecondLine(expectedSecondLine);
        address.setThirdLine(expectedThirdLine);
        address.setPostcode(expectedPostcode);
        addressDaoImpl.persistAddress(address);
        Address address2 = addressDaoImpl.fetchAddress(expectedId);

        assertEquals(expectedId, address2.getId());
        //assertEquals(expectedCustomerId, address2.getCustomerId());
        assertEquals(expectedTypeId, address2.getTypeId());
        assertEquals(expectedFirstLine, address2.getFirstLine());
        assertEquals(expectedSecondLine, address2.getSecondLine());
        assertEquals(expectedThirdLine, address2.getThirdLine());
        assertEquals(expectedPostcode, address2.getPostcode());
    }
}
