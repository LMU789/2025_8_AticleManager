package org.example.controller;

import org.example.vo.Member;

public class Controller {

    private Member logindMember;

    public void doAction(String cmd, String actionMethodName) {
    }

    public boolean isLogined() {
        return logindMember != null;
    }
}
