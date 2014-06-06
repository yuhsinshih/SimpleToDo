package com.example.simpletodo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends Activity {

//	private final int REQUEST_CODE = 20;
	int position = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		System.out.println("Edit onCreate");
		String editText = getIntent().getStringExtra("text");

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_item);
		
		EditText etNewItem = (EditText) findViewById(R.id.editItemText);
		position = getIntent().getIntExtra("position", 0);
		etNewItem.setText(editText);
	}
	
	public void onSubmit(View v){
		EditText etNewItem = (EditText) findViewById(R.id.editItemText);
		Intent data = new Intent();
		data.putExtra("text", etNewItem.getText().toString());
		data.putExtra("position", position);
		this.setResult(RESULT_OK, data);
		this.finish();
	}
}
