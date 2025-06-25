
package Business_logic;

import com.tyss.optimize.common.util.*;
import com.tyss.optimize.nlp.util.*;
import com.tyss.optimize.nlp.util.annotation.*;
import java.util.*;

import org.openqa.selenium.PageLoadStrategy;

public class PageLoader implements Nlp {
    @InputParams({@InputParam(name = "pageLoader", type = "org.openqa.selenium.chrome.ChromeOptions")})
    

      public NlpResponseModel execute(NlpRequestModel nlpRequestModel) throws NlpException {

          Map<String, Object> programElementsInput = nlpRequestModel.getAttributes();
          org.openqa.selenium.chrome.ChromeOptions pageLoader = (org.openqa.selenium.chrome.ChromeOptions) programElementsInput.get("pageLoader");
          NlpResponseModel nlpResponseModel = new NlpResponseModel();
          try {
        	  pageLoader.setPageLoadStrategy(PageLoadStrategy.EAGER);
              // Your program element business logic starts here ...
              nlpResponseModel.setStatus(CommonConstants.pass);
          }
          catch(Exception e) {
          	 // Your program element Exception handling goes here ...
             nlpResponseModel.setStatus(CommonConstants.fail);

          }

          // Your program element business logic ends here ...
          return nlpResponseModel;
      }

  } 