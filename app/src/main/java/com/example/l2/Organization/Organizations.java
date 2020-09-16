package com.example.l2.Organization;

import java.util.jar.Attributes;

public enum Organizations {
    Tiharb("Tiharb, 500 students"),
    Epam("Epam, 300 students"),
    Google("Google, 666 students"),
    GloruHL("GloruHL, 1488 students");

    private final String str;

    Organizations(String str) {
        this.str = str;
    }

    public String getOrg() {
        return str;
    }
}
