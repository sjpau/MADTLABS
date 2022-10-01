package xyz.mobyus.labs.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.mariuszgromada.math.mxparser.*;
import xyz.mobyus.labs.R;


public class PlaceholderFragmentThree extends Fragment {

    Button btnNumber0;
    Button btnNumber1;
    Button btnNumber2;
    Button btnNumber3;
    Button btnNumber4;
    Button btnNumber5;
    Button btnNumber6;
    Button btnNumber7;
    Button btnNumber8;
    Button btnNumber9;

    TextView txtResult;

    EditText edtInput;

    Button btnC;

    Button btnSqrR;
    Button btnAdd;
    Button btnSub;
    Button btnMul;
    Button btnDiv;
    Button btnChangeSign;

    Button btnDot;
    Button btnResult;

    public PlaceholderFragmentThree() {
        // Required empty public constructor
    }


    public static PlaceholderFragmentThree newInstance() {
        PlaceholderFragmentThree fragment = new PlaceholderFragmentThree();
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
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_placeholder_three, container, false);
        return view;
    }
}
