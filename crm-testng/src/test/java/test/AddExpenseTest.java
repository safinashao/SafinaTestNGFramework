package test;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddExpensePage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddExpenseTest {

	@Test
	public void AddExpenseToVerifyExpensePosted() {
		WebDriver driver = BrowserFactory.startBrowser("http://techfios.com/test/billing/?ng=admin/");
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login("techfiosdemo@gmail.com", "abc123");
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.waitForDashBoardPage();
		Assert.assertTrue("DashboardPageTitle Displayed", dashboardPage.isDashBoardPageTitleDisplayed());
		dashboardPage.clickOnAddExpenseButton();
		AddExpensePage addExpensePage = PageFactory.initElements(driver, AddExpensePage.class);
		addExpensePage.waitForAddExpensePage();
		addExpensePage.selectFromDropDownForAccount("Tedla");
		addExpensePage.clearTheDateAndInputField("2019-05-31");
		addExpensePage.clickAway();
		Random random = new Random();
		String eDescription = "Zumba Classess" + String.valueOf(random.nextInt(125));
		String eAmount = String.valueOf(random.nextInt(1000));
		addExpensePage.inputDescriptionAndAmountField(eDescription, eAmount);
		addExpensePage.clickOnSubmitButton();
		addExpensePage.waitForExpenseAddedSuccessMsg();
		Assert.assertTrue("Success Message Not Posted", addExpensePage.isExpenseSuccessMsgDisplayed());
		driver.close();
		driver.quit();
	}
}
