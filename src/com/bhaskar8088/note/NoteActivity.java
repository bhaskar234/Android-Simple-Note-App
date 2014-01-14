package com.bhaskar8088.note;

import com.bhaskar8088.note.Note;
import com.bhaskar8088.note.DbHandler;
import com.bhaskar8088.note.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NoteActivity extends BaseActivity {
	int note_id;
	DbHandler db;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.note);
		db = new DbHandler(this);
		Intent intent = getIntent();
		String snid = intent.getStringExtra("note_id");
		int nid = Integer.parseInt(snid);
		Note note = db.getNote(nid);
		
		TextView title, content;
		title = (TextView)findViewById(R.id.title);
		content = (TextView)findViewById(R.id.content);
		title.setText(note.getTitle());
		content.setText(note.getContent());
		
	}
	
	
        
	

}
