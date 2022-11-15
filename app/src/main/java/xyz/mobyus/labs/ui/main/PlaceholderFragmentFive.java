package xyz.mobyus.labs.ui.main;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.loader.content.AsyncTaskLoader;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import org.json.JSONObject;
import org.json.JSONException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.AsynchronousByteChannel;
import java.util.ArrayList;
import java.util.Iterator;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;


import xyz.mobyus.labs.R;

public class PlaceholderFragmentFive extends Fragment {

    public PlaceholderFragmentFive() {
        // Required empty public constructor
    }

    public String APIURL = "https://api.exchangerate.host/latest/";
    static ListView ratesListView;
    static ArrayAdapter<String> ratesListAdapter;
    TextView textbox;

    public interface RetrofitAPI {
        @GET
        Call<ResponseBody> getRatesResponse(@Url String url);
    }

    public static URL newURLFromString(String u) {
        try {
            URL url = new URL(u);
            return url;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static PlaceholderFragmentFive newInstance() {
        PlaceholderFragmentFive fragment = new PlaceholderFragmentFive();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_placeholder_five, container, false);
        ratesListView = view.findViewById(R.id.crypto_rates_list);

        textbox = view.findViewById(R.id.crypto_rates_text);

        RetrofitWrapper r = new RetrofitWrapper();
        r.getRatesData();

        EditText inputSearch = (EditText) view.findViewById(R.id.searchBar);
        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence cs, int i, int i1, int i2) {
                ratesListAdapter.getFilter().filter(cs);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        return view;
    }


    public class RetrofitWrapper {
        ArrayList ratesList;

        private void getRatesData() {
            ratesList = new ArrayList<String>();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(APIURL)
                    .build();
            RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
            Call<ResponseBody> callURL = retrofitAPI.getRatesResponse(APIURL);
            callURL.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response.isSuccessful()) {
                        try {
                            String jsonFromAPI = response.body().string();
                            JSONObject jObj = new JSONObject(jsonFromAPI);
                            JSONObject ratesObject = jObj.getJSONObject("rates");
                            for (Iterator<String> self = ratesObject.keys(); self.hasNext(); ) {
                                String key = self.next();
                                String value = ratesObject.get(key).toString();
                                ratesList.add(key + ": " + value);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        PlaceholderFragmentFive.ratesListAdapter = new ArrayAdapter<>(getContext(), R.layout.crypto_listview_layout, ratesList);
                        PlaceholderFragmentFive.ratesListView.setAdapter(PlaceholderFragmentFive.ratesListAdapter);
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        }

    }
}