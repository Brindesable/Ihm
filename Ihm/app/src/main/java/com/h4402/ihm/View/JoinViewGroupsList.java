package com.h4402.ihm.View;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.h4402.ihm.Controller.ButtonJoinListener;
import com.h4402.ihm.Controller.Controller;
import com.h4402.ihm.Model.Group;
import com.h4402.ihm.R;

import java.util.List;

/**
 * Created by Kilian on 21/12/2015.
 * Modify the linear layout given in the constructor with the group list given in the method setGroup.
 */
public class JoinViewGroupsList {

    private Context context;
    private LinearLayout viewGroups;

    /**
     * Constructor
     * @param c Context
     * @param ll Linear layout which will contain the groups for one restaurant
     */
    public JoinViewGroupsList(Context c, LinearLayout ll) {
        context = c;
        viewGroups = ll;
    }

    public void setGroups(List<Group> groups){
        viewGroups.removeAllViews();
        for(Group g : groups)
        {
            // We get the XML view for one group (and inflate it)
            RelativeLayout viewGroup = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.join_view_group, (ViewGroup) viewGroups, false);
            // We set the TextViews displaying the group name and the hour
            TextView groupName = (TextView) viewGroup.findViewById(R.id.group_name);
            groupName.setText(g.getName());
            TextView groupHour = (TextView) viewGroup.findViewById(R.id.horaire);
            groupHour.setText(g.getHour());
            // We get the part which will display the avatars
            LinearLayout usersView = (LinearLayout) viewGroup.findViewById(R.id.avatar_bar);
            // Then we give it to ViewUsers which will fill it with the rights avatars
            JoinViewUsersList viewUsers = new JoinViewUsersList(context, usersView);
            viewUsers.setUsers(g.getUsers());
            //
            ImageButton joinButton = (ImageButton) viewGroup.findViewById(R.id.join_button);
            joinButton.setColorFilter(Color.GRAY);
            joinButton.setOnClickListener(new ButtonJoinListener(g.getId()));
            //
            Controller.addGroupJoinView(g.getId(), new GroupJoinView(g, viewGroup));
            // We add the group to the general viewGroups layout
            viewGroups.addView(viewGroup);
        }
    }

    /**
     * Gives back the view which has benne modified with setGroup method
     * @return View Groups
     */
    public View getView(){
        return viewGroups;
    }
}
