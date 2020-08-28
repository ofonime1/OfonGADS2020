package com.jedusei.gadsleaderboard.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jedusei.gadsleaderboard.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SkillLeadersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SkillLeadersFragment extends Fragment {

    public SkillLeadersFragment() {
        // Required empty public constructor
    }

    public static SkillLeadersFragment newInstance() {
        SkillLeadersFragment fragment = new SkillLeadersFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skill_leaders, container, false);
    }
}