package net.alexanderheavens.methodicalkitchen.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import net.alexanderheavens.methodicalkitchen.core.pantry.ItemInstance;
import net.alexanderheavens.methodicalkitchen.core.pantry.Pantry;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by alexander on 04/11/15.
 */
public class PantryDetails implements Parcelable {

    //// CONSTANTS
    public static final String NAME_FIELD = "name";
    public static final String ITEM_INSTANCE_SET_FIELD = "itemInstanceSet";

    //// FIELDS
    private final String name;
    private final Set<InstanceDetails> instanceDetailsList;

    public PantryDetails(final Pantry pantry) {
        this(pantry.getName(), createInstanceDetailsSet(pantry.getItemInstances()));
    }

    private PantryDetails(final String name, Parcelable[] instanceDetailsSet) {
        this.name = name;


        this.instanceDetailsList = new HashSet<InstanceDetails>(instanceDetailsSet.length);
        for (int i = 0; i < instanceDetailsSet.length; i++) {
            this.instanceDetailsList.add((InstanceDetails) instanceDetailsSet[i]);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(final Parcel out, int flags) {
        final Bundle bundle = createBundle();
        out.writeBundle(bundle);
    }

    private Bundle createBundle() {
        final Bundle bundle = new Bundle();
        bundle.putString(NAME_FIELD, getName());
        return bundle;
    }

    public static final Parcelable.Creator<PantryDetails> CREATOR
            = new Parcelable.Creator<PantryDetails>() {

        public PantryDetails createFromParcel(Parcel in) {
            return new PantryDetails(in);
        }

        public PantryDetails[] newArray(int size) {
            return new PantryDetails[size];
        }
    };

    private PantryDetails(Parcel in) {
        this(in.readBundle());
    }

    private PantryDetails(final Bundle bundle) {
        this(bundle.getString(NAME_FIELD), bundle.getParcelableArray(ITEM_INSTANCE_SET_FIELD));
    }


    private static Parcelable[] createInstanceDetailsSet(final Collection<ItemInstance> itemInstances) {

        final Parcelable[] instanceSet = new Parcelable[itemInstances.size()];

        int index = 0;
        for (final ItemInstance instance : itemInstances) {
            instanceSet[index++] = new InstanceDetails(instance);
        }

        return instanceSet;
    }

    //// GETTERS & SETTERS
    public String getName() {
        return name;
    }

    public Set<InstanceDetails> getInstanceDetails(){
        return instanceDetailsList;
    }

}
