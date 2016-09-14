package course.labs.activitylab;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.content.SharedPreferences;

public class ActivityOne extends Activity {

		// string for logcat documentation
		private final static String TAG = "Lab-ActivityOne";

	
		// lifecycle counts
		//Create 7 counter variables, each corresponding to a different one of the lifecycle callback methods.
		// You will need to increment these variables' values when their corresponding lifecycle methods get called.  
		int stopCtr = 0;
		int pauseCtr = 0;
		int resumeCtr = 0;
		int startCtr = 0;
		int destroyCtr = 0;
		int createCtr = 0;
		int restartCtr = 0;

		SharedPreferences prefs;


		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_one);

			if (savedInstanceState != null){
				// Restore value of counters from saved state
				stopCtr = savedInstanceState.getInt("stopCtr");
				startCtr = savedInstanceState.getInt("startCtr");
				pauseCtr = savedInstanceState.getInt("pauseCtr");
				createCtr = savedInstanceState.getInt("createCtr");
				destroyCtr = savedInstanceState.getInt("destroyCtr");
				restartCtr = savedInstanceState.getInt("restartCtr");
				resumeCtr = savedInstanceState.getInt("resumeCtr");
			}

			prefs = getPreferences(MODE_PRIVATE);
			if(prefs.getInt("createCtr", createCtr) != 0)
			{
				stopCtr = prefs.getInt("stopCtr", stopCtr);
				startCtr = prefs.getInt("startCtr", startCtr);
				pauseCtr = prefs.getInt("pauseCtr", pauseCtr);
				createCtr = prefs.getInt("createCtr", createCtr);
				destroyCtr = prefs.getInt("destroyCtr", destroyCtr);
				restartCtr = prefs.getInt("restartCtr", restartCtr);
				resumeCtr = prefs.getInt("resumeCtr", resumeCtr);
			}

			//Log cat print out
			Log.i(TAG, "onCreate called");
			
			//TODO:
			//update the appropriate count variable
			createCtr ++;
			//update the view
			TextView createText = (TextView) findViewById(R.id.create);
			createText.setText("onCreate() calls:" + Integer.toString(createCtr));
		}

		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.activity_one, menu);
			return true;
		}
		
		// lifecycle callback overrides
		
		@Override
		public void onStart(){
			super.onStart();
			
			//Log cat print out
			Log.i(TAG, "onStart called");
			
			//TODO:
			//update the appropriate count variable
			startCtr++;
			//update the view
			TextView startText = (TextView) findViewById(R.id.start);
			startText.setText("onStart() calls:" + Integer.toString(startCtr));
		}

	    // TODO: implement 5 missing lifecycle callback methods
		@Override
		public void onResume(){
			super.onResume();

			//Log cat print out
			Log.i(TAG, "onResume called");

			//TODO:
			//update the appropriate count variable
			resumeCtr++;
			//update the view
			TextView resumeText = (TextView) findViewById(R.id.resume);
			resumeText.setText("onResume() calls:" + Integer.toString(resumeCtr));
		}
		@Override
		public void onPause(){
			super.onPause();

			//Log cat print out
			Log.i(TAG, "onPause called");

			//TODO:
			//update the appropriate count variable
			pauseCtr++;
			//update the view
			TextView pauseText = (TextView) findViewById(R.id.pause);
			pauseText.setText("onPause() calls:" + Integer.toString(pauseCtr));
		}

		@Override
		public void onStop(){
			super.onStop();

			//Log cat print out
			Log.i(TAG, "onStop called");

			//TODO:
			//update the appropriate count variable
			stopCtr++;
			//update the view
			TextView stopText = (TextView) findViewById(R.id.stop);
			stopText.setText("onStop() calls:" + Integer.toString(stopCtr));

			SharedPreferences.Editor editor = prefs.edit();
			editor.putInt("startCtr", startCtr);
			editor.putInt("restartCtr", restartCtr);
			editor.putInt("createCtr", createCtr);
			editor.putInt("stopCtr", stopCtr);
			editor.putInt("destroyCtr", destroyCtr);
			editor.putInt("pauseCtr", pauseCtr);
			editor.putInt("resumeCtr", resumeCtr);

			editor.commit();

		}

		@Override
		public void onRestart(){
			super.onRestart();

			//Log cat print out
			Log.i(TAG, "onRestart called");

			//TODO:
			//update the appropriate count variable
			restartCtr++;
			//update the view
			TextView restartText = (TextView) findViewById(R.id.restart);
			restartText.setText("onRestart() calls:" + Integer.toString(restartCtr));
		}
		@Override
		public void onDestroy(){
			super.onDestroy();

			//Log cat print out
			Log.i(TAG, "onDestroy called");

			//TODO:
			//update the appropriate count variable
			destroyCtr++;
			//update the view
			TextView destroyText = (TextView) findViewById(R.id.start);
			destroyText.setText("onDestroy() calls:" + Integer.toString(destroyCtr));
		}
		@Override
		public void onSaveInstanceState(Bundle savedInstanceState){
			//TODO:
			// save state information with a collection of key-value pairs
			savedInstanceState.putInt("startCtr", startCtr);
			savedInstanceState.putInt("restartCtr", restartCtr);
			savedInstanceState.putInt("destroyCtr", destroyCtr);
			savedInstanceState.putInt("pauseCtr", pauseCtr);
			savedInstanceState.putInt("stopCtr", stopCtr);
			savedInstanceState.putInt("createCtr", createCtr);
			savedInstanceState.putInt("resumeCtr", resumeCtr);
			// save all  count variables
			super.onSaveInstanceState(savedInstanceState);
		}
		
		public void launchActivityTwo(View view) {
			//TODO:
			// This function launches Activity Two. 
			// Hint: use Context’s startActivity() method.
			Intent i = new Intent(ActivityOne.this, ActivityTwo.class);
			startActivity(i);
		}
		

}
