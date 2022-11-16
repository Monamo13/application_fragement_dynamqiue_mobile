package com.example.fragmentdy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Fragment1 fragment1;
    Fragment2 fragment2;
    Boolean isFragment1Showing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        getSupportFragmentManager().beginTransaction().add(R.id.framePourFragmentsDynamiques, fragment1).commit();
        isFragment1Showing = true;
        ((Button)findViewById(R.id.changerFragmentsBt)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switchFragments();
            }
        });
    }
    private void switchFragments() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(android.R.anim.slide_in_left , android.R.anim.slide_out_right);
        if (isFragment1Showing) {
            ft.replace(R.id.framePourFragmentsDynamiques, fragment2);
        }
        else {
            ft.replace(R.id. framePourFragmentsDynamiques, fragment1);
        }
        ft.commit();
        isFragment1Showing = !isFragment1Showing;
    }
}

