package com.example.injection.component;

import com.example.injection.module.FragmentModule;
import com.example.injection.module.ServicesModule;
import com.example.main.activity.StackRXActivity;
import com.example.main.fragment.StackRXBaseFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * The application base dependency injection graph component interface
 *
 * @see {http://google.github.io/dagger/api/latest/dagger/Component.html}
 */
@Singleton
@Component(modules = {ServicesModule.class, FragmentModule.class})
public interface ApplicationComponent {

    void inject(StackRXActivity activity);

    void inject(StackRXBaseFragment fragment);

}
