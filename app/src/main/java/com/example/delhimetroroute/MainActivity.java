package com.example.delhimetroroute;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView sourceAutoTextView = findViewById(R.id.source);
        AutoCompleteTextView destinationAutoTextView = findViewById(R.id.destination);

        String[] stations = getResources().getStringArray(R.array.Stations);

        ArrayAdapter<String> sourceAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stations);
        sourceAutoTextView.setAdapter(sourceAdapter);

        ArrayAdapter<String> destinationAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stations);
        destinationAutoTextView.setAdapter(destinationAdapter);

        final String[] src = {""};
        final String[] dest = {""};

        sourceAutoTextView.setOnItemClickListener((adapterView, view, i, l) -> {
        src[0] = adapterView.getItemAtPosition(i).toString();
        sourceAutoTextView.setSelected(true);
    });

        destinationAutoTextView.setOnItemClickListener((adapterView, view, i, l) -> {
        dest[0] = adapterView.getItemAtPosition(i).toString();
        destinationAutoTextView.setSelected(true);
    });

        Button showButton = findViewById(R.id.showbutton);
        showButton.setOnClickListener(view -> {
        // Proceed to route activity only if items from both auto text views are selected
        if (sourceAutoTextView.isSelected() && destinationAutoTextView.isSelected()) {
            sourceAutoTextView.setSelected(false);
            destinationAutoTextView.setSelected(false);

            Intent intent = new Intent(MainActivity.this, RouteAndFair.class);
            intent.putExtra("src_key", src[0]);
            intent.putExtra("dest_key", dest[0]);
            startActivity(intent);
        } else {
            // Raise a dialog
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
            alertDialog.setMessage("Please Select a Station from Drop Down Menu Again.");
            alertDialog.setPositiveButton("OK", (dialog, which) -> {});
            AlertDialog alert = alertDialog.create();
            alert.setCanceledOnTouchOutside(false);
            alert.show();
        }
    });

        // Exit
        Button exitButton = findViewById(R.id.exit);
        exitButton.setOnClickListener(view -> {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setMessage("Do You Really Want To Exit?");
        alertDialog.setPositiveButton("Yes", (dialog, which) -> finish());
        alertDialog.setNegativeButton("No", (dialog, which) -> {});
        AlertDialog alert = alertDialog.create();
        alert.setCanceledOnTouchOutside(false);
        alert.show();
    });
    }
}
