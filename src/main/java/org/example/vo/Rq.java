package org.example.vo;

import java.util.HashMap;
import java.util.Map;

public class Rq {

    private String cmd;
    Map<String, String> params = new HashMap<>();
    private String actionMethod;

    public Rq(String cmd) {
        this.cmd = cmd;

        String[] cmdBits = cmd.split("\\?");

        if(cmdBits.length < 2) {
            return;
        }

        actionMethod = cmdBits[0];
        String[] paramBits;
        paramBits = cmdBits[1].split("=");
        if(paramBits.length < 2) {
            return;
        }

        String key = paramBits[0];
        String value = paramBits[1];
        params.put(key, value);

    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public String getActionMethod() {
        return actionMethod;
    }

    public void setActionMethod(String actionMethod) {
        this.actionMethod = actionMethod;
    }
}
