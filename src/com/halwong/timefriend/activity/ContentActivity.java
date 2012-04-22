package com.halwong.timefriend.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.webkit.WebView;

import com.halwong.timefriend.R;

import greendroid.app.GDActivity;

public class ContentActivity extends GDActivity {
	private WebView contentView;
	private List<String> catalogList;
	private int selectedIndex;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setActionBarContentView(R.layout.content);
		
		contentView = (WebView)findViewById(R.id.contentView);
		
		
		initCatalogList();
		selectedIndex = CatalogActivity.selectedIndex;
		Log.e("index", "" + selectedIndex);
		contentView.loadUrl(catalogList.get(selectedIndex));
	}
	
	@Override
	protected void onPause() {
		PreferenceManager.getDefaultSharedPreferences(this).edit()
			.putInt("position", contentView.getScrollY()).commit();
		super.onPause();
		Log.e("life", "onpause");
	}
	
	@Override
	protected void onResume() {
		int position = PreferenceManager.getDefaultSharedPreferences(this)
				.getInt("position", 0);
		
		contentView.scrollTo(0, position);
		super.onResume();
		Log.e("life", "onresume" + position);
	}
	
	private void initCatalogList() {
		String intro_url = "file:///android_asset/html/intro.html";
		String preface_url = "file:///android_asset/html/preface.html";
		
		catalogList = new ArrayList<String>();
		catalogList.add(0, intro_url);
		catalogList.add(1, preface_url);
	}
	
}
