package com.example.nyashadzaishebryan.waterdiary;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity{

    MainPresenter presenter;

    public void setUp(){
        presenter = new MainPresenter(this);
    }

    private void renderList(List<DayUse> dayUses){
        Log.w("Main", "About to render!");
        Log.w("Main", dayUses.toString());
        ListView mainList = findViewById(R.id.main_list);
        ArrayAdapter<DayUse> adapter = new ArrayAdapter<DayUse>(this.getApplicationContext(),
                R.layout.list_textview, dayUses);
        mainList.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUp();
        setContentView(R.layout.activity_main);
    }


    @Override
    protected void onResume(){
        super.onResume();
        // Async loading of the list of dayUses objects
        Log.w("Main", "Making Retrieve class");
        new RetrieveDayUses(this).execute();

        // Set on Click Listeners for + button
        FloatingActionButton fab = findViewById(R.id.fab_add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToCalculator();
            }
        });

        // Set OnClick Listener for the List Items
        ListView mainList = findViewById(R.id.main_list);
        mainList.setOnItemClickListener(mMessageClickedHandler);

    }

    private AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            goToDiary(position+1, parent.getCount());
        }
    };

    private void goToCalculator(){
        Intent toCalculatorIntent = new Intent(this, CalculatorActivity.class);
        startActivity(toCalculatorIntent);
    }

    private void goToDiary(int position, int count){
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        bundle.putInt("count", count);
        Intent toDiaryIntent = new Intent(this, DiaryActivity.class);
        toDiaryIntent.putExtras(bundle);
        startActivity(toDiaryIntent);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private static class RetrieveDayUses extends AsyncTask<Void, Void, List<DayUse>>{

        MainActivity activity;
        private RetrieveDayUses(MainActivity activity){
            this.activity = activity;
        }

        @Override
        protected List<DayUse> doInBackground(Void... voids) {
            List<DayUse> dayUses;
            dayUses = activity.presenter.getListOfDayUses();
            return dayUses;
        }

        @Override
        protected void onPostExecute(List<DayUse> dayUses) {
            super.onPostExecute(dayUses);
            activity.renderList(dayUses);
        }
    }

}