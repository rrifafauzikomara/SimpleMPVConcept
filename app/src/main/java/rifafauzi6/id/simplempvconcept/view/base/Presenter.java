package rifafauzi6.id.simplempvconcept.view.base;

public interface Presenter<T extends View> {

    void onAttach(T view);

    void onDetach();

}