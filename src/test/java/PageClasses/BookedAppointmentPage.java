package PageClasses;
//
//public class BookedAppointmentPage {
//
//}


import org.openqa.selenium.By;

public class BookedAppointmentPage {

    // Locator to find the History link in the sidebar menu
    public static By historyMenuLink() {
        return By.xpath("//a[text()='History']");
    }

    // Locator for the blocks containing each appointment
    public static By historyItems() {
        return By.cssSelector(".panel.panel-info");
    }

    // Locator for the comment text inside the history blocks
    public static By historyComments() {
        return By.id("comment");
    }
}