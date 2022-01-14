package com.example.tigerAppDeposit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DepositActivity extends AppCompatActivity implements BottomSheetDialogDeposit.BottomSheetListener {

    TextView textOp;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);

        // SET TEXTVIEW
        textOp = findViewById(R.id.textOption);
        // SET LAYOUT
        layout = findViewById(R.id.layoutType);

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialogDeposit bottomSheet = new BottomSheetDialogDeposit();
                bottomSheet.show(getSupportFragmentManager(), "exampleBottomSheet");
            }
        });
    }

    @Override
    public void onButtonClicked(String text) {
        textOp.setText(text);
    }
}