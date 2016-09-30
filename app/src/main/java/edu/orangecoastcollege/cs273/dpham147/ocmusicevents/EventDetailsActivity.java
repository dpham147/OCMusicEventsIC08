package edu.orangecoastcollege.cs273.dpham147.ocmusicevents;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class EventDetailsActivity extends AppCompatActivity {

    private ImageView eventImageView;
    private TextView eventTitleTextView;
    private TextView eventDateDayTextView;
    private TextView eventTimeTextView;
    private TextView eventLocationTextView;
    private TextView eventAddress1TextView;
    private TextView eventAddress2TextView;

    // in order to use AssetManager, need to know context
    private Context context = (Context) this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        eventImageView = (ImageView) findViewById(R.id.eventImageView);
        eventTitleTextView = (TextView) findViewById(R.id.eventTitleTextView);
        eventDateDayTextView = (TextView) findViewById(R.id.eventDateDayTextView);
        eventTimeTextView = (TextView) findViewById(R.id.eventTimeTextView);
        eventLocationTextView = (TextView) findViewById(R.id.eventLocationTextView);
        eventAddress1TextView = (TextView) findViewById(R.id.eventAddress1TextView);
        eventAddress2TextView = (TextView) findViewById(R.id.eventAddress2TextView);

        Intent fromListActivity = getIntent();

        String title = fromListActivity.getStringExtra("Title");
        String imageFileName = title.replace(" ", "") + ".jpeg";

        // load image from assets folder using asset manager class
        AssetManager am = context.getAssets();
        try {
            InputStream stream = am.open(imageFileName);
            Drawable image = Drawable.createFromStream(stream, title);
            eventImageView.setImageDrawable(image);
        }
        catch (IOException exception) {
            Log.e("OC Music Events", "Cannot load image: " + imageFileName + exception);
        }

        eventTitleTextView.setText(title);
        eventDateDayTextView.setText(fromListActivity.getStringExtra("DayDate"));
        eventTimeTextView.setText(fromListActivity.getStringExtra("Time"));
        eventLocationTextView.setText(fromListActivity.getStringExtra("Location"));
        eventAddress1TextView.setText(fromListActivity.getStringExtra("Address1"));
        eventAddress2TextView.setText(fromListActivity.getStringExtra("Address2"));
    }
}
