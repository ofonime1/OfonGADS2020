package com.jedusei.gadsleaderboard.fragment;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class OkDialogFragment extends DialogFragment {
    public static final String ARGS_MESSAGE = "message";

    public OkDialogFragment() {
    }

    public static OkDialogFragment newInstance(String message) {
        OkDialogFragment dialog = new OkDialogFragment();
        Bundle args = new Bundle();
        args.putString(ARGS_MESSAGE, message);
        dialog.setArguments(args);
        return dialog;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new AlertDialog.Builder(getContext())
                .setMessage(getArguments().getString(ARGS_MESSAGE, ""))
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }

}
