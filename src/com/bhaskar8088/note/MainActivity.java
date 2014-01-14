package com.bhaskar8088.note;

import com.bhaskar8088.note.Note;
import com.bhaskar8088.note.NoteActivity;
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

public class MainActivity extends BaseActivity {
	
	DbHandler db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button b1;
        b1 = (Button) findViewById(R.id.sbmt);
        db = new DbHandler(this);
        b1.setOnClickListener(myhandler1);
	}
	
        View.OnClickListener myhandler1 = new View.OnClickListener() {
            public void onClick(View v) {
              // it was the 1st button
            	TextView result;
            	EditText title, content;
            	title = (EditText)findViewById(R.id.title);
            	content = (EditText)findViewById(R.id.content);
            	
            	long id = db.addNote(new Note(title.getText().toString(), content.getText().toString()));
            	
            	Intent intent = new Intent(MainActivity.this, NoteActivity.class);
            	intent.putExtra("note_id", id+"");
            	startActivity(intent);
            }
        };
	


}
