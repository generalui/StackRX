package com.example.questions.fragment;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.test.ActivityInstrumentationTestCase2;

import com.example.injection.component.ApplicationComponent;
import com.example.main.activity.InitialFragment;
import com.example.main.activity.StackRXActivity;
import com.example.main.application.StackRXApp;
import com.example.main.fragment.QuestionsFragment;
import com.example.main.fragment.StackRXBaseFragment;
import com.example.stackrx.R;
import com.example.stackrx.services.questions.model.Questions;
import com.example.stackrx.services.questions.service.StackExchangeService;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;
import rx.Observable;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

public class QuestionsFragmentTest extends ActivityInstrumentationTestCase2<StackRXActivity> {

    private QuestionsFragmentTestModule mQuestionsFragmentTestModule;

    public QuestionsFragmentTest() {
        super(StackRXActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();

        //work around for mockito https://code.google.com/p/dexmaker/issues/detail?id=2
        System.setProperty("dexmaker.dexcache", getInstrumentation().getTargetContext()
                .getCacheDir().getPath());

        //setup testing dependency injection
        mQuestionsFragmentTestModule = new QuestionsFragmentTestModule();

        StackRXApp app = (StackRXApp) getInstrumentation().getTargetContext().getApplicationContext();

        ApplicationComponent component = DaggerQuestionsFragmentTest_TestApplicationComponent.builder()
                .questionsFragmentTestModule(mQuestionsFragmentTestModule)
                .build();

        app.setComponent(component);

        //Minimum mock data to prevent Fragment NPE
        Questions questions = new Questions();
        Mockito.when(mQuestionsFragmentTestModule.mStackExchangeService.getQuestions())
                .thenReturn(Observable.just(questions));
    }


    private QuestionsFragment startFragment() {
        return (QuestionsFragment) getActivity().getFragmentManager().findFragmentById(R.id.container);
    }

    //Todo: failing test
    public void testNetwork_Disconnected() throws Exception {
        /*
         * When network state is disconnected, verify that QuestionsDAO.getQuestions() is NOT called
         */

        NetworkInfo networkInfo = Mockito.mock(NetworkInfo.class);
        Mockito.when(networkInfo.getState()).thenReturn(NetworkInfo.State.DISCONNECTED);
        Mockito.when(mQuestionsFragmentTestModule.mConnectivityManager.getActiveNetworkInfo())
                .thenReturn(networkInfo);
        startFragment();

        //The thing under test
        Mockito.verify(mQuestionsFragmentTestModule.mStackExchangeService, never()).getQuestions();
    }

    public void testNetwork_Connected() throws Exception {
        /*
         * When network state is connected, verify that QuestionsDAO.getQuestions() is called
         */

        NetworkInfo networkInfo = Mockito.mock(NetworkInfo.class);
        Mockito.when(networkInfo.getState()).thenReturn(NetworkInfo.State.CONNECTED);
        Mockito.when(mQuestionsFragmentTestModule.mConnectivityManager.getActiveNetworkInfo())
                .thenReturn(networkInfo);
        startFragment();

        //The thing under test
        Mockito.verify(mQuestionsFragmentTestModule.mStackExchangeService, times(1)).getQuestions();
    }


    //region Dependency Injection ------------------------------------------------------------------

    @Singleton
    @Component(modules = {QuestionsFragmentTestModule.class})
    public interface TestApplicationComponent extends ApplicationComponent {
    }

    @Module
    public static class QuestionsFragmentTestModule {

        @Mock
        StackExchangeService mStackExchangeService;

        @Mock
        ConnectivityManager mConnectivityManager;

        public QuestionsFragmentTestModule() {
            MockitoAnnotations.initMocks(this);
        }

        @Provides
        InitialFragment provideFragmentCreator() {

            return new InitialFragment() {
                @Override
                public StackRXBaseFragment createInitialFragment() {
                    return new QuestionsFragment();
                }
            };
        }

        @Provides
        ConnectivityManager provideConnectivityManager() {
            return mConnectivityManager;
        }

        @Provides
        StackExchangeService provideQuestionDAO() {
            return mStackExchangeService;
        }
    }

    //endregion
}
