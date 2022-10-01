package xyz.mobyus.labs.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.mobyus.labs.R;

public class PlaceholderFragmentSix extends Fragment {

    public PlaceholderFragmentSix() {
        // Required empty public constructor
    }

    public static PlaceholderFragmentSix newInstance() {
        PlaceholderFragmentSix fragment = new PlaceholderFragmentSix();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_placeholder_six, container, false);
    }
}