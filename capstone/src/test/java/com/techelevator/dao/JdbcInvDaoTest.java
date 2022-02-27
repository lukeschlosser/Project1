package com.techelevator.dao;

import com.techelevator.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.math.BigDecimal;
import java.util.List;

public class JdbcInvDaoTest extends BaseDaoTests{

    private static final Product PRODUCT_1 = new Product("A1","Potato Crisps",new BigDecimal("3.05"),"Chip",5);
    private static final Product PRODUCT_2 = new Product("A2","Stackers",new BigDecimal("1.45"),"Chip",5);
    private static final Product PRODUCT_3 = new Product("A3","Grain Waves",new BigDecimal("2.75"),"Chip",5);
    private static final Product PRODUCT_4 = new Product("A4","Cloud Popcorn",new BigDecimal("3.05"),"Chip",5);

    private Product product;
    private  JdbcInvDao inventoryDao;

    @Before
    public void setup() {
        inventoryDao = new JdbcInvDao(dataSource);
        product = new Product("A5","Cotton Candy",new BigDecimal("1.00"),"Candy",5);
    }

    @Test
    public void getProductList_returns_correct_product_list() {
        List<Product> pList = inventoryDao.getProductList();
        assertProductsMatch(PRODUCT_1,pList.get(0));
        assertProductsMatch(PRODUCT_2,pList.get(1));
        assertProductsMatch(PRODUCT_3,pList.get(2));
        assertProductsMatch(PRODUCT_4,pList.get(3));
    }

    @Test
    public void getProductList_returns_correct_product_list_not_null() {
        List<Product> pList = inventoryDao.getProductList();
        Assert.assertNotNull(pList);
    }

    @Test
    public void searchInventory_with_product_id_return_product(){

    }

    @Test
    public void updateInventory_with_product_no_return(){  // after update, select

    }

    @Test
    public void getInventoryList_quantity_greater_than_zero(){ //quantity>0 check

    }

    private void assertProductsMatch(Product expected, Product actuals) {

        Assert.assertEquals(expected.getSlotLocation(), actuals.getSlotLocation());
        Assert.assertEquals(expected.getName(), actuals.getName());
        Assert.assertEquals(expected.getPrice(), actuals.getPrice());
        Assert.assertEquals(expected.getType(), actuals.getType());
        Assert.assertEquals(expected.getQuantity(), actuals.getQuantity());
    }
}
