/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proxyservice.controllers;

import com.proxyservice.controllers.models.TokenProxyRequest;
import com.proxyservice.controllers.models.TokenProxyResponse;
import com.proxyservice.handlers.HTTPHandler;
import java.io.IOException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Mostafa Kashif
 */
@Controller
public class TokenProxyController {
    
    @Autowired
    private HTTPHandler httpHandler;
    
    @PostMapping("/token")
    @ResponseBody
    public TokenProxyResponse retrieveToken(@RequestBody @Valid TokenProxyRequest tokenProxyRequest) throws IOException  {
        return httpHandler.retrieveKeyCloakToken(tokenProxyRequest);
    }
}
