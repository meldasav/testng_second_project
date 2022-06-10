package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class UnitedAirlinesTest extends Base {

    @Test(priority = 1, description = "TESTCASE 1: Validate Main menu navigation items")
    public void testUnitedAirlinesMainMenu() {
        driver.get("https://www.united.com/en/us");
        String[] expectedText = {"BOOK", "MY TRIPS", "TRAVEL INFO", "MILEAGEPLUS® PROGRAM", "DEALS", "HELP"};
        for (int i = 0; i < unitedAirlinesHomePage.navigationItems.size(); i++) {
            Assert.assertTrue(unitedAirlinesHomePage.navigationItems.get(i).isDisplayed());
            Assert.assertEquals(unitedAirlinesHomePage.navigationItems.get(i).getText(), expectedText[i]);
        }
    }

    @Test(priority = 2, description = "TESTCASE 2:Validate \"Book travel menu\" navigation items")
    public void testBookTravelMenu() {
        driver.get("https://www.united.com/en/us");
        String[] expectedText = {"Book", "Flight status", "Check-in", "My trips"};
        for (int i = 0; i < unitedAirlinesHomePage.bookTravelMenus.size(); i++) {
            Assert.assertTrue(unitedAirlinesHomePage.bookTravelMenus.get(i).isDisplayed());
            Assert.assertEquals(unitedAirlinesHomePage.bookTravelMenus.get(i).getText(), expectedText[i]);
        }
    }

    @Test(priority = 3, description = "TESTCASE 3 : Round-trip\" and \"One-way\" radio buttons")
    public void testRadioButtons() {
        driver.get("https://www.united.com/en/us");
        Assert.assertTrue(unitedAirlinesHomePage.roundTripButtonText.isDisplayed());
        Assert.assertEquals(unitedAirlinesHomePage.roundTripButtonText.getText(), "Roundtrip");
        Assert.assertTrue(unitedAirlinesHomePage.roundTripButton.isEnabled());

        Assert.assertTrue(unitedAirlinesHomePage.oneWayButtonText.isDisplayed());
        Assert.assertEquals(unitedAirlinesHomePage.oneWayButtonText.getText(), "One-way");
        Assert.assertTrue(unitedAirlinesHomePage.oneWayButton.isEnabled());

        Assert.assertTrue(unitedAirlinesHomePage.roundTripButton.isSelected());
        Assert.assertFalse(unitedAirlinesHomePage.oneWayButton.isSelected());
    }

    @Test(priority = 4, description = "TestCase 4 :Book with miles\" and \"Flexible dates\" checkboxes")
    public void testBookWithMilesAndFlexibleDates() {
        driver.get("https://www.united.com/en/us");
        Assert.assertTrue(unitedAirlinesHomePage.bookWithMilesCheckBox.isDisplayed());
        Assert.assertTrue(unitedAirlinesHomePage.bookWithMilesCheckBox.isEnabled());
        Assert.assertFalse(unitedAirlinesHomePage.bookWithMilesCheckBox.isSelected());

        Assert.assertTrue(unitedAirlinesHomePage.flexibleDatesCheckBox.isDisplayed());
        Assert.assertTrue(unitedAirlinesHomePage.flexibleDatesCheckBox.isEnabled());
        Assert.assertFalse(unitedAirlinesHomePage.flexibleDatesCheckBox.isSelected());

        unitedAirlinesHomePage.bookWithMilesCheckBox.click();
        unitedAirlinesHomePage.flexibleDatesCheckBox.click();
        unitedAirlinesHomePage.bookWithMilesCheckBox.click();
        unitedAirlinesHomePage.flexibleDatesCheckBox.click();

        Assert.assertFalse(unitedAirlinesHomePage.bookWithMilesCheckBox.isSelected());
        Assert.assertFalse(unitedAirlinesHomePage.flexibleDatesCheckBox.isSelected());
    }

    @Test(priority = 5, description = "Test Case 5: Validate One-way ticket search results \"from Chicago, IL, US (ORD) to Miami, FL, US (MIA)")
    public void testOneWayTicket() {
        driver.get("https://www.united.com/en/us");
        unitedAirlinesHomePage.oneWayButton.click();
        unitedAirlinesHomePage.cityInputBox.sendKeys("Miami, FL, US (MIA)");
        unitedAirlinesHomePage.dateInputBox.click();
        Waiter.pause(2);
        int click = 0;
        do {
            unitedAirlinesHomePage.dateSelectorTableButton.click();
            click++;
        } while (click < 5);

        unitedAirlinesHomePage.jan30.click();
        unitedAirlinesHomePage.passengerSelector.click();
        unitedAirlinesHomePage.increaseAdultNumber.click();

        unitedAirlinesHomePage.closePanel.click();
        unitedAirlinesHomePage.cabinDropdown.click();

        unitedAirlinesHomePage.cabinDropdowns.get(2).click();
        unitedAirlinesHomePage.findFlightsButton.click();
        Assert.assertEquals(departurePage.departureText.getText(), "Chicago, IL, US to Miami, FL, US");


    }
}
