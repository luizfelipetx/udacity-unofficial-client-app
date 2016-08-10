package xyz.abhaychauhan.www.udacityunofficialclient;


public class Course {

    private String mTitle;
    private String mSubTitle;
    private String mKey;
    private String mImageUrl;
    private String mHomePageUrl;
    private String mLevel;
    private String mExpectedDurationUnit;
    private int mExpectedDuration;
    private String mSyllabus;
    private String mSummary;
    private String mExpectedLearning;
    private String mShortSummary;

    /**
     * Construct {@link Course}
     *
     * @param title
     * @param subTitle
     * @param key
     * @param imageUrl
     * @param homePageUrl
     * @param level
     * @param expectedDurationUnit
     * @param expectedDuration
     * @param syllabus
     * @param summary
     * @param expectedLearning
     * @param shortSummary
     */
    public Course(String title, String subTitle, String key, String imageUrl, String homePageUrl, String level,
                  String expectedDurationUnit, int expectedDuration, String syllabus, String summary, String expectedLearning, String shortSummary) {

        mTitle = title;
        mSubTitle = subTitle;
        mKey = key;
        mImageUrl = imageUrl;
        mHomePageUrl = homePageUrl;
        mLevel = level;
        mExpectedDurationUnit = expectedDurationUnit;
        mExpectedDuration = expectedDuration;
        mSyllabus = syllabus;
        mSummary = summary;
        mExpectedLearning = expectedLearning;
        mShortSummary = shortSummary;
    }

    /**
     * Return title of course
     *
     * @return
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Return subtitle of course
     *
     * @return
     */
    public String getSubTitle() {
        return mSubTitle;
    }

    /**
     * Return key of course
     *
     * @return
     */
    public String getKey() {
        return mKey;
    }

    /**
     * Return image url of the course
     *
     * @return
     */
    public String getImageUrl() {
        return mImageUrl;
    }

    /**
     * Return home page url of course
     *
     * @return
     */
    public String getHomePageUrl() {
        return mHomePageUrl;
    }

    /**
     * Return level of the course
     *
     * @return
     */
    public String getLevel() {
        return mLevel;
    }

    /**
     * Return expected duration unit of course
     *
     * @return
     */
    public String getExpectedDurationUnit() {
        return mExpectedDurationUnit;
    }

    /**
     * Return expected duration (int) of course
     *
     * @return
     */
    public int getExpectedDuration() {
        return mExpectedDuration;
    }

    /**
     * Return syllabus of course
     *
     * @return
     */
    public String getSyllabus() {
        return mSyllabus;
    }

    /**
     * Return summary of course
     *
     * @return
     */
    public String getSummary() {
        return mSummary;
    }

    /**
     * Return expected learning of course
     *
     * @return
     */
    public String getExpectedLearning() {
        return mExpectedLearning;
    }

    /**
     * Return short summary of course
     *
     * @return
     */
    public String getShortSummary() {
        return mShortSummary;
    }

}
