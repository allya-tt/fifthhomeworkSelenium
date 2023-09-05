import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class forFun {
    @Test
    public void aSimpleTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://ya.ru/");
        driver.quit();
    }

}
