package Business_logic;

import com.tyss.optimize.common.util.*;
import com.tyss.optimize.nlp.util.*;
import com.tyss.optimize.nlp.util.annotation.*;
import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Openbrowsermobileview implements Nlp {
    @InputParams({@InputParam(name = "url", type = "java.lang.String"), @InputParam(name = "Device name", type = "java.lang.String")})
    //@ReturnType(name = "Sum of Two numbers", type = "java.lang.Integer")

      public NlpResponseModel execute(NlpRequestModel nlpRequestModel) throws NlpException {

          Map<String, Object> programElementsInput = nlpRequestModel.getAttributes();
          String url1 = (String) programElementsInput.get("url");
          String Devicename = (String) programElementsInput.get("Device name");
        //  Integer returnValue=null;

          NlpResponseModel nlpResponseModel = new NlpResponseModel();
          try {
              // Your program element business logic starts here ...
        	  Map<String, String> mobileEmulation = new HashMap<>();
              mobileEmulation.put("deviceName", Devicename);

              ChromeOptions options = new ChromeOptions();
              options.setExperimentalOption("mobileEmulation", mobileEmulation);

              WebDriver driver1 = new ChromeDriver(options);
              driver1.manage().window().maximize();
              driver1.get(url1);
              nlpResponseModel.setWebDriver(driver1);
              nlpResponseModel.setMessage("successfully launched " +Devicename+ "in browser");
              nlpResponseModel.setStatus(CommonConstants.pass);
          }
          catch(Exception e) {
        	  nlpResponseModel.setMessage("Failed to launch " +Devicename+ "in browser" + e);
             nlpResponseModel.setStatus(CommonConstants.fail);
          }
          return nlpResponseModel;
      }

  } 
