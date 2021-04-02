package com.example.alertdiaglog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alertdiaglog.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AlertDialog firstDialog = new AlertDialog.Builder(MainActivity.this)
                .setTitle("First Dialog")
                .setIcon(R.drawable.ic_android_black_24dp)
                .setMessage("Is this the first dialog?")
                .setPositiveButton("yes", (dialog, which) -> {
                    Toast.makeText(MainActivity.this, "Accept first", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("no", (dialog, which) -> {
                    Toast.makeText(MainActivity.this, "Denied first", Toast.LENGTH_SHORT).show();
                })
                .create();

        binding.btnFirst.setOnClickListener(v -> {
            firstDialog.show();
        });

        String[] optionsNum = new String[]{"first","second","third","fourth"};
        AlertDialog secondDialog = new AlertDialog.Builder(MainActivity.this)
                .setSingleChoiceItems(optionsNum, 0, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"So you've choosen ".concat(optionsNum[which].concat(String.valueOf(which))),Toast.LENGTH_SHORT).show();
                        binding.tv.setText(optionsNum[which]);
                    }
                }).setPositiveButton("oks", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();

        binding.btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               secondDialog.show();
            }
        });



        // String array for alert dialog multi choice items
        String[] colors = new String[]{
                "Red",
                "Green",
                "Blue",
                "Purple"
        };

        // Boolean array for initial selected items
        final boolean[] checkedColors = new boolean[]{
                false, // Red
                true, // Green
                false, // Blue
                true, // Purple
                false // Olive

        };

        // Convert the color array to list
        final List<String> colorsList = Arrays.asList(colors);

        // Set multiple choice items for alert dialog
                /*
                    AlertDialog.Builder setMultiChoiceItems(CharSequence[] items, boolean[]
                    checkedItems, DialogInterface.OnMultiChoiceClickListener listener)
                        Set a list of items to be displayed in the dialog as the content,
                        you will be notified of the selected item via the supplied listener.
                 */
                /*
                    DialogInterface.OnMultiChoiceClickListener
                    public abstract void onClick (DialogInterface dialog, int which, boolean isChecked)

                        This method will be invoked when an item in the dialog is clicked.

                        Parameters
                        dialog The dialog where the selection was made.
                        which The position of the item in the list that was clicked.
                        isChecked True if the click checked the item, else false.
                 */
        AlertDialog builder = new AlertDialog.Builder(MainActivity.this)
            .setMultiChoiceItems(colors, checkedColors, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                // Update the current focused item's checked status
                checkedColors[which] = isChecked;

                // Get the current focused item
                String currentItem = colorsList.get(which);

                // Notify the current action
                Toast.makeText(getApplicationContext(),
                        currentItem + " " + isChecked, Toast.LENGTH_SHORT).show();
            }
        }).setCancelable(false).setTitle("Your preferred colors?")
            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do something when click positive button
                binding.tv.setText("Your preferred colors..... \n");
                for (int i = 0; i<checkedColors.length; i++){
                    boolean checked = checkedColors[i];
                    if (checked) {
                        binding.tv.setText(binding.tv.getText() + colorsList.get(i) + "\n");
                    }
                }
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do something when click the negative button
            }
        }).setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do something when click the neutral button
            }
        }).create();
        binding.btnThird.setOnClickListener(v -> {
            builder.show();
        });
    }
}