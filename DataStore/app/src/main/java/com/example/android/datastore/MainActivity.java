package com.example.android.datastore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private String emailText;

    EditText mEmailEditText;
    CheckBox mSaveCheckbox;

    private SharedPreferences mPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmailEditText = findViewById(R.id.edit_email);
        mSaveCheckbox = findViewById(R.id.save_checkbox);

        mPreference = PreferenceManager.getDefaultSharedPreferences(this);

        Boolean isEmailSaveChecked = mPreference.getBoolean("Save",false);
        mSaveCheckbox.setChecked(isEmailSaveChecked);

        if(isEmailSaveChecked){
            String Email = mPreference.getString("Email","");
            mEmailEditText.setText(Email);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        SharedPreferences.Editor editor = mPreference.edit();

        editor.putBoolean("save",mSaveCheckbox.isChecked());
        editor.apply();

    }
}
