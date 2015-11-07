package net.alexanderheavens.methodicalkitchen.app;

import android.content.Context;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

import net.alexanderheavens.methodicalkitchen.R;

/**
 * Created by alexander on 07/11/15.
 */
public class PantrySelectionLayout extends RelativeLayout {


    private boolean isToggled;
    private float startX;

    private void init(){
        this.isToggled = true;
        this.startX = 0f;
    }

    public PantrySelectionLayout(Context context) {
        super(context);
        init();
    }

    public PantrySelectionLayout(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        init();
    }

    public PantrySelectionLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr, 0);
        init();
    }



    public boolean isToggled(){
        return isToggled;
    }

    private void setIsToggled(final boolean isToggled){
        this.isToggled = isToggled;
    }

    private void setTogglePercent(final float togglePercent) {
        if (togglePercent < 0f || togglePercent > 1f)
            throw new IllegalArgumentException("Expected togglePercent between 0 and 1 but was actually " + togglePercent);

        setIsToggled(togglePercent == 1f);

        final float width = getWidth();

        final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        layoutParams.setMarginStart((int) (-width * (1f - togglePercent)));
    }


}
