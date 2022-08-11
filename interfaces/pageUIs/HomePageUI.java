package pageUIs;

public class HomePageUI {
	public static final String REGISTER_LINK = "//a[@class='ico-register']";
	public static final String LOGOUT_LINK = "//a[@class='ico-logout']";
	public static final String LOGIN_LINK = "//a[@class='ico-login']";
	public static final String MYACCOUNT_LINK = "//a[@class='ico-account']";
	public static final String FOOTER_TEXT_LINK = "//div[@class='footer']//a[text()='%s']";
	public static final String PRODUCT_NAME = "//h2[@class='product-title']//a[contains(text(),'%s')]";
	public static final String ADD_TO_WISHLIST_BUTTON = "//button[@id='add-to-wishlist-button-4']";
	public static final String MESSAGE_WISHLIST_SUCCESS = "//div[@class='bar-notification success']//p";
	public static final String MESSAGE_WISHLIST_SUCCESS_CLOSE = "//span[@class='close']";
	public static final String WISHLIST_LINK = "//a[@class='ico-wishlist']";
	public static final String ADD_TO_COMPARE_LIST_BUTTON = "//div[@class='compare-products']//button[contains(@class,'add-to-compare-list-button')]";
	public static final String MESSAGE_ADD_TO_SUCCESS = "//p[@class='content']/a";
	public static final String RECENTLY_PRODUCT_VIEW = "//a[text()='%s']/parent::li/following-sibling::li/a[text()='%s']/parent::li/following-sibling::li/a[text()='%s']";
	public static final String COMPUTER_LINK = "//ul[contains(@class,'notmobile')]//a[contains(text(),'Computers')]";
	public static final String NOTERBOOK_LINK = "//ul[contains(@class,'notmobile')]//ul[contains(@class,'sublist')]//a[contains(text(),'Notebooks')]";
	public static final String PRODUCT_TYPE_LINK = "//ul[contains(@class,'notmobile')]//ul[contains(@class,'sublist')]//a[contains(text(),'%s ')]";
	public static final String COMPONENTS_OF_CPU_DROPDOWN = "//label[text()=' %s ']/parent::dt/following-sibling::dd//select";
	public static final String COMPONENTS_OF_CPU_CHECKBOX = "//label[text()=' %s ']/parent::dt/following-sibling::dd//label[contains(text(),'%s')]";
	public static final String SOFTWARE_RADIOBUTTON = "//label[text()=' Software ']/parent::dt/following-sibling::dd//label[text()='%s']";
	public static final String QUANTITY_ADD_TO_CART_TEXTBOX = "//input[@id='product_enteredQuantity_1']";
	public static final String ADD_TO_CART_BUTTON = "//button[@id='add-to-cart-button-1']";
	public static final String QUANTITY_PRODUCT_INSHOPPING_CART = "//span[@class='cart-qty']";
	public static final String SHOPPING_CART_LINK = "//span[@class='cart-label']";
	public static final String MINI_SHOPPING_CART_TITLE = "//div[@class='mini-shopping-cart']//a";
	public static final String PRODUCT_INFOR = "//a[text()='%s']/parent::div/following-sibling::div[contains(text(),'Processor: %s') and text()='RAM: %s' and text()='HDD: %s'  and text()='OS: %s' and text()='Software: %s' and text()='Software: %s']";
	public static final String SUB_TOTAL_PRICE ="//div[@id='flyout-cart']//div[@class='totals']//strong";
}
