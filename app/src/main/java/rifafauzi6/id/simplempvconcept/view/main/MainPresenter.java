package rifafauzi6.id.simplempvconcept.view.main;

import rifafauzi6.id.simplempvconcept.model.Data;
import rifafauzi6.id.simplempvconcept.view.base.Presenter;

public class MainPresenter implements Presenter<MainView> {
    private MainView mView;

    @Override
    public void onAttach(final MainView view) {
        mView = view;
    }

    @Override
    public void onDetach() {
        mView = null;
    }

    void showFragment() {
        // Set Data
        final Data data = new Data();
        data.setText("Hello from Data!");

        // Show Fragment with Data
        mView.onShowFragment(data);
    }
}