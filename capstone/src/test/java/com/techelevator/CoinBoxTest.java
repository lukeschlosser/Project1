package com.techelevator;


import org.junit.Test;
import static org.mockito.Mockito.*;

public class CoinBoxTest {

    CoinBox cB = mock(CoinBox.class);


    @Test
    public void giveChangeTestNormalRange(){

        doNothing().when(cB).giveChange(5.00);
        verify(cB,times(1));


    }


}
