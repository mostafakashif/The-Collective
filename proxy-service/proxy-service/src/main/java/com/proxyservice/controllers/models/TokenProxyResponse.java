/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proxyservice.controllers.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Mostafa Kashif
 */
@Getter
@Setter
public class TokenProxyResponse {
    
    private String access_token;
    
    private Integer expires_in;
    
    private Integer refresh_expires_in;
    
    private String refresh_token;
    
    private String token_type;
    
    @JsonProperty("not-before-policy")
    private Integer not_before_policy;
    
    private String session_state;
    
    private String scope;
}


