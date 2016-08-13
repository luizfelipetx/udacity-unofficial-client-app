package xyz.abhaychauhan.www.udacityunofficialclient;

import java.io.Serializable;

public class Track implements Serializable {

    private String[] mCourses;
    private String mName;
    private String mDescription;

    /**
     * Construct {@link Track}
     *
     * @param courses
     * @param name
     * @param description
     */
    public Track(String[] courses, String name, String description) {
        mCourses = courses;
        mName = name;
        mDescription = description;
    }

    /**
     * Function returns an array of courses
     *
     * @return
     */
    public String[] getCourses() {
        return mCourses;
    }

    /**
     * Function returns name of the track
     *
     * @return
     */
    public String getName() {
        return mName;
    }

    /**
     * Function returns description of track
     *
     * @return
     */
    public String getDescription() {
        return mDescription;
    }


}
