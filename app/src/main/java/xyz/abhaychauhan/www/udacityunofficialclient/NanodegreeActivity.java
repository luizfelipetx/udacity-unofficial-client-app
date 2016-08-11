package xyz.abhaychauhan.www.udacityunofficialclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class NanodegreeActivity extends AppCompatActivity {

    private final static String COURSE_URL = "https://www.udacity.com/public-api/v0/courses";
    ListView listView;
    ArrayList<Course> mNanodegree;
    FreeCourseAdapter adapter;
    LinearLayout loading_screen;
    LinearLayout no_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nanodegree);

        //Inilializing
        listView = (ListView) findViewById(R.id.list_nanodegree);
        mNanodegree = new ArrayList<>();
        adapter = new FreeCourseAdapter(this, mNanodegree, "nanodegree");
        loading_screen = (LinearLayout) findViewById(R.id.loading_screen);
        no_data = (LinearLayout) findViewById(R.id.no_data);

        FreeCourseAsyncTask freeCourseAsyncTask = new FreeCourseAsyncTask(new CourseAsyncTaskResponse() {
            @Override
            public void processFinish(ArrayList<Course> courseList) {
                mNanodegree.clear();
                if (courseList != null) {
                    mNanodegree.addAll(courseList);
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
        freeCourseAsyncTask.execute(COURSE_URL, "nanodegree");
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Course currentCourse = mNanodegree.get(i);
                //startActivity(new Intent(FreeCourseActivity.this, FreeCourseDetailActivity.class));
                Intent courseIntent = new Intent(NanodegreeActivity.this, NanodegreeDetailActivity.class);
                courseIntent.putExtra("courseObject", currentCourse);
                startActivity(courseIntent);
            }
        });
    }
}
