package com.sample;

public class MyService {

    private ExternalAPI api;

    public MyService(ExternalAPI api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }
}
