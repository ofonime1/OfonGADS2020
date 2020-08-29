package com.jedusei.gadsleaderboard.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jedusei.gadsleaderboard.R;
import com.jedusei.gadsleaderboard.adapter.LearningLeadersRvAdapter;
import com.jedusei.gadsleaderboard.model.LearningLeader;
import com.jedusei.gadsleaderboard.viewmodel.LearningLeadersViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LearningLeadersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LearningLeadersFragment extends Fragment {

    private LearningLeadersViewModel viewModel;

    public LearningLeadersFragment() {
        // Required empty public constructor
    }

    public static LearningLeadersFragment newInstance() {
        LearningLeadersFragment fragment = new LearningLeadersFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(LearningLeadersViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_learning_leaders, container, false);
        final View emptyView = view.findViewById(R.id.emptyView);

        final SwipeRefreshLayout swipeRefreshLayout = view.findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setRefreshing(true);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                viewModel.refreshList();
            }
        });

        final RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        final LearningLeadersRvAdapter adapter = new LearningLeadersRvAdapter(getContext());
        recyclerView.setAdapter(adapter);
        viewModel.getLearningLeaders()
                .observe(this, new Observer<List<LearningLeader>>() {
                    @Override
                    public void onChanged(List<LearningLeader> learningLeaders) {
                        adapter.setItems(learningLeaders);
                        swipeRefreshLayout.setRefreshing(false);
                        if (learningLeaders.size() > 0) {
                            recyclerView.setVisibility(View.VISIBLE);
                            emptyView.setVisibility(View.GONE);
                        }
                        else {
                            recyclerView.setVisibility(View.GONE);
                            emptyView.setVisibility(View.VISIBLE);
                        }
                    }
                });

        return view;
    }
}