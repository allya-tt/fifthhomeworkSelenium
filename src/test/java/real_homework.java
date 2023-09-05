import com.codeborne.selenide.commands.As;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class real_homework {
    private WebDriver driver;
    @BeforeEach
    public void setUp() {
        String browser = System.getProperty("browser");
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();}
    }
    @Test
    public void formTest() throws InterruptedException {
        String url = "https://demoqa.com/automation-practice-form";
        driver.get(url);
        driver.manage().window().maximize();
//        JavascriptExecutor executor = (JavascriptExecutor)driver;
//        executor.executeScript("document.body.style.zoom = '0.70'");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15), Duration.ofMillis(500));
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("[class='col-12 mt-4 col-md-6']")));
        WebElement inputFirstName = driver.findElement(By.id("firstName"));
        inputFirstName.sendKeys("Aleksandra");
        Thread.sleep(2000);
        WebElement inputLastName = driver.findElement(By.id("lastName"));
        inputLastName.sendKeys("Telesheva");
        Thread.sleep(2000);

        WebElement inputEmail = driver.findElement(By.id("userEmail"));
        inputEmail.sendKeys("rrr03@mail.ru");
        Thread.sleep(2000);

        WebElement radiobutton = driver.findElement(By.cssSelector("label[for='gender-radio-2']"));
        radiobutton.click();
        Thread.sleep(2000);
        Assertions.assertEquals("Female", radiobutton.getText());
        Thread.sleep(2000);

        WebElement inputNumber = driver.findElement(By.id("userNumber"));
        inputNumber.sendKeys("5555555555");
        Thread.sleep(2000);

        WebElement inputBirth = driver.findElement(By.id("dateOfBirthInput"));
        inputBirth.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("select[class='react-datepicker__month-select']")));

        WebElement selectDropdownMonth = driver.findElement(By.cssSelector("select[class='react-datepicker__month-select']"));
        Select selectMonth = new Select(selectDropdownMonth);
        selectMonth.selectByVisibleText("January");
        WebElement selectDropdownYear = driver.findElement(By.cssSelector("select[class='react-datepicker__year-select']"));
        Select selectYear = new Select(selectDropdownYear);
        selectYear.selectByVisibleText("2003");
        WebElement selectDay = driver.findElement(By.cssSelector("div[class=\"react-datepicker__month\"] > div:nth-child(2) > div:nth-child(4)"));
        selectDay.click();
        Thread.sleep(2000);

        WebElement inputSubjects = driver.findElement(By.id("subjectsInput"));
        inputSubjects.sendKeys("something");
        Thread.sleep(2000);

        WebElement checkbox1 = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
        checkbox1.click();
        Thread.sleep(2000);
        Assertions.assertEquals("Sports", checkbox1.getText());
        Thread.sleep(2000);

        WebElement checkbox2 = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-3']"));
        checkbox2.click();
        Thread.sleep(2000);
        Assertions.assertEquals("Music", checkbox2.getText());
        Thread.sleep(2000);

        WebElement uploadFile = driver.findElement(By.cssSelector("input[id='uploadPicture']"));
        uploadFile.sendKeys("C:\\Users\\hpsas\\Documents\\study\\_opuOWMKaA8.jpg");
        Thread.sleep(2000);

        WebElement inputAddress = driver.findElement(By.id("currentAddress"));
        wait.until(ExpectedConditions.elementToBeClickable(inputAddress));
        inputAddress.sendKeys("something");
        Thread.sleep(2000);

        WebElement frstDropdown = driver.findElement(By.cssSelector("#state"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", frstDropdown);
        frstDropdown.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("react-select-3-option-0")));
        driver.findElement(By.id("react-select-3-option-0")).click();
        Thread.sleep(2000);

        WebElement scndDropdown = driver.findElement(By.cssSelector("#city"));
        scndDropdown.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("react-select-4-option-0")));
        driver.findElement(By.id("react-select-4-option-0")).click();
        Thread.sleep(2000);


        WebElement button = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        Thread.sleep(2000);
        button.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("example-modal-sizes-title-lg")));
        Assertions.assertEquals("Aleksandra Telesheva", driver.findElement(By.cssSelector("div[class='table-responsive'] tbody > tr:first-child > td:nth-child(2)")).getText());
        Assertions.assertEquals("rrr03@mail.ru", driver.findElement(By.cssSelector("div[class='table-responsive'] tbody > tr:nth-child(2) > td:nth-child(2)")).getText());
        Assertions.assertEquals("Female", driver.findElement(By.cssSelector("div[class='table-responsive'] tbody > tr:nth-child(3) > td:last-child")).getText());
        Assertions.assertEquals("5555555555", driver.findElement(By.cssSelector("div[class='table-responsive'] tbody > tr:nth-child(4) > td:last-child")).getText());
        Assertions.assertEquals("08 January,2003", driver.findElement(By.cssSelector("div[class='table-responsive'] tbody > tr:nth-child(5) > td:last-child")).getText());
        Assertions.assertEquals("", driver.findElement(By.cssSelector("div[class='table-responsive'] tbody > tr:nth-child(6) > td:last-child")).getText());
        Assertions.assertEquals("Sports, Music", driver.findElement(By.cssSelector("div[class='table-responsive'] tbody > tr:nth-child(7) > td:last-child")).getText());
        Assertions.assertEquals("_opuOWMKaA8.jpg", driver.findElement(By.cssSelector("div[class='table-responsive'] tbody > tr:nth-child(8) > td:last-child")).getText());
        Assertions.assertEquals("something", driver.findElement(By.cssSelector("div[class='table-responsive'] tbody > tr:nth-child(9) > td:last-child")).getText());
        Assertions.assertEquals("NCR Delhi", driver.findElement(By.cssSelector("div[class='table-responsive'] tbody > tr:nth-child(10) > td:last-child")).getText());
        Thread.sleep(2000);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
