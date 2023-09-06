package jimuelmedrano.letcode.tests;

import jimuelmedrano.letcode.actions.PageActions;
import jimuelmedrano.letcode.constants.FrameworkConstants;
import jimuelmedrano.letcode.pages.AlertPage;
import jimuelmedrano.letcode.pages.ElementsPage;
import jimuelmedrano.letcode.pages.FramePage;
import jimuelmedrano.letcode.utils.Annotations;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ElementsTest extends Annotations {

    @BeforeMethod
    public void open(){
        ds.driver.get(FrameworkConstants.BASE_URL);
        PageActions.scrollToElement(ds.driver, ElementsPage.elementsPageView);
        PageActions.click(ds.driver, ElementsPage.elementsPageLink);
    }

    @Test(priority = 1)
    public void checkGithubImage() throws InterruptedException{
        PageActions.inputText(ds.driver, ElementsPage.usernameInput, FrameworkConstants.GITHUB_USERNAME);
        PageActions.click(ds.driver,ElementsPage.searchButton);
        if(PageActions.checkElementExist(ds.driver,ElementsPage.profilePicture)){
            System.out.println("Image Exists");
        }else{System.out.println("Image is Missing");};
    }

    @Test(priority = 2)
    public void printGithubInfo() throws InterruptedException{
        PageActions.inputText(ds.driver, ElementsPage.usernameInput, FrameworkConstants.GITHUB_USERNAME);
        PageActions.click(ds.driver,ElementsPage.searchButton);
        String username = FrameworkConstants.GITHUB_USERNAME;
        String fullName = PageActions.getText(ds.driver,ElementsPage.profileName);
        List<WebElement> otherInfo = PageActions.getElements(ds.driver,ElementsPage.otherInfoElements);
        List<WebElement> repoList = PageActions.getElements(ds.driver,ElementsPage.repoList);

        //Print All Info
        System.out.println("Github User Information");
        System.out.println("Github Username: "+username);
        System.out.println("Github Full Name: "+fullName);
        System.out.println("Github Other Information");
        for (int i = 0; i < otherInfo.size(); i++) {
            String infoName = otherInfo.get(i).getText();
            String infoValue = otherInfo.get(i+1).getText();
            System.out.println("-"+infoName+": "+infoValue);
            //increment again to get the next info name and skip the value
            i++;
        }
        System.out.println("Github Public Repo List");
        repoList.forEach((elm)->{
            System.out.println("-"+elm.getText());
        });
    }
}
