package TestClasses;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageClasses.CreateNewAppointmentPage;
import PageClasses.HistoryPage;
import PageClasses.LoginPage;
import Utilities.BaseClass;
import Utilities.ListenersImplementation;

@Listeners(ListenersImplementation.class)
public class BookedAppointmentTest extends BaseClass {

    @Test(groups = "sanity")
//    public void verifyAppointmentHistory() throws IOException, InterruptedException {
//        // 1. Login
//        LoginTest.executeLogin();
//        
//        String comment1 = "First Appointment - Dental Checkup";
//        String comment2 = "Second Appointment - General Physician";
//
//        // 2. Create First Appointment
//        bookSingleAppt("25/05/2026", comment1);
//        driver.findElement(CreateNewAppointmentPage.btnGoToHomepage()).click();
//
//        // 3. Create Second Appointment
//        bookSingleAppt("30/05/2026", comment2);
//
//        // 4. Go to History
//        driver.findElement(LoginPage.hamburgerMenu()).click();
//        driver.findElement(HistoryPage.historyMenuLink()).click();
////        Thread.sleep(3000);
//
//        // 5. Count the number of booked appointments
//        List<WebElement> appointments = driver.findElements(HistoryPage.historyItems());
//        int count = appointments.size();
//        System.out.println("Total appointments found in history: " + count);
//        Reporter.log("Total appointments found in history: " + count);
//        
//        Assert.assertEquals(count, 2, "Appointment count does not match!");
//
//        // 6. Verify comments
//        boolean found1 = false;
//        boolean found2 = false;
//
//        List<WebElement> commentsInHistory = driver.findElements(HistoryPage.historyComments());
//        for (WebElement element : commentsInHistory) {
//            String actualText = element.getText();
//            System.out.println("Found comment in History: " + actualText); 
//
//            if (actualText.equals(comment1)) found1 = true;
//            if (actualText.equals(comment2)) found2 = true;
//            
//            if (actualText.equals(comment1)) {
//                found1 = true;
//                System.out.println("Verification Passed for Comment 1");
//            }
//            if (actualText.equals(comment2)) {
//                found2 = true;
//                System.out.println("Verification Passed for Comment 2");
//            }
//        }
//
//        Assert.assertTrue(found1, "Comment 1 not found in history!");
//        Assert.assertTrue(found2, "Comment 2 not found in history!");
//        System.out.println("Final Status: All comments verified successfully.");
//        Reporter.log("Comments verified successfully in History Page");
//    }
    
    public void verifyAppointmentHistory() throws IOException, InterruptedException {
        // 1. Login
        LoginTest.executeLogin();
        
        String comment1 = "First Appointment - Dental Checkup";
        String comment2 = "Second Appointment - General Physician";

        // 2. Create First Appointment
        bookSingleAppt("25/05/2026", comment1);
        driver.findElement(CreateNewAppointmentPage.btnGoToHomepage()).click();

        // 3. Create Second Appointment
        bookSingleAppt("30/05/2026", comment2);

        // 4. Go to History
        Thread.sleep(3000); 
        driver.findElement(LoginPage.hamburgerMenu()).click();
        driver.findElement(HistoryPage.historyMenuLink()).click();
        
        // CHANGE 1: You MUST keep this sleep. The History page takes time to load the data from the database.
        Thread.sleep(3000); 

        // 5. Count the number of booked appointments
        // CHANGE 2: Re-find the elements here to make sure they are fresh after the page load
        int count = driver.findElements(HistoryPage.historyItems()).size();
        System.out.println("Total appointments found in history: " + count);
        Reporter.log("Total appointments found in history: " + count);
        
        Assert.assertEquals(count, 2, "Appointment count does not match!");

        // 6. Verify comments
        boolean found1 = false;
        boolean found2 = false;

        // CHANGE 3: Instead of a "for-each" loop, use a standard for-loop.
        // We re-find the list inside the loop to prevent the "Stale" error.
        int totalComments = driver.findElements(HistoryPage.historyComments()).size();
        
        for (int i = 0; i < totalComments; i++) {
            // This line re-finds the element every time, so it's never stale
            String actualText = driver.findElements(HistoryPage.historyComments()).get(i).getText();
            System.out.println("Found comment in History: " + actualText); 

            if (actualText.equals(comment1)) {
                found1 = true;
                System.out.println("Verification Passed for Comment 1");
            }
            if (actualText.equals(comment2)) {
                found2 = true;
                System.out.println("Verification Passed for Comment 2");
            }
        }

        Assert.assertTrue(found1, "Comment 1 not found in history!");
        Assert.assertTrue(found2, "Comment 2 not found in history!");
        System.out.println("Final Status: All comments verified successfully.");
        Reporter.log("Comments verified successfully in History Page");
    }

    private void bookSingleAppt(String date, String comment) {
        WebElement facility = driver.findElement(CreateNewAppointmentPage.facilityName());
        new Select(facility).selectByIndex(1);
        driver.findElement(CreateNewAppointmentPage.apptDate()).sendKeys(date);
        driver.findElement(CreateNewAppointmentPage.apptDetails()).sendKeys(comment);
        driver.findElement(CreateNewAppointmentPage.btnAppointment()).click();
        
        Reporter.log("Appointment booked for date: " + date);
    }
}
