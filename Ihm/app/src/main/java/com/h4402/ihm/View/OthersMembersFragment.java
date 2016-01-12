package com.h4402.ihm.View;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;

import com.h4402.ihm.Controller.MainActivity;
import com.h4402.ihm.Model.User;
import com.h4402.ihm.R;

import org.apmem.tools.layouts.FlowLayout;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Kilian on 12/01/2016.
 */
public class OthersMembersFragment extends DialogFragment {

    private List<User> members;

    public OthersMembersFragment(List<User> m){
        members = m;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.activity);
        View popup = MainActivity.activity.getLayoutInflater().inflate(R.layout.members_popup_join_view, null);
        FlowLayout listAvatarMembers = (FlowLayout) popup.findViewById(R.id.list_avatar_members);

        for(User user : members){
            CircleImageView avatar = (CircleImageView) MainActivity.activity.getLayoutInflater().inflate(R.layout.join_view_user, null);
            avatar.setImageResource(user.getAvSrc());
            listAvatarMembers.addView(avatar);
        }

        builder.setView(popup)
                // Add action buttons
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...
                    }
                });
        return builder.create();
    }
}
