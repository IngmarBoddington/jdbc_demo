package dao.imp;

import connection.Conn;
import dao.DaoImplTest;
import model.AddressType;
import org.dbunit.dataset.IDataSet;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.sql.Connection;

public class AddressTypeDaoImplTest extends DaoImplTest {

    @Test
    public void testFetchExistingAddressType() throws Exception {
        Integer expectedId = 1;
        String expectedDescription = "Work";

        AddressTypeDaoImpl addressTypeDaoImpl = new AddressTypeDaoImpl(DaoImplTest.connection);
        AddressType addressType = addressTypeDaoImpl.fetchAddressType(expectedId);

        assertEquals(expectedId, addressType.getId());
        assertEquals(expectedDescription, addressType.getDescription());
    }

    @Test
    public void testUpdateExistingAddressType() throws Exception {
        Integer expectedId = 2;
        String expectedDescription = "China";

        AddressTypeDaoImpl addressTypeDaoImpl = new AddressTypeDaoImpl(DaoImplTest.connection);
        AddressType addressType = addressTypeDaoImpl.fetchAddressType(expectedId);
        addressType.setDescription(expectedDescription);
        addressTypeDaoImpl.persistAddressType(addressType);
        AddressType addressType2 = addressTypeDaoImpl.fetchAddressType(expectedId);

        assertEquals(expectedId, addressType2.getId());
        assertEquals(expectedDescription, addressType2.getDescription());
    }

    @Test
    public void testInsertAddressType() throws Exception {
        Integer expectedId = 4;
        String expectedDescription = "Alpha Centurai";

        AddressTypeDaoImpl addressTypeDaoImpl = new AddressTypeDaoImpl(DaoImplTest.connection);
        AddressType addressType = new AddressType(expectedDescription);
        addressTypeDaoImpl.persistAddressType(addressType);
        AddressType addressType2 = addressTypeDaoImpl.fetchAddressType(expectedId);

        assertEquals(expectedId, addressType2.getId());
        assertEquals(expectedDescription, addressType2.getDescription());
    }
}
