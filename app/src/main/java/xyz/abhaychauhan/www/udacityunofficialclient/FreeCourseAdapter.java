package xyz.abhaychauhan.www.udacityunofficialclient;


import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FreeCourseAdapter extends ArrayAdapter<Course> {

    private String mCourseType;

    public FreeCourseAdapter(Context context, ArrayList<Course> courses) {
        super(context, 0, courses);
    }

    public FreeCourseAdapter(Context context, ArrayList<Course> courses, String courseType) {
        super(context, 0, courses);
        mCourseType = courseType;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.free_course_list_item, parent, false);
        }

        Course currentCourse = getItem(position);

        if (mCourseType == "nanodegree") {
            if (currentCourse.getImageUrl() != null && currentCourse.getImageUrl() != "") {
                try {
                    ImageView imageView = (ImageView) convertView.findViewById(R.id.free_course_image);
                    Picasso.with(getContext()).load(currentCourse.getImageUrl()).into(imageView);
                    imageView.setVisibility(View.VISIBLE);
                } catch (Exception e) {
                    Log.e("FreeCourseAdapter.java", "Error -> In setting ImageView !!!");
                }
            }
        }

        //title
        TextView titleView = (TextView) convertView.findViewById(R.id.free_course_title);
        titleView.setText(currentCourse.getTitle());

        //Course ID
        TextView idView = (TextView) convertView.findViewById(R.id.free_course_id);
        idView.setText("( Course id : " + currentCourse.getKey() + " )");

        //Short summary
        TextView shortSummaryView = (TextView) convertView.findViewById(R.id.free_course_short_summary);
        shortSummaryView.setText(currentCourse.getShortSummary());

        //Duration
        TextView durationView = (TextView) convertView.findViewById(R.id.free_course_duration);
        durationView.setText("Duration\nApprox. " + currentCourse.getExpectedDuration() + " " + currentCourse.getExpectedDurationUnit());

        //Level
        TextView levelView = (TextView) convertView.findViewById(R.id.free_course_level);
        levelView.setText(currentCourse.getLevel());

        GradientDrawable drawable = (GradientDrawable) levelView.getBackground();
        drawable.setColor(getLevelColor(currentCourse.getLevel()));


        return convertView;
    }

    /**
     * Function return the color according to level
     *
     * @param level
     * @return
     */
    private int getLevelColor(String level) {
        int levelColorResourceId;
        switch (level.toLowerCase()) {
            case "beginner":
                levelColorResourceId = R.color.color_beginner;
                break;
            case "intermediate":
                levelColorResourceId = R.color.color_intermediate;
                break;
            case "advanced":
                levelColorResourceId = R.color.color_advanced;
                break;
            default:
                levelColorResourceId = R.color.color_default;
                break;
        }
        return ContextCompat.getColor(getContext(), levelColorResourceId);
    }
}
