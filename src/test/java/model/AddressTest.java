package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AddressTest {

    private Address address;
    private Address fullAddress;

    @Before
    public void setUpAddress() {
        this.address = new Address(5, 12, "10 Streetname", "Second line", "third line", "postcode");
    }

    @Before
    public void setUpFullAddress() {
        this.fullAddress = new Address(3, 1, 2, "firstLine", "secondLine", "thirdLine", "postCode");
    }

    @After
    public void tearDown() {
        this.address = null;
        this.fullAddress = null;
    }

    @Test
    public void testGetId() {
        Integer expectedValue = null;
        assertEquals(expectedValue, this.address.getId());
    }

    @Test
    public void testGetFullId() {
        Integer expectedValue = 3;
        assertEquals(expectedValue, this.fullAddress.getId());
    }

    @Test
    public void testGetCustomerId() {
        Integer expectedValue = 5;
        assertEquals(expectedValue, this.address.getCustomerId());
    }

    @Test
    public void testGetTypeId() {
        Integer expectedValue = 12;
        assertEquals(expectedValue, this.address.getTypeId());
    }

    @Test
    public void testGetFirstLine() {
        String expectedValue = "10 Streetname";
        assertEquals(expectedValue, this.address.getFirstLine());
    }

    @Test
    public void testGetSecondLine() {
        String expectedValue = "Second line";
        assertEquals(expectedValue, this.address.getSecondLine());
    }

    @Test
    public void testGetThirdLine() {
        String expectedValue = "third line";
        assertEquals(expectedValue, this.address.getThirdLine());
    }

    @Test
    public void testGetPostcode() {
        String expectedValue = "postcode";
        assertEquals(expectedValue, this.address.getPostcode());
    }

    @Test
    public void setValidCustomerId() {
        Integer expectedValue = 2;
        this.address.setCustomerId(expectedValue);
        assertEquals(expectedValue, this.address.getCustomerId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCustomerIdCannotBeNull() {
        this.address.setCustomerId(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCustomerIdCannotBeLessThanZero() {
        this.address.setCustomerId(-1);
    }

    @Test
    public void testSetValidTypeId() {
        Integer expectedValue = 7;
        this.address.setTypeId(expectedValue);
        assertEquals(expectedValue, this.address.getTypeId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTypeIdCannotBeNull() {
        this.address.setTypeId(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTypeIdCannotBeLessThanZero() {
        this.address.setTypeId(-1);
    }

    @Test
    public void testSetValidFirstLine() {
        String expectedValue = "new first line";
        this.address.setFirstLine(expectedValue);
        assertEquals(expectedValue, this.address.getFirstLine());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFirstLineCannotBeNull() {
        this.address.setFirstLine(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFirstLineCannotBeEmptyString() {
        this.address.setFirstLine("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFirstLineCannotBeMoreThan200Characters() {
        this.address.setFirstLine("123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901");
    }

    @Test
    public void testSetValidSecondLine() {
        String expectedValue = "new second line";
        this.address.setSecondLine(expectedValue);
        assertEquals(expectedValue, this.address.getSecondLine());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSecondLineCannotBeMoreThan200Characters() {
        this.address.setSecondLine("123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901");
    }

    @Test
    public void testSetValidThirdLine() {
        String expectedValue = "new third line";
        this.address.setThirdLine(expectedValue);
        assertEquals(expectedValue, this.address.getThirdLine());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThirdLineCannotBeMoreThan200Characters() {
        this.address.setThirdLine("123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901");
    }

    @Test
    public void testSetValidPostcode() {
        String expectedValue = "S1 1AA";
        this.address.setPostcode(expectedValue);
        assertEquals(expectedValue, this.address.getPostcode());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPostcodeCannotBeNull() {
        this.address.setPostcode(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPostcodeCannotBeEmptyString() {
        this.address.setPostcode("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPostcodeCannotBeMoreThan9Characters() {
        this.address.setPostcode("1234567890");
    }
}
