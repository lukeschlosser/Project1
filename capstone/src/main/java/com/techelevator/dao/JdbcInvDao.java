package com.techelevator.dao;

import com.techelevator.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcInvDao implements InventoryDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcInvDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Product> getInventoryList() {
        List<Product> productList = new ArrayList<>();
        String sql ="SELECT pd.product_id, pd.name,pd.price, pd.type ,s.quantity " +
                "FROM product as pd " +
                "JOIN stock as s ON pd.product_id = s.product_id WHERE s.quantity > 0 "+
                "ORDER BY product_id";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            productList.add(mapToRowProduct(results));
        }
        return productList;
    }

    @Override
    public Product searchInventory(String product_id) {
        Product product = null;
        String sql ="SELECT pd.product_id, pd.name,pd.price, pd.type ,s.quantity " +
                "FROM product as pd " +
                "JOIN stock as s ON pd.product_id = s.product_id WHERE product_id=? "+
                "ORDER BY product_id";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,product_id);
        if(result.next()){
            product = mapToRowProduct(result);
        }
        return product;
    }

    @Override     // only update a product's quantity
    public void updateInventory(Product product) {
        String sql="UPDATE stock " +
                "SET quantity=? " +
                "WHERE product_id=?";
        jdbcTemplate.update(sql,product.getQuantity(),product.getSlotLocation());
    }

    @Override
    public List<Product> getProductList() {
       List<Product> pList = new ArrayList<>();
        String sql ="SELECT pd.product_id, pd.name,pd.price, pd.type ,s.quantity " +
               "FROM product as pd " +
               "JOIN stock as s ON pd.product_id = s.product_id "+
                "ORDER BY product_id";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            pList.add(mapToRowProduct(results));
        }
        return pList;
    }

    @Override
    public Product mapToRowProduct(SqlRowSet results) {
        Product pd = new Product();
        pd.setSlotLocation(results.getString("product_id"));
        pd.setName(results.getString("name"));
        pd.setPrice(results.getBigDecimal("price").setScale(2));
        pd.setType(results.getString("type"));
        pd.setQuantity(results.getInt("quantity"));
        return pd;
    }
}
