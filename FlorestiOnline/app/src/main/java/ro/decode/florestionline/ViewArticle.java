package ro.decode.florestionline;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ViewArticle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_article);


        if(getSupportActionBar() != null)
            getSupportActionBar().hide();


        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/socicon.ttf");

        Button contulMeu_icon=(Button) findViewById(R.id.button4);
        contulMeu_icon.setTypeface(custom_font);

        contulMeu_icon=(Button) findViewById(R.id.button5);
        contulMeu_icon.setTypeface(custom_font);

        contulMeu_icon=(Button) findViewById(R.id.button6);
        contulMeu_icon.setTypeface(custom_font);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_article, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        return super.onOptionsItemSelected(item);
    }
}
