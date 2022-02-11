package com.techelevator;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_Exit = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_Exit};

    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

	private static final String FEED_MONEY_OPTION_ONE_DOLLAR = "$1";
	private static final String FEED_MONEY_OPTION_TWO_DOLLAR = "$2";
	private static final String FEED_MONEY_OPTION_FIVE_DOLLAR = "$5";
	private static final String FEED_MONEY_OPTION_TEN_DOLLAR = "$10";
	private static final String[] FEED_MONEY_OPTIONS = {FEED_MONEY_OPTION_ONE_DOLLAR, FEED_MONEY_OPTION_TWO_DOLLAR, FEED_MONEY_OPTION_FIVE_DOLLAR, FEED_MONEY_OPTION_TEN_DOLLAR};

	private VendingMachine vm;
    private Menu menu;

    public VendingMachineCLI(Menu menu) {
        this.vm = new VendingMachine();
        this.menu = menu;
    }

    public void run() {

        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                // display vending machine items
                vm.displayItems();

            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                // do purchase
                choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
               // purchase menu(1) Feed money
                if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {

					choice =(String) menu.getChoiceFromOptions(FEED_MONEY_OPTIONS);

                    if(vm.feedMoney(choice)){
                        choice =(String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
                        if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
                            choice =(String) menu.getChoiceFromOptions(FEED_MONEY_OPTIONS);
                            if(vm.feedMoney(choice)){
                                choice =(String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
                                if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {

                                }else if(choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)){

                                }
                            }
                        }
                    }
                // purchase menu(2) Select product
                } else if (choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {

                    vm.selectProduct();
                 // purchase menu(3) finish transaction
                } else if (choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
               /*   Selecting "(3) Finish Transaction" allows the customer to complete the transaction and receive any remaining change.
                    The customer's money is returned using nickels, dimes, and quarters (using the smallest amount of coins possible).
                    The machine's current balance must be updated to $0 remaining.
                */
                    vm.finishTransaction();
                    //After completing their purchase, the user is returned to the "Main" menu to continue using the vending machine.
                }

            } else if (choice.equals(MAIN_MENU_OPTION_Exit)) {
                // do Exit
                vm.exit();
            }
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }
}
