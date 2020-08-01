package stepDef;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import org.junit.Assert;

import base.Log;
import base.Utilities;

public class LogIn extends Utilities{
	
    private Utilities utl;
    public LogIn(Utilities utl) {
        this.utl = utl;
    }
    
    @Given("^App is open$")
    public void app_is_open() {
        Log.info("App is open");
    }

    @When("^User selects the value from \"([^\"]*)\" with \"([^\"]*)\"$")
    public void user_selects_the_value_from_with(String arg1, String arg2) {
    	utl.click(arg1);
    	utl.scrollToFind(arg2);
    }
   
    @And("^User enters in the \"([^\"]*)\" box with \"([^\"]*)\"$")
    public void user_enters_in_the_box_with(String arg1, String arg2) {
    	utl.enterText(arg1, arg2);
    }
    
    @And("^User selects a \"([^\"]*)\"$")
    public void user_selects_a(String arg1) {
    	utl.click((arg1));
    }
    
    @And("^User clicks on \"([^\"]*)\"$")
    public void user_clicks_on(String arg1) {
        utl.click(arg1);
    }
    
    @And("^User selects a value$")
    public void user_selects_a_value(DataTable arg1) {
    	List<List<String>> data = arg1.asLists(String.class);
    	utl.click(data.get(0).get(1));
    }
    
    @When("^User selects the value from dropdown$")
    public void user_selects_the_value_from_dropdown(DataTable arg1) throws Throwable {
    	List<List<String>> data = arg1.asLists(String.class);
    	utl.click("dropdown");
    	utl.scrollToFind(data.get(0).get(1));
    }

    @And("^User enters the detail$")
    public void user_enters_the_detail(DataTable arg1) {
    	List<List<String>> data = arg1.asLists(String.class);
    	utl.enterText(data.get(0).get(0), data.get(0).get(1));
    }

}
