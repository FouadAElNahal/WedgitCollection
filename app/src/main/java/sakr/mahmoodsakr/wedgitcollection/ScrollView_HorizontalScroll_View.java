package sakr.mahmoodsakr.wedgitcollection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ScrollView_HorizontalScroll_View extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scrollview_horizontalscrollview_view);
    }

    public void back2widget(View view) {
        Intent i = new Intent(ScrollView_HorizontalScroll_View.this, UiComponent2.class);
        startActivity(i);
        finish();
    }

    public void exit(View view) {
        finish();
    }
}
