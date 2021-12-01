package com.example.demofragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements InputDialogFragment.InputListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickName(View view){
        DialogFragment dialogFragment = new InputDialogFragment();
        dialogFragment.show(getSupportFragmentManager(),"NAME_DIALOG");
    }

    @Override
    public void onInput(String name) {
        ((TextView) findViewById(R.id.text_name)).setText(name);
    }
}