package xyz.abhaychauhan.www.udacityunofficialclient;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class ExtractData {

    /**
     * Function takes UDACITY API URL (String) and return List of Courses
     *
     * @param stringUrl
     * @return
     */
    public static ArrayList<Course> extractCourses(String stringUrl) {
        URL url = createUrl(stringUrl);
        String jsonResponse = "";
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e("ExtractData.java", "Error -> Not able to fetch JSON RESPONSE !!!");
        }
        ArrayList<Course> courses = extractCourseData(jsonResponse);
        return courses;
    }

    /**
     * Function take String url as a parameter, convert it to URL object and return the URL object.
     *
     * @param stringUrl
     * @return url
     */
    public static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e("ExtractData.java", "Error -> Not able to create URL object !!!");
        }
        return url;
    }

    /**
     * Function take URL object as parameter, make HTTP connection with the URL and return the
     * JsonReponse in String format.
     *
     * @param url
     * @return jsonResponse
     * @throws IOException
     */
    public static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";
        if (url == null) {
            return null;
        }
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(15000);
            urlConnection.connect();
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e("ExtractData.java", "Error -> Response code : " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e("ExtractData.java", "Error -> Not able to create HttpUrlConnection Object !!!");
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    /**
     * Function take InputStream object, read data from stream , convert to String and return the String.
     *
     * @param inputStream
     * @return output (String)
     * @throws IOException
     */
    public static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    /**
     * Function return UDACITY course list
     *
     * @param jsonResponse
     * @return
     */
    public static ArrayList<Course> extractCourseData(String jsonResponse) {
        ArrayList<Course> course = new ArrayList<>();
        try {
            JSONObject object = new JSONObject(jsonResponse);
            JSONArray coursesArray = object.getJSONArray("courses");
            for (int i = 0; i < coursesArray.length(); i++) {
                JSONObject courseObject = coursesArray.getJSONObject(i);
                String subtitle = courseObject.optString("subtitle");
                String key = courseObject.optString("key");
                String imageUrl = courseObject.optString("image");
                String expectedLearning = courseObject.optString("expected_learning");
                String title = courseObject.optString("title");
                String syllabus = courseObject.optString("syllabus");
                String homePageUrl = courseObject.optString("homepage");
                String level = courseObject.optString("level");
                String expected_duration_unit = courseObject.optString("expected_duration_unit");
                String summary = courseObject.optString("summary");
                int expected_duration = courseObject.optInt("expected_duration");
                String short_summary = courseObject.optString("short_summary");
                course.add(new Course(title, subtitle, key, imageUrl, homePageUrl, level, expected_duration_unit, expected_duration, syllabus, summary, expectedLearning, short_summary));
            }
        } catch (JSONException e) {
            Log.e("ExtractData.java", "Error -> JSONException error !!!");
        }
        return course;
    }
}
