package xyz.abhaychauhan.www.udacityunofficialclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TrackAdapter extends ArrayAdapter<Track> {

    public TrackAdapter(Context context, ArrayList<Track> tracks) {
        super(context, 0, tracks);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.track_item_list, parent, false);
        }

        Track currentTrack = getItem(position);

        TextView nameView = (TextView) convertView.findViewById(R.id.track_name);
        nameView.setText(currentTrack.getName());

        TextView descriptionView = (TextView) convertView.findViewById(R.id.track_description);
        descriptionView.setText(currentTrack.getDescription());

        TextView noOfCoursesView = (TextView) convertView.findViewById(R.id.track_no_of_courses);
        noOfCoursesView.setText("Courses : " + currentTrack.getCourses().length);

        return convertView;
    }
}
