package com.halwong.timefriend.activity;

import br.com.dina.ui.widget.UITableView;
import br.com.dina.ui.widget.UITableView.ClickListener;

import com.halwong.timefriend.R;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import greendroid.app.GDActivity;

public class CatalogActivity extends GDActivity {
	UITableView tableView;
	public static int selectedIndex = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setActionBarContentView(R.layout.catalog);
		
		tableView = (UITableView)findViewById(R.id.tableView);
		createList();
		tableView.commit();
	}
	
	private void createList() {
        CustomClickListener listener = new CustomClickListener();
        tableView.setClickListener(listener);
        tableView.addBasicItem("简介", "");
        tableView.addBasicItem("前言", "");
        tableView.addBasicItem("第一章", getString(R.string.book_chapter1));
        tableView.addBasicItem("第二章", getString(R.string.book_chapter2));
        tableView.addBasicItem("第三章", getString(R.string.book_chapter3));
        tableView.addBasicItem("第四章", getString(R.string.book_chapter4));
        tableView.addBasicItem("第五章", getString(R.string.book_chapter5));
        tableView.addBasicItem("第六章", getString(R.string.book_chapter6));
        tableView.addBasicItem("第七章", getString(R.string.book_chapter7));
        tableView.addBasicItem(getString(R.string.book_appendix), "");
        tableView.addBasicItem(getString(R.string.book_index), "");
        tableView.addBasicItem(getString(R.string.book_reference), "");
        tableView.addBasicItem(getString(R.string.book_addon), "");
        tableView.addBasicItem(getString(R.string.book_claim), "");
        tableView.addBasicItem(getString(R.string.book_goto), "作者：梁晶");
        tableView.addBasicItem(getString(R.string.book_howto), "");
        tableView.addBasicItem(getString(R.string.book_editor), "");
        tableView.addBasicItem(getString(R.string.book_info), "");
    }
	
	private class CustomClickListener implements ClickListener {
        public void onClick(int index) {
        	selectedIndex = index;
        	Log.e("index", "" + selectedIndex);
        	Intent intent = new Intent(CatalogActivity.this, ContentActivity.class);
            startActivity(intent);
        }       
    }   
}
