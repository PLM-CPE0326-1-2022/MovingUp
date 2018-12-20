package com.gmail.plmcpesar.k12schoolsearch.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.gmail.plmcpesar.k12schoolsearch.R;
import com.gmail.plmcpesar.k12schoolsearch.models.Schools;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class SearchActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar mToolbar;
    private EditText SearchText;
    private ImageButton Searchbtn;
    private RecyclerView searchrview;
    private DatabaseReference SearchRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        SearchRef = FirebaseDatabase.getInstance().getReference().child("SchoolList");

        mToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.search_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Search Schools");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        searchrview = (RecyclerView) findViewById(R.id.searchlist_view);
        searchrview.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(false);
        linearLayoutManager.setStackFromEnd(false);
        searchrview.setLayoutManager(linearLayoutManager);

        SearchText = (EditText) findViewById(R.id.searchtext);
        Searchbtn = (ImageButton) findViewById(R.id.btn_searchschool);
        Searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchText = SearchText.getText().toString();
                DisplaySchoolList(searchText);
            }
        });
    }

    private void DisplaySchoolList(String searchText) {
        Toast.makeText(SearchActivity.this, "Started Search", Toast.LENGTH_LONG).show();

        Query firebaseSearchQuery = SearchRef.orderByChild("schoolname").startAt(searchText).endAt(searchText + "\uf8ff");

        FirebaseRecyclerAdapter<Schools, SearchSchoolViewHolder > firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Schools, SearchSchoolViewHolder>(
                Schools.class,
                R.layout.schoollists,
                SearchSchoolViewHolder.class,
                firebaseSearchQuery
        ) {
            @Override
            protected void populateViewHolder(SearchSchoolViewHolder viewHolder, Schools model, int position) {
                viewHolder.setSchoolname(model.getSchoolname());
                viewHolder.setStrandoffers(model.getStrandoffers());
                viewHolder.setTrackoffers(model.getTrackoffers());
                viewHolder.setSchooltype(model.getSchooltype());
                viewHolder.setSchoollocation(model.getSchoollocation());
                viewHolder.setSchoollogo(getApplicationContext(), model.getSchoollogo());
                viewHolder.setSchoolimage(getApplicationContext(), model.getSchoolimage());
            }
        };
        searchrview.setAdapter(firebaseRecyclerAdapter);
    }

    public static class SearchSchoolViewHolder extends RecyclerView.ViewHolder{
        View mView;

        public SearchSchoolViewHolder(View itemView) {
            super(itemView);
            mView=itemView;
        }

        public void setSchoolname(String schoolname)
        {
            TextView sname = (TextView) mView.findViewById(R.id.slist_schoolname);
            sname.setText(schoolname);
        }

        public void setSchoollogo(Context ctx, String schoollogo)
        {
            CircleImageView slogo = (CircleImageView) mView.findViewById(R.id.slist_logo);
            Picasso.get().load(schoollogo).into(slogo);
        }

        public void setSchooltype(String schooltype)
        {
            TextView stype = (TextView) mView.findViewById(R.id.slist_schooltype);
            stype.setText(schooltype);
        }

        public void setStrandoffers(String strandoffers)
        {
            TextView sstrand = (TextView) mView.findViewById(R.id.slist_strandoffers);
            sstrand.setText("    Strand Offers: " + strandoffers);
        }

        public void setSchoollocation(String schoollocation)
        {
            TextView sloc = (TextView) mView.findViewById(R.id.slist_location);
            sloc.setText(schoollocation);
        }

        public void setTrackoffers(String trackoffers)
        {
            TextView stracks = (TextView) mView.findViewById(R.id.slist_trackoffers);
            stracks.setText("    Track Offers: " + trackoffers);
        }

        public void setSchoolimage(Context ctx1,  String schoolimage)
        {
            ImageView simage = (ImageView) mView.findViewById(R.id.slist_schoolimage);
            Picasso.get().load(schoolimage).into(simage);
        }

    }

}
