package com.alex.piper.activity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.alex.piper.R;
import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Database;
import com.couchbase.lite.Document;
import com.couchbase.lite.Manager;
import com.couchbase.lite.Query;
import com.couchbase.lite.QueryEnumerator;
import com.couchbase.lite.QueryRow;

public class MainActivity extends Activity {
	protected static Manager manager;
	private Database database;
	public static final String DATABASE_NAME = "piper-user-action";
	private static final String TAG = MainActivity.class.getName();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        try {
			manager = new Manager(getApplicationContext().getFilesDir(), Manager.DEFAULT_OPTIONS);
			database = manager.getDatabase(DATABASE_NAME);

			Document document = database.createDocument();
			Map<String, Object> properties = new HashMap<String, Object>();
			
			properties.put("clusterId", new Random().nextInt(3));
			properties.put("action", "eat:" + UUID.randomUUID().toString());
			document.putProperties(properties);
			
			Query documentsQuery = database.createAllDocumentsQuery();
			QueryEnumerator enumerator = documentsQuery.run();
			
			
			while (enumerator.hasNext()) {
				QueryRow row = enumerator.next();
				Log.i(TAG, "row info: ["+row.getDocument().getProperties().toString()+"]");
			}
        } catch (IOException e) {
			e.printStackTrace();
		} catch (CouchbaseLiteException e) {
			e.printStackTrace();
		}

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
