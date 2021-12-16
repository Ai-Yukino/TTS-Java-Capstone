package com.tts1;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UserCheckController {

    // https://dzone.com/articles/how-to-get-current-logged-in-username-in-spring-se
    // Paragraph: Alternatively, you can also ask for the Authentication object instead of a Principal object, as shown below:
    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Authentication authentication) {
        return authentication.getName();
    }
}