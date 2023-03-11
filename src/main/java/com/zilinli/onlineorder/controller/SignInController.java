//**********************************************************************************************************************
// * Documentation
// * Author: zilin.li
// * Date: 12/22
// * Definition: Implementation of SignInController class.
//**********************************************************************************************************************

package com.zilinli.onlineorder.controller;
//**********************************************************************************************************************
// * Includes
//**********************************************************************************************************************


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//**********************************************************************************************************************
// * Class definition
//**********************************************************************************************************************
@Controller
public class SignInController {

//**********************************************************************************************************************
// * Class constructors
//**********************************************************************************************************************

//**********************************************************************************************************************
// * Public methods
//**********************************************************************************************************************
    @RequestMapping(value="/login")
    public void login(@RequestParam(value = "error") String error, HttpServletResponse response) throws IOException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        Map<String, Object> data = new HashMap<>();
        data.put("message", "bad credentials");
        response.getOutputStream().println(objectMapper.writeValueAsString(data));
    }

//**********************************************************************************************************************
// * Protected methods
//**********************************************************************************************************************

//**********************************************************************************************************************
// * Private methods
//**********************************************************************************************************************

//**********************************************************************************************************************
// * Private attributes
//**********************************************************************************************************************

    private final ObjectMapper objectMapper = new ObjectMapper();
}
