package xyz.abhaychauhan.www.udacityunofficialclient;

import android.os.AsyncTask;

import java.util.ArrayList;


public class TracksAsyncTask extends AsyncTask<String, Void, ArrayList<Track>> {

    private TrackAsyncTaskResponse mCourseAsyncTaskResponse;

    public TracksAsyncTask(TrackAsyncTaskResponse courseAsyncTaskResponse) {
        mCourseAsyncTaskResponse = courseAsyncTaskResponse;
    }

    @Override
    protected ArrayList<Track> doInBackground(String... strings) {
        if (strings[0] != null || strings[0] != "") {
            return ExtractData.extractTracks(strings[0]);
        }
        return null;
    }

    @Override
    protected void onPostExecute(ArrayList<Track> tracks) {
        if (tracks == null) {
            return;
        }
        mCourseAsyncTaskResponse.processFinishTrack(tracks);
    }
}
