package com.h4402.ihm.View;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.h4402.ihm.Controller.MainActivity;
import com.h4402.ihm.Model.User;
import com.h4402.ihm.R;

import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Kilian on 21/12/2015.
 *
 * Change the list of users into a linear layout displaying each one's avatar
 */
public class JoinViewUsersList {

    private Context context;
    private LinearLayout viewUsers;

    /**
     * Constructor
     * @param c Context
     * @param ll Linear Layout which will contains the avatars
     */
    public JoinViewUsersList(Context c, LinearLayout ll){
        context = c;
        viewUsers = ll;
    }

    /**
     * Change the view viewUsers according to the users list given in parameter
     * @param users Users inside the group
     */
    public void setUsers(final List<User> users){
        viewUsers.removeAllViews();

        // We get the screen metrics in order to know how many avatar we can display
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int nbUsersMax = (int) (dpWidth - 64*4) / 64;

        int nbUsers = 0;
        for(User u : users){
            if(nbUsers++ < nbUsersMax) {
                // We get the special XML view and inflate it
                CircleImageView avatar = (CircleImageView) LayoutInflater.from(context).inflate(R.layout.join_view_user, (ViewGroup) viewUsers, false);
                // We set the right image id
                avatar.setImageResource(u.getAvSrc());
                viewUsers.addView(avatar);
            }
        }
        // If there still some avatars undisplayed
        if(users.size() > nbUsersMax){
            // We get the XML for a white button
            final Button others = (Button) LayoutInflater.from(context).inflate(R.layout.join_view_white_button, (ViewGroup) viewUsers, false);
            // And we write how many avatars have not been displayed
            others.setText("+" + (users.size() - nbUsersMax));

            others.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogFragment othersFragment = new OthersMembersFragment(users);
                    othersFragment.show(MainActivity.fragmentManager, "others");
                    others.setTextColor(Color.parseColor("#2196f3"));
                    others.setBackgroundResource(R.drawable.roundcorner_blue);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                        others.setTextColor(Color.GRAY);
                        others.setBackgroundResource(R.drawable.roundcorner_white);
                        }
                    }, 500);
                }
            });

            viewUsers.addView(others);
        }
    }

    /**
     * Linear view getter
     * @return the linear view modified with setUsers method
     */
    public View getView(){
        return viewUsers;
    }
}
