package xyz.abhaychauhan.www.udacityunofficialclient;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    LinearLayout course_free;
    LinearLayout course_nanodegree;
    LinearLayout course_track;
    LinearLayout noNetworkLayout;
    LinearLayout defaultLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialising linear layout for click.
        course_free = (LinearLayout) findViewById(R.id.course_free);
        course_nanodegree = (LinearLayout) findViewById(R.id.course_nanodegree);
        course_track = (LinearLayout) findViewById(R.id.course_track);
        noNetworkLayout = (LinearLayout) findViewById(R.id.show_no_connection_layout);
        defaultLayout = (LinearLayout) findViewById(R.id.show_default_layout);

        //Setting on click listener
        course_free.setOnClickListener(this);
        course_nanodegree.setOnClickListener(this);
        course_track.setOnClickListener(this);

        //Connectivity status
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            noNetworkLayout.setVisibility(View.GONE);
            defaultLayout.setVisibility(View.VISIBLE);
        } else {
            defaultLayout.setVisibility(View.GONE);
            noNetworkLayout.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onClick(View view) {
        if (view == findViewById(R.id.course_free)) {
            Intent courseIntent = new Intent(MainActivity.this, FreeCourseActivity.class);
            startActivity(courseIntent);
        } else if (view == findViewById(R.id.course_nanodegree)) {
            Intent nanodegreeIntent = new Intent(MainActivity.this, NanodegreeActivity.class);
            startActivity(nanodegreeIntent);
        } else if (view == findViewById(R.id.course_track)) {
            Intent tracksIntent = new Intent(MainActivity.this, TracksActivity.class);
            startActivity(tracksIntent);
        } else {
            Toast.makeText(this, "Operation currently not available !!!", Toast.LENGTH_SHORT).show();
        }
    }
}
