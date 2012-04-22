package com.halwong.timefriend.activity;

import com.halwong.timefriend.R;

import android.content.Intent;
import android.net.Uri;
import greendroid.app.GDApplication;

public class GDActionBarExampleApplication extends GDApplication {
	@Override
    public Class<?> getHomeActivityClass() {
        return MainActivity.class;
    }
 
    @Override
    public Intent getMainApplicationIntent() {
        return new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.app_url)));
    }
}
