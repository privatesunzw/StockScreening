package com.example.stockscreening.net;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Context mContext;

    public  AppModule(Context context){
        this.mContext = context;
    }

    @Provides
    public Context provideContext(){
        return mContext;
    }

}
