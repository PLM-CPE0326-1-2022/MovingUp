package com.gmail.plmcpesar.k12schoolsearch.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.gmail.plmcpesar.k12schoolsearch.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserProfileActivity extends AppCompatActivity {

    private TextView userName, userProfilename, userCountry;
    private CircleImageView userProfileimage;

    private DatabaseReference profileUserRef;
    private FirebaseAuth mAuth;

    private String currentUserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        mAuth = FirebaseAuth.getInstance();
        currentUserID = mAuth.getCurrentUser().getUid();
        profileUserRef = FirebaseDatabase.getInstance().getReference().child("Users").child(currentUserID);

        userName = (TextView) findViewById(R.id.user_username);
        userProfilename = (TextView) findViewById(R.id.user_profile_name);
        userCountry = (TextView) findViewById(R.id.user_country);
        userProfileimage = (CircleImageView) findViewById(R.id.user_profile_pic);

        profileUserRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    String myProfileImage = dataSnapshot.child("profileimage").getValue().toString();
                    String myuserName = dataSnapshot.child("username").getValue().toString();
                    String myUserProfilename = dataSnapshot.child("fullname").getValue().toString();
                    String myuserCountry = dataSnapshot.child("country").getValue().toString();

                    Picasso.get().load(myProfileImage).placeholder(R.drawable.profile).into(userProfileimage);
                    userName.setText(myuserName);
                    userProfilename.setText(myUserProfilename);
                    userCountry.setText(myuserCountry);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
