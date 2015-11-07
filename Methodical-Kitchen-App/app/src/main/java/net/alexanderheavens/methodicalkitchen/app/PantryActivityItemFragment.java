package net.alexanderheavens.methodicalkitchen.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import net.alexanderheavens.methodicalkitchen.R;
import net.alexanderheavens.methodicalkitchen.core.Controller;
import net.alexanderheavens.methodicalkitchen.core.pantry.Pantry;

import java.util.Set;


public class PantryActivityItemFragment extends ListFragment {

    public static final String PANTRY_DETAILS_FIELD = "pantryDetails";

    private PantryDetails pantry;

    private final Controller controller;

    // TODO: Rename and change types of parameters
    public static PantryActivityItemFragment newInstance(final PantryDetails pantry) {

        PantryActivityItemFragment fragment = new PantryActivityItemFragment();

        // Arguments
        final Bundle bundle = new Bundle();
        bundle.putParcelable(PANTRY_DETAILS_FIELD, pantry);

        fragment.setArguments(bundle);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PantryActivityItemFragment() {
        this.controller = new Controller();
        final Pantry pantry = this.controller.createPantry();
        this.pantry = new PantryDetails(pantry);
        pantry.addItemInstance();

        System.out.println("Created");
    }

    private void validatePantryArgument(final Parcelable pantryArgument) {
        if (pantryArgument == null)
            throw new NullPointerException("pantryArgument is null");

        if (!(pantryArgument instanceof PantryDetails))
            throw new IllegalArgumentException("pantryArgument is " + pantryArgument.getClass().getName() + " but expected " + PantryDetails.class.getName());

    }

    @Override
    public void setArguments(final Bundle bundle) {

        final Parcelable pantryArgument = bundle.getParcelable(PANTRY_DETAILS_FIELD);

        validatePantryArgument(pantryArgument);
        setPantryDetails((PantryDetails) pantryArgument);

    }

    public void setPantryDetails(final PantryDetails newPantry) {
        validatePantryArgument(newPantry);
        this.pantry = newPantry;
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {

        if (savedInstanceState != null) {
            setArguments(savedInstanceState);
        }

        final PantryItemInstanceArrayAdapter adapter = new PantryItemInstanceArrayAdapter(inflater.getContext(), getPantry().getInstanceDetails());
        setListAdapter(adapter);

        inflater.inflate(R.layout.activity_pantry_list, container, false);

        final View titleText = container.getChildAt(0);
        assert(titleText != null);
        assert(getPantry() != null);
        assert(getPantry().getName() != null);



        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        System.out.println("onListItemClick Clicked! " + position);
    }


    private static class PantryItemInstanceArrayAdapter extends ArrayAdapter<InstanceDetails> {

        public PantryItemInstanceArrayAdapter(final Context context, final Set<InstanceDetails> itemInstanceCollection) {
            super(context, android.R.layout.simple_list_item_1);
            addAll(itemInstanceCollection);
        }

    }

    private PantryDetails getPantry() {
        return pantry;
    }
}
