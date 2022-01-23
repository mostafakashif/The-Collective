/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proxyservice.controllers.models;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Mostafa Kashif
 */
@Getter
@Setter
public class TokenProxyRequest {

    @NotNull
    private String grant_type;
    @NotNull
    private String client_id;
    @NotNull
    private String username;
    @NotNull
    private String password;
}
