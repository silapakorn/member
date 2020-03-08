package com.example.member.model;

import javax.validation.constraints.NotNull;

public class InfoRequest {
    @NotNull
    private String jwttoken;

    public String getJwttoken() {
        return jwttoken;
    }

    public void setJwttoken(String jwttoken) {
        this.jwttoken = jwttoken;
    }
}
