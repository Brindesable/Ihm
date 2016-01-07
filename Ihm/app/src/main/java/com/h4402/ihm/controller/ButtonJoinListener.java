package com.h4402.ihm.Controller;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Kilian on 06/01/2016.
 *
 * Manage the event fired when the user join a group
 */
public class ButtonJoinListener implements View.OnClickListener {

    // Id og the group the user want to join
    private int idGroup;

    /**
     * Constructor
     * @param id Id of the group
     */
    public ButtonJoinListener(int id){
        idGroup = id;
    }

    /**
     * When the event is fired
     * @param view ImageButton view
     */
    @Override
    public void onClick(View view) {
        // We inform the Controller that we choosed a group
        Controller.selectGroupJoinView(idGroup);
        // We launch a new activity to get the hours
        Context context = view.getContext();
        Intent intent = new Intent(context, JoinGroupHourActivity.class);
        context.startActivity(intent);
    }
}
