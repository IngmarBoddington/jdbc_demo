package dao;

import model.AddressType;

public interface AddressTypeDao {

    AddressType fetchAddressType(Integer Id) throws Exception;

    AddressType persistAddressType(AddressType addressType) throws Exception;

}