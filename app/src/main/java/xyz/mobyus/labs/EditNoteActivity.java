package xyz.mobyus.labs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.HashSet;

import xyz.mobyus.labs.ui.main.PlaceholderFragmentFour;

public class EditNoteActivity extends AppCompatActivity {
    int noteId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);
        EditText editText = findViewById(R.id.editText);

        // Fetch data that is passed from PlaceholderFragmentFour
        Intent intent = getIntent();

        // Accessing the data using key and value
        noteId = intent.getIntExtra("noteId", -1);
        if (noteId != -1) {
            editText.setText(PlaceholderFragmentFour.notes.get(noteId));
        } else {

            PlaceholderFragmentFour.notes.add("");
            noteId = PlaceholderFragmentFour.notes.size() - 1;
            PlaceholderFragmentFour.arrayAdapter.notifyDataSetChanged();

        }

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                PlaceholderFragmentFour.notes.set(noteId, String.valueOf(charSequence));
                PlaceholderFragmentFour.arrayAdapter.notifyDataSetChanged();
                // Creating Object of SharedPreferences to store data in the phone
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("xyz.mobyus.labs", Context.MODE_PRIVATE);
                HashSet<String> set = new HashSet(PlaceholderFragmentFour.notes);
                sharedPreferences.edit().putStringSet("notes", set).apply();
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }
}