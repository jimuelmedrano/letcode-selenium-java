package jimuelmedrano.letcode.tests;

import jimuelmedrano.letcode.actions.PageActions;
import jimuelmedrano.letcode.constants.FrameworkConstants;
import jimuelmedrano.letcode.pages.FormPage;
import jimuelmedrano.letcode.pages.WindowPage;
import jimuelmedrano.letcode.utils.Annotations;
import jimuelmedrano.letcode.utils.HttpUtils;
import jimuelmedrano.letcode.utils.JavaUtils;
import org.json.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class FormTest extends Annotations {

    @BeforeMethod
    public void open(){
        ds.driver.get(FrameworkConstants.BASE_URL);
        PageActions.scrollToElement(ds.driver, FormPage.formPageView);
        PageActions.click(ds.driver, FormPage.formPageLink);
    }

    @Test(priority = 1)
    public void inputForm() throws InterruptedException, IOException, ParseException {
        JSONObject randomUser = HttpUtils.GET(FrameworkConstants.RANDOM_USER_BASE_URL,FrameworkConstants.RANDOM_USER_ENDPOINT);
        //Input First Name from API
        PageActions.inputText(ds.driver,FormPage.firstNameInput,randomUser.getString("first_name"));
        //Input Last Name from API
        PageActions.inputText(ds.driver,FormPage.lastNameInput,randomUser.getString("last_name"));
        //Input Email from API
        PageActions.getElement(ds.driver,FormPage.emailInput).clear();
        PageActions.inputText(ds.driver,FormPage.emailInput,randomUser.getString("email"));
        //Select Country Code using random number generator
        List<WebElement> countryCodes = PageActions.getAllSelectOptions(ds.driver,FormPage.countryCodeSelect);
        int randomCountryIndex = JavaUtils.randomNumber(3,countryCodes.size());
        PageActions.selectByIndex(ds.driver,FormPage.countryCodeSelect,randomCountryIndex);
        //Input Phone Number using random number generator
        long randomPhoneNumber = JavaUtils.randomLongNumber(9000000000L,9999999999L);
        PageActions.inputText(ds.driver,FormPage.phoneInput, ""+randomPhoneNumber);
        //Input Address Line 1 from API
        JSONObject address = randomUser.getJSONObject("address");
        PageActions.inputText(ds.driver,FormPage.addressLine1Input,address.getString("street_address"));
        //Input Address Line 2 from API
        PageActions.inputText(ds.driver,FormPage.addressLine2Input,address.getString("city"));
        //Input State from API
        PageActions.inputText(ds.driver,FormPage.stateInput,address.getString("state"));
        //Input Postal Code from API
        PageActions.inputText(ds.driver,FormPage.postalInput,address.getString("zip_code"));
        //Select Country from API
        PageActions.selectByValue(ds.driver,FormPage.countrySelect,address.getString("country"));
        //Select Date of Birth from API
        String dateString = JavaUtils.formattedDate(randomUser.getString("date_of_birth"));
        PageActions.scrollToElement(ds.driver,FormPage.dateOfBirthInput);
        PageActions.inputText(ds.driver,FormPage.dateOfBirthInput,dateString);
        //Select Random Gender using random number generator
        List<WebElement> genderElements = PageActions.getElements(ds.driver,FormPage.genderRadioElements);
        int randomGender = JavaUtils.randomNumber(0,2);
        genderElements.get(randomGender).click();
        //Click Agree to Terms and Conditions
        PageActions.click(ds.driver,FormPage.agreeToTerms);
        //Click Submit Button
        PageActions.click(ds.driver,FormPage.submitButton);
    }

    @Test(priority = 2)
    public void testPost() throws InterruptedException, IOException {
        //Sample Data for post API
        //The sample post API will return the same parameter you sent as response
        var body = new HashMap<String, String>() {{
            put("first_name", FrameworkConstants.FIRST_NAME);
            put("last_name", FrameworkConstants.LAST_NAME);
            put("github_username", FrameworkConstants.GITHUB_USERNAME);
        }};
        JSONObject postResponse = HttpUtils.POST(FrameworkConstants.SAMPLE_POST_BASE_URL,FrameworkConstants.SAMPLE_POST_BASE_ENDPOINT,body);
        System.out.println(postResponse.get("data"));
    }


}
