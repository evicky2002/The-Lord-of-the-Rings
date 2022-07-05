package com.example.lordoftherings.NetworkActivity;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.example.lordoftherings.DataModels.BookModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DataService {
    public List<BookModel> booksList= new ArrayList<>();
    public JSONArray bookArray;
    public JSONObject jsonObject;
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
                        jsonObject = bookArray.getJSONObject(i);
                        booksList.add(new BookModel(jsonObject.getString("_id"),jsonObject.getString("name")));
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
}
