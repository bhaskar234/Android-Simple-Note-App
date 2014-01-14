package com.bhaskar8088.note;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
 
public class BaseActivity extends Activity{
 
 @Override
 public boolean onCreateOptionsMenu(Menu menu) {
  getMenuInflater().inflate(R.layout.common_menu, menu);
  return true;
 }
  
 @Override
 public boolean onOptionsItemSelected(MenuItem item) {
 
  switch (item.getItemId()) {
   
  case R.id.all_notes:
   Intent intent = new Intent(BaseActivity.this, NotesListActivity.class);
   startActivity(intent);
   return true;
    
  case R.id.new_note:
	   Intent intent1 = new Intent(BaseActivity.this, MainActivity.class);
	   startActivity(intent1);
	   return true;
	    
  default:
   return super.onOptionsItemSelected(item);
  }
 
 }
  
}