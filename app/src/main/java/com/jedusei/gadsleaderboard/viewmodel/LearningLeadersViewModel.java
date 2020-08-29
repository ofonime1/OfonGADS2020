package com.jedusei.gadsleaderboard.viewmodel;

import android.os.Handler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jedusei.gadsleaderboard.model.LearningLeader;

import java.util.Arrays;
import java.util.List;

public class LearningLeadersViewModel extends ViewModel {
    private MutableLiveData<List<LearningLeader>> learningLeaders;
    private Handler handler = new Handler();

    public LiveData<List<LearningLeader>> getLearningLeaders() {
        if (learningLeaders == null) {
            learningLeaders = new MutableLiveData<>();
            refreshList();
        }
        return learningLeaders;
    }

    public void refreshList() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                learningLeaders.setValue(Arrays.asList(
                        new LearningLeader("Eric Yenge", "Tanzania", 83),
                        new LearningLeader("Kojo Yeboah", "Ghana", 74),
                        new LearningLeader("Sam George", "Nigeria", 55)
                ));
            }
        }, 1000);
    }
}
