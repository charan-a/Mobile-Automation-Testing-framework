package stepDef;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;

import java.util.List;

import org.junit.Assert;

import base.Log;
import base.Utilities;

public class Products extends Utilities{
	
    private Utilities utl;
    public Products(Utilities utl) {
        this.utl = utl;
    }
    
    @And("^User navigates to the \"([^\"]*)\" page$")
    public void user_navigates_to_the_something_page(String arg1) {
    	Assert.assertTrue(utl.check(arg1));
    	Log.info("User is on "+arg1+" page");
    }
    
    @And("^User adds products to the cart$")
    public void user_adds_products_to_the_cart(DataTable arg1)  {
    	List<List<String>> data = arg1.asLists(String.class);
    	utl.products(data);
    	Log.info("Products added");
    }


}
