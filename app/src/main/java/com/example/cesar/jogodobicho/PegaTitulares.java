package com.example.cesar.jogodobicho;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PegaTitulares extends DialogFragment implements TextView.OnEditorActionListener {

    private EditText mEditText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setStyle(android.app.DialogFragment.STYLE_NO_TITLE, R.style.MeuDialog);
    }

    public interface UserNameListener {
        void onFinishUserDialog(String user);
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//
//
//        if (getDialog() == null)
//            return;
//
//        int dialogWidth = 600;
//        int dialogHeight = 400;
//
//        getDialog().getWindow().setLayout(dialogWidth, dialogHeight);
//
//    }

    // Empty constructor required for DialogFragment
    public PegaTitulares() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pega_titulares, container);
        mEditText = (EditText) view.findViewById(R.id.username);

        // set this instance as callback for editor action
        mEditText.setOnEditorActionListener(this);
        mEditText.requestFocus();
        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        getDialog().setTitle("Please enter username");

        return view;
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        // Return input text to activity
        UserNameListener activity = (UserNameListener) getActivity();
        activity.onFinishUserDialog(mEditText.getText().toString());
        this.dismiss();
        return true;
    }

    public void clickFinish(Context context){
    }
}
