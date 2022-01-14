package com.example.tigerAppDeposit;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetDialogDeposit extends BottomSheetDialogFragment {

    private BottomSheetListener mListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.alert_bottom_option_deposit, container, false);

        Button btnOptionMenu1 = v.findViewById(R.id.buttonOptionMenu1);
        Button btnOptionMenu2 = v.findViewById(R.id.buttonOptionMenu2);
        Button btnOptionMenu3 = v.findViewById(R.id.buttonOptionMenu3);
        Button btnCancelAlert = v.findViewById(R.id.buttonCancelAlert);

        // BUTTON OPTION 1 ON CLICK
        btnOptionMenu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onButtonClicked("ค่าเช่ารายวัน");
                dismiss();
            }
        });

        // BUTTON OPTION 2 ON CLICK
        btnOptionMenu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onButtonClicked("ค่าเช่ารายเดือน");
                dismiss();
            }
        });

        // BUTTON OPTION 3 ON CLICK
        btnOptionMenu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onButtonClicked("ค่าส่วนกลาง");
                dismiss();
            }
        });

        // BUTTON CANCEL ON CLICK
        btnCancelAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return v;
    }

    public interface BottomSheetListener {
        void onButtonClicked(String text);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mListener = (BottomSheetListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement BottomSheetListener");
        }
    }
}
