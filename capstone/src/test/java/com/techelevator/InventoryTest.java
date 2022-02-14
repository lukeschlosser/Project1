package com.techelevator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class InventoryTest {

    private Inventory inventory;
    Inventory inventoryMock = mock(Inventory.class);

    @Before
    public void setup(){
        Inventory inventory = new Inventory();
    }

    @After public void teardown(){}

    @Test
    public void searchInventoryOutOfRange(){ // this test fails

        Item itemExpected = new Item("A6","Potato Noms", 3.05, "Chip");
        Item productCode = inventory.searchInventory("A6");

        Assert.assertEquals(itemExpected, productCode);
    }


    @Test
    public void updateInventoryRunCheck(){

        doNothing().when(inventoryMock).updateInventory(null);
        verify(inventoryMock, times(1));
    }

}
