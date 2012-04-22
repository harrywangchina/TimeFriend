package com.halwong.timefriend.activity;

import greendroid.app.GDActivity;
import greendroid.widget.ActionBarItem;
import greendroid.widget.ActionBarItem.Type;
import greendroid.widget.QuickAction;
import greendroid.widget.QuickActionGrid;
import greendroid.widget.QuickActionWidget;
import greendroid.widget.QuickActionWidget.OnQuickActionClickListener;

import com.halwong.timefriend.R;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends GDActivity {
	private static final int ACTION_BAR_HOME = 0;
	private static final int ACTION_BAR_INFO = 1;

	private QuickActionGrid mGrid;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setActionBarContentView(R.layout.main);

		addActionBarItem(Type.Info, ACTION_BAR_INFO);

		prepareQuickActionGrid();

		addActionBarItem(Type.Edit);
	}

	public void onShowGrid(View v) {
		mGrid.show(v);
	}

	private void prepareQuickActionGrid() {
		mGrid = new QuickActionGrid(this);
		mGrid.addQuickAction(new MyQuickAction(this,
				R.drawable.gd_action_bar_compose, R.string.gd_compose));
		mGrid.addQuickAction(new MyQuickAction(this,
				R.drawable.gd_action_bar_export, R.string.gd_export));
		mGrid.addQuickAction(new MyQuickAction(this,
				R.drawable.gd_action_bar_share, R.string.gd_share));
		mGrid.addQuickAction(new MyQuickAction(this,
				R.drawable.gd_action_bar_search, R.string.gd_search));
		mGrid.addQuickAction(new MyQuickAction(this,
				R.drawable.gd_action_bar_edit, R.string.gd_edit));
		mGrid.addQuickAction(new MyQuickAction(this,
				R.drawable.gd_action_bar_locate, R.string.gd_locate));

		mGrid.setOnQuickActionClickListener(mActionListener);
	}

	private OnQuickActionClickListener mActionListener = new OnQuickActionClickListener() {
		public void onQuickActionClicked(QuickActionWidget widget, int position) {
			switch (position) {
			case 0:
				Toast.makeText(MainActivity.this,
						"Item " + position + " clicked", Toast.LENGTH_SHORT)
						.show();

				break;

			case 1:
				startActivity(new Intent(MainActivity.this, CatalogActivity.class));
				break;
				
			case 2:
				Toast.makeText(MainActivity.this,
						"Item " + position + " clicked", Toast.LENGTH_SHORT)
						.show();

				break;
				
			case 3:
				Toast.makeText(MainActivity.this,
						"Item " + position + " clicked", Toast.LENGTH_SHORT)
						.show();
				break;
			case 4:
				startActivity(new Intent(MainActivity.this, InfoActivity.class));
				break;
			case 5:
				Toast.makeText(MainActivity.this,
						"Item " + position + " clicked", Toast.LENGTH_SHORT)
						.show();
				break;

			default:
				break;
			}
		}
	};

	private static class MyQuickAction extends QuickAction {

		private static final ColorFilter BLACK_CF = new LightingColorFilter(
				Color.BLACK, Color.BLACK);

		public MyQuickAction(Context ctx, int drawableId, int titleId) {
			super(ctx, buildDrawable(ctx, drawableId), titleId);
		}

		private static Drawable buildDrawable(Context ctx, int drawableId) {
			Drawable d = ctx.getResources().getDrawable(drawableId);
			d.setColorFilter(BLACK_CF);
			return d;
		}

	}

	@Override
	public boolean onHandleActionBarItemClick(ActionBarItem item, int position) {
		switch (item.getItemId()) {
		case ACTION_BAR_INFO:
			startActivity(new Intent(this, InfoActivity.class));
			break;
		default:
			return super.onHandleActionBarItemClick(item, position);
		}
		return true;
	}
}