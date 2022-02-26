package com.techelevator;

import com.techelevator.exceptions.InsufficientFundsException;
import com.techelevator.exceptions.InvalidSlotException;
import com.techelevator.exceptions.SoldOutException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {

    private VendingMachine vm;

    @Before
    public void setup() {
        vm = new VendingMachine();
    }

    @After
    public void teardown() {
        vm = null;
    }


    @Test
    public void makeDepositTest(){


        String deposit = "5.00";
        boolean expected = true;

//        Assert.assertEquals(expected, vm.makeDeposit(deposit));

    }

    @Test
    public void makeDepositTestThisWillFail(){ //customer only has set options so there is no reason for this to pass.

        String deposit = "";
        boolean expected = true;

//        Assert.assertEquals(expected, vm.makeDeposit(deposit));

    }

    @Test
    public void makeDepositTestValueHigh(){

        String deposit = "10.00";
        boolean expected = true;

//        Assert.assertEquals(true, vm.makeDeposit(deposit));

    }

    @Test
    public void selectProductInvalidCode() throws InsufficientFundsException, InvalidSlotException, SoldOutException { // this should fail

        String productCode = "A6";

//        Assert.assertFalse(vm.selectProduct(productCode));
    }
}
