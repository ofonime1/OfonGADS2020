package com.jedusei.gadsleaderboard.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jedusei.gadsleaderboard.model.LearningLeader;
import com.jedusei.gadsleaderboard.model.SkillLeader;

import java.util.Arrays;
import java.util.List;

public class SkillLeadersViewModel extends ViewModel {
    private MutableLiveData<List<SkillLeader>> skillLeaders;

    public LiveData<List<SkillLeader>> getSkillLeaders() {
        if (skillLeaders == null) {
            skillLeaders = new MutableLiveData<>();
            refreshList();
        }
        return skillLeaders;
    }

    public void refreshList() {
        skillLeaders.postValue(Arrays.asList(
                new SkillLeader("Perry Oluwatobi", "Nigeria", 300),
                new SkillLeader("Perry Oluwatobi", "Nigeria", 214),
                new SkillLeader("Perry Oluwatobi", "Nigeria", 207)
        ));
    }
}
