package jimuelmedrano.letcode.tests;

import jimuelmedrano.letcode.actions.PageActions;
import jimuelmedrano.letcode.constants.FrameworkConstants;
import jimuelmedrano.letcode.pages.FormPage;
import jimuelmedrano.letcode.pages.WindowPage;
import jimuelmedrano.letcode.utils.Annotations;
import jimuelmedrano.letcode.utils.HttpUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

public class FormTest extends Annotations {

    @BeforeMethod
    public void open(){
//        ds.driver.get(FrameworkConstants.BASE_URL);
//        PageActions.scrollToElement(ds.driver, FormPage.formPageView);
//        PageActions.click(ds.driver, FormPage.formPageLink);
    }

    @Test(priority = 1)
    public void inputForm() throws InterruptedException, IOException {
        JSONObject randomUser = HttpUtils.GET(FrameworkConstants.RANDOM_USER_BASE_URL,FrameworkConstants.RANDOM_USER_ENDPOINT);
        System.out.println(randomUser.toString());
        System.out.println(randomUser.getString("first_name"));

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
