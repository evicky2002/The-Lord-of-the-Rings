package com.example.lordoftherings.NetworkActivity;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.lordoftherings.DataModels.BookModel;
import com.example.lordoftherings.DataModels.MovieModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataService {
    public List<BookModel> booksList= new ArrayList<>();
    public List<MovieModel> movieList= new ArrayList<>();
    public ArrayList<String> bookChaptersArray;

    public JSONArray bookArray, movieArray, bookChapterArray;
    public JSONObject bookObject,movieObject,bookChapterObject;

    public static final String ACCESSTOKEN = "0BeOhwGQ4Sn_3EIHHlo_";
    public final String ENDPOINT = "https://the-one-api.dev/v2";
    Context context;

    public DataService(Context context){
        this.context = context;
    }
    public interface BookListener{
        void onResponse(List<BookModel> response);
        void onError(String placeholder);
    }
    public interface MovieListener{
        void onResponse(List<MovieModel> response);
        void onError(String placeholder);
    }
    public interface ChapterListener{
        void onResponse(String response);
        void onError(String placeholder);
    }

    public void getBooks(BookListener bookListener){
        String url = ENDPOINT+"/book";
        JSONObject parameters = new JSONObject();
        try {
            parameters.put("key","value");
        }catch (Exception e){

        }
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, parameters, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    bookArray = response.getJSONArray("docs");
                    for (int i=0;i<bookArray.length();i++){
                        bookObject = bookArray.getJSONObject(i);
                        booksList.add(new BookModel(bookObject.getString("_id"), bookObject.getString("name")));
                    }
                    bookListener.onResponse(booksList);
                } catch (Exception e) {

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("HELLO","volley error");

            }
        });
        MySingleton.getInstance(context).addToRequestQueue(request);
    }
    public void getMovies(MovieListener movieListener){
        String url = ENDPOINT+"/movie";
        JSONObject parameters = new JSONObject();
        try {
            parameters.put("key","value");
        }catch (Exception e){

        }
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, parameters, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    movieArray = response.getJSONArray("docs");
                    for (int i=2;i<movieArray.length();i++){
                        movieObject = movieArray.getJSONObject(i);
                        movieList.add(new MovieModel(movieObject.getString("name"), movieObject.getString("_id"),movieObject.getString("runtimeInMinutes")));
                    }
                    movieListener.onResponse(movieList);
                } catch (Exception e) {

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("HELLO","volley error here");

            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Authorization", "Bearer " + ACCESSTOKEN);
                return headers;
            }
        };
        MySingleton.getInstance(context).addToRequestQueue(request);
    }

    public void getChapters(String id, ChapterListener chapterListener){

        String url = ENDPOINT+"/book/"+id+"/chapter";
        JSONObject parameters = new JSONObject();
        try {
            parameters.put("key","value");
        }catch (Exception e){

        }
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, parameters, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    bookChapterArray = response.getJSONArray("docs");
                    bookChaptersArray = new ArrayList<>(bookChapterArray.length());
                    for (int i=0;i<bookChapterArray.length();i++){

                        bookChapterObject = bookChapterArray.getJSONObject(i);

                        bookChaptersArray.add(bookChapterObject.getString("chapterName"));


                    }

                    for(int j=0;j<booksList.size();j++){
                        if(booksList.get(j).getId() == id){
                            booksList.get(j).setTotalChapters(response.getString("total"));
                            booksList.get(j).setChapters(bookChaptersArray);
                            break;
                        }
                    }

                    chapterListener.onResponse("success");
                } catch (Exception e) {

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("HELLO","volley error here");

            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Authorization", "Bearer " + ACCESSTOKEN);
                return headers;
            }
        };
        MySingleton.getInstance(context).addToRequestQueue(request);
    }


}
