package utils;

import java.io.IOException;

public class BrowserSelector {

    public static String getDefaultBrowser() {
        String browser = checkForBrowser("msedge", "where /r \"C:\\Program Files (x86)\" msedge.exe"); // Check for Microsoft Edge
        if (browser != null) {
            System.out.println("Microsoft Edge is available.");
            return browser;
        }

        browser = checkForBrowser("chrome", "where /r \"C:\\Program Files\" chrome.exe"); // Fallback to Chrome
        if (browser != null) {
            System.out.println("Google Chrome is available.");
            return browser;
        }

        System.out.println("No supported browser found.");
        return null;
    }



    private static String checkForBrowser(String browserName, String command) {
        try {
            String[] commandParts = command.split(" ");
            ProcessBuilder processBuilder = new ProcessBuilder(commandParts);

            processBuilder.redirectErrorStream(true);

            Process process = processBuilder.start();

            if (process.waitFor() == 0) {
                System.out.printf("%s is available.%n", browserName);
                return browserName;
            } else {
                System.out.printf("%s is not available. Command exited with non-zero status.%n", browserName);
            }
        } catch (IOException | InterruptedException e) {
            System.err.printf("Error checking for %s: %s%n", browserName, e.getMessage());
        }
        return null;
    }


    public static void main(String[] args) {
        String defaultBrowser = getDefaultBrowser();
        if (defaultBrowser != null) {
            System.out.printf("Default browser selected: %s%n", defaultBrowser);
        } else {
            System.out.println("No default browser found. Please install one.");
        }
    }
}