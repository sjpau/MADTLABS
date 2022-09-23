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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlaceholderFragmentTwo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlaceholderFragmentTwo extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Spinner spinner;
    private Button buttonParser;
    private EditText editText;
    public PlaceholderFragmentTwo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlaceholderFragmentTwo.
     */
    // TODO: Rename and change types and number of parameters
    public static PlaceholderFragmentTwo newInstance(String param1, String param2) {
        PlaceholderFragmentTwo fragment = new PlaceholderFragmentTwo();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
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
                    StringTokenizer words = new StringTokenizer(textFieldInput);
                    int countStrings = words.countTokens();
                    buttonParser.setText(countStrings + " words!");
                    break;
                case "Count characters":
                    String[] chars = textFieldInput.split("\\s");
                    int countChars = textFieldInput.length();
                    buttonParser.setText(countChars + " characters");
                    break;
            }
        }
    }
}