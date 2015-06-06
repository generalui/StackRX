package com.example.injection;

import android.app.Application;

import com.example.main.user.UserSession;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import example.com.stackrx.services.base.ServiceEnvironment;
import example.com.stackrx.services.questions.dao.QuestionsDAO;

@Module
public class ServicesModule {

    private final Application application;

    public ServicesModule(Application application) {
        this.application = application;
    }

    @Provides
    Application provideApplication(){
        return application;
    }

    @Provides
    ServiceEnvironment provideServiceEnvironment() {
        return new ServiceEnvironment();
    }

    @Provides
    @Singleton
    QuestionsDAO provideQuestionsDAO(ServiceEnvironment serviceEnvironment) {
        return new QuestionsDAO(serviceEnvironment);
    }

    @Provides
    @Singleton
    UserSession provideUserSession() {
        return new UserSession();
    }

}