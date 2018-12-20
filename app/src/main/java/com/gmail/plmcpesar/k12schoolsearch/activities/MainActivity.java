package com.gmail.plmcpesar.k12schoolsearch.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.gmail.plmcpesar.k12schoolsearch.BlankActivity;
import com.gmail.plmcpesar.k12schoolsearch.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private RecyclerView postList;
    private android.support.v7.widget.Toolbar mToolbar;
    private ImageButton BtnAbout;
    private ImageButton BtnMaps;
    private ImageButton BtnAllschools;
    private ImageButton BtnFav;
    private ImageButton BtnShsprog;
    private ImageButton BtnFaq;
    private FloatingActionButton mFab;

    private CircleImageView NavProfileImage;
    private TextView NavProfileUserName;

    private FirebaseAuth mAuth;
    private DatabaseReference UsersRef, PostsRef;

    String currentUserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser() == null) {
            SendUserToLoginActivity();
        }
        else{
            currentUserID = mAuth.getCurrentUser().getUid();
        }

        UsersRef = FirebaseDatabase.getInstance().getReference().child("Users");
        PostsRef = FirebaseDatabase.getInstance().getReference().child("Posts");

        mToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Home");

        drawerLayout = (DrawerLayout) findViewById(R.id.drawable_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);


        View navView = navigationView.inflateHeaderView(R.layout.navigation_header);
        NavProfileImage = (CircleImageView) navView.findViewById(R.id.nav_profile_image);
        NavProfileUserName = (TextView) navView.findViewById(R.id.nav_user_full_name);

        mFab = (FloatingActionButton) findViewById(R.id.SearchFAB);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchIntent = new Intent(MainActivity.this, ClassifiedSearchActivity.class);
                startActivity(searchIntent);
            }
        });

        UsersRef.child(currentUserID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                if(dataSnapshot.exists())
                {
                    if(dataSnapshot.hasChild("username"))                    {
                        String fullname = dataSnapshot.child("username").getValue().toString();
                        NavProfileUserName.setText(fullname);
                    }
                    if(dataSnapshot.hasChild("profileimage"))
                    {
                        String image = dataSnapshot.child("profileimage").getValue().toString();
                        Picasso.get().load(image).placeholder(R.drawable.profile).into(NavProfileImage);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Profile name do not exists...", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                UserMenuSelector(item);
                return false;
            }
        });

        BtnAbout = (ImageButton)findViewById(R.id.homemenu_about);
        BtnAllschools = (ImageButton)findViewById(R.id.homemenu_allschools);
        BtnFaq = (ImageButton)findViewById(R.id.homemenu_faq);
        BtnFav = (ImageButton)findViewById(R.id.homemenu_favorites);
        BtnMaps = (ImageButton)findViewById(R.id.homemenu_maps);
        BtnShsprog = (ImageButton)findViewById(R.id.homemenu_shsprog);

        BtnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setupIntent = new Intent(MainActivity.this, DisplayAboutAppActivity.class);
                startActivity(setupIntent);
            }
        });
        BtnAllschools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setupIntent = new Intent(MainActivity.this, SchoolList.class);
                startActivity(setupIntent);
            }
        });
        BtnFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setupIntent = new Intent(MainActivity.this, SHSSchoolPIckerActivity.class);
                startActivity(setupIntent);
            }
        });
        BtnFaq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent faqIntent = new Intent(MainActivity.this, FAQActivity.class);
                startActivity(faqIntent);
            }
        });
        BtnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setupIntent = new Intent(MainActivity.this, SchoolSearchMapActivity.class);
                startActivity(setupIntent);
            }
        });
        BtnShsprog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setupIntent = new Intent(MainActivity.this, ProgramsActivity.class);
                startActivity(setupIntent);
            }
        });
    }



    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser == null){
            SendUserToLoginActivity();
        }
        else
        {
            CheckUserExistence();
        }
    }

    private void CheckUserExistence()
    {
        final String current_user_id = mAuth.getCurrentUser().getUid();

        UsersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                if(!dataSnapshot.hasChild(current_user_id))
                {
                    SendUserToSetupActivity();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void SendUserToSetupActivity()
    {
        Intent setupIntent = new Intent(MainActivity.this, SetupUserAccountActivity.class);
        setupIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(setupIntent);
        finish();
    }

    private void SendUserToLoginActivity()
    {
        Intent loginIntent = new Intent(MainActivity.this, LoginUserAccActivity.class);
        loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(loginIntent);
        finish();
    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void UserMenuSelector(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.nav_profile:
                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
                SendUserToUserProfileActivity();
                break;

            case R.id.nav_shsprograms:
                Toast.makeText(this, "SHS Programs", Toast.LENGTH_SHORT).show();
                SendUserToSHSProgramsActivity();
                break;

            case R.id.nav_schools:
                Toast.makeText(this, "All Schools", Toast.LENGTH_SHORT).show();
                SendUserToAllSchoolsActivity();
                break;

            case R.id.nav_find_schools:
                Toast.makeText(this, "Find Schools", Toast.LENGTH_SHORT).show();
                SendUserToSearchActivity();
                break;

            case R.id.nav_aboutus:
                Toast.makeText(this, "About Us", Toast.LENGTH_SHORT).show();
                SendUserToAboutUsActivity();
                break;

            case R.id.nav_Logout:
                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
                mAuth.signOut();
                SendUserToOnBoardActivity();
                break;
        }
    }

    private void SendUserToSchoolListActivity() {
        Intent schoollistIntent = new Intent(MainActivity.this, SchoolList.class);
        startActivity(schoollistIntent);
}

    private void SendUserToAllSchoolsActivity() {
        Intent allschoolIntent = new Intent(MainActivity.this, SchoolList.class);
        startActivity(allschoolIntent);
    }

    private void SendUserToSHSProgramsActivity() {
        Intent shsprogramsIntent = new Intent(MainActivity.this, ProgramsActivity.class);
        startActivity(shsprogramsIntent);
    }

    private void SendUserToSearchActivity() {
        Intent searchschoolIntent = new Intent(MainActivity.this, ClassifiedSearchActivity.class);
        startActivity(searchschoolIntent);
    }

    private void SendUserToAboutUsActivity() {
        Intent aboutusIntent = new Intent(MainActivity.this, DisplayAboutAppActivity.class);
        startActivity(aboutusIntent);
    }

    private void SendUserToBlankActivity() {
        Intent blankIntent = new Intent(MainActivity.this, BlankActivity.class);
        startActivity(blankIntent);
    }


    private void SendUserToUserProfileActivity() {
        Intent profileIntent = new Intent(MainActivity.this, UserProfileActivity.class);
        startActivity(profileIntent);
    }

    private void SendUserToOnBoardActivity() {
        Intent mainIntent = new Intent(MainActivity.this, OnboardingScreenActivity.class);
        mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(mainIntent);
        finish();
    }

}
