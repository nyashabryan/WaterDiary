package com.example.nyashadzaishebryan.waterdiary;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class CalculatorActivity extends AppCompatActivity {

    int runningTotal = 0;

    /**
     * OnCreate sets the content View to the layout and sets the onEditListeners on the
     * EditText views in the layout.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        setOnEditListeners();
    }

    /**
     * Sets the onClickListeners to the Save and Cancel Buttons.
     */
    @Override
    protected void onResume() {
        super.onResume();

        Button save_button = findViewById(R.id.calculator_save_button);
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Log.w("Saving", "Button Clicked");
                saveEnteredUse();
            }
        });

        Button cancel_button = (Button)findViewById(R.id.calculator_cancel_button);
        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMainActivity();
            }
        });
    }

    /**
     * Sets onEditListeners to all the predefined EditText views on the layout. All the listeners
     * have a TextWatcher callback to watch for any edits to the text on the EditText views. After a
     * change has been made, the runningTotal is updated.
     */
    private void setOnEditListeners() {
        EditText showerInput = findViewById(R.id.calculator_input_shower);
        showerInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                updateRunningTotal(Integer.parseInt(s.toString()));
            }
        });

        EditText otherInput = findViewById(R.id.calculator_input_other);
        otherInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                updateRunningTotal(Integer.parseInt(s.toString()));
            }
        });

        EditText hygieneInput = findViewById(R.id.calculator_input_hygiene);
        hygieneInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                updateRunningTotal(Integer.parseInt(s.toString()));
            }
        });

        EditText toiletInput = findViewById(R.id.calculator_input_toilet);
        toiletInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                updateRunningTotal(Integer.parseInt(s.toString()));
            }
        });

        EditText drinkingInput = findViewById(R.id.calculator_input_drinking);
        drinkingInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                updateRunningTotal(Integer.parseInt(s.toString()));
            }
        });

        EditText laundryInput = findViewById(R.id.calculator_input_laundry);
        laundryInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                updateRunningTotal(Integer.parseInt(s.toString()));
            }
        });

        EditText cookingInput = findViewById(R.id.calculator_input_cooking);
        cookingInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                updateRunningTotal(Integer.parseInt(s.toString()));
            }
        });

        EditText cleaningInput = findViewById(R.id.calculator_input_cleaning);
        cleaningInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                updateRunningTotal(Integer.parseInt(s.toString()));
            }
        });

        EditText dishesInput = findViewById(R.id.calculator_input_dishes);
        dishesInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                updateRunningTotal(Integer.parseInt(s.toString()));
            }
        });
    }

    /**
     * Takes in an integer value from the EditText views and updates the runningTotal using this
     * value. Updates the runningTotal view using the updateTotalView() method.
     *
     * @param value
     */
    private void updateRunningTotal(int value){
        this.runningTotal+=value;
        updateTotalView();
    }

    /**
     * Updates the calculator total view setting it's text to the current value of the
     * runningTotal.
     */
    private void updateTotalView() {
        TextView totalText = findViewById(R.id.calculator_input_total);
        totalText.setText(Integer.toString(runningTotal));
    }

    /**
     * Checks if the user has inputted values for all the input fields on the layout.
     * @return boolean
     */
    private boolean allEntered(){
        return !((EditText)findViewById(R.id.calculator_input_dishes)).getText().toString().equals("") &&
                !((EditText)findViewById(R.id.calculator_input_cooking)).getText().toString().equals("") &&
                !((EditText)findViewById(R.id.calculator_input_drinking)).getText().toString().equals("") &&
                !((EditText)findViewById(R.id.calculator_input_other)).getText().toString().equals("") &&
                !((EditText)findViewById(R.id.calculator_input_hygiene)).getText().toString().equals("") &&
                !((EditText)findViewById(R.id.calculator_input_shower)).getText().toString().equals("") &&
                !((EditText)findViewById(R.id.calculator_input_cleaning)).getText().toString().equals("") &&
                !((EditText)findViewById(R.id.calculator_input_laundry)).getText().toString().equals("");

    }

    /**
     * Saves all the inputted values of WaterUsage as a DayUse object into the database using
     * a SavingDataAsyncTask object.
     */
    private void saveEnteredUse(){
        DayUse dayUse = new DayUse(
                Integer.parseInt(((EditText)findViewById(R.id.calculator_input_cleaning)).getText().toString()),
                Integer.parseInt(((EditText)findViewById(R.id.calculator_input_cooking)).getText().toString()),
                Integer.parseInt(((EditText)findViewById(R.id.calculator_input_dishes)).getText().toString()),
                Integer.parseInt(((EditText)findViewById(R.id.calculator_input_drinking)).getText().toString()),
                Integer.parseInt(((EditText)findViewById(R.id.calculator_input_hygiene)).getText().toString()),
                Integer.parseInt(((EditText)findViewById(R.id.calculator_input_laundry)).getText().toString()),
                Integer.parseInt(((EditText)findViewById(R.id.calculator_input_other)).getText().toString()),
                Integer.parseInt(((EditText)findViewById(R.id.calculator_input_shower)).getText().toString()),
                Integer.parseInt(((EditText)findViewById(R.id.calculator_input_toilet)).getText().toString()),
                (new Date()).getTime()
        );
        Log.w("Saving", "About to start saving the data");
        new SavingDataAsyncTask(this).execute(dayUse);
    }

    /**
     * Resets the activity values without reCreating the actual activity. It will reset all the
     * input values to 0 and reset the runningTotal variable to 0. Lastly calls the updateTotal
     * method to update the runningTotal View.
     *
     */
    private void ResetInputs(){

        // Reset the runningTotal variable
        runningTotal = 0;
        // Reset the EditText fields
        ((EditText)findViewById(R.id.calculator_input_cleaning)).setText(R.string.zero);
        ((EditText)findViewById(R.id.calculator_input_cooking)).setText(R.string.zero);
        ((EditText)findViewById(R.id.calculator_input_dishes)).setText(R.string.zero);
        ((EditText)findViewById(R.id.calculator_input_drinking)).setText(R.string.zero);
        ((EditText)findViewById(R.id.calculator_input_hygiene)).setText(R.string.zero);
        ((EditText)findViewById(R.id.calculator_input_laundry)).setText(R.string.zero);
        ((EditText)findViewById(R.id.calculator_input_other)).setText(R.string.zero);
        ((EditText)findViewById(R.id.calculator_input_shower)).setText(R.string.zero);
        ((EditText)findViewById(R.id.calculator_input_toilet)).setText(R.string.zero);

        updateTotalView();
    }

    /**
     * Starts the MainActivity.
     */
    private void goToMainActivity(){
        Intent toMainActivityIntent = new Intent(this, MainActivity.class);
        startActivity(toMainActivityIntent);
    }

    private static class SavingDataAsyncTask extends AsyncTask<DayUse,Void, Void>{

        private CalculatorActivity activity;

        SavingDataAsyncTask(CalculatorActivity activity){
            this.activity = activity;
        }
        @Override
        protected Void doInBackground(DayUse...dayUse) {
            DayUseDatabase db = Room.databaseBuilder(activity.getApplicationContext(),
                    DayUseDatabase.class, "database-name").build();
            Log.w("Saving", "Writing");
            db.dayUseDao().insertAll(dayUse);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.w("Saving", "Done writing");
            //TODO
        }
    }
}


