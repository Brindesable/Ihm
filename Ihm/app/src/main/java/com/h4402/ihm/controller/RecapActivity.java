package com.h4402.ihm.Controller;

import android.app.Activity;
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

        for(User member : Controller.currentGroupSelected.getGroup().getUsers()){
            CardView cv = (CardView) getLayoutInflater().inflate(R.layout.recap_view_users, membersList, false);

            TextView username = (TextView) cv.findViewById(R.id.username);
            username.setText(member.getName());

            CircleImageView avatar = (CircleImageView) cv.findViewById(R.id.user_avatar);
            avatar.setImageResource(member.getAvSrc());

            membersList.addView(cv);
        }
    }
}
