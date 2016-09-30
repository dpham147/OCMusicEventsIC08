package edu.orangecoastcollege.cs273.dpham147.ocmusicevents;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EventListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Set adapter (binds listview with data in MusicEvent.java
        // Use an array adapter as data is in an array
        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicEvent.titles));

        // setContentView(R.layout.activity_event_list); //crashes
    }

    @Override
    protected void onListItemClick(ListView list, View v, int pos, long id) {
        // use position to extract title and details (MusicEvent.java)
        String title = MusicEvent.titles[pos];
        String details = MusicEvent.details[pos];

        Intent detailsIntent = new Intent(this, EventDetailsActivity.class);
        detailsIntent.putExtra("Title", title);
        detailsIntent.putExtra("Details", details);
        startActivity(detailsIntent);
    }
}
