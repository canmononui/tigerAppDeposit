package com.example.tigerAppDeposit;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetDialogDeposit extends BottomSheetDialogFragment {

    private BottomSheetListener mListener;
    boolean btnOptionBool1 = false;
    boolean btnOptionBool2 = false;
    boolean btnOptionBool3 = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.alert_bottom_option_deposit, container, false);
        Button btnOptionMenu1 = v.findViewById(R.id.buttonOptionMenu1);
        Button btnOptionMenu2 = v.findViewById(R.id.buttonOptionMenu2);
        Button btnOptionMenu3 = v.findViewById(R.id.buttonOptionMenu3);
        Button btnCancelAlert = v.findViewById(R.id.buttonCancelAlert);
        Button btnSubmitAlert = v.findViewById(R.id.buttonSubmitAlert);

        // BUTTON OPTION 1 ON CLICK
        btnOptionMenu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onButtonClicked("ค่าเช่ารายวัน");
                if(btnOptionBool1) {
                    btnOptionBool1 = false;
                    btnOptionMenu1.setBackgroundResource(R.drawable.bg_button_white);
                }
                else {
                    btnOptionBool1 = true;
                    btnOptionMenu1.setBackgroundResource(R.drawable.bg_button_yellow);
                }
            }
        });

        // BUTTON OPTION 2 ON CLICK
        btnOptionMenu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onButtonClicked("ค่าเช่ารายเดือน");
                if(btnOptionBool2) {
                    btnOptionBool2 = false;
                    btnOptionMenu2.setBackgroundResource(R.drawable.bg_button_white);
                }
                else {
                    btnOptionBool2 = true;
                    btnOptionMenu2.setBackgroundResource(R.drawable.bg_button_yellow);
                }
            }
        });

        // BUTTON OPTION 3 ON CLICK
        btnOptionMenu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onButtonClicked("ค่าส่วนกลาง");
                if(btnOptionBool3) {
                    btnOptionBool3 = false;
                    btnOptionMenu3.setBackgroundResource(R.drawable.bg_button_white);
                }
                else {
                    btnOptionBool3 = true;
                    btnOptionMenu3.setBackgroundResource(R.drawable.bg_button_yellow);
                }
            }
        });

        // BUTTON CANCEL ON CLICK
        btnCancelAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        // BUTTON SUBMIN ON CLICK
        btnSubmitAlert.setOnClickListener(new View.OnClickListener() {
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
