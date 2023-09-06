package jimuelmedrano.letcode.tests;

import jimuelmedrano.letcode.actions.PageActions;
import jimuelmedrano.letcode.constants.FrameworkConstants;
import jimuelmedrano.letcode.pages.SliderPage;
import jimuelmedrano.letcode.pages.WindowPage;
import jimuelmedrano.letcode.utils.Annotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SliderTest extends Annotations {

    @BeforeMethod
    public void open(){
        ds.driver.get(FrameworkConstants.BASE_URL);
        PageActions.scrollToElement(ds.driver, SliderPage.sliderPageView);
        PageActions.click(ds.driver, SliderPage.sliderPageLink);
    }

    @Test(priority = 1)
    public void slideAndGenerate() throws InterruptedException{
        //Slide the slider by -150x offset. this will put the slider to value: 15
        PageActions.dragDropOffset(ds.driver, SliderPage.sliderRange,-150,0);
        PageActions.click(ds.driver, SliderPage.generateButton);
        //Print the results and count the countries
        String results = PageActions.getText(ds.driver,SliderPage.resultText);
        String[] countries = results.split("-");
        System.out.println("Countries Slider Result: ");
        for (String country : countries)
            System.out.println("- "+country);
        System.out.println("Countries count: "+ countries.length);
    }
}
