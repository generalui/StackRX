package liffft.com.stackrx.services.questions.dao;


import javax.inject.Inject;

import liffft.com.stackrx.services.base.BaseService;
import liffft.com.stackrx.services.base.ServiceEnvironment;
import liffft.com.stackrx.services.questions.model.Questions;
import liffft.com.stackrx.services.questions.service.QuestionsService;
import rx.Observable;

/**
 * Created by pair on 4/6/15.
 */
public class QuestionsDAO extends BaseService<QuestionsService> {
    /**
     * Setup retrofit with the correct parameters from the environment.
     *
     * @param serviceEnvironment     environment parameters
     */
    @Inject
    public QuestionsDAO(ServiceEnvironment serviceEnvironment) {
        super(QuestionsService.class, serviceEnvironment.getSecureParameters());
    }

    /**
     * GET list of questions
     * @return List of questions
     */
    public Observable<Questions> getQuestions() {
        return API().getQuestions();
    }
}
