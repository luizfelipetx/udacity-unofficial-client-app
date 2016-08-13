package xyz.abhaychauhan.www.udacityunofficialclient;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NanodegreeDetailActivity extends AppCompatActivity {

    ImageView courseImageView;
    TextView titleView;
    TextView subTitleView;
    TextView idView;
    TextView durationView;
    TextView levelView;
    TextView summaryView;
    TextView expectedLearningView;
    TextView syllabusView;
    Button buttonView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nanodegree_detail);

        Intent i = getIntent();
        final Course currentCourse = (Course) i.getSerializableExtra("courseObject");

        courseImageView = (ImageView) findViewById(R.id.nanodegree_image);
        titleView = (TextView) findViewById(R.id.nanodegree_title);
        subTitleView = (TextView) findViewById(R.id.nanodegree_subtitle);
        idView = (TextView) findViewById(R.id.nanodegree_id);
        durationView = (TextView) findViewById(R.id.nanodegree_duration);
        levelView = (TextView) findViewById(R.id.nanodegree_level);
        summaryView = (TextView) findViewById(R.id.nanodegree_summary);
        expectedLearningView = (TextView) findViewById(R.id.nanodegree_expected_learning);
        syllabusView = (TextView) findViewById(R.id.nanodegree_syllabus);
        buttonView = (Button) findViewById(R.id.button_view_course);

        if (currentCourse.getImageUrl() != null && currentCourse.getImageUrl() != "" && !currentCourse.getImageUrl().contains(" ")) {
            try {
                Picasso.with(this).load(currentCourse.getImageUrl()).into(courseImageView);
                courseImageView.setVisibility(View.VISIBLE);
            } catch (Exception e) {
                courseImageView.setVisibility(View.GONE);
            }
        } else {
            courseImageView.setVisibility(View.GONE);
        }

        titleView.setText(currentCourse.getTitle());
        if (currentCourse.getSubTitle() != null) {
            subTitleView.setText(currentCourse.getSubTitle());
            subTitleView.setVisibility(View.VISIBLE);
        } else {
            subTitleView.setVisibility(View.GONE);
        }

        idView.setText("( Course Id : " + currentCourse.getKey() + " )");

        durationView.setText("Duration\nApprox. " + currentCourse.getExpectedDuration() + " " + currentCourse.getExpectedDurationUnit());
        levelView.setText(currentCourse.getLevel());

        GradientDrawable drawable = (GradientDrawable) levelView.getBackground();
        drawable.setColor(getLevelColor(currentCourse.getLevel()));

        if (currentCourse.getShortSummary() != null) {
            summaryView.setText(currentCourse.getShortSummary());
        } else {
            summaryView.setText(currentCourse.getSummary());
        }

        expectedLearningView.setText(currentCourse.getExpectedLearning());

        syllabusView.setText(currentCourse.getSyllabus());

        buttonView.setBackgroundColor(getLevelColor(currentCourse.getLevel()));

        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(currentCourse.getHomePageUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(uri);
                startActivity(intent);
            }
        });

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
        return ContextCompat.getColor(this, levelColorResourceId);
    }


}
