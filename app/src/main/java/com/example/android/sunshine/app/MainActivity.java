package com.example.android.sunshine.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        ArrayAdapter<String> mForecastAdapter;
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            String[] forecastArray =
                    {
                            "Hello World 1",
                            "Hello World 2"
                    };

            List<String> weekForecast = new ArrayList<String>(Arrays.asList(forecastArray));

            mForecastAdapter =
                    new ArrayAdapter<String>(
                            getActivity(),
                            R.layout.list_item_forecast,
                            R.id.list_item_forecast_textview,
                            forecastArray
                    );

            ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
            listView.setAdapter(mForecastAdapter);
            //OPENWEATHERMAP API KEY = 16ce9cac8f1fb56891572e04bfd8615d

            return rootView;
        }


    }


}
