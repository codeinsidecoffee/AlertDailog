package com.mrlonewolfer.alertdailog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AlertDialogLayout;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAlert,btnCustomAlert;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        btnAlert= findViewById(R.id.btnAlert);
        btnAlert.setOnClickListener(this);
        btnCustomAlert=findViewById(R.id.btnCustomAlert);
        btnCustomAlert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnAlert)
        {
            ShowSimpleAlertDailog();
          }
          if(v.getId()==R.id.btnCustomAlert){
              ShowCustomAlertDailog();
          }

    }

    private void ShowCustomAlertDailog() {
        LayoutInflater layoutInflater=getLayoutInflater();
        View layoutView=layoutInflater.inflate(R.layout.custom_alert_layout,
                (ViewGroup) findViewById(R.id.mycustomAlert));
        //  Here is main code to bind xml with java
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setTitle("Get Alert");
        builder.setMessage("Submit Details TO get Notification");
        builder.setIcon(R.mipmap.ic_launcher_round);
        builder.setView(layoutView);

        final AlertDialog  dialog=builder.create();
        Button btnCancel,btnSubmit;
        final EditText edtName,edtEmail;
        edtName=layoutView.findViewById(R.id.edtName);
        edtEmail=layoutView.findViewById(R.id.edtEmail);
        btnCancel=layoutView.findViewById(R.id.btnCancle);
        btnSubmit=layoutView.findViewById(R.id.btnSubmit);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Your Not Intrested To \n Get Notification", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Thank You For Submiting Details \n" +
                        " Name: " +edtName.getText()+"\n" +
                        " EMail : "+edtEmail.getText(), Toast.LENGTH_SHORT).show();
                dialog.dismiss();

            }
        });

        dialog.show();
    }

    private void ShowSimpleAlertDailog() {
        AlertDialog.Builder builder= new AlertDialog.Builder(context);
        builder.setTitle("This is Alert Dailog Title");
        builder.setMessage("This Alert Dailog Message");
        builder.setIcon(R.mipmap.ic_launcher_round);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "This is Positive Action Button", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "This is Negative Action Button", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("Not Sure", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "This is Nutral Action Button", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
}
