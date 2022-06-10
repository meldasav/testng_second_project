package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.Waiter;

import java.util.List;

public class UnitedAirlinesHomePage {

    public UnitedAirlinesHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "div[class*='app-components-GlobalHeader-globalHeader__globalBottomNav-'] a")
    public List<WebElement> navigationItems;

    @FindBy(css = "ul[class*='app-components-BookTravel-bookTravel__'] li")
    public List<WebElement> bookTravelMenus;

    @FindBy(css = "label[for='roundtrip']")
    public WebElement roundTripButtonText;

    @FindBy(id = "roundtrip")
    public WebElement roundTripButton;

    @FindBy(css = "label[for='oneway']")
    public WebElement oneWayButtonText;

    @FindBy(id = "oneway")
    public WebElement oneWayButton;

    @FindBy(css = "label[for='award']")
    public WebElement bookWithMilesCheckBox;

    @FindBy(css = "label[for='flexibleDates']")
    public WebElement flexibleDatesCheckBox;

    @FindBy(id = "bookFlightDestinationInput")
    public WebElement cityInputBox;

    @FindBy(id = "DepartDate")
    public WebElement dateInputBox;

    @FindBy(css = "#cabinType div")
    public WebElement cabinDropdown;

    @FindBy(css = "ul[role='listbox']>li")
    public List<WebElement> cabinDropdowns;

    @FindBy(css = "button[class*='app-components-BookFlightForm-bookFlightForm__findFlightBtn--']")
    public WebElement findFlightsButton;

    @FindBy(css = "button[class*='app-containers-BookCalendar-bookCalendar__next']")
    public WebElement dateSelectorTableButton;

    @FindBy(css = "td[aria-label='Monday, January 30, 2023']")
    public WebElement jan30;


    @FindBy(id = "passengerSelector")
    public WebElement passengerSelector;

    @FindBy(css = "button[aria-label='Substract one Adult']")
    public WebElement increaseAdultNumber;

    @FindBy(css = "div[class='app-components-PassengerSelector-passengers__passengerMenu__controls--1-kWM'] use")
    public WebElement closePanel;
}