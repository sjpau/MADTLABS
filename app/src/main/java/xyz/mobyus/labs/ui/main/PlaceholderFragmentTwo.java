package xyz.mobyus.labs.ui.main;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.StringTokenizer;

import xyz.mobyus.labs.R;
import xyz.mobyus.labs.StringParser;

public class PlaceholderFragmentTwo extends Fragment implements View.OnClickListener {


    private Spinner spinner;
    private Button buttonParser;
    private EditText editText;
    public PlaceholderFragmentTwo() {
        // Required empty public constructor
    }


    public static PlaceholderFragmentTwo newInstance() {
        PlaceholderFragmentTwo fragment = new PlaceholderFragmentTwo();
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
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_placeholder_two, container, false);
        editText = (EditText) view.findViewById(R.id.editTextParser);
        spinner = view.findViewById(R.id.Spinner1);
        ArrayList<String> spinnerArgs = new ArrayList<>();
        spinnerArgs.add("Count words");
        spinnerArgs.add("Count characters");
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, spinnerArgs);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        buttonParser = (Button) view.findViewById(R.id.buttonParser);
        buttonParser.setOnClickListener(this);


        return view;
    } @Override
    public void onClick(View view) {
        Context context = getContext();
        CharSequence text = "Empty input field!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        String textFieldInput = editText.getText().toString();
        if (textFieldInput.isEmpty()) {
            toast.show();
        } else {
            String tmpSpinnerItem = spinner.getSelectedItem().toString();
            switch (tmpSpinnerItem) {
                case "Count words":
                    int countStrings = StringParser.CountStrings(textFieldInput);
                    buttonParser.setText(countStrings + " words!");
                    break;
                case "Count characters":
                    int countChars = StringParser.CountChars(textFieldInput);
                    buttonParser.setText(countChars + " characters");
                    break;
            }
        }
    }
}