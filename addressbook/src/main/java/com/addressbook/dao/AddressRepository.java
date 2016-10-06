package com.addressbook.dao;

/**
 * Created by Sven on 10/2/2016.
 */
import com.addressbook.row_Objects.Address_row;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address_row, Long> {

    List<Address_row> findByState(String state);

}
