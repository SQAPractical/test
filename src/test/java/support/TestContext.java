// Created by Viacheslav (Slava) Skryabin 04/01/2018
package support;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class TestContext {

    private static WebDriver driver;

    public static WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), 10);
    }

    public static WebDriverWait getWait(int timeout) {
        return new WebDriverWait(getDriver(), timeout);
    }

    public static HashMap<String, String> getSender() throws FileNotFoundException {
        String path = System.getProperty("user.dir") + "/src/test/resources/data/sender.yml";
        File file = new File(path);
        FileInputStream stream  = new FileInputStream(file);
        Yaml yaml = new Yaml();
        return yaml.load(stream);

    }

    public static JavascriptExecutor getExecutor() {
        return (JavascriptExecutor) driver;
    }

    public static void initialize() {
        setDriver("chrome");
    }

    public static void close() {
        closeDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(String browser) {
        driver = initializeDriver(browser);
    }

    private static WebDriver initializeDriver(String browser) {
        try {
            WebDriver driver;
            boolean headless = false;
            String osName = System.getProperty("os.name");
            switch (browser) {
                case "chrome":
                    String chromeDriverName = "chromedriver.exe";
                    if (osName != null && (osName.contains("Mac") || osName.contains("Linux"))) {
                        chromeDriverName = "chromedriver";
                    }
                    System.setProperty("webdriver.chrome.driver", getDriversDirPath() + chromeDriverName);
                    Map<String, Object> chromePreferences = new HashMap<>();
                    chromePreferences.put("profile.default_content_settings.geolocation", 2);
                    chromePreferences.put("download.prompt_for_download", false);
                    chromePreferences.put("download.directory_upgrade", true);
                    chromePreferences.put("download.default_directory", getDownloadsPath());
                    chromePreferences.put("credentials_enable_service", false);
                    chromePreferences.put("password_manager_enabled", false);
                    chromePreferences.put("safebrowsing.enabled", "true");
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    chromeOptions.setExperimentalOption("prefs", chromePreferences);
                    if (headless) {
                        chromeOptions.setHeadless(true);
                        chromeOptions.addArguments("--window-size=1920,1080");
                        chromeOptions.addArguments("--disable-gpu");
                    }
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    String geckoDriverName = "geckodriver.exe";
                    if (osName != null && (osName.contains("Mac") || osName.contains("Linux"))) {
                        geckoDriverName = "geckodriver";
                    }
                    System.setProperty("webdriver.gecko.driver", getDriversDirPath() + geckoDriverName);
                    System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
                    System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
                    FirefoxProfile firefoxProfile = new FirefoxProfile();
                    firefoxProfile.setPreference("xpinstall.signatures.required", false);
                    firefoxProfile.setPreference("app.update.enabled", false);
                    firefoxProfile.setPreference("browser.download.folderList", 2);
                    firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
                    firefoxProfile.setPreference("browser.download.dir", getDownloadsPath());
                    firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/zip;application/octet-stream;application/x-zip;application/x-zip-compressed;text/css;text/html;text/plain;text/xml;text/comma-separated-values");
                    firefoxProfile.setPreference("browser.helperApps.neverAsk.openFile", "application/zip;application/octet-stream;application/x-zip;application/x-zip-compressed;text/css;text/html;text/plain;text/xml;text/comma-separated-values");
                    firefoxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
                    firefoxProfile.setPreference("plugin.disable_full_page_plugiâ€Œâ€‹n_for_types", "application/pdf,application/vnd.adobe.xfdf,application/vnd.â€Œâ€‹fdf,application/vnd.â€Œâ€‹adobe.xdp+xml");
                    firefoxProfile.setPreference("webdriver.log.driver", "OFF");
                    FirefoxOptions firefoxOptions = new FirefoxOptions().setProfile(firefoxProfile).setLogLevel(FirefoxDriverLogLevel.INFO);
                    if (Boolean.valueOf(headless)) {
                        FirefoxBinary firefoxBinary = new FirefoxBinary();
                        firefoxBinary.addCommandLineOptions("--headless");
                        firefoxOptions.setBinary(firefoxBinary);
                    }
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                case "edge":
                    System.setProperty("webdriver.edge.driver", getDriversDirPath() + "MicrosoftWebDriver.exe");
                    driver = new EdgeDriver();
                    break;
                case "ie":
                    System.setProperty("webdriver.ie.driver", getDriversDirPath() + "IEDriverServer.exe");
                    DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
                    ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                    ieCapabilities.setCapability("requireWindowFocus", true);
                    InternetExplorerOptions ieOptions = new InternetExplorerOptions(ieCapabilities);
                    driver = new InternetExplorerDriver(ieOptions);
                    break;
                case "htmlunit":
                    driver = new HtmlUnitDriver();
                    break;
                default:
                    throw new RuntimeException("Driver is not implemented for: " + browser);
            }
            return driver;
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }

    private static void closeDriver() {
        driver.quit();
    }

    private static String getDriversDirPath() {
        return System.getProperty("user.dir") + String.format("%1$ssrc%1$stest%1$sresources%1$sdrivers%1$s", File.separator);
    }

    private static String getDownloadsPath() {
        return System.getProperty("user.dir") + String.format("%1$ssrc%1$stest%1$sresources%1$sdownloads%1$s", File.separator);
    }

}