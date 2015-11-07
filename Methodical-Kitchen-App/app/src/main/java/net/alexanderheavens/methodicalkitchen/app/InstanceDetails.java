package net.alexanderheavens.methodicalkitchen.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import net.alexanderheavens.methodicalkitchen.core.pantry.ItemInstance;

/**
 * Created by alexander on 04/11/15.
 */
public class InstanceDetails implements Parcelable{

    public static final String NAME_FIELD = "name";

    private final String name;

    public InstanceDetails(final ItemInstance itemInstance){
        this(itemInstance.getItem().getName());
    }

    public InstanceDetails(final Parcel in){
        this(in.readBundle());
    }

    public InstanceDetails(final Bundle bundle){
        this(bundle.getString(NAME_FIELD));
    }

    private InstanceDetails(final String name){
        if(name == null)throw new NullPointerException("name");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(final Parcel out, int flags) {
        final Bundle bundle = createBundle();
        out.writeBundle(bundle);
    }

    private Bundle createBundle(){
        final Bundle bundle = new Bundle();
        bundle.putString(NAME_FIELD, getName());
        return bundle;
    }

    public static final Parcelable.Creator<InstanceDetails> CREATOR
            = new Parcelable.Creator<InstanceDetails>() {

        public InstanceDetails createFromParcel(Parcel in) {
            return new InstanceDetails(in);
        }

        public InstanceDetails[] newArray(int size) {
            return new InstanceDetails[size];
        }
    };

}
