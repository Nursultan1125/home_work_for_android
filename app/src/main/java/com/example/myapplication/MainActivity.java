package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button buttonTrue;
    private Button buttonFalse;
    private TextView questionTextVew;
    private TextView leaveTextView;
    private Controller controller;



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonTrue = findViewById(R.id.buttonTrue);
        buttonFalse = findViewById(R.id.buttonFalse);
        questionTextVew = findViewById(R.id.quesiotionTextView);
        leaveTextView = findViewById(R.id.leaveTextView);

        controller = new Controller();

        handle();

        buttonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.handle(true);
                handle();
            }
        });
        buttonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.handle(false);
                handle();
            }
        });
    }

    public void showAlertDialog(String text){
        new AlertDialog.Builder(this)
                .setTitle(text)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        controller.reset();
                        handle();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public void handle(){
        questionTextVew.setText((controller.getCurrentQuestion().getText()));
        leaveTextView.setText("Жизнь " + controller.getLeave() + "/ 3");
        if(controller.getLeave() <= 0){
            showAlertDialog("Вы проиграли! Еще хотите играть");
        }
        else if(controller.isFinish()){
            showAlertDialog("Вы выирали! Еще хотите играть");
        }
    }
}