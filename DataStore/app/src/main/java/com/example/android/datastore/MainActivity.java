package com.example.android.datastore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText mEmailEditText;
    CheckBox mSaveCheckbox;

    SharedPreferences mPreference;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmailEditText = findViewById(R.id.edit_email);
        mSaveCheckbox = findViewById(R.id.save_checkbox);

        mPreference = getSharedPreferences("Example",MODE_PRIVATE);

        Boolean isEmailSaveChecked = mPreference.getBoolean("Save",false);
        mSaveCheckbox.setChecked(isEmailSaveChecked);

        if(isEmailSaveChecked){
            String Email = mPreference.getString("Email","");
            mEmailEditText.setText(Email);
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        editor = mPreference.edit();
        editor.clear();
        editor.putBoolean("Save",mSaveCheckbox.isChecked());
        editor.putString("Email",mEmailEditText.getText().toString());
        editor.apply();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
