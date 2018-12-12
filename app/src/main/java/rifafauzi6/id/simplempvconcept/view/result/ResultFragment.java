package rifafauzi6.id.simplempvconcept.view.result;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Objects;

import rifafauzi6.id.simplempvconcept.R;


public class ResultFragment extends Fragment implements ResultView {
    ResultPresenter presenter;

    public static ResultFragment newInstance() {
        return new ResultFragment();
    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initPresenter();
        onAttachView();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_result, container, false);
    }

    @Override
    public void onAttachView() {
        presenter.onAttach(this);
        setResult();
    }

    @Override
    public void onDetachView() {
        presenter.onDetach();
    }

    @Override
    public void onShowResult(final String text) {
        final TextView textView = Objects.requireNonNull(getActivity()).findViewById(R.id.tv_result);
        textView.setText(text);
    }

    @Override
    public void onDestroyView() {
        onDetachView();
        super.onDestroyView();
    }

    private void initPresenter() {
        presenter = new ResultPresenter();
    }

    private void setResult() {
        final Bundle bundle = getArguments();
        final String text = Objects.requireNonNull(bundle).getString("data");

        presenter.showResult(text);
    }
}