package com.example.cesar.jogodobicho;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Cesar on 04/02/2017.
 */

public class BottomSheetModalFragment extends BottomSheetDialogFragment {

    public static BottomSheetModalFragment newInstance() {
        return new BottomSheetModalFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_sheet_modal, container, false);
        return v;
    }
}
