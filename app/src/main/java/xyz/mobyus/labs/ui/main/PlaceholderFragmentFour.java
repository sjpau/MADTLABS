package xyz.mobyus.labs.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashSet;


import xyz.mobyus.labs.EditNoteActivity;
import xyz.mobyus.labs.R;

public class PlaceholderFragmentFour extends Fragment {

    public PlaceholderFragmentFour() {
        // Required empty public constructor
    }


    public static ArrayList<String> notes = new ArrayList<>();
    public static ArrayAdapter arrayAdapter;



    public static PlaceholderFragmentFour newInstance() {
        PlaceholderFragmentFour fragment = new PlaceholderFragmentFour();
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
        View view = inflater.inflate(R.layout.fragment_placeholder_four, container, false);
        ListView listView = view.findViewById(R.id.listView);
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("xyz.mobyus.labs", Context.MODE_PRIVATE);
        HashSet<String> set = (HashSet<String>) sharedPreferences.getStringSet("notes", null);
        if (set == null) {
           // notes.add("Example note");
        } else {
            notes = new ArrayList(set);
        }
        view.findViewById(R.id.floatingActionButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), EditNoteActivity.class);
                startActivity(intent);
            }
        });
        arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_expandable_list_item_1, notes);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // Going from MainActivity to NotesEditorActivity
                Intent intent = new Intent(getContext(), EditNoteActivity.class);
                intent.putExtra("noteId", i);
                startActivity(intent);

            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                final int itemToDelete = i;
                // To delete the data from the App
                new AlertDialog.Builder(getContext())
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Delete note?")
                        .setMessage("This note will be deleted irreversibly.")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                notes.remove(itemToDelete);
                                arrayAdapter.notifyDataSetChanged();
                                SharedPreferences sharedPreferences = getContext().getSharedPreferences("xyz.mobyus.labs", Context.MODE_PRIVATE);
                                HashSet<String> set = new HashSet(PlaceholderFragmentFour.notes);
                                sharedPreferences.edit().putStringSet("notes", set).apply();
                            }
                        }).setNegativeButton("No", null).show();
                return true;
            }
        });


        return view;
    }
}