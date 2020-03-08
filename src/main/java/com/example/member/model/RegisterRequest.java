package com.example.member.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class RegisterRequest {
    @NotNull
    @Valid
    private Member member;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
