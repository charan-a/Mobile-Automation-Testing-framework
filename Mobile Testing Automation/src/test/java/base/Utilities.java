package base;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Reader;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class Utilities {
	
	public AndroidDriver<AndroidElement> driver;
    public final static String repo = "repo.properties";
    public Reader reader = new Reader();
    public WebDriverWait wait;
    
    public boolean scrollToFind(String object) {
		Log.debug("Scroll to find");
    	try {
    		//scrolls and finds
    		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" +object +"\"))").click();
    	}
    	catch (Exception e){
    		Log.error("ScrollToFind "+object,e);
    		return false;
    	}
    	return true;
    }
    
    public boolean enterText(String box, String text) {
		Log.debug("Entering Text");
    	try {
    		//Find path of element to be clicked
    		String path = reader.path(box);
    		//wait and then enter
    		if(box.equals("Search"))
    			{
    				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path))).sendKeys(text+"\n");    
    			}
    		else {
    			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path))).sendKeys(text);    
    			driver.pressKey(new KeyEvent(AndroidKey.ESCAPE));
    		}		
    	}
    	catch(Exception e) {
    		Log.error("Entering Text "+box, e);
    		return false;
    	}
    	return true;
    }
    
    public boolean click(String object) {
		Log.debug("Clicking an element");
    	try {
    		//Find path of element to be clicked
    		String path = reader.path(object);
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path))).click();    
    	}
    	catch(Exception e) {
    		Log.error("Clicking "+object, e);
    		return false;
    	}
    	return true;
    }
    
    public boolean scroll() {
    	Log.debug("Scrolling");
    	try {
    		//general scrolling
    		Dimension size = this.driver.manage().window().getSize();
    		int startX = size.width / 2;
			int startY = (int) (size.height * 0.91);
			int endY = (int) (size.height * 0.04);
    		TouchAction action = new TouchAction(this.driver);
    		action.longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(startX, endY)).release().perform();
    	}
    	catch(Exception e) {
    		Log.error("Scrolling",e);
    		return false;
    	}
    	return true;
    }
    
    public boolean check(String object) {
    	Log.debug("Checking presence");
    	try {
    		//Check whether element is present or not
    		String path = reader.path(object);
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
    		//driver.findElementByXPath(path);  
    	}
    	catch(Exception e) {
    		Log.error("Checking "+object, e);
    		return false;
    	}
    	return true;
    }
    
	public boolean dragndrop(String from, String to) {
		Log.debug("Performing drag n drop");
		try {
			WebElement first = driver.findElement(By.xpath(reader.path(from)));
			WebElement second = driver.findElement(By.xpath(reader.path(to)));
			Actions builder = new Actions(driver);
			Action dragAndDrop = builder.clickAndHold(first).moveToElement(second).release(first).build();
			dragAndDrop.perform();
		}
		catch(Exception e) {
			Log.error("Dragging & Dropping", e);
			return false;
		}
		return true;
	}
    
    public boolean products(List<List<String>> data) {
    	Log.debug("Adding products to cart");
    	try {
    		int temp=0;
    		for(int i=1;i<data.get(0).size();i++)
    		{
    			String index = reader.path(data.get(0).get(i));
    			int n= Integer.parseInt(index);
    			int k=n/2-temp;
    			temp=k;
    			for(int j=0;j<k;j++)
    			{
    				scroll();
    			}
    			driver.findElementsById("productAddCart").get(n%2).click();
    		}
    	}
    	catch(Exception e) {
    		Log.error("Adding products to cart", e);
    		return false;
    	}
    	return true;
    	}
    
    public boolean switchToWebContext() throws InterruptedException {
    	Log.debug("Switching context");
    	try {
    		Thread.sleep(3000);
    		Set<String> contexts = driver.getContextHandles();
            for (String context : contexts) {
            	if(context.contains("WEBVIEW"))
            	{
            		 driver.context(context);
            		 Log.info(driver.getContext());
            	}
            }
    	}
    	catch(Exception e) {
    		Log.error("Switching context", e);
    		return false;
    	}
    	return true;
    }
    public void moveSliderToNumber(String object, String num) throws IOException{
    	Log.debug("Moving slider");
    	try{
    		int n = Integer.parseInt(num);
        	String xpath=reader.path(object);
        	WebElement slider=driver.findElementByXPath(xpath);
        	Actions move = new Actions(driver);
        	Action action = move.dragAndDropBy(slider, n, 0).build();
        	action.perform();
    	}
    	catch(Exception e)
    	{
    		Log.error("Moving slider", e);
    	}
    }
    
    public void webScroll(){
    	Log.debug("Web Scroll");
    	try {
    		JavascriptExecutor jse = (JavascriptExecutor) driver;
    		jse.executeScript("window.scrollBy(0,400)");
    	}
    	catch(Exception e)
    	{
    		Log.error("Web Scroll", e);
    	}
    }
    public void alertBox(){
    	Log.debug("Alert Box");
    	try{
    		click("Alert_Box_Click_Me");
    		Thread.sleep(1000);
    		Alert alert= driver.switchTo().alert();
    		alert.accept();
    	}
    	catch(Exception e)
    	{
    		Log.error("Alert Box", e);
    	}
    }
    
    public void confirmBox(){
    	Log.debug("Confirm Box");
    	try{
    		click("Confirm_Box_Click_Me");
    		Thread.sleep(1000);
    		Alert alert= driver.switchTo().alert();
    		alert.dismiss();
    	}
    	catch(Exception e)
    	{
    		Log.error("Confirm Box", e);
    	}
    }
    
    public void promptBox(String object){
    	Log.debug("Prompt Box");
    	try{
    		click("Prompt_Box_Click_Me");
    		Thread.sleep(1000);
    		Alert alert= driver.switchTo().alert();
    		alert.sendKeys(object);
    		alert.accept();
    	}
    	catch(Exception e)
    	{
    		Log.error("Prompt Box", e);
    	}
    }
    
    }
    
