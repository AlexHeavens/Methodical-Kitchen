package net.alexanderheavens.methodicalkitchen.app;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.AppCompatEditText;

import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import net.alexanderheavens.methodicalkitchen.R;
import net.alexanderheavens.methodicalkitchen.core.Controller;
import net.alexanderheavens.methodicalkitchen.core.pantry.Pantry;

public class PantryActivity extends AppCompatActivity implements GestureDetector.OnGestureListener{


    private static final float TOGGLE_MIN_X_VEL = 5f;
    private GestureDetectorCompat gestureDetector;

    private final Controller controller;
    private final Pantry pantry;

    public PantryActivity() {
        super();
        this.controller = new Controller();
        this.pantry = this.controller.createPantry();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pantry_list);


        FragmentManager fm = getSupportFragmentManager();

        if (fm.findFragmentById(android.R.id.content) == null) {

            final AppCompatEditText nameText = (AppCompatEditText) findViewById(R.id.pantry_details_title);
            assert(nameText != null);


            System.out.println("Created PantryActivity with " + nameText.toString());
            nameText.setText(pantry.getName());
            nameText.setTextIsSelectable(true);



            nameText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final AppCompatEditText editText = (AppCompatEditText) v;
                    System.out.println("onClick");
                }
            });

            nameText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    pantry.setName(s.toString());
                }
            });

            nameText.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    final int action = MotionEventCompat.getActionMasked(event);

                    final AppCompatEditText editText = (AppCompatEditText) v;
                    System.out.println("event: " + event.toString());
                    return false;
                }
            });


            gestureDetector = new GestureDetectorCompat(this, this);


        }


    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        //System.out.println("touch " + ev);

        // TODO Auto-generated method stub
        return super.dispatchTouchEvent(ev);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        final MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_pantry_list, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        return super.onPrepareOptionsMenu(menu);
    }

    private void addPantryFragment(){
        // Create a new Fragment to be placed in the activity layout
        final PantryActivityItemFragment pantryFragment = new PantryActivityItemFragment();

        // In case this activity was started with special instructions from an
        // Intent, pass the Intent's extras to the fragment as arguments
        pantryFragment.setArguments(getIntent().getExtras());

        // Add the fragment to the 'fragment_container' FrameLayout
        getSupportFragmentManager().beginTransaction().add(pantryFragment, "pantryfragment_list").commit();

    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_new_pantry:
                final Pantry newPantry = controller.createPantry();
                addPantryFragment();
                break;
            case R.id.action_settings:
                // TODO
                break;
            default:
                assert (false); // unreachable code

        }
        return true;
    }

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            System.out.println("onFling " + e1 + ": " + e2);

            final PantrySelectionLayout pantryListLayout = (PantrySelectionLayout) findViewById(R.id.pantry_list_select_layout);
            assert(pantryListLayout != null);

            if(Math.abs(velocityX) >= 0){

                final Scene mEndingScene = Scene.getSceneForLayout(pantryListLayout, R.layout.activity_pantry_list_details_s2, pantryListLayout.getContext());

                Transition mFadeTransition =
                        TransitionInflater.from(this).
                                inflateTransition(R.transition.fade);
                TransitionManager.go(mEndingScene, mFadeTransition);
                Log.d(DEBUG_TAG, "transition to " + mEndingScene.toString());
                return true;
            }



            return true;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return true;
        }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.gestureDetector.onTouchEvent(event);
        // Be sure to call the superclass implementation
        return super.onTouchEvent(event);
    }

    private static final String DEBUG_TAG = "Gestures";
    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        Log.d(DEBUG_TAG, "onSingleTapUp: " + event.toString());
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public void onLongPress(MotionEvent event) {
        Log.d(DEBUG_TAG, "onLongPress: " + event.toString());
    }
}
