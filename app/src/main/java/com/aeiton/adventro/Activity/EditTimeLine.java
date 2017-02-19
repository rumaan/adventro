package com.aeiton.adventro.Activity;

import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.aeiton.adventro.Adapters.NewsFeedAdapter;
import com.aeiton.adventro.Adapters.TimeLineAdapter;
import com.aeiton.adventro.Adapters.TimeLineListAdapter;
import com.aeiton.adventro.Model.FeedTimeLineModel;
import com.aeiton.adventro.Model.TimeLineModel;
import com.aeiton.adventro.R;

import java.util.ArrayList;

public class EditTimeLine extends AppCompatActivity {


    RecyclerView timeline;
    private TimeLineAdapter mAdapter;
    private ArrayList<TimeLineModel> timelineMOdel = new ArrayList<>();
    AppBarLayout userAccess;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_time_line);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Timeline");


        userAccess = (AppBarLayout) findViewById(R.id.user_access);

        Bundle b = getIntent().getExtras();
        if (b.getInt("access",0) != 1){
            userAccess.setVisibility(View.GONE);
        }

        timeline = (RecyclerView) findViewById(R.id.recycler);
        mAdapter = new TimeLineAdapter(timelineMOdel);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(EditTimeLine.this);
        timeline.setLayoutManager(mLayoutManager);
        timeline.setItemAnimator(new DefaultItemAnimator());
        timeline.setAdapter(mAdapter);


        timelineMOdel.add(new TimeLineModel("this is a sample timeline item","Here i am","26/07/2017",R.drawable.ic_profile_pic,R.drawable.img_placeholder));
        timelineMOdel.add(new TimeLineModel("this is a sample timeline item","Here i am","26/07/2017",R.drawable.ic_profile_pic,R.drawable.img_placeholder));
        timelineMOdel.add(new TimeLineModel("this is a sample timeline item","Here i am","26/07/2017",R.drawable.ic_profile_pic,R.drawable.img_placeholder));
        timelineMOdel.add(new TimeLineModel("this is a sample timeline item","Here i am","26/07/2017",R.drawable.ic_profile_pic,R.drawable.img_placeholder));
        timelineMOdel.add(new TimeLineModel("this is a sample timeline item","Here i am","26/07/2017",R.drawable.ic_profile_pic,R.drawable.img_placeholder));

        mAdapter.notifyDataSetChanged();


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
