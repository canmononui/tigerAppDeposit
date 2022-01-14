package com.example.tigerAppDeposit;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import java.util.Calendar;

public class HistoryActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, BottomSheetDialog.BottomSheetListener {

    Button btnCalendar, btnOption;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        // SET BUTTON OPTION
        btnOption = findViewById(R.id.buttonOption);
        btnOption.setText("ทั้งหมด");

        btnOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheet = new BottomSheetDialog();
                bottomSheet.show(getSupportFragmentManager(), "exampleBottomSheet");

            }
        });

        // GET STRING CALENDAR
        String date = Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + "/" + (Calendar.getInstance().get(Calendar.MONTH) + 1) + "/" + Calendar.getInstance().get(Calendar.YEAR);

        // SET BUTTON SUBMIT
        btnCalendar = findViewById(R.id.buttonCalendar);
        btnCalendar.setText(date);

        // ON CLICK BUTTON
        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
    }

    // FUNC DATE PICKER
    public void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date =  dayOfMonth + "/" + (month + 1) + "/" + year;
        btnCalendar.setText(date);
    }

    @Override
    public void onButtonClicked(String text) {
        btnOption.setText(text);
    }
}