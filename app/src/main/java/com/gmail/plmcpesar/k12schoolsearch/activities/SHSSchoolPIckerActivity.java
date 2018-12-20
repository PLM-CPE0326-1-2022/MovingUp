package com.gmail.plmcpesar.k12schoolsearch.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.gmail.plmcpesar.k12schoolsearch.R;

public class SHSSchoolPIckerActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar mToolbar;

    private CheckBox[] pick;
    private ImageView resultImage;
    private Button submitpick;

    int checkcounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shsschool_picker);

        mToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.shspicker_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("SHS Program Adviser");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pick = new CheckBox[]{
                (CheckBox)findViewById(R.id.pick1), (CheckBox)findViewById(R.id.pick2),
                (CheckBox)findViewById(R.id.pick3), (CheckBox)findViewById(R.id.pick4),
                (CheckBox)findViewById(R.id.pick5), (CheckBox)findViewById(R.id.pick6),
                (CheckBox)findViewById(R.id.pick7), (CheckBox)findViewById(R.id.pick8),
                (CheckBox)findViewById(R.id.pick9), (CheckBox)findViewById(R.id.pick10),
                (CheckBox)findViewById(R.id.pick11), (CheckBox)findViewById(R.id.pick12),
                (CheckBox)findViewById(R.id.pick13), (CheckBox)findViewById(R.id.pick14),
                (CheckBox)findViewById(R.id.pick15), (CheckBox)findViewById(R.id.pick16),
                (CheckBox)findViewById(R.id.pick17), (CheckBox)findViewById(R.id.pick18),
                (CheckBox)findViewById(R.id.pick19), (CheckBox)findViewById(R.id.pick20),
                (CheckBox)findViewById(R.id.pick21), (CheckBox)findViewById(R.id.pick22),
                (CheckBox)findViewById(R.id.pick23), (CheckBox)findViewById(R.id.pick24),
                (CheckBox)findViewById(R.id.pick25), (CheckBox)findViewById(R.id.pick26),
                (CheckBox)findViewById(R.id.pick27), (CheckBox)findViewById(R.id.pick28),
                (CheckBox)findViewById(R.id.pick29), (CheckBox)findViewById(R.id.pick30),
                (CheckBox)findViewById(R.id.pick31), (CheckBox)findViewById(R.id.pick32),
                (CheckBox)findViewById(R.id.pick33), (CheckBox)findViewById(R.id.pick34),
                (CheckBox)findViewById(R.id.pick35), (CheckBox)findViewById(R.id.pick36),
                (CheckBox)findViewById(R.id.pick37), (CheckBox)findViewById(R.id.pick38),
                (CheckBox)findViewById(R.id.pick39), (CheckBox)findViewById(R.id.pick40),
                (CheckBox)findViewById(R.id.pick41)
        };

        for(CheckBox picktemp:pick){
            picktemp.setOnCheckedChangeListener(picktemplistener);
        }
        submitpick = (Button) findViewById(R.id.result_button);

        submitpick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pick[0].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickstem);
                }
                else if (pick[1].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickabm);
                }
                else if (pick[2].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickgas);
                }
                else if (pick[3].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickhumms);
                }
                else if (pick[4].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickhe);
                }
                else if (pick[5].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickict);
                }
                else if (pick[6].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickagrifishery);
                }
                else if (pick[7].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickindustrial);
                }
                else if (pick[8].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.picksport);
                }
                else if (pick[9].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickarts);
                }
                else if (pick[10].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickstem);
                }
                else if (pick[11].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickabm);
                }
                else if (pick[12].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickgas);
                }
                else if (pick[13].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickhumms);
                }
                else if (pick[14].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickhe);
                }
                else if (pick[15].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickict);
                }
                else if (pick[16].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickagrifishery);
                }
                else if (pick[17].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.picksport);
                }
                else if (pick[18].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickarts);
                }
                else if (pick[19].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickstem);
                }
                else if (pick[20].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickabm);
                }
                else if (pick[21].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickgas);
                }
                else if (pick[22].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickhe);
                }
                else if (pick[23].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickict);
                }
                else if (pick[24].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickhe);
                }
                else if (pick[25].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickagrifishery);
                }
                else if (pick[26].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickarts);
                }
                else if (pick[27].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickstem);
                }
                else if (pick[28].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickabm);
                }
                else if (pick[29].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickhumms);
                }
                else if (pick[30].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickhe);
                }
                else if (pick[31].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickict);
                }
                else if (pick[32].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickarts);
                }
                else if (pick[33].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickstem);
                }
                else if (pick[34].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickabm);
                }
                else if (pick[35].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickhumms);
                }
                else if (pick[36].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickarts);
                }
                else if (pick[37].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickabm);
                }
                else if (pick[38].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickhumms);
                }
                else if (pick[39].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickarts);
                }
                else if (pick[40].isChecked()==true){
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickhumms);
                }

                else {
                    ImageView image = (ImageView) findViewById(R.id.pickresult_image);
                    image.setImageResource(R.drawable.pickresult);
                }

            }
        });

    }

    CompoundButton.OnCheckedChangeListener picktemplistener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            checkEnoughAndMakeDisabled(pick);
        }
    };

    private void checkEnoughAndMakeDisabled(CheckBox checkBoxes[])
    {
        int countChecked =0;
        for (CheckBox cb:checkBoxes){
            cb.setEnabled(true);
            if (cb.isChecked()) countChecked++;
        }
        //your variable
        if (1 <= countChecked) {
            for (CheckBox cb:checkBoxes){
                if (!cb.isChecked())cb.setEnabled(false);
            }
        }

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