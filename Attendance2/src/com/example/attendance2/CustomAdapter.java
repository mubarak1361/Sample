package com.example.attendance2;

import java.util.ArrayList;
import java.util.zip.Inflater;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
	LayoutInflater inflater;
	private Context mcontext;
	ArrayList<Student> storedValues;
	int i=0;
	long date_id;
	SqliteAdapter db;
	public CustomAdapter(Context context, ArrayList<Student> storedValues,long date_id) {
		super();
		this.mcontext = context;
		this.storedValues = storedValues;
		this.date_id=date_id;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return storedValues.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return getItem(position);
	}
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView==null){
			db=new SqliteAdapter(mcontext);
			LayoutInflater inflater=(LayoutInflater)mcontext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			convertView=inflater.inflate(R.layout.list_row, null);
		}
		TextView id=(TextView)convertView.findViewById(R.id.textView1);
		TextView name=(TextView)convertView.findViewById(R.id.textView2);
		Switch s=(Switch)convertView.findViewById(R.id.switch1);
	
		id.setText(String.valueOf(storedValues.get(position).getId()));
		name.setText(storedValues.get(position).getName());
		db.addPresent(storedValues.get(position).getId(),date_id,false);
		
		s.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				 
				
				 //((MainActivity)mcontext).MainData(position, isChecked);
				
					    Log.e("val", "update");
						db.updateDATA(storedValues.get(position).getId(),date_id,isChecked);
					
			}
		});
		
		return convertView;
	}
	
	
}
