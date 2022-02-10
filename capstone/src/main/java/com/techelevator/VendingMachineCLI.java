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

                if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
                    //Feed money  -> we need to know input dollar
					choice =(String) menu.getChoiceFromOptions(FEED_MONEY_OPTIONS);
                    vm.feedMoney(choice);
                } else if (choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
                    // select product -> where do we save the product?
                    vm.selectProduct();
                } else if (choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
                    //finish transaction
                    // ->>>>>>> return change
                    vm.finishTransaction();
                }

            } else if (choice.equals(MAIN_MENU_OPTION_Exit)) {
                // do Exit
                vm.finishTransaction();
            }
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }
}
