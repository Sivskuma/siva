package com.adactin.bassclass.cucumberproject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Element;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BassClass {

	public static WebDriver driver;

	public static WebDriver getdriver(String BrowserName) {

		try {
			if (BrowserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
				driver = new ChromeDriver();
			}

			else if (BrowserName.equalsIgnoreCase("IE")) {

				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\Driver\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}

			
			
			else {
				System.out.println("invalid browser");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		driver.manage().window().maximize();
		return driver;
	}

	public static void geturl(String URL) {

		driver.get(URL);

	}

	public static void currenturl() {

		System.out.println(driver.getCurrentUrl());

	}

	public static void scroll(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);

	}

	public static void inputvalueonelement(WebElement element, String value) {

		element.sendKeys(value);

	}

	public static void gettitle() {

		System.out.println(driver.getTitle());
	}

	public static void dropdown(WebElement element, String value, String option) {

		Select s = new Select(element);
		if (option.equalsIgnoreCase("byindex")) {

			int parseint = Integer.parseInt(value);
			s.selectByIndex(parseint);

		} else if (option.equalsIgnoreCase("byvalue")) {

			s.selectByValue(value);

		}

		else if (option.equalsIgnoreCase("byvisibletext")) {

			s.selectByVisibleText(value);

		}

		else {

			System.out.println("invalid option");
		}

	}

	public static void clickonelement(WebElement  element) {

		element.click();
	}

	public static void navigateto(String URL) {

		driver.navigate().to(URL);
	}

	public static void navigateback() {

		driver.navigate().back();

	}

	public static void navigateforward() {

		driver.navigate().forward();
	}

	public static void refresh() {

		driver.navigate().refresh();

	}

	public static void gettext(WebElement element) {

		element.getText();

	}

	public static void getattribute(WebElement element, String attributename) {

		element.getAttribute(attributename);

	}

	public static void screenshot(String path) throws Throwable {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourcefile = ts.getScreenshotAs(OutputType.FILE);
		File desinationfile = new File(path);
		FileUtils.copyFile(sourcefile, desinationfile);

	}

	public static void windowhandle() {

		System.out.println(driver.getWindowHandle());
	}

	public static void windowhandles() {

		Set<String> allid = driver.getWindowHandles();

		for (String id : allid) {

			System.out.println("windows id:" + id);
		}

	}

	public static void close() {

		driver.close();

	}

	public static void quit() {

		driver.quit();
	}

	public static void clear(WebElement element){
		element.clear();

	}
	public static void alert(String confirmation, String message) {

		try {
			if (confirmation == "ok") {
				driver.switchTo().alert().accept();
			}

			else if (confirmation == "cancel") {

				driver.switchTo().alert().dismiss();

			}

			else if (confirmation == "Alert textbox") {

				Alert a = driver.switchTo().alert();
				a.sendKeys(message);
				a.accept();

			}

			else

			{
				System.out.println("invalid alert option");
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void actions(WebElement element, String options) {

		try {
			Actions ac = new Actions(driver);

			if (options.equalsIgnoreCase("click and hold")) {

				ac.clickAndHold(element).build().perform();

			}

			else if (options.equalsIgnoreCase("click")) {

				ac.click(element).build().perform();

			}

			else if (options.equalsIgnoreCase("context click")) {

				ac.contextClick(element).build().perform();

			}

			else if (options.equalsIgnoreCase("double click")) {

				ac.doubleClick(element).build().perform();

			}

			else if (options.equalsIgnoreCase("move to element")) {

				ac.moveToElement(element);
			}

			else {

				System.out.println("invalid action option");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void robot() throws AWTException {

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

	public static void draganddrop(WebElement source, WebElement target) {

		Actions ac = new Actions(driver);

		ac.dragAndDrop(source, target).build().perform();

	}

	public static void frame(String type, String value, WebElement element) {

		try {
			if (type.equalsIgnoreCase("index")) {

				int parseint = Integer.parseInt(value);
				driver.switchTo().frame(parseint);
			} else if (type.equalsIgnoreCase("id or name of frame")) {

				driver.switchTo().frame(value);

			}

			else if (type.equalsIgnoreCase("webelement")) {

				driver.switchTo().frame(element);

			}

			else {

				System.out.println("invalid frame");
			}
		}

		catch (NumberFormatException e) {
			e.printStackTrace();
		}

	}

	public static void implicitWait(int seconds) {

		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);

	}

	public static void explicitWait(int seconds, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.invisibilityOf(element));

	}

	public static void flentWait(int seconds) {

		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(seconds))
				.pollingEvery(Duration.ofSeconds(seconds)).ignoring(Exception.class);

	}

	public static void displayed(WebElement element) {

		element.isDisplayed();

	}

	public static void enabled(WebElement element) {

		element.isEnabled();

	}

	public static void selected(WebElement element) {

		element.isSelected();

	}

	public static void checkbox(java.util.List<WebElement> element, String attributename, String attributevalue) {

		for (WebElement s : element) {

			if (s.getAttribute(attributename).equalsIgnoreCase(attributevalue)
					|| s.getAttribute(attributename).equalsIgnoreCase(attributevalue)) {

				s.click();
				
				

			}

		}

	}

	
	}


