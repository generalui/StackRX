package com.example.main.application;

import android.app.Application;

import com.example.injection.component.ApplicationComponent;
import com.example.injection.component.DaggerApplicationComponent;
import com.example.injection.module.FragmentModule;
import com.example.injection.module.ServicesModule;

public class StackRXApp extends Application {

    //region INJECTED CLASSES ----------------------------------------------------------------------
    //endregion


    //region INJECTED VIEWS ------------------------------------------------------------------------
    //endregion


    //region LOCAL CONSTANTS -----------------------------------------------------------------------

    private static StackRXApp APP;

    //endregion


    //region FIELDS --------------------------------------------------------------------------------

    private ApplicationComponent mApplicationComponent = null;

    //endregion


    //region CONSTRUCTOR ---------------------------------------------------------------------------
    //endregion


    //region LIFE CYCLE METHODS --------------------------------------------------------------------

    @Override
    public void onCreate() {
        super.onCreate();
        APP = this;
        buildComponentAndInject();
    }

    //endregion


    //region WIDGET --------------------------------------------------------------------------------
    //endregion


    //region LISTENERS -----------------------------------------------------------------------------
    //endregion


    //region EVENTS --------------------------------------------------------------------------------
    //endregion


    //region LOCAL METHODS -------------------------------------------------------------------------

    /**
     * Create the default dependency injection component.
     */
    public void buildComponentAndInject() {
        if (mApplicationComponent == null) {
            setComponent(DaggerApplicationComponent.builder()
                    .servicesModule(new ServicesModule(APP))
                    .fragmentModule(new FragmentModule())
                    .build());
        }
    }

    //endregion


    //region SUBSCRIBERS ---------------------------------------------------------------------------
    //endregion


    //region ACCESSORS -----------------------------------------------------------------------------

    /**
     * Set the application dependency injection implementation.
     *
     * @param component the application component to set
     * @see {http://google.github.io/dagger/api/latest/dagger/Component.html}
     */
    public void setComponent(ApplicationComponent component) {
        mApplicationComponent = component;
    }

    //endregion


    //region INNER CLASSES -------------------------------------------------------------------------
    //endregion


    //region CLASS METHODS -------------------------------------------------------------------------

    /**
     * Get the application dependency injection implementation.
     *
     * @return the application component
     */
    public static ApplicationComponent component() {
        return APP.mApplicationComponent;
    }

    //endregion

}
