package sakr.mahmoodsakr.wedgitcollection;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

//autoCompleteText+Spinner+RatingBar
public class UiComponent2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener, SeekBar.OnSeekBarChangeListener {
    String[] numberArray, country;
    AutoCompleteTextView autoText;
    Spinner spin;
    SeekBar seekBar;
    RatingBar ratebar;
    DatePicker datePicker;
    TimePicker timePicker;
    Button ratebarbutton, butDatepicker, butTimepicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget2);
        // to create alert dialog , you must create builder first for that alert dialog
        //Builder is used for Setting alert message manually and performing action on Y/N button click
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Do you want to close this application ?")
                .setCancelable(false)
                .setPositiveButton("Yes Text", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'Yes' Button
                        finish();  // close the application activity
                    }
                })
                .setNegativeButton("No Text", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();
                    }
                });

        //Creating alert dialog box
        AlertDialog alert = builder.create();
        alert.setTitle("AlertDialogExample");
        alert.show();


        numberArray = new String[]{"one", "oone", "two", "three", "fff", "fffffour"};
        country = new String[]{"India", "USA", "China", "Japan", "Egypt", "Other"};
        //AutoCompleteTextView
        autoText = (AutoCompleteTextView) findViewById(R.id.autocompleteid);
        ArrayAdapter autotextviewAdapter = new ArrayAdapter(this, android.R.layout.select_dialog_item, numberArray);
        //autoText.setThreshold(1);//default is 2
        autoText.setAdapter(autotextviewAdapter);
        autoText.setTextColor(Color.BLUE);

        spin = (Spinner) findViewById(R.id.spinnerid);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);

        //Rating bar processing
        ratebar = (RatingBar) findViewById(R.id.ratingbarid);
        ratebarbutton = (Button) findViewById(R.id.ratebuttonid);
        ratebarbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                StringBuilder mess = new StringBuilder();
                int numberstar = ratebar.getNumStars();
                float numstar = ratebar.getRating();
                mess.append("NumberStart : ").append(numberstar).append("\n");
                mess.append("Floating Rating : ").append(numstar);

                Toast.makeText(getApplicationContext(), mess, Toast.LENGTH_LONG).show();
            }
        });
        seekBar = (SeekBar) findViewById(R.id.seekbarid);
        seekBar.setOnSeekBarChangeListener(this);
//DatePicker
        datePicker = (DatePicker) findViewById(R.id.datepickerid);
        butDatepicker = (Button) findViewById(R.id.datepickerbuttonid);
        butDatepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder build = new StringBuilder();
                build.append(datePicker.getDayOfMonth() + " / ");
                build.append((datePicker.getMonth() + 1) + " / ");
                build.append(datePicker.getYear());
                Toast.makeText(getApplicationContext(), build.toString(), Toast.LENGTH_LONG).show();
            }
        });
//DatePicker End
        timePicker = (TimePicker) findViewById(R.id.timepickerid);
//        timePicker.setIs24HourView(true);
        butTimepicker = (Button) findViewById(R.id.timepickerbuttonid);
        butTimepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = timePicker.getCurrentHour();
                int minute = timePicker.getCurrentMinute();
                Toast.makeText(getApplicationContext(), "Time is : " + hour + " : " + minute, Toast.LENGTH_LONG).show();
            }
        });
    }

    //Spinner Action
    //// onItemSelectedListener interface methods
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), country[position], Toast.LENGTH_LONG).show();
        //        Toast.makeText(getApplicationContext(), "You select " + spin.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
// id=position
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
    //End Spinner action

    // SeekBar Action   ( progress from 0 to 100 )
    // OnSeekBarchangeListener interface Methods


    // note each action on seek bar the three 3 method will lunched sequentially
// this is the first method will be launched
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        Toast.makeText(this, "Seek Bar touch Started", Toast.LENGTH_SHORT).show();
    }
    // this is the second method will be launched

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Toast.makeText(this, "seekbar progress: " + progress, Toast.LENGTH_SHORT).show();
    }
// this is the last method will be launched

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        Toast.makeText(this, "Seek Bar touch Stopped", Toast.LENGTH_SHORT).show();

    }

    //End SeekBar action
    public void nextWidget(View view) {
        Intent i = new Intent(UiComponent2.this, ScrollView_HorizontalScroll_View.class);
        startActivity(i);
        finish();
    }

    public void backWidget(View view) {
        Intent i = new Intent(UiComponent2.this, UIComponent1.class);
        startActivity(i);
        finish();
    }

}
