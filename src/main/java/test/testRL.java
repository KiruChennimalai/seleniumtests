package test;

import org.junit.Assert;
import org.junit.Test;
import utilities.CommonTestCase;
/**
 * Created by kchennimalai on 30/11/2017.
 */
public class testRL extends CommonTestCase{

    @Test
    public void getRLLink() {

        driver.get("https://blueprint.meteorapp.com/");

        String pageTitle = driver.getTitle();

        System.out.println("pagetitle is ------" + pageTitle);

        Assert.assertEquals(pageTitle, "Blueprint");

        

    }
}
