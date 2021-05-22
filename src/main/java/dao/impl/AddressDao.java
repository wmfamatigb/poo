package dao.impl;

import dao.AbstractDao;
import model.Address;

public class AddressDao extends AbstractDao<Address> {

    private static AddressDao instance = new AddressDao();

    public static AddressDao getInstance() {
        return instance;
    }
}
