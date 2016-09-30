package edu.orangecoastcollege.cs273.dpham147.ocmusicevents;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class EventListActivity extends ListActivity {

    private ArrayList<MusicEvent> allMusicEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Set adapter (binds listview with data in MusicEvent.java
        // Use an array adapter as data is in an array
        setListAdapter(new MusicEventAdapter(this, R.layout.music_event_list_item, allMusicEvents));

        // setContentView(R.layout.activity_event_list); //crashes
    }

    @Override
    protected void onListItemClick(ListView list, View v, int pos, long id) {
        // use position to extract title and details (MusicEvent.java)
        String title = allMusicEvents.get(pos).getTitle();
        String dateDay = allMusicEvents.get(pos).getDate() + " - " + allMusicEvents.get(pos).getDay();
        String time = allMusicEvents.get(pos).getTime();
        String location = allMusicEvents.get(pos).getLocation();
        String address1 = allMusicEvents.get(pos).getAddress1();
        String address2 = allMusicEvents.get(pos).getAddress2();

        Intent detailsIntent = new Intent(this, EventDetailsActivity.class);
        detailsIntent.putExtra("Title", title);
        detailsIntent.putExtra("DateDay", dateDay);
        detailsIntent.putExtra("Time", time);
        detailsIntent.putExtra("Location", location);
        detailsIntent.putExtra("Address1", address1);
        detailsIntent.putExtra("Address2", address2);

        startActivity(detailsIntent);
    }
}
