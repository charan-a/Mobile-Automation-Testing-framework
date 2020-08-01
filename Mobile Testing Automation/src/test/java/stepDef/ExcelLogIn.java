package stepDef;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import excelUtls.DataHelper;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.util.HashMap;
import java.util.List;
import org.junit.Assert;

import base.Log;
import base.Utilities;

public class ExcelLogIn extends Utilities{

    private Utilities utl;
    public List<HashMap<String,String>> datamap;
	public static int index;
    public ExcelLogIn(Utilities utl) {
        this.utl = utl;
        datamap = DataHelper.data(System.getProperty("user.dir")+"\\src\\test\\java\\excelUtls\\data.xlsx","Sheet1");
    }
    
    @Given("^App open$")
    public void app_open() {
        Log.info("App open");
    }

    @When("^User gets data from excel at \"([^\"]*)\" row$")
    public void user_get_data_from_excel_at_row(String arg1) {
    	index = Integer.parseInt(arg1)-1;
        System.out.println("current data set at" + index);
    }
    @And("^ExcelUser selects the value from \"([^\"]*)\" with \"([^\"]*)\"$")
    public void exceluser_selects_the_value_from_with(String arg1, String arg2) {
    	utl.click(arg1);
    	String value = datamap.get(index).get(arg2);
    	utl.scrollToFind(value);
    }

    @And("^ExcelUser enters in the \"([^\"]*)\" box with \"([^\"]*)\"$")
    public void exceluser_enters_in_the_box_with(String arg1, String arg2) {
    	String value = datamap.get(index).get(arg2);
    	utl.enterText(arg1, value);
    }

    @And("^ExcelUser selects a \"([^\"]*)\"$")
    public void exceluser_selects_a(String arg1) {
    	String value = datamap.get(index).get(arg1);
    	utl.click((value));
    }

    @Then("^ExcelUser clicks on \"([^\"]*)\"$")
    public void exceluser_clicks_on_the(String arg1) throws Throwable {
    	String value = datamap.get(index).get(arg1);
    	utl.click(value);
    }

}
