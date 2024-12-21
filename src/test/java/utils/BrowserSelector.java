package utils;


import java.io.IOException;

public class BrowserSelector {

    public static String getDefaultBrowser() {
        try {
            // Check if Edge is available
            Process edgeProcess = Runtime.getRuntime().exec("where msedge"); // Windows-specific
            if (edgeProcess.waitFor() == 0) {
                System.out.println("Microsoft Edge is available.");
                return "edge";
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Microsoft Edge is not available.");
        }

        // Fallback to Chrome if Edge is not found
        System.out.println("Falling back to Google Chrome.");
        return "chrome";
    }
}
