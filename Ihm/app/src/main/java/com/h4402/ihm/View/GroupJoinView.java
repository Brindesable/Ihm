package com.h4402.ihm.View;

import android.graphics.Color;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.h4402.ihm.Controller.Controller;
import com.h4402.ihm.Model.Group;
import com.h4402.ihm.R;

/**
 * Created by Kilian on 06/01/2016.
 */
public class GroupJoinView {

    private RelativeLayout view;
    private Group group;

    public GroupJoinView(Group g, RelativeLayout v){
        view = v;
        group = g;
    }

    public void join(){
        ImageButton joinButton = (ImageButton) view.findViewById(R.id.join_button);
        joinButton.setColorFilter(Color.RED);
    }

    public void quit(){
        ImageButton joinButton = (ImageButton) view.findViewById(R.id.join_button);
        joinButton.setColorFilter(Color.GRAY);
    }

    public Group getGroup(){ return group; }
}
