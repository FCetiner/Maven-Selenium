package day00_selenium_homework_documents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q04 {
    public static void main(String[] args) {
        //1. Bir class oluşturun: LocatorsIntro
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //       2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
        //        // a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");
        //        // b. Sign in butonuna basin
        driver.findElement(By.id("sign-in")).click();
        //        // c. email textbox,password textbox, and signin button elementlerini locate ediniz..
       WebElement emailTextBox= driver.findElement(By.id("session_email"));
       WebElement passwordTextBox=driver.findElement(By.id("session_password"));
       WebElement signInButonu=driver.findElement(By.name("commit"));
        //        // d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        //        // i. Username : testtechproed@gmail.com
        //        // ii.Password : Test1234!
            emailTextBox.sendKeys("testtechproed@gmail.com");
            passwordTextBox.sendKeys("Test1234!");
            signInButonu.click();
        //        // e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
                if(driver.findElement(By.xpath("//span[@class='navbar-text']")).isDisplayed()) {
                    System.out.println("Expected user Id Elementi testi PASS");
                } else{
                    System.out.println("Expected user Id Elementi testi FAILED");
                }
        //        // f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        WebElement addressYazisiWebElementi=driver.findElement(By.xpath("//a[@data-test='addresses']"));
        System.out.println(addressYazisiWebElementi.isDisplayed() ? "adress yazisi testi PASS" : "adress yazisi tesi FAILED");
        WebElement signOutYazisiWebElementi=driver.findElement(By.xpath("//a[@data-test='sign-out']"));
        //    //3. Sayfada kac tane link oldugunu bulun.
       List<WebElement>  sayfadakiLinkSayisi=driver.findElements(By.tagName("a"));
        System.out.println("Sayfadaki link sayisi : " + sayfadakiLinkSayisi.size());
        //    //4.Linklerin yazisini nasil yazdirabiliriz
        for (WebElement each: sayfadakiLinkSayisi) {
            System.out.println("Sayfadaki linklerin yazisi :"+each.getText()+"\n");
        }
        //    //5. driver i kapatin
        driver.close();
    }
}
