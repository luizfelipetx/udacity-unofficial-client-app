package xyz.abhaychauhan.www.udacityunofficialclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class TracksActivity extends AppCompatActivity {

    private final static String COURSE_URL = "https://www.udacity.com/public-api/v0/courses";
    ListView listView;
    ArrayList<Track> mTracks;
    TrackAdapter adapter;
    LinearLayout loading_screen;
    LinearLayout no_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracks);

        //Inilializing
        listView = (ListView) findViewById(R.id.list_tracks);
        mTracks = new ArrayList<>();
        adapter = new TrackAdapter(this, mTracks);
        loading_screen = (LinearLayout) findViewById(R.id.loading_screen);
        no_data = (LinearLayout) findViewById(R.id.no_data);

        TracksAsyncTask tracksAsyncTask = new TracksAsyncTask(new TrackAsyncTaskResponse() {
            @Override
            public void processFinishTrack(ArrayList<Track> tracks) {
                mTracks.clear();
                if (tracks != null) {
                    mTracks.addAll(tracks);
                    loading_screen.setVisibility(View.GONE);
                    no_data.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                } else {
                    loading_screen.setVisibility(View.GONE);
                    listView.setVisibility(View.GONE);
                    no_data.setVisibility(View.VISIBLE);
                }

                listView.setAdapter(adapter);
            }
        });
        tracksAsyncTask.execute(COURSE_URL);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Track currentTrack = mTracks.get(i);
                //startActivity(new Intent(FreeCourseActivity.this, FreeCourseDetailActivity.class));
                Intent courseIntent = new Intent(TracksActivity.this, TracksDetailsActivity.class);
                courseIntent.putExtra("courseTrack", currentTrack);
                startActivity(courseIntent);
            }
        });

    }
}
