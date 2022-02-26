package com.techelevator;

import com.techelevator.exceptions.VendingMachineExceptions;
import com.techelevator.view.Menu;


public class VendingMachineCLI {
    //MAIN OPTION
    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    //PURCHASE OPTIONS
    private static final String PURCHASE_MENU_OPTION_DEPOSIT_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_END_TRANSACTION = "Finish Transaction";
    //FEED MONEY OPTIONS
    private static final String FEED_MONEY_OPTION_ONE = "$1";
    private static final String FEED_MONEY_OPTION_TWO = "$2";
    private static final String FEED_MONEY_OPTION_FIVE = "$5";
    private static final String FEED_MONEY_OPTION_TEN = "$10";
    //MENU COLLECTIONS
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_DEPOSIT_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_END_TRANSACTION};
    private static final String[] DEPOSIT_MENU_OPTIONS = {FEED_MONEY_OPTION_ONE, FEED_MONEY_OPTION_TWO, FEED_MONEY_OPTION_FIVE, FEED_MONEY_OPTION_TEN};

    private VendingMachine vm;
    private Menu menu;

    public VendingMachineCLI(Menu menu) {
        this.vm = new VendingMachine();
        this.menu = menu;
    }

    public void run() {
        String[] activeMenu = MAIN_MENU_OPTIONS;
        boolean run = true;
        while (run) {
            String userChoice = (String) menu.getChoiceFromOptions(activeMenu);

            if (userChoice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                vm.listItems();

            } else if (userChoice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                activeMenu = PURCHASE_MENU_OPTIONS;

            } else if (userChoice.equals(MAIN_MENU_OPTION_EXIT)) {
                vm.exitDialog();
                run = false;

            } else if (userChoice.equals(PURCHASE_MENU_OPTION_DEPOSIT_MONEY)) {
                String deposit = (String) menu.getChoiceFromOptions(DEPOSIT_MENU_OPTIONS);
                vm.makeDeposit(deposit);

            } else if (userChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
                vm.getAvailableItems();
                String productCode = (String) menu.getChoiceFromOptions2(PURCHASE_MENU_OPTIONS);
                try {
                    vm.selectProduct(productCode);
                } catch (VendingMachineExceptions vme) {
                    System.out.println(vme.getMessage() + "\n");
                    activeMenu = PURCHASE_MENU_OPTIONS;
                }
            } else if (userChoice.equals(PURCHASE_MENU_OPTION_END_TRANSACTION)) {
                vm.closeBank();
                activeMenu = MAIN_MENU_OPTIONS;
            }
        }

    }

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }
}
