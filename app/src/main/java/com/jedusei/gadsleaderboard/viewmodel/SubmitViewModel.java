package com.jedusei.gadsleaderboard.viewmodel;

import android.os.Handler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jedusei.gadsleaderboard.model.Submission;


public class SubmitViewModel extends ViewModel {
    public static final int STATUS_NEUTRAL = 0;
    public static final int STATUS_OK = 1;
    public static final int STATUS_ERROR = -1;
    private MutableLiveData<Integer> status = new MutableLiveData<>(STATUS_NEUTRAL);

    public void submit(Submission submission) {
        status.setValue(STATUS_NEUTRAL);
        new Handler()
                .postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        status.setValue(STATUS_OK);
                    }
                }, 1500);
    }

    public LiveData<Integer> getStatus() {
        return status;
    }
}
