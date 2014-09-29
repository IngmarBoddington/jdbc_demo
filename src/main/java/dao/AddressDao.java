package dao;

import model.Address;

public interface AddressDao {

    Address fetchAddress(Integer Id) throws Exception;

    Address persistAddress(Address address) throws Exception;
}
