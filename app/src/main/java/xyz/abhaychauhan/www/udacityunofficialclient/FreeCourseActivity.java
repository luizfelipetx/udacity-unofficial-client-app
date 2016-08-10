package xyz.abhaychauhan.www.udacityunofficialclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FreeCourseActivity extends AppCompatActivity {

    private final static String COURSE_URL = "https://www.udacity.com/public-api/v0/courses";
    ListView listView;
    ArrayList<Course> mFreeCourse;
    FreeCourseAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_course);

        //Inilializing
        listView = (ListView) findViewById(R.id.list_course);
        mFreeCourse = new ArrayList<>();
        adapter = new FreeCourseAdapter(this, mFreeCourse);


        FreeCourseAsyncTask freeCourseAsyncTask = new FreeCourseAsyncTask(new CourseAsyncTaskResponse() {
            @Override
            public void processFinish(ArrayList<Course> courseList) {
                mFreeCourse.clear();
                mFreeCourse.addAll(courseList);
                listView.setAdapter(adapter);
            }
        });
        freeCourseAsyncTask.execute(COURSE_URL);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Course currentCourse = mFreeCourse.get(i);
                startActivity(new Intent(FreeCourseActivity.this, FreeCourseDetailActivity.class));
            }
        });
    }


}
