package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends BasePage {

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	// element library or repository
	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Dashboard')]")
	WebElement PageTitle;
	@FindBy(how = How.LINK_TEXT, using = "Add Deposit")
	WebElement AddDepositLink;
	@FindBy(how = How.LINK_TEXT, using = "Add Expense")
	WebElement AddExpenseField;

	// every page should have a waitforpage method--wait for dashboardpage to show up
	
	
	public void waitForDashBoardPage() {
		waitForElement(PageTitle, driver);

	}
	
	public void clickOnAddDepositButton() {
		AddDepositLink.click();
	}

	public boolean isDashBoardPageTitleDisplayed() {
		return PageTitle.isDisplayed();
	}

	public void clickOnAddExpenseButton() {
		AddExpenseField.click();
		
	}

}
