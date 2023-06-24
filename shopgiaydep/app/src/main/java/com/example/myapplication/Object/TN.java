package com.example.myapplication.Object;

import java.io.Serializable;

public class TN implements Serializable {
    private Boolean iskhach;
    private String tinnhan;
    public TN(Boolean iskhach, String tinnhan) {
        this.iskhach = iskhach;
        this.tinnhan = tinnhan;
    }
    public Boolean getIskhach() {
        return iskhach;
    }

    public void setIskhach(Boolean iskhach) {
        this.iskhach = iskhach;
    }

    public String getTinnhan() {
        return tinnhan;
    }

    public void setTinnhan(String tinnhan) {
        this.tinnhan = tinnhan;
    }
}
