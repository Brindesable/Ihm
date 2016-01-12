package com.h4402.ihm.Controller;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.h4402.ihm.Model.User;
import com.h4402.ihm.R;

import java.util.zip.Inflater;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Kilian on 07/01/2016.
 */
public class RecapActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.recap_view);

        TextView resto = (TextView) findViewById(R.id.resto);
        resto.setText(Controller.currentGroupSelected.getGroup().getRestaurant().getName());
        TextView group = (TextView) findViewById(R.id.group_name);
        group.setText(Controller.currentGroupSelected.getGroup().getName());
        LinearLayout membersList = (LinearLayout) findViewById(R.id.groupe_members);

        TextView hour = (TextView) getLayoutInflater().inflate(R.layout.recap_view_hour, membersList, false);
        hour.setText("12h30");
        membersList.addView(hour);

        CardView cv = (CardView) getLayoutInflater().inflate(R.layout.recap_view_users, membersList, false);
        TextView username = (TextView) cv.findViewById(R.id.username);
        username.setText(Controller.me.getName());
        CircleImageView avatar = (CircleImageView) cv.findViewById(R.id.user_avatar);
        avatar.setImageResource(Controller.me.getAvSrc());
        avatar.setBorderColor(Color.parseColor("#2196f3"));
        membersList.addView(cv);


        int i = 0;
        for(User member : Controller.currentGroupSelected.getGroup().getUsers()){
            cv = (CardView) getLayoutInflater().inflate(R.layout.recap_view_users, membersList, false);

            username = (TextView) cv.findViewById(R.id.username);
            username.setText(member.getName());

            avatar = (CircleImageView) cv.findViewById(R.id.user_avatar);
            avatar.setImageResource(member.getAvSrc());

            membersList.addView(cv);

            if(Controller.currentGroupSelected.getGroup().getUsers().size() > 5 && (i == 0 || i == 4)){
                hour = (TextView) getLayoutInflater().inflate(R.layout.recap_view_hour, membersList, false);
                if(i == 0)
                    hour.setText("13h15");
                if(i == 4)
                    hour.setText("13h30");

                membersList.addView(hour);
            }
            i++;
        }
    }
}
