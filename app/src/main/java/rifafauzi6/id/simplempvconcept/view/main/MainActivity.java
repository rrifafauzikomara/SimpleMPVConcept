package rifafauzi6.id.simplempvconcept.view.main;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import rifafauzi6.id.simplempvconcept.R;
import rifafauzi6.id.simplempvconcept.view.result.ResultFragment;
import rifafauzi6.id.simplempvconcept.model.Data;

public class MainActivity extends AppCompatActivity implements MainView {
    MainPresenter presenter;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPresenter();
        onAttachView();
    }

    @Override
    public void onAttachView() {
        presenter.onAttach(this);
        addButtonListener();
    }

    @Override
    public void onDetachView() {
        presenter.onDetach();
    }

    @Override
    public void onShowFragment(final Data data) {
        // Get Data
        final Bundle bundle = new Bundle();
        bundle.putString("data", data.getText());

        // Show Fragment with Data
        final String tag = ResultFragment.class.getSimpleName();
        final Fragment fragment = ResultFragment.newInstance();
        fragment.setArguments(bundle);

        // Begin Fragment Transaction
        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_main, fragment, tag);
        fragmentTransaction.commit();
    }

    @Override
    protected void onDestroy() {
        onDetachView();
        super.onDestroy();
    }

    private void initPresenter() {
        presenter = new MainPresenter();
    }

    private void addButtonListener() {
        final Button button = findViewById(R.id.btn_main);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                button.setVisibility(View.GONE);
                presenter.showFragment();
            }
        });
    }
}