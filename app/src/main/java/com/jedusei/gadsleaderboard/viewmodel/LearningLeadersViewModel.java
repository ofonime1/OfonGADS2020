package com.jedusei.gadsleaderboard.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jedusei.gadsleaderboard.model.LearningLeader;

import java.util.Arrays;
import java.util.List;

public class LearningLeadersViewModel extends ViewModel {
    private MutableLiveData<List<LearningLeader>> learningLeaders;

    public LiveData<List<LearningLeader>> getLearningLeaders() {
        if (learningLeaders == null) {
            learningLeaders = new MutableLiveData<>();
            refreshList();
        }
        return learningLeaders;
    }

    public void refreshList() {
        learningLeaders.postValue(Arrays.asList(
                new LearningLeader("Eric Yenge", "Tanzania", 83),
                new LearningLeader("Kojo Yeboah", "Ghana", 74),
                new LearningLeader("Sam George", "Nigeria", 55)
        ));
    }
}
