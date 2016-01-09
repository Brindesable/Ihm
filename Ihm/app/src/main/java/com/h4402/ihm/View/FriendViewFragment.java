package com.h4402.ihm.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.h4402.ihm.R;

/**
 * Created by Kilian on 08/01/2016.
 */
public class FriendViewFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.friends_view_fragment, container, false);

        return view;
    }
}
