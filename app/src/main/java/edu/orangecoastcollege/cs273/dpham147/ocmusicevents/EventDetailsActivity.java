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
    private TextView eventDetailsTextView;
    // in order to use AssetManager, need to know context
    private Context context = (Context) this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        eventImageView = (ImageView) findViewById(R.id.eventImageView);
        eventTitleTextView = (TextView) findViewById(R.id.eventTitleTextView);
        eventDetailsTextView = (TextView) findViewById(R.id.eventDetailsTextView);

        Intent fromListActivity = getIntent();

        String title = fromListActivity.getStringExtra("Title");
        String details = fromListActivity.getStringExtra("Details");
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
        eventDetailsTextView.setText(details);
    }
}
