package xyz.abhaychauhan.www.udacityunofficialclient;

import android.os.AsyncTask;

import java.util.ArrayList;

public class FreeCourseAsyncTask extends AsyncTask<String, Void, ArrayList<Course>> {

    private CourseAsyncTaskResponse mCourseAsyncTaskResponse;

    public FreeCourseAsyncTask(CourseAsyncTaskResponse courseAsyncTaskResponse) {
        mCourseAsyncTaskResponse = courseAsyncTaskResponse;
    }

    @Override
    protected ArrayList<Course> doInBackground(String... strings) {
        if (strings[0] != null || strings[0] != "") {
            return ExtractData.extractCourses(strings[0],strings[1]);
        }
        return null;
    }

    @Override
    protected void onPostExecute(ArrayList<Course> courses) {
        if (courses == null) {
            return;
        }
        mCourseAsyncTaskResponse.processFinish(courses);
    }
}
