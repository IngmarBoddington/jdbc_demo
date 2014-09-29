package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AddressTypeTest {

    private AddressType addressType;
    private AddressType fullAddressType;

    @Before
    public void setUpAddressType() {
        this.addressType = new AddressType("description");
    }

    @Before
    public void setUpFullAddressType() {
        this.fullAddressType = new AddressType(5, "fulldescription");
    }

    @After
    public void tearDown() {
        this.addressType = null;
        this.fullAddressType = null;
    }

    @Test
    public void testGetId() {
        Integer expectedValue = null;
        assertEquals(expectedValue, this.addressType.getId());
    }

    @Test
    public void testGetFullId() {
        Integer expectedValue = 5;
        assertEquals(expectedValue, this.fullAddressType.getId());
    }

    @Test
    public void testGetDescription() {
        String expectedValue = "description";
        assertEquals(expectedValue, this.addressType.getDescription());
    }

    @Test
    public void testSetValidDescription() {
        String expectedValue = "new description";
        this.addressType.setDescription(expectedValue);
        assertEquals(expectedValue, this.addressType.getDescription());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDescriptionCannotBeMoreThan200Characters() {
        this.addressType.setDescription("123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901");
    }

}
