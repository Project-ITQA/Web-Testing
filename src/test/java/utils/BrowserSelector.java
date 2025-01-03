package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BrowserSelector {

    public static String getDefaultBrowser() {
        String browser = checkForBrowser("Microsoft Edge", "where /r \"C:\\Program Files (x86)\" msedge.exe");
        if (browser != null) return browser;

        browser = checkForBrowser("Google Chrome (64-bit)", "where /r \"C:\\Program Files\" chrome.exe");
        if (browser != null) return browser;

        System.out.println("No supported browser found.");
        return null;
    }

    private static String checkForBrowser(String browserName, String command) {
        try {
            String[] commandParts = command.split(" ");
            ProcessBuilder processBuilder = new ProcessBuilder(commandParts);
            processBuilder.redirectErrorStream(true);

            Process process = processBuilder.start();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                StringBuilder output = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line).append(System.lineSeparator());
                }

                if (process.waitFor() == 0 && !output.toString().isBlank()) {
                    System.out.printf("%s is available. Command output: %s%n", browserName, output.toString().trim());
                    return browserName;
                } else {
                    System.out.printf("%s is not available. Command exited with non-zero status.%n", browserName);
                }
            }
        } catch (IOException e) {
            System.err.printf("IOException while checking for %s: %s%n", browserName, e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.printf("Interrupted while checking for %s: %s%n", browserName, e.getMessage());
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
