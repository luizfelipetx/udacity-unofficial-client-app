package xyz.abhaychauhan.www.udacityunofficialclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class TracksDetailsActivity extends AppCompatActivity {

    TextView nameView;
    TextView descriptionView;
    ListView courseListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracks_details);
        Intent i = getIntent();
        final Track currentTrack = (Track) i.getSerializableExtra("courseTrack");

        //Initialising
        nameView = (TextView) findViewById(R.id.track_name);
        nameView.setText(currentTrack.getName());

        descriptionView = (TextView) findViewById(R.id.track_description);
        descriptionView.setText(currentTrack.getDescription());

        //courseListView = (ListView) findViewById(R.id.track_course_list);


    }
}
