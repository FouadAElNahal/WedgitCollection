package sakr.mahmoodsakr.wedgitcollection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;

public class UIComponent1 extends AppCompatActivity implements OnClickListener, OnLongClickListener {
    CheckBox withSuger, withNoSuger;
    Button summaryChecked, textwithimageButton;
    RadioGroup hotDrinkRadioGroup;
    RadioButton milkRadio, coffeeRadio, greenTeaRadio;
    Switch swtch;
    ToggleButton toggleButton;
    ImageView imageView;
    ImageButton imageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);
        hotDrinkRadioGroup = (RadioGroup) findViewById(R.id.radioGroupCoffeeType);
        milkRadio = (RadioButton) findViewById(R.id.radioMilk);
        coffeeRadio = (RadioButton) findViewById(R.id.radiocoffee);
        greenTeaRadio = (RadioButton) findViewById(R.id.radioGreentea);
        withSuger = (CheckBox) findViewById(R.id.withSuger);
        withNoSuger = (CheckBox) findViewById(R.id.withNoSuger);
        swtch = (Switch) findViewById(R.id.Switch);
        toggleButton = (ToggleButton) findViewById(R.id.togglebutton);
        summaryChecked = (Button) findViewById(R.id.summarychecked);
        textwithimageButton = (Button) findViewById(R.id.button_with_textandImage);
        summaryChecked.setOnClickListener(this);
        swtch.setOnClickListener(this);
        toggleButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageButton.setOnLongClickListener(this);
        imageView.setOnLongClickListener(this);
        textwithimageButton.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.summarychecked:
                String status = "";
                int radiogroupselected = hotDrinkRadioGroup.getCheckedRadioButtonId();
                if (milkRadio.isChecked()) {  // if(radiogroupselected==R.id.radioMilk)
                    status += " Milk ";
                }
                if (coffeeRadio.isChecked()) {
                    status += " Coffee ";
                }
                if (greenTeaRadio.isChecked()) {
                    status += " greenTea ";
                }
                if (withSuger.isChecked()) {
                    status += " withSuger ";
                }
                if (withNoSuger.isChecked()) {
                    status += " withNoSuger ";
                }
                Toast.makeText(this, status, Toast.LENGTH_LONG).show();
                break;
            case R.id.Switch:
                if (swtch.isChecked()) {
                    Toast.makeText(this, "Switch is ON", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Switch is Off", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.togglebutton:
                if (toggleButton.isChecked()) {
                    Toast.makeText(this, "Toggle Button is ON", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Toggle Button is Off", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void nextWidget(View view) {
        Intent i = new Intent(UIComponent1.this, UiComponent2.class);
        startActivity(i);
        finish();
    }

    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()) {
            case R.id.button_with_textandImage:
                Toast.makeText(this, "Button with imageand text is clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageButton:
                Toast.makeText(this, "ImageButton is clicked", Toast.LENGTH_SHORT).show();

                break;
            case R.id.imageView:
                Toast.makeText(this, "ImageView is clicked", Toast.LENGTH_SHORT).show();

                break;
        }


        return false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this, "Back button is pressed", Toast.LENGTH_SHORT).show();
    }
}
