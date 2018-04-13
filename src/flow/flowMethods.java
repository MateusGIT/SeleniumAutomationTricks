/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Mateus Oliveira
 */
//public class flowMethods {
//   - - - - - - - - -- - - -- - - -- - DEFINE FILEPATH FOR DOWNLOADS - - -- - - - - - -- -  


//        String downloadFilepath = "C:/Users/fernandabelay/Downloads/";
//        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
//        chromePrefs.put("profile.default_content_settings.popups", 0);
//        chromePrefs.put("download.default_directory", downloadFilepath);
//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("prefs", chromePrefs);
//        DesiredCapabilities cap = DesiredCapabilities.chrome();
//        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//        cap.setCapability(ChromeOptions.CAPABILITY, options);


//   -- - - -- - -- - - -- - - -- - -- -  AUTOMATING DOWNLOAD OF FLASH PLAYER - -- - - - -- - - - 


//       System.setProperty("webdriver.chrome.driver", "ChromeWebDriver/chromedriver.exe");
//        Map<String, Object> prefs = new HashMap<>(); //changing prefs of google chrome
//
//        prefs.put(
//                "profile.default_content_setting_values.plugins", 1); //enabling plugins
//        prefs.put(
//                "profile.content_settings.plugin_whitelist.adobe-flash-player", 1); //enabling flash
//        prefs.put(
//                "profile.content_settings.exceptions.plugins.*,*.per_resource.adobe-flash-player", 1); //enlabed
//        // Enable Flash for this site
//        prefs.put(
//                "PluginsAllowedForUrls", "WEBSITE"); //whitelist
//
// - - -  --- - -- - - - - -- - -- --  DISABLE PDF DOWNLOADER - - -- - -- -- -- - - -- -


//        options.setExperimentalOption("prefs", prefs); //seta preferências
//
//        this.driver = new ChromeDriver(options); //instancia driver com opçoes escolhidas


//    -- -- - - - -- - - -- - - -- - - --- SINTAXES EXAMPLES --- - - - -- - - - -- -


//    driver = new ChromeDriver(); // create a instance of a driver (open a browser) 
//    driver.get ("string") // acess a link
//    driver.findElement(By.xpath("//input[contains(@value, 'String')]")).click(); //acess by xpath input value
//    driver.findElement(By.xpath("//a[contains(@href, 'Link based on dom')]")); //acess a link by xpath
//    driver.findElement(By.xpath("//*[contains(text(), 'String')]")); //acess by a partial text on the page  
//    driver.findElement(By.xpath("//*[@id=\"tabela_login\"]/tbody/tr[2]/td[1]/div/table/tbody/tr[2]/td[2]/obrigatorio/input")); //example for acessing specif element at dom and then finding the element
//      driver.findElement(By.xpath("//*[contains(@id, 'DIV_DAGRHISTORY_')]/table/tbody/tr[2]/td/table/tbody/tr[last()]")); //selecting last tr from tbody
//                login_email.sendKeys(Keys.CONTROL + "v"); sending a key by selenium
// if (tipopgto.findElement(By.xpath("//*[contains(text(), '')]")).isEnabled()) { } // if for doing an action only if finds determinated element

//                              ---- - - -- - - --- DROP DOWN - - - - - -- --  --- 

//     Select arquivo = new Select(driver.findElement(By.id("ID"))); // select is the class for drop down menus
//            arquivo.selectByVisibleText("TXT");
//                    dropdown.selectByIndex(2); //selecting by index

//    - - - - -- - -- - -- - -- - - -- - -- - - JAVASCRIPT - -- - - -- - - - 

//                 JavascriptExecutor motorJs = (JavascriptExecutor) driver;
//      motorJs.executeScript(string.split(":")[1]);  // executing scripts that are named by  (example - >) javascript:1203120301230 
//            motorJs.executeScript("window.scrollTo(0, document.body.scrollHeight)"); // go to the end of the page

//    -- - - - -- - - - -- - -- -- - - -- - -- - - GETTING ATRIBUTE - - -- -- - 

//    List<String> msgs = new ArrayList<>();
//      List<WebElement> mensagens = driver.findElements(By.xpath("//a[contains(@href, 'EXAMPLE')]"));
//            for (WebElement msg : mensagens) {
//                msgs.add(msg.getAttribute("href"));
//}
//-- - - - -- - - - - -- - - -- - - -- - - -- - - CHANGE WINDOW BY LINKTEXT -- -- - - -- - - -- - -

//    public void ChangeWindow(String partialLinkText) {
//        Set<String> janelas = driver.getWindowHandles();//retorna codigo das paginas
//        List<String> windows = new ArrayList<>(); //cria lista String
//        windows.addAll(janelas); //add na lista
//        for (String s : windows) {
//            System.out.println(s);
//            if (driver.switchTo().window(s).getCurrentUrl().contains("partialLinkText")) { //troca pra janela certa
//                break;
//            }
//        }
//    }
// - - - -- - - -- - -- - - -- - -- - - -- - - ACESSING TDS OR TRS - -- - -- - - -- -- 

//            List<WebElement> trs = driver.findElements(By.tagName("tr"));
//            for (WebElement tr : trs) {
//                List<WebElement> tds = tr.findElements(By.tagName("td"));
//                for (WebElement td : tds) {
//                    }
//}
//- - - -- - - - -- - - -- - -- - -- - -- - - SIKULI - -- - - - -- -

//                            sikuli.click("images/save.PNG");
//                            sikuli.type(Key.TAB);
// - - - - -- - -- - - -- -- - EXECUTING A TREATMENT ACTION BASED ON CATCHED EXCEPTION -- - - - 

//try { } catch (Exception e) {
//                if ((e.getClass().getSimpleName()).equals("STRING")) {
//
//                }
