package com.techelevator;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class ItemTest {

    Item item = mock(Item.class);

    @Test
    public void setQuantityDoesItRun(){

        doNothing().when(item).setQuantity(4);
        verify(item,times(1));

    }
}
