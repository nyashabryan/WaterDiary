package com.example.nyashadzaishebryan.waterdiary;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DiaryActivity extends AppCompatActivity {

    private DiaryPresenter presenter;

    private int currentIndex;
    protected int maxIndex;

    private void setUp(){
        this.presenter = new DiaryPresenter(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUp();
        setContentView(R.layout.activity_diary);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            currentIndex = extras.getInt("position", 1);
            maxIndex = extras.getInt("count", 1);
        }
        else{
            currentIndex = 1;
            maxIndex = 1;
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.w("Dairy", Integer.toString(maxIndex));
        new RenderDiaryEntriesAsyncTask(this).execute(currentIndex);

        // Set onClick Listeners to the buttons
        Button prev = findViewById(R.id.diary_prev_button);
        if (!(hasPrev())){
            prev.setVisibility(View.INVISIBLE);
        } else{
            prev.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentIndex--;
                    restartActivity();
                }
            });
        }

        Button next = findViewById(R.id.diary_next_button);
        if (!(hasNext())){
            next.setVisibility(View.INVISIBLE);
        } else{
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentIndex++;
                    restartActivity();
                }
            });
        }

        Button overview = findViewById(R.id.diary_overview_button);
        overview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMainActivity();
            }
        });

        FloatingActionButton fab = findViewById(R.id.diary_fab_add);
        fab.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                goToCalculatorActivity();
            }
        });

    }

    private void restartActivity(){
        Intent restartIntent = getIntent();
        restartIntent.putExtra("position", this.currentIndex);
        startActivity(restartIntent);
    }

    private void goToMainActivity(){
        Intent toMainActivityIntent = new Intent(this, MainActivity.class);
        startActivity(toMainActivityIntent);
    }

    private void goToCalculatorActivity(){
        Intent toCalculatorActivity = new Intent(this, CalculatorActivity.class);
        startActivity(toCalculatorActivity);
    }

    private boolean hasNext(){
        return this.currentIndex < this.maxIndex;
    }

    private boolean hasPrev(){
        return !(this.currentIndex == 1);
    }

    public void setMaxIndex(int newMax){
        Log.w("New Max", Integer.toString(newMax));
        this.maxIndex = newMax;
    }

    private void renderPage(DayUse currentDayUse){

        TextView diary_date = findViewById(R.id.diary_date);
        diary_date.setText(currentDayUse.getDateAsString());

        TextView diary_hygiene = findViewById(R.id.diary_hygiene);
        diary_hygiene.setText(String.valueOf(currentDayUse.getHygiene()));

        TextView diary_shower = findViewById(R.id.diary_shower);
        diary_shower.setText(String.valueOf(currentDayUse.getShower()));

        TextView diary_toilet = findViewById(R.id.diary_toilet);
        diary_toilet.setText(String.valueOf(currentDayUse.getToilet()));

        TextView diary_other = findViewById(R.id.diary_other);
        diary_other.setText(String.valueOf(currentDayUse.getOther()));

        TextView diary_drinking = findViewById(R.id.diary_drinking);
        diary_drinking.setText(String.valueOf(currentDayUse.getDrinking()));

        TextView diary_laundry = findViewById(R.id.diary_laundry);
        diary_laundry.setText(String.valueOf(currentDayUse.getLaundry()));

        TextView diary_cleaning = findViewById(R.id.diary_cleaning);
        diary_cleaning.setText(String.valueOf(currentDayUse.getCleaning()));

        TextView diary_cooking = findViewById(R.id.diary_cooking);
        diary_cooking.setText(String.valueOf(currentDayUse.getCooking()));

        TextView diary_dishes = findViewById(R.id.diary_dishes);
        diary_dishes.setText(String.valueOf(currentDayUse.getDishes()));

        TextView diary_total = findViewById(R.id.diary_total);
        diary_total.setText(String.valueOf(currentDayUse.getTotalUsage()));

    }

    /**
     *  Gets a DayUse object from the database asynchronously and renders it on the page.
     *
     */
    private static class RenderDiaryEntriesAsyncTask extends AsyncTask<Integer, Void, DayUse>{

        DiaryActivity activity;

        /**
         * Constructor. Takes in a DiaryActivity object in which it is.
         * @param activity
         */

        private RenderDiaryEntriesAsyncTask(DiaryActivity activity){
            this.activity = activity;
        }

        /**
         * Accesses the dataBase through the presenter and returns a DayUse object that with the
         * selected index.
         * @param listOfIntegers
         * @return
         */
        @Override
        protected DayUse doInBackground(Integer...listOfIntegers) {
            activity.setMaxIndex(activity.presenter.getMaxIndex());
            return activity.presenter.getDayUseByIndex(listOfIntegers[0]);
        }

        @Override
        protected void onPostExecute(DayUse dayUse) {
            super.onPostExecute(dayUse);
            activity.renderPage(dayUse);
        }
    }
}
