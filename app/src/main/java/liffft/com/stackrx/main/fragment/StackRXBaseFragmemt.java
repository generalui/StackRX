package liffft.com.stackrx.main.fragment;

import android.support.v4.app.Fragment;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by graemeharnish on 5/25/15.
 */
public class StackRXBaseFragmemt extends Fragment {

    //region INJECTED CLASSES ----------------------------------------------------------------------
    //endregion

    //region INJECTED VIEWS ------------------------------------------------------------------------
    //endregion

    //region LOCAL CONSTANTS -----------------------------------------------------------------------
    //endregion

    //region CLASS VARIABLES -----------------------------------------------------------------------

    protected CompositeSubscription mCompositeSubscription = new CompositeSubscription();
    //endregion

    //region CONSTRUCTOR ---------------------------------------------------------------------------
    //endregion

    //region LIFE CYCLE METHODS --------------------------------------------------------------------

    @Override
    public void onDestroy() {
        super.onDestroy();
        mCompositeSubscription.unsubscribe();
    }


    //endregion

    //region WIDGET --------------------------------------------------------------------------------
    //endregion

    //region LISTENERS -----------------------------------------------------------------------------
    //endregion

    //region EVENTS --------------------------------------------------------------------------------
    //endregion

    //region LOCAL METHODS -------------------------------------------------------------------------
    //endregion

    //region SUBSCRIBERS ---------------------------------------------------------------------------
    //endregion

    //region ACCESSORS -----------------------------------------------------------------------------
    //endregion

    //region INNER CLASSES -------------------------------------------------------------------------
    //endregion

    //region CLASS METHODS -------------------------------------------------------------------------
    //endregion

}
