package com.techelevator;


import org.junit.Test;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

public class CoinBoxTest {

    CoinBox cB = mock(CoinBox.class);


    @Test
    public void giveChangeTestNormalRange(){

        doNothing().when(cB).giveChange(new BigDecimal("5.00"));
        verify(cB,times(1));


    }


}
