package com.bhaskar8088.note;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.ArrayAdapter;

public class NotesListActivity extends ListActivity {
	ArrayList<String> note_ids = new ArrayList<String>();
	 public void onCreate(Bundle savedInstanceState) {
		    setContentView(R.layout.notes_list);
		    super.onCreate(savedInstanceState);
		    DbHandler db = new DbHandler(this);
		    List<Note> list = db.getAllNotes();
		    ArrayList<String> values = new ArrayList<String>();
		    for(Note list_item : list){
		    	values.add(list_item.title);
		    	note_ids.add(list_item.id+"");
		    }
		    
		        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		            android.R.layout.simple_list_item_1, values);
		        setListAdapter(adapter);
		        
	 }
	 protected void onListItemClick(ListView l, View v, final int position, long id) { 
	        super.onListItemClick(l, v, position, id);                
	        Intent myIntent = new Intent(NotesListActivity.this, NoteActivity.class); // when a row is tapped, load SubView.class

	        String selectionID = note_ids.get(position); // get the value from employeIdArray which corrosponds to the 'position' of the selected row
	        myIntent.putExtra("note_id", selectionID); // add selectionID to the Intent   

	        startActivity(myIntent); // display SubView.class  

	    } 
}
