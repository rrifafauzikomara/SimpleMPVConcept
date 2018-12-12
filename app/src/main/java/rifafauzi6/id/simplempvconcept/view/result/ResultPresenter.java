package rifafauzi6.id.simplempvconcept.view.result;

import rifafauzi6.id.simplempvconcept.view.base.Presenter;

public class ResultPresenter implements Presenter<ResultView> {
    private ResultView mView;

    @Override
    public void onAttach(final ResultView view) {
        mView = view;
    }

    @Override
    public void onDetach() {
        mView = null;
    }

    void showResult(final String text) {
        mView.onShowResult(text);
    }
}