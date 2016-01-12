package com.h4402.ihm.View;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.h4402.ihm.Controller.AddGroupActivity;
import com.h4402.ihm.Controller.Controller;
import com.h4402.ihm.Controller.SearchFriendActivity;
import com.h4402.ihm.Model.User;
import com.h4402.ihm.R;

/**
 * Created by Kilian on 08/01/2016.
 */
public class FriendViewFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.friends_view_fragment, container, false);
        LinearLayout friendsContainer = (LinearLayout) view.findViewById(R.id.list_friends);

        for(final User friend : Controller.friends){
            CardView friendView = (CardView) inflater.inflate(R.layout.friend_friend_view, friendsContainer, false);
            TextView userName = (TextView) friendView.findViewById(R.id.username);
            userName.setText(friend.getName());
            ImageView avatar = (ImageView) friendView.findViewById(R.id.user_avatar);
            avatar.setImageResource(friend.getAvSrc());
            final ImageButton deleteButton = (ImageButton) friendView.findViewById(R.id.delete_button);
            deleteButton.setColorFilter(Color.GRAY);
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // On touch colors
                    deleteButton.setColorFilter(Color.parseColor("#f44336"));
                    deleteButton.setBackgroundResource(R.drawable.roundcorner_red);
                    // Base color of the buttons
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            deleteButton.setColorFilter(Color.GRAY);
                            deleteButton.setBackgroundResource(R.drawable.roundcorner_white);
                        }
                    }, 500);
                    // Confirm dialog
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder
                            .setMessage("Voulez-vous vraiment supprimer " + friend.getName() + " de vos amis ?")
                            .setPositiveButton("Oui",  new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                    // Yes-code
                                }
                            })
                            .setNegativeButton("Non", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,int id) {
                                    dialog.cancel();
                                }
                            })
                            .show();
                }
            });
            friendsContainer.addView(friendView);

            final ImageButton addfriendButton = (ImageButton)  view.findViewById(R.id.button_add);
            addfriendButton.setColorFilter(Color.GRAY);
            addfriendButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, SearchFriendActivity.class);
                    context.startActivity(intent);
                    addfriendButton.setColorFilter(Color.parseColor("#2196f3"));
                    addfriendButton.setBackgroundResource(R.drawable.roundcorner_blue);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            addfriendButton.setColorFilter(Color.GRAY);
                            addfriendButton.setBackgroundResource(R.drawable.roundcorner_white);
                        }
                    }, 500);
                }
            });
        }
        return view;
    }
}
