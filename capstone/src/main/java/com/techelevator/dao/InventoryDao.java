package com.techelevator.dao;

import com.techelevator.model.Product;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;


public interface InventoryDao {

    List<Product> getInventoryList();

    Product searchInventory(String productCode);

    void updateInventory(Product productUpdated);

    List<Product> getProductList(); // do I need this method?

    Product mapToRowProduct(SqlRowSet results);
}
