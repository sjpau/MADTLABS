package xyz.mobyus.labs.ui.main;

import android.os.Bundle;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import android.view.View;
import java.util.Random;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.graphics.Color;
import xyz.mobyus.labs.R;

public class PlaceholderFragmentOne extends Fragment implements View.OnClickListener {


    private Button buttonHelloWorld;
    private String textHello = "Hello";
    private String textWorld = "World!";
    private int   textSwitched = 0;



    public PlaceholderFragmentOne() {
        // Required empty public constructor
    }
    public static PlaceholderFragmentOne newInstance() {
        PlaceholderFragmentOne fragment = new PlaceholderFragmentOne();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_placeholder_one, container, false);
        buttonHelloWorld = (Button) view.findViewById(R.id.buttonHelloWorld);
        buttonHelloWorld.setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View view) {
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        buttonHelloWorld.setBackgroundColor(color);
        if (textSwitched == 1) {
            buttonHelloWorld.setText(textWorld);
            textSwitched = 0;
        } else {
            buttonHelloWorld.setText(textHello);
            textSwitched = 1;
        }
    }
}