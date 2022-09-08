package com.example.stockscreening.net;

import android.content.Context;

public class ComponentManager {
    private static HttpComponent sAppComponent;
    public static HttpComponent getAppComponent(Context context) {
        synchronized (ComponentManager.class) {
            if (sAppComponent == null) {
                sAppComponent = DaggerHttpComponent.builder().provideRetrofit(new ProvideRetrofit()).appModule(new AppModule(context.getApplicationContext())).build();
            }
        }
        return sAppComponent;
    }
}
