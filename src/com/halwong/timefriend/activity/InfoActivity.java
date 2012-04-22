package com.halwong.timefriend.activity;

import android.os.Bundle;
import android.widget.TextView;
import br.com.dina.ui.widget.UITableView;
import greendroid.app.GDActivity;
import com.halwong.timefriend.R;

public class InfoActivity extends GDActivity {
	TextView infoTextView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setActionBarContentView(R.layout.info);
		
		//infoView = (UITableView)findViewById(R.id.infoView);
		//createList();
		//infoView.commit();
		infoTextView = (TextView)findViewById(R.id.infoTextView);
		infoTextView.setText(getString(R.string.info_activity_title));
	}
	
	/*private void createList() {
		infoView.addBasicItem("", getString(R.string.info_activity_title));
	}*/
}
