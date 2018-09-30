package com.example.tcc.iteach;


import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class editSpots extends AppCompatActivity implements View.OnClickListener {

    Spot spot;

    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    FirebaseUser firebaseUser;

    Dialog groupDialog;
    EditText groupMembers;
    Button saveGroupMembers;

    private TextView textViewSelectedDate;
    private Button done;
    private TextView textViewNumber6;
    private TextView textViewNumber7;
    private TextView textViewNumber8;
    private TextView textViewNumber9;
    private TextView textViewNumber10;
    private TextView textViewNumber11;
    private TextView textViewNumber12;
    private TextView textViewNumber13;
    private TextView textViewNumber14;
    private TextView textViewNumber15;
    private TextView textViewNumber16;
    private TextView textViewNumber17;
    private TextView textViewNumber18;
    private TextView textViewNumber19;
    private TextView textViewNumber20;
    private TextView textViewNumber21;
    private TextView textViewNumber22;
    private TextView textViewNumber23;

    String date;

    int numberInt6=0, numberInt7=1, numberInt8=1, numberInt9=1, numberInt10=1, numberInt11=1, numberInt12=1, numberInt13=1, numberInt14=1, numberInt15=1, numberInt16=1, numberInt17=1, numberInt18=1, numberInt19=1, numberInt20=1, numberInt21=1, numberInt22=1, numberInt23=1;

    private boolean individual6;
    private boolean individual7;
    private boolean individual8;
    private boolean individual9;
    private boolean individual10;
    private boolean individual11;
    private boolean individual12;
    private boolean individual13;
    private boolean individual14;
    private boolean individual15;
    private boolean individual16;
    private boolean individual17;
    private boolean individual18;
    private boolean individual19;
    private boolean individual20;
    private boolean individual21;
    private boolean individual22;
    private boolean individual23;

    private boolean chosen6, chosen7, chosen8, chosen9, chosen10, chosen11, chosen12, chosen13, chosen14, chosen15, chosen16, chosen17, chosen18, chosen19, chosen20, chosen21, chosen22, chosen23;


    private Button button6g ;
    private Button button6i;
    private Button button7g ;
    private Button button7i;
    private Button button8g;
    private Button button8i ;
    private Button button9g;
    private Button button9i;
    private Button button10g ;
    private Button button10i ;
    private Button button11g ;
    private Button button11i ;
    private Button button12g ;
    private Button button12i ;
    private Button button13g ;
    private Button button13i ;
    private Button button14g ;
    private Button button14i ;
    private Button button15g ;
    private Button button15i ;
    private Button button16g ;
    private Button button16i ;
    private Button button17g ;
    private Button button17i ;
    private Button button18g ;
    private Button button18i ;
    private Button button19g ;
    private Button button19i ;
    private Button button20g ;
    private Button button20i ;
    private Button button21g ;
    private Button button21i ;
    private Button button22g ;
    private Button button22i ;
    private Button button23g ;
    private Button button23i ;

    private int members6, members7, members8, members9, members10, members11, members12, members13, members14, members15, members16, members17, members18, members19, members20, members21, members22, members23;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_spots);

        Intent intent = getIntent();

        date = intent.getStringExtra("date");

        databaseReference= FirebaseDatabase.getInstance().getReference("Spots");
        firebaseAuth = FirebaseAuth.getInstance();

        textViewSelectedDate = findViewById(R.id.textViewSelectedDate);
        textViewSelectedDate.setText(date);


        textViewNumber6 = (TextView) findViewById(R.id.textViewNumber6) ;
        textViewNumber7 = (TextView) findViewById(R.id.textViewNumber7) ;
        textViewNumber8 = (TextView) findViewById(R.id.textViewNumber8) ;
        textViewNumber9 = (TextView) findViewById(R.id.textViewNumber9) ;
        textViewNumber10 = (TextView) findViewById(R.id.textViewNumber10) ;
        textViewNumber11 = (TextView) findViewById(R.id.textViewNumber11) ;
        textViewNumber12 = (TextView) findViewById(R.id.textViewNumber12) ;
        textViewNumber13 = (TextView) findViewById(R.id.textViewNumber13) ;
        textViewNumber14 = (TextView) findViewById(R.id.textViewNumber14) ;
        textViewNumber15 = (TextView) findViewById(R.id.textViewNumber15) ;
        textViewNumber16 = (TextView) findViewById(R.id.textViewNumber16) ;
        textViewNumber17 = (TextView) findViewById(R.id.textViewNumber17) ;
        textViewNumber18 = (TextView) findViewById(R.id.textViewNumber18) ;
        textViewNumber19 = (TextView) findViewById(R.id.textViewNumber19) ;
        textViewNumber20 = (TextView) findViewById(R.id.textViewNumber20) ;
        textViewNumber21 = (TextView) findViewById(R.id.textViewNumber21) ;
        textViewNumber22 = (TextView) findViewById(R.id.textViewNumber22) ;
        textViewNumber23 = (TextView) findViewById(R.id.textViewNumber23) ;


        done = findViewById(R.id.button_choose_date_schedule);

        button6g = findViewById(R.id.button_group_6);
        button6i = findViewById(R.id.button_individual_6);
        button7g = findViewById(R.id.button_group_7);
        button7i = findViewById(R.id.button_individual_7);
        button8g = findViewById(R.id.button_group_8);
        button8i = findViewById(R.id.button_individual_8);
        button9g = findViewById(R.id.button_group_9);
        button9i = findViewById(R.id.button_individual_9);
        button10g = findViewById(R.id.button_group_10);
        button10i = findViewById(R.id.button_individual_10);
        button11g = findViewById(R.id.button_group_11);
        button11i = findViewById(R.id.button_individual_11);
        button12g = findViewById(R.id.button_group_12);
        button12i = findViewById(R.id.button_individual_12);
        button13g = findViewById(R.id.button_group_13);
        button13i = findViewById(R.id.button_individual_13);
        button14g = findViewById(R.id.button_group_14);
        button14i = findViewById(R.id.button_individual_14);
        button15g = findViewById(R.id.button_group_15);
        button15i = findViewById(R.id.button_individual_15);
        button16g = findViewById(R.id.button_group_16);
        button16i = findViewById(R.id.button_individual_16);
        button17g = findViewById(R.id.button_group_17);
        button17i = findViewById(R.id.button_individual_17);
        button18g = findViewById(R.id.button_group_18);
        button18i = findViewById(R.id.button_individual_18);
        button19g = findViewById(R.id.button_group_19);
        button19i = findViewById(R.id.button_individual_19);
        button20g = findViewById(R.id.button_group_20);
        button20i = findViewById(R.id.button_individual_20);
        button21g = findViewById(R.id.button_group_21);
        button21i = findViewById(R.id.button_individual_21);
        button22g = findViewById(R.id.button_group_22);
        button22i = findViewById(R.id.button_individual_22);
        button23g = findViewById(R.id.button_group_23);
        button23i = findViewById(R.id.button_individual_23);

        done.setOnClickListener(this);

        button6g.setOnClickListener(this);
        button6i.setOnClickListener(this);
        button7g.setOnClickListener(this);
        button7i.setOnClickListener( this);
        button8g.setOnClickListener( this);
        button8i.setOnClickListener( this);
        button9g.setOnClickListener(this);
        button9i.setOnClickListener( this);
        button10g.setOnClickListener( this);
        button10i.setOnClickListener( this);
        button11g.setOnClickListener( this);
        button11i.setOnClickListener( this);
        button12g.setOnClickListener( this);
        button12i.setOnClickListener( this);
        button13g.setOnClickListener( this);
        button13i.setOnClickListener( this);
        button14g.setOnClickListener( this);
        button14i.setOnClickListener( this);
        button15g.setOnClickListener( this);
        button15i.setOnClickListener( this);
        button16g.setOnClickListener( this);
        button16i.setOnClickListener( this);
        button17g.setOnClickListener(this);
        button17i.setOnClickListener( this);
        button18g.setOnClickListener( this);
        button18i.setOnClickListener( this);
        button19g.setOnClickListener( this);
        button19i.setOnClickListener( this);
        button20g.setOnClickListener( this);
        button20i.setOnClickListener( this);
        button21g.setOnClickListener( this);
        button21i.setOnClickListener(this);
        button22g.setOnClickListener( this);
        button22i.setOnClickListener( this);
        button23g.setOnClickListener( this);
        button23i.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == button6g) {
            chosen6=true;
            button6g.setBackgroundColor(Color.GRAY);
            button6i.setBackgroundResource(android.R.drawable.btn_default);
            individual6 = false;

            groupDialog = new Dialog(editSpots.this);
            groupDialog.setTitle("Write the number of students\nyou can teach in a lesson");
            groupDialog.setContentView(R.layout.dialog_template);
            groupMembers = (EditText) groupDialog.findViewById(R.id.editTextGroupMembers);
            saveGroupMembers = (Button) groupDialog.findViewById(R.id.saveGroupMembers);
            groupMembers.setEnabled(true);
            saveGroupMembers.setEnabled(true);

            saveGroupMembers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPrefesSave(groupMembers.getText().toString());
                    SharedPreferences sp = getApplicationContext().getSharedPreferences("members",0);
                    String number = sp.getString("members", null);
                    numberInt6= Integer.parseInt(number);
                    textViewNumber6.setText(number + " students");
                    groupDialog.cancel();

                }
            });
            groupDialog.show();
        }
        if (v == button6i) {
            chosen6 = true;
            button6i.setBackgroundColor(Color.GRAY);
            button6g.setBackgroundResource(android.R.drawable.btn_default);
            individual6 = true;
        }
        if (v == button7g) {
            chosen7 = true;
            button7g.setBackgroundColor(Color.GRAY);
            button7i.setBackgroundResource(android.R.drawable.btn_default);
            individual7 = false;

            groupDialog = new Dialog(editSpots.this);
            groupDialog.setTitle("Write the number of students\nyou can teach in a lesson");
            groupDialog.setContentView(R.layout.dialog_template);
            groupMembers = (EditText) groupDialog.findViewById(R.id.editTextGroupMembers);
            saveGroupMembers = (Button) groupDialog.findViewById(R.id.saveGroupMembers);
            groupMembers.setEnabled(true);
            saveGroupMembers.setEnabled(true);

            saveGroupMembers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPrefesSave(groupMembers.getText().toString());
                    SharedPreferences sp = getApplicationContext().getSharedPreferences("members",0);
                    String number = sp.getString("members", null);
                    numberInt7= Integer.parseInt(number);
                    textViewNumber7.setText(number + " students");
                    groupDialog.cancel();

                }
            });
            groupDialog.show();

        }
        if (v == button7i) {
            chosen7 = true;
            button7i.setBackgroundColor(Color.GRAY);
            button7g.setBackgroundResource(android.R.drawable.btn_default);
            individual7 = true;
        }
        if (v == button8g) {
            chosen8=true;
            button8g.setBackgroundColor(Color.GRAY);
            button8i.setBackgroundResource(android.R.drawable.btn_default);
            individual8 = false;

            groupDialog = new Dialog(editSpots.this);
            groupDialog.setTitle("Write the number of students\nyou can teach in a lesson");
            groupDialog.setContentView(R.layout.dialog_template);
            groupMembers = (EditText) groupDialog.findViewById(R.id.editTextGroupMembers);
            saveGroupMembers = (Button) groupDialog.findViewById(R.id.saveGroupMembers);
            groupMembers.setEnabled(true);
            saveGroupMembers.setEnabled(true);

            saveGroupMembers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPrefesSave(groupMembers.getText().toString());
                    SharedPreferences sp = getApplicationContext().getSharedPreferences("members",0);
                    String number = sp.getString("members", null);
                    numberInt8= Integer.parseInt(number);
                    textViewNumber8.setText(number + " students");
                    groupDialog.cancel();

                }
            });
            groupDialog.show();

        }
        if (v == button8i) {
            chosen8 = true;
            button8i.setBackgroundColor(Color.GRAY);
            button8g.setBackgroundResource(android.R.drawable.btn_default);
            individual8 = true;
        }
        if (v == button9g) {
            chosen9 = true;
            button9g.setBackgroundColor(Color.GRAY);
            button9i.setBackgroundResource(android.R.drawable.btn_default);
            individual9 = false;

            groupDialog = new Dialog(editSpots.this);
            groupDialog.setTitle("Write the number of students\nyou can teach in a lesson");
            groupDialog.setContentView(R.layout.dialog_template);
            groupMembers = (EditText) groupDialog.findViewById(R.id.editTextGroupMembers);
            saveGroupMembers = (Button) groupDialog.findViewById(R.id.saveGroupMembers);
            groupMembers.setEnabled(true);
            saveGroupMembers.setEnabled(true);

            saveGroupMembers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPrefesSave(groupMembers.getText().toString());
                    SharedPreferences sp = getApplicationContext().getSharedPreferences("members",0);
                    String number = sp.getString("members", null);
                    numberInt9= Integer.parseInt(number);
                    textViewNumber9.setText(number + " students");
                    groupDialog.cancel();

                }
            });
            groupDialog.show();

        }
        if (v == button9i) {
            chosen9 = true;
            button9i.setBackgroundColor(Color.GRAY);
            button9g.setBackgroundResource(android.R.drawable.btn_default);
            individual9 = true ;
        }
        if (v == button10g) {
            chosen10 = true;
            button10g.setBackgroundColor(Color.GRAY);
            button10i.setBackgroundResource(android.R.drawable.btn_default);
            individual10 = false;

            groupDialog = new Dialog(editSpots.this);
            groupDialog.setTitle("Write the number of students\nyou can teach in a lesson");
            groupDialog.setContentView(R.layout.dialog_template);
            groupMembers = (EditText) groupDialog.findViewById(R.id.editTextGroupMembers);
            saveGroupMembers = (Button) groupDialog.findViewById(R.id.saveGroupMembers);
            groupMembers.setEnabled(true);
            saveGroupMembers.setEnabled(true);

            saveGroupMembers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPrefesSave(groupMembers.getText().toString());
                    SharedPreferences sp = getApplicationContext().getSharedPreferences("members",0);
                    String number = sp.getString("members", null);
                    numberInt10= Integer.parseInt(number);
                    textViewNumber10.setText(number + " students");
                    groupDialog.cancel();

                }
            });
            groupDialog.show();

        }
        if (v == button10i) {
            chosen10 = true;
            button10i.setBackgroundColor(Color.GRAY);
            button10g.setBackgroundResource(android.R.drawable.btn_default);
            individual10 =true;
        }
        if (v == button11g) {
            chosen11 = true;
            button11g.setBackgroundColor(Color.GRAY);
            button11i.setBackgroundResource(android.R.drawable.btn_default);
            individual11 = false;

            groupDialog = new Dialog(editSpots.this);
            groupDialog.setTitle("Write the number of students\nyou can teach in a lesson");
            groupDialog.setContentView(R.layout.dialog_template);
            groupMembers = (EditText) groupDialog.findViewById(R.id.editTextGroupMembers);
            saveGroupMembers = (Button) groupDialog.findViewById(R.id.saveGroupMembers);
            groupMembers.setEnabled(true);
            saveGroupMembers.setEnabled(true);

            saveGroupMembers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPrefesSave(groupMembers.getText().toString());
                    SharedPreferences sp = getApplicationContext().getSharedPreferences("members",0);
                    String number = sp.getString("members", null);
                    numberInt11= Integer.parseInt(number);
                    textViewNumber11.setText(number + " students");
                    groupDialog.cancel();

                }
            });
            groupDialog.show();

        }
        if (v == button11i) {
            chosen11 = true;
            button11i.setBackgroundColor(Color.GRAY);
            button11g.setBackgroundResource(android.R.drawable.btn_default);
            individual11 = true;
        }
        if (v == button12g) {
            chosen12 = true;
            button12g.setBackgroundColor(Color.GRAY);
            button12i.setBackgroundResource(android.R.drawable.btn_default);
            individual12 = false;

            groupDialog = new Dialog(editSpots.this);
            groupDialog.setTitle("Write the number of students\nyou can teach in a lesson");
            groupDialog.setContentView(R.layout.dialog_template);
            groupMembers = (EditText) groupDialog.findViewById(R.id.editTextGroupMembers);
            saveGroupMembers = (Button) groupDialog.findViewById(R.id.saveGroupMembers);
            groupMembers.setEnabled(true);
            saveGroupMembers.setEnabled(true);

            saveGroupMembers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPrefesSave(groupMembers.getText().toString());
                    SharedPreferences sp = getApplicationContext().getSharedPreferences("members",0);
                    String number = sp.getString("members", null);
                    numberInt12= Integer.parseInt(number);
                    textViewNumber12.setText(number + " students");
                    groupDialog.cancel();

                }
            });
            groupDialog.show();

        }
        if (v == button12i) {
            chosen12 = true;
            button12i.setBackgroundColor(Color.GRAY);
            button12g.setBackgroundResource(android.R.drawable.btn_default);
            individual12=true;
        }
        if (v == button13g) {
            chosen13 = true;
            button13g.setBackgroundColor(Color.GRAY);
            button13i.setBackgroundResource(android.R.drawable.btn_default);
            individual13 = false;

            groupDialog = new Dialog(editSpots.this);
            groupDialog.setTitle("Write the number of students\nyou can teach in a lesson");
            groupDialog.setContentView(R.layout.dialog_template);
            groupMembers = (EditText) groupDialog.findViewById(R.id.editTextGroupMembers);
            saveGroupMembers = (Button) groupDialog.findViewById(R.id.saveGroupMembers);
            groupMembers.setEnabled(true);
            saveGroupMembers.setEnabled(true);

            saveGroupMembers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPrefesSave(groupMembers.getText().toString());
                    SharedPreferences sp = getApplicationContext().getSharedPreferences("members",0);
                    String number = sp.getString("members", null);
                    numberInt13= Integer.parseInt(number);
                    textViewNumber13.setText(number + " students");
                    groupDialog.cancel();

                }
            });
            groupDialog.show();

        }
        if (v == button13i) {
            chosen13 = true;
            button13i.setBackgroundColor(Color.GRAY);
            button13g.setBackgroundResource(android.R.drawable.btn_default);
            individual13 = true;
        }
        if (v == button14g) {
            chosen14 = true;
            button14g.setBackgroundColor(Color.GRAY);
            button14i.setBackgroundResource(android.R.drawable.btn_default);
            individual14 = false;

            groupDialog = new Dialog(editSpots.this);
            groupDialog.setTitle("Write the number of students\nyou can teach in a lesson");
            groupDialog.setContentView(R.layout.dialog_template);
            groupMembers = (EditText) groupDialog.findViewById(R.id.editTextGroupMembers);
            saveGroupMembers = (Button) groupDialog.findViewById(R.id.saveGroupMembers);
            groupMembers.setEnabled(true);
            saveGroupMembers.setEnabled(true);

            saveGroupMembers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPrefesSave(groupMembers.getText().toString());
                    SharedPreferences sp = getApplicationContext().getSharedPreferences("members",0);
                    String number = sp.getString("members", null);
                    numberInt14= Integer.parseInt(number);
                    textViewNumber14.setText(number + " students");
                    groupDialog.cancel();

                }
            });
            groupDialog.show();

        }
        if (v == button14i) {
            chosen14 = true;
            button14i.setBackgroundColor(Color.GRAY);
            button14g.setBackgroundResource(android.R.drawable.btn_default);
            individual14 = true;
        }
        if (v == button15g) {
            chosen15 = true;
            button15g.setBackgroundColor(Color.GRAY);
            button15i.setBackgroundResource(android.R.drawable.btn_default);
            individual15 = false;

            groupDialog = new Dialog(editSpots.this);
            groupDialog.setTitle("Write the number of students\nyou can teach in a lesson");
            groupDialog.setContentView(R.layout.dialog_template);
            groupMembers = (EditText) groupDialog.findViewById(R.id.editTextGroupMembers);
            saveGroupMembers = (Button) groupDialog.findViewById(R.id.saveGroupMembers);
            groupMembers.setEnabled(true);
            saveGroupMembers.setEnabled(true);

            saveGroupMembers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPrefesSave(groupMembers.getText().toString());
                    SharedPreferences sp = getApplicationContext().getSharedPreferences("members",0);
                    String number = sp.getString("members", null);
                    numberInt15= Integer.parseInt(number);
                    textViewNumber15.setText(number + " students");
                    groupDialog.cancel();

                }
            });
            groupDialog.show();

        }
        if (v == button15i) {
            chosen15 = true;
            button15i.setBackgroundColor(Color.GRAY);
            button15g.setBackgroundResource(android.R.drawable.btn_default);
            individual15 = true;
        }
        if (v == button16g) {
            chosen16 = true;
            button16g.setBackgroundColor(Color.GRAY);
            button16i.setBackgroundResource(android.R.drawable.btn_default);
            individual16 = false;

            groupDialog = new Dialog(editSpots.this);
            groupDialog.setTitle("Write the number of students\nyou can teach in a lesson");
            groupDialog.setContentView(R.layout.dialog_template);
            groupMembers = (EditText) groupDialog.findViewById(R.id.editTextGroupMembers);
            saveGroupMembers = (Button) groupDialog.findViewById(R.id.saveGroupMembers);
            groupMembers.setEnabled(true);
            saveGroupMembers.setEnabled(true);

            saveGroupMembers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPrefesSave(groupMembers.getText().toString());
                    SharedPreferences sp = getApplicationContext().getSharedPreferences("members",0);
                    String number = sp.getString("members", null);
                    numberInt16= Integer.parseInt(number);
                    textViewNumber16.setText(number + " students");
                    groupDialog.cancel();

                }
            });
            groupDialog.show();

        }
        if (v == button16i) {
            chosen16 = true;
            button16i.setBackgroundColor(Color.GRAY);
            button16g.setBackgroundResource(android.R.drawable.btn_default);
            individual16 = true;
        }
        if (v == button17g) {
            chosen17 = true;
            button17g.setBackgroundColor(Color.GRAY);
            button17i.setBackgroundResource(android.R.drawable.btn_default);
            individual17 = false;

            groupDialog = new Dialog(editSpots.this);
            groupDialog.setTitle("Write the number of students\nyou can teach in a lesson");
            groupDialog.setContentView(R.layout.dialog_template);
            groupMembers = (EditText) groupDialog.findViewById(R.id.editTextGroupMembers);
            saveGroupMembers = (Button) groupDialog.findViewById(R.id.saveGroupMembers);
            groupMembers.setEnabled(true);
            saveGroupMembers.setEnabled(true);

            saveGroupMembers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPrefesSave(groupMembers.getText().toString());
                    SharedPreferences sp = getApplicationContext().getSharedPreferences("members",0);
                    String number = sp.getString("members", null);
                    numberInt17= Integer.parseInt(number);
                    textViewNumber17.setText(number + " students");
                    groupDialog.cancel();

                }
            });
            groupDialog.show();

        }
        if (v == button17i) {
            chosen17 = true;
            button17i.setBackgroundColor(Color.GRAY);
            button17g.setBackgroundResource(android.R.drawable.btn_default);
            individual17 = true;
        }
        if (v == button18g) {
            chosen18 = true;
            button18g.setBackgroundColor(Color.GRAY);
            button18i.setBackgroundResource(android.R.drawable.btn_default);
            individual18 = false;

            groupDialog = new Dialog(editSpots.this);
            groupDialog.setTitle("Write the number of students\nyou can teach in a lesson");
            groupDialog.setContentView(R.layout.dialog_template);
            groupMembers = (EditText) groupDialog.findViewById(R.id.editTextGroupMembers);
            saveGroupMembers = (Button) groupDialog.findViewById(R.id.saveGroupMembers);
            groupMembers.setEnabled(true);
            saveGroupMembers.setEnabled(true);

            saveGroupMembers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPrefesSave(groupMembers.getText().toString());
                    SharedPreferences sp = getApplicationContext().getSharedPreferences("members",0);
                    String number = sp.getString("members", null);
                    numberInt18= Integer.parseInt(number);
                    textViewNumber18.setText(number + " students");
                    groupDialog.cancel();

                }
            });
            groupDialog.show();

        }
        if (v == button18i) {
            chosen18 = true;
            button18i.setBackgroundColor(Color.GRAY);
            button18g.setBackgroundResource(android.R.drawable.btn_default);
            individual18 = true;
        }
        if (v == button19g) {
            chosen19 = true;
            button19g.setBackgroundColor(Color.GRAY);
            button19i.setBackgroundResource(android.R.drawable.btn_default);
            individual19 = false;

            groupDialog = new Dialog(editSpots.this);
            groupDialog.setTitle("Write the number of students\nyou can teach in a lesson");
            groupDialog.setContentView(R.layout.dialog_template);
            groupMembers = (EditText) groupDialog.findViewById(R.id.editTextGroupMembers);
            saveGroupMembers = (Button) groupDialog.findViewById(R.id.saveGroupMembers);
            groupMembers.setEnabled(true);
            saveGroupMembers.setEnabled(true);

            saveGroupMembers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPrefesSave(groupMembers.getText().toString());
                    SharedPreferences sp = getApplicationContext().getSharedPreferences("members",0);
                    String number = sp.getString("members", null);
                    numberInt19= Integer.parseInt(number);
                    textViewNumber19.setText(number + " students");
                    groupDialog.cancel();

                }
            });
            groupDialog.show();

        }
        if (v == button19i) {
            chosen19 = true;
            button19i.setBackgroundColor(Color.GRAY);
            button19g.setBackgroundResource(android.R.drawable.btn_default);
            individual19 = true;
        }
        if (v == button20g) {
            chosen20 = true;
            button20g.setBackgroundColor(Color.GRAY);
            button20i.setBackgroundResource(android.R.drawable.btn_default);
            individual20 = false;

            groupDialog = new Dialog(editSpots.this);
            groupDialog.setTitle("Write the number of students\nyou can teach in a lesson");
            groupDialog.setContentView(R.layout.dialog_template);
            groupMembers = (EditText) groupDialog.findViewById(R.id.editTextGroupMembers);
            saveGroupMembers = (Button) groupDialog.findViewById(R.id.saveGroupMembers);
            groupMembers.setEnabled(true);
            saveGroupMembers.setEnabled(true);

            saveGroupMembers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPrefesSave(groupMembers.getText().toString());
                    SharedPreferences sp = getApplicationContext().getSharedPreferences("members",0);
                    String number = sp.getString("members", null);
                    numberInt20= Integer.parseInt(number);
                    textViewNumber20.setText(number + " students");
                    groupDialog.cancel();

                }
            });
            groupDialog.show();

        }
        if (v == button20i) {
            chosen20 = true;
            button20i.setBackgroundColor(Color.GRAY);
            button20g.setBackgroundResource(android.R.drawable.btn_default);
            individual20 = true;
        }
        if (v == button21g) {
            chosen21 = true;
            button21g.setBackgroundColor(Color.GRAY);
            button21i.setBackgroundResource(android.R.drawable.btn_default);
            individual21 = false;

            groupDialog = new Dialog(editSpots.this);
            groupDialog.setTitle("Write the number of students\nyou can teach in a lesson");
            groupDialog.setContentView(R.layout.dialog_template);
            groupMembers = (EditText) groupDialog.findViewById(R.id.editTextGroupMembers);
            saveGroupMembers = (Button) groupDialog.findViewById(R.id.saveGroupMembers);
            groupMembers.setEnabled(true);
            saveGroupMembers.setEnabled(true);

            saveGroupMembers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPrefesSave(groupMembers.getText().toString());
                    SharedPreferences sp = getApplicationContext().getSharedPreferences("members",0);
                    String number = sp.getString("members", null);
                    numberInt21= Integer.parseInt(number);
                    textViewNumber21.setText(number + " students");
                    groupDialog.cancel();

                }
            });
            groupDialog.show();

        }
        if (v == button21i) {
            chosen21 = true;
            button21i.setBackgroundColor(Color.GRAY);
            button21g.setBackgroundResource(android.R.drawable.btn_default);
            individual21 = true;
        }
        if (v == button22g) {
            chosen22 = true;
            button22g.setBackgroundColor(Color.GRAY);
            button22i.setBackgroundResource(android.R.drawable.btn_default);
            individual22 = false;

            groupDialog = new Dialog(editSpots.this);
            groupDialog.setTitle("Write the number of students\nyou can teach in a lesson");
            groupDialog.setContentView(R.layout.dialog_template);
            groupMembers = (EditText) groupDialog.findViewById(R.id.editTextGroupMembers);
            saveGroupMembers = (Button) groupDialog.findViewById(R.id.saveGroupMembers);
            groupMembers.setEnabled(true);
            saveGroupMembers.setEnabled(true);

            saveGroupMembers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPrefesSave(groupMembers.getText().toString());
                    SharedPreferences sp = getApplicationContext().getSharedPreferences("members",0);
                    String number = sp.getString("members", null);
                    numberInt22= Integer.parseInt(number);
                    textViewNumber22.setText(number + " students");
                    groupDialog.cancel();

                }
            });
            groupDialog.show();

        }
        if (v == button22i) {
            chosen22 = true;
            button22i.setBackgroundColor(Color.GRAY);
            button22g.setBackgroundResource(android.R.drawable.btn_default);
            individual22 = true;
        }
        if (v == button23g) {
            chosen23 = true;
            button23g.setBackgroundColor(Color.GRAY);
            button23i.setBackgroundResource(android.R.drawable.btn_default);
            individual23 = false;

            groupDialog = new Dialog(editSpots.this);
            groupDialog.setTitle("Write the number of students\nyou can teach in a lesson");
            groupDialog.setContentView(R.layout.dialog_template);
            groupMembers = (EditText) groupDialog.findViewById(R.id.editTextGroupMembers);
            saveGroupMembers = (Button) groupDialog.findViewById(R.id.saveGroupMembers);
            groupMembers.setEnabled(true);
            saveGroupMembers.setEnabled(true);

            saveGroupMembers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPrefesSave(groupMembers.getText().toString());
                    SharedPreferences sp = getApplicationContext().getSharedPreferences("members",0);
                    String number = sp.getString("members", null);
                    numberInt23= Integer.parseInt(number);
                    textViewNumber23.setText(number + " students");
                    groupDialog.cancel();

                }
            });
            groupDialog.show();

        }
        if (v == button23i) {
            chosen23 = true;
            button23i.setBackgroundColor(Color.GRAY);
            button23g.setBackgroundResource(android.R.drawable.btn_default);
            individual23 = true;
        }

        if (v == done ) {

            String instructor_id = databaseReference.push().getKey();
            firebaseUser=firebaseAuth.getCurrentUser();

            if(chosen6){
                if(individual6){
                    spot = new Spot( instructor_id, date,  "6:00", 0, true,  true);
                    databaseReference.child(instructor_id).setValue(spot);
                }
                else {
                    spot = new Spot( instructor_id, date,  "6:00", numberInt6, true,  false);
                    databaseReference.child(instructor_id).setValue(spot);
                }

            }
            if(chosen7){
                if(individual7){
                    spot = new Spot( instructor_id, date,  "7:00", 0, true,  true);
                    databaseReference.child(instructor_id).setValue(spot);
                }
                else {
                    spot = new Spot( instructor_id, date,  "7:00", numberInt7, true,  false);
                    databaseReference.child(instructor_id).setValue(spot);
                }
                if(chosen8){
                    if(individual8){
                        spot = new Spot( instructor_id, date,  "8:00", 0, true,  true);
                        databaseReference.child(instructor_id).setValue(spot);
                    }
                    else {
                        spot = new Spot( instructor_id, date,  "8:00", numberInt8, true,  false);
                        databaseReference.child(instructor_id).setValue(spot);
                    }

                }
                if(chosen9){
                    if(individual9){
                        spot = new Spot( instructor_id, date,  "9:00", 0, true,  true);
                        databaseReference.child(instructor_id).setValue(spot);
                    }
                    else {
                        spot = new Spot( instructor_id, date,  "9:00", numberInt9, true,  false);
                        databaseReference.child(instructor_id).setValue(spot);
                    }

                }
                if(chosen10){
                    if(individual10){
                        spot = new Spot( instructor_id, date,  "10:00", 0, true,  true);
                        databaseReference.child(instructor_id).setValue(spot);
                    }
                    else {
                        spot = new Spot( instructor_id, date,  "10:00", numberInt10, true,  false);
                        databaseReference.child(instructor_id).setValue(spot);
                    }

                }
                if(chosen11){
                    if(individual11){
                        spot = new Spot( instructor_id, date,  "11:00", 0, true,  true);
                        databaseReference.child(instructor_id).setValue(spot);
                    }
                    else {
                        spot = new Spot( instructor_id, date,  "11:00", numberInt11, true,  false);
                        databaseReference.child(instructor_id).setValue(spot);
                    }

                }
                if(chosen12){
                    if(individual12){
                        spot = new Spot( instructor_id, date,  "12:00", 0, true,  true);
                        databaseReference.child(instructor_id).setValue(spot);
                    }
                    else {
                        spot = new Spot( instructor_id, date,  "12:00", numberInt12, true,  false);
                        databaseReference.child(instructor_id).setValue(spot);
                    }

                }
                if(chosen13){
                    if(individual13){
                        spot = new Spot( instructor_id, date,  "13:00", 0, true,  true);
                        databaseReference.child(instructor_id).setValue(spot);
                    }
                    else {
                        spot = new Spot( instructor_id, date,  "6:00", numberInt13, true,  false);
                        databaseReference.child(instructor_id).setValue(spot);
                    }

                }
                if(chosen14){
                    if(individual14){
                        spot = new Spot( instructor_id, date,  "14:00", 0, true,  true);
                        databaseReference.child(instructor_id).setValue(spot);
                    }
                    else {
                        spot = new Spot( instructor_id, date,  "14:00", numberInt14, true,  false);
                        databaseReference.child(instructor_id).setValue(spot);
                    }

                }
                if(chosen15){
                    if(individual15){
                        spot = new Spot( instructor_id, date,  "15:00", 0, true,  true);
                        databaseReference.child(instructor_id).setValue(spot);
                    }
                    else {
                        spot = new Spot( instructor_id, date,  "15:00", numberInt15, true,  false);
                        databaseReference.child(instructor_id).setValue(spot);
                    }

                }
                if(chosen16){
                    if(individual16){
                        spot = new Spot( instructor_id, date,  "16:00", 0, true,  true);
                        databaseReference.child(instructor_id).setValue(spot);
                    }
                    else {
                        spot = new Spot( instructor_id, date,  "16:00", numberInt16, true,  false);
                        databaseReference.child(instructor_id).setValue(spot);
                    }

                }
                if(chosen17){
                    if(individual17){
                        spot = new Spot( instructor_id, date,  "17:00", 0, true,  true);
                        databaseReference.child(instructor_id).setValue(spot);
                    }
                    else {
                        spot = new Spot( instructor_id, date,  "17:00", numberInt17, true,  false);
                        databaseReference.child(instructor_id).setValue(spot);
                    }

                }
                if(chosen18){
                    if(individual18){
                        spot = new Spot( instructor_id, date,  "18:00", 0, true,  true);
                        databaseReference.child(instructor_id).setValue(spot);
                    }
                    else {
                        spot = new Spot( instructor_id, date,  "18:00", numberInt18, true,  false);
                        databaseReference.child(instructor_id).setValue(spot);
                    }

                }
                if(chosen19){
                    if(individual19){
                        spot = new Spot( instructor_id, date,  "19:00", 0, true,  true);
                        databaseReference.child(instructor_id).setValue(spot);
                    }
                    else {
                        spot = new Spot( instructor_id, date,  "19:00", numberInt19, true,  false);
                        databaseReference.child(instructor_id).setValue(spot);
                    }

                }
                if(chosen20){
                    if(individual20){
                        spot = new Spot( instructor_id, date,  "20:00", 0, true,  true);
                        databaseReference.child(instructor_id).setValue(spot);
                    }
                    else {
                        spot = new Spot( instructor_id, date,  "20:00", numberInt20, true,  false);
                        databaseReference.child(instructor_id).setValue(spot);
                    }

                }
                if(chosen21){
                    if(individual21){
                        spot = new Spot( instructor_id, date,  "21:00", 0, true,  true);
                        databaseReference.child(instructor_id).setValue(spot);
                    }
                    else {
                        spot = new Spot( instructor_id, date,  "21:00", numberInt21, true,  false);
                        databaseReference.child(instructor_id).setValue(spot);
                    }

                }
                if(chosen22){
                    if(individual22){
                        spot = new Spot( instructor_id, date,  "22:00", 0, true,  true);
                        databaseReference.child(instructor_id).setValue(spot);
                    }
                    else {
                        spot = new Spot( instructor_id, date,  "22:00", numberInt22, true,  false);
                        databaseReference.child(instructor_id).setValue(spot);
                    }

                }
                if(chosen23){
                    if(individual23){
                        spot = new Spot( instructor_id, date,  "23:00", 0, true,  true);
                        databaseReference.child(instructor_id).setValue(spot);
                    }
                    else {
                        spot = new Spot( instructor_id, date,  "23:00", numberInt23, true,  false);
                        databaseReference.child(instructor_id).setValue(spot);
                    }

                }

            }

        }

    }

    public void SharedPrefesSave (String members){

        SharedPreferences prefs = getApplicationContext().getSharedPreferences("members", 0);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("members", members);
        prefEdit.commit();
    }
}
