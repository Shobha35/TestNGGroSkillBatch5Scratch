package PageClasses;

import org.openqa.selenium.By;

public class HistoryPage {
    
    public static By historyMenuLink() {
        return By.xpath("//a[text()='History']");
    }
    
    public static By historyItems() {
        return By.cssSelector(".panel.panel-info");
    }
    
    public static By historyComments() {
        return By.id("comment");
    }
}
