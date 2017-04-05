package com.nikhil.patel.demo_scrolling_tab.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.nikhil.patel.demo_scrolling_tab.R;
import com.nikhil.patel.demo_scrolling_tab.Fragments.Tab1;

/**
 * Created by ABC on 04-Apr-17.
 */

public class Activity_Tab1 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_tab_1);
        Toast toast=Toast.makeText(this,"Hello",Toast.LENGTH_SHORT);
        toast.show();
    }

    Tab1 t=new Tab1();
    public void tab1(View view){
        t.startTab1(view);
    }
}
