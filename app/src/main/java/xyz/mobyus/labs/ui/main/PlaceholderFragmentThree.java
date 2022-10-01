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

    TextView txtResult;
    EditText edtInput;

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

    public void addStringToInput(String addStr, EditText in){
        String currStr = in.getText().toString();
        in.setText(String.format("%s%s", currStr, addStr));
    }

    public boolean endsWithSign(String exp){
        if (exp.endsWith("-") || exp.endsWith("+") || exp.endsWith("*") || exp.endsWith("/")){
            return true;
        }
        return false;
    }

    public String removeLastChar(String exp){
        String res = exp.substring(0, exp.length() - 1);
        return res;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_placeholder_three, container, false);
        edtInput = view.findViewById(R.id.edtInput);

        view.findViewById(R.id.btnNumber0).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                addStringToInput("0", edtInput);
            }
        });

        view.findViewById(R.id.btnNumber1).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                addStringToInput("1", edtInput);
            }
        });

        view.findViewById(R.id.btnNumber2).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                addStringToInput("2", edtInput);
            }
        });

        view.findViewById(R.id.btnNumber3).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                addStringToInput("3", edtInput);
            }
        });

        view.findViewById(R.id.btnNumber4).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                addStringToInput("4", edtInput);
            }
        });

        view.findViewById(R.id.btnNumber5).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                addStringToInput("5", edtInput);
            }
        });

        view.findViewById(R.id.btnNumber6).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                addStringToInput("6", edtInput);
            }
        });

        view.findViewById(R.id.btnNumber7).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                addStringToInput("7", edtInput);
            }
        });

        view.findViewById(R.id.btnNumber8).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                addStringToInput("8", edtInput);
            }
        });

        view.findViewById(R.id.btnNumber9).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                addStringToInput("9", edtInput);
            }
        });

        view.findViewById(R.id.btnC).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                edtInput.setText(null);
            }
        });

        view.findViewById(R.id.btnSqrRoot).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (!edtInput.getText().toString().endsWith("√")) {
                    addStringToInput("√", edtInput);
                }
            }
        });

        view.findViewById(R.id.btnNumberAdd).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (endsWithSign(edtInput.getText().toString())){
                    String text = edtInput.getText().toString();
                    edtInput.setText(removeLastChar(text));
                }
                    addStringToInput("+", edtInput);
            }
        });

        view.findViewById(R.id.btnNumberDiv).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (endsWithSign(edtInput.getText().toString())){
                    String text = edtInput.getText().toString();
                    edtInput.setText(removeLastChar(text));
                }
                addStringToInput("/", edtInput);
            }
        });

        view.findViewById(R.id.btnNumberMul).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (endsWithSign(edtInput.getText().toString())){
                    String text = edtInput.getText().toString();
                    edtInput.setText(removeLastChar(text));
                }
                addStringToInput("*", edtInput);
            }
        });

        view.findViewById(R.id.btnNumberSub).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (endsWithSign(edtInput.getText().toString())){
                    String text = edtInput.getText().toString();
                    edtInput.setText(removeLastChar(text));
                }
                addStringToInput("-", edtInput);
            }
        });


        view.findViewById(R.id.btnChangeSign).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (!edtInput.getText().toString().startsWith("-")) {
                    String text = edtInput.getText().toString();
                    edtInput.setText("-"+text);
                }
                else {
                    String text = edtInput.getText().toString();
                    edtInput.setText(text.substring(1));
                }
            }
        });

        view.findViewById(R.id.btnDot).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                addStringToInput(".", edtInput);
            }
        });

        view.findViewById(R.id.btnResult).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            String userExp = edtInput.getText().toString();
            Expression exp = new Expression(userExp);
            String result = String.valueOf(exp.calculate());
            if (result.equals("NaN")){
                edtInput.setText(null);
                Toast toast = Toast.makeText(getContext(), "NaN", Toast.LENGTH_LONG);
                toast.show();
            } else {
                edtInput.setText(result);
                edtInput.setSelection(result.length());
            }
            }

        });
        return view;
    }

}