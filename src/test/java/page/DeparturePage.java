package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DeparturePage {
    public DeparturePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
   @FindBy(xpath="//div[@class='app-components-Shopping-TripInfo-styles__tripOriginDestinationHeader--RcPyp']//span[2]")
    public WebElement departureText;
}
