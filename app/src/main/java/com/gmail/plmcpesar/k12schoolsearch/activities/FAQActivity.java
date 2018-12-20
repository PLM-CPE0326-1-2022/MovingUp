package com.gmail.plmcpesar.k12schoolsearch.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.gmail.plmcpesar.k12schoolsearch.R;

public class FAQActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar mToolbar;
    private CheckBox questionbtn1, questionbtn2, questionbtn3, questionbtn4 , questionbtn5,
                     questionbtn6, questionbtn7, questionbtn8, questionbtn9 , questionbtn10,
                     questionbtn11, questionbtn12, questionbtn13, questionbtn14 , questionbtn15,
                     questionbtn16, questionbtn17, questionbtn18, questionbtn19;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        mToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.shsfaq_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("SHS FAQs");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        questionbtn1 = (CheckBox) findViewById(R.id.question1);
        questionbtn2 = (CheckBox) findViewById(R.id.question2);
        questionbtn3 = (CheckBox) findViewById(R.id.question3);
        questionbtn4 = (CheckBox) findViewById(R.id.question4);
        questionbtn5 = (CheckBox) findViewById(R.id.question5);
        questionbtn6 = (CheckBox) findViewById(R.id.question6);
        questionbtn7 = (CheckBox) findViewById(R.id.question7);
        questionbtn8 = (CheckBox) findViewById(R.id.question8);
        questionbtn9 = (CheckBox) findViewById(R.id.question9);
        questionbtn10 = (CheckBox) findViewById(R.id.question10);
        questionbtn11 = (CheckBox) findViewById(R.id.question11);
        questionbtn12 = (CheckBox) findViewById(R.id.question12);
        questionbtn13 = (CheckBox) findViewById(R.id.question13);
        questionbtn14 = (CheckBox) findViewById(R.id.question14);
        questionbtn15 = (CheckBox) findViewById(R.id.question15);
        questionbtn16 = (CheckBox) findViewById(R.id.question16);
        questionbtn17 = (CheckBox) findViewById(R.id.question17);
        questionbtn18 = (CheckBox) findViewById(R.id.question18);
        questionbtn19 = (CheckBox) findViewById(R.id.question19);



        questionbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionbtn1.isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.answer1);
                    image.setImageResource(R.drawable.faq1);
                }
                else{
                    ImageView image = (ImageView) findViewById(R.id.answer1);
                    image.setImageResource(0);
                }
            }
        });
        questionbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionbtn2.isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.answer2);
                    image.setImageResource(R.drawable.faq2);
                }
                else{
                    ImageView image = (ImageView) findViewById(R.id.answer2);
                    image.setImageResource(0);
                }
            }
        });

        questionbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionbtn3.isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.answer3);
                    image.setImageResource(R.drawable.faq3);
                }
                else{
                    ImageView image = (ImageView) findViewById(R.id.answer3);
                    image.setImageResource(0);
                }
            }
        });
        questionbtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionbtn4.isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.answer4);
                    image.setImageResource(R.drawable.faq4);
                }
                else{
                    ImageView image = (ImageView) findViewById(R.id.answer4);
                    image.setImageResource(0);
                }
            }
        });

        questionbtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionbtn5.isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.answer5);
                    image.setImageResource(R.drawable.faq5);
                }
                else{
                    ImageView image = (ImageView) findViewById(R.id.answer5);
                    image.setImageResource(0);
                }
            }
        });
        questionbtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionbtn6.isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.answer6);
                    image.setImageResource(R.drawable.faq6);
                }
                else{
                    ImageView image = (ImageView) findViewById(R.id.answer6);
                    image.setImageResource(0);
                }
            }
        });

        questionbtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionbtn7.isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.answer7);
                    image.setImageResource(R.drawable.faq7);
                }
                else{
                    ImageView image = (ImageView) findViewById(R.id.answer7);
                    image.setImageResource(0);
                }
            }
        });
        questionbtn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionbtn8.isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.answer8);
                    image.setImageResource(R.drawable.faq8);
                }
                else{
                    ImageView image = (ImageView) findViewById(R.id.answer8);
                    image.setImageResource(0);
                }
            }
        });

        questionbtn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionbtn9.isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.answer9);
                    image.setImageResource(R.drawable.faq9);
                }
                else{
                    ImageView image = (ImageView) findViewById(R.id.answer9);
                    image.setImageResource(0);
                }
            }
        });
        questionbtn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionbtn10.isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.answer10);
                    image.setImageResource(R.drawable.faq10);
                }
                else{
                    ImageView image = (ImageView) findViewById(R.id.answer10);
                    image.setImageResource(0);
                }
            }
        });

        questionbtn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionbtn11.isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.answer11);
                    image.setImageResource(R.drawable.faq11);
                }
                else{
                    ImageView image = (ImageView) findViewById(R.id.answer11);
                    image.setImageResource(0);
                }
            }
        });
        questionbtn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionbtn12.isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.answer12);
                    image.setImageResource(R.drawable.faq12);
                }
                else{
                    ImageView image = (ImageView) findViewById(R.id.answer12);
                    image.setImageResource(0);
                }
            }
        });

        questionbtn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionbtn13.isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.answer13);
                    image.setImageResource(R.drawable.faq13);
                }
                else{
                    ImageView image = (ImageView) findViewById(R.id.answer13);
                    image.setImageResource(0);
                }
            }
        });
        questionbtn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionbtn14.isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.answer14);
                    image.setImageResource(R.drawable.faq14);
                }
                else{
                    ImageView image = (ImageView) findViewById(R.id.answer14);
                    image.setImageResource(0);
                }
            }
        });

        questionbtn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionbtn15.isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.answer15);
                    image.setImageResource(R.drawable.faq15);
                }
                else{
                    ImageView image = (ImageView) findViewById(R.id.answer15);
                    image.setImageResource(0);
                }
            }
        });
        questionbtn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionbtn16.isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.answer16);
                    image.setImageResource(R.drawable.faq16);
                }
                else{
                    ImageView image = (ImageView) findViewById(R.id.answer16);
                    image.setImageResource(0);
                }
            }
        });

        questionbtn17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionbtn17.isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.answer17);
                    image.setImageResource(R.drawable.faq17);
                }
                else{
                    ImageView image = (ImageView) findViewById(R.id.answer17);
                    image.setImageResource(0);
                }
            }
        });
        questionbtn18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionbtn18.isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.answer18);
                    image.setImageResource(R.drawable.faq18);
                }
                else{
                    ImageView image = (ImageView) findViewById(R.id.answer18);
                    image.setImageResource(0);
                }
            }
        });

        questionbtn19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionbtn19.isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.answer19);
                    image.setImageResource(R.drawable.faq19);
                }
                else{
                    ImageView image = (ImageView) findViewById(R.id.answer19);
                    image.setImageResource(0);
                }
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
