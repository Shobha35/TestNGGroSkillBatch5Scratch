package ConstantsData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConstantData {
	
	public static final String PROP_FILE_PATH="src/main/java/Global.properties";
	public static final String EXCEL_PATH="src/main/java/TestData/TestData4thApril.xlsx";
	public static final String FAILED_SCREENSHOT_PATH="target/FailedScreenShots/" +
			LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) +
			"_Test.png";

}



