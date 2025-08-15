package com.gyabisito.springcore.propertyplaceholder;

public class MyDAO {
    private String server;

    MyDAO(String server) {
        this.server = server;
    }

    @Override
    public String toString() {
        return "MyDAO{" +
                "server='" + server + '\'' +
                '}';
    }
}
