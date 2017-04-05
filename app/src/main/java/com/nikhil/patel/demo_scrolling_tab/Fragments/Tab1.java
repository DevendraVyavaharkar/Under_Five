package com.nikhil.patel.demo_scrolling_tab.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.nikhil.patel.demo_scrolling_tab.Activity.Under5_Core;
import com.nikhil.patel.demo_scrolling_tab.R;
import com.nikhil.patel.demo_scrolling_tab.BackgroundFunction.BackgroundTaskCR1;
import com.nikhil.patel.demo_scrolling_tab.BackgroundFunction.TaskCompleteCR;
/**
 * Created by nikhil on 10-02-2017.
 */

public class Tab1 extends Fragment implements TaskCompleteCR{

    public Tab1() {}

    TextView txt;
    Button button1;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_tab_1, container, false);
        txt= (TextView) view.findViewById(R.id.TextView1);
        button1 = (Button) view.findViewById(R.id.button_tab1);
        return view;
    }

    //button1.setOnClickListener(new View.OnClickListener)
    //{
      //  @Override
        //public void onClick(View view)
        //{
        //    BackgroundTaskCR1 backgroundTaskCR1 = new BackgroundTaskCR1(getActivity().getApplicationContext() /*, dialog */, Tab1.this);
         //   backgroundTaskCR1.execute(txt.getText().toString());
        //}
    //}

    public void startTab1(View view)
    {

          BackgroundTaskCR1 backgroundTaskCR1 = new BackgroundTaskCR1(getActivity().getApplicationContext() /*, dialog */, Tab1.this);
          backgroundTaskCR1.execute(txt.getText().toString());
    }

    @Override
    public void TaskCreate(){}
    @Override
    public void TaskRecords() {
        txt.setText("Child Identifier: "+ Under5_Core.childidentifier+
                "\nFamily Identifier: "+Under5_Core.familyidentifier+
                "\nAddress: "+Under5_Core.address+
                "\nMobile Number: "+Under5_Core.mobilenumber+
                "\nChild Name: "+Under5_Core.childname+
                "\nFather's Name: "+Under5_Core.fathername+
                "\nMother's Name: "+Under5_Core.mothername+
                "\nDate of Birth: "+Under5_Core.dob+
                "\nSex: "+Under5_Core.sex);
    }
    @Override
    public void TaskUpdate() {}
}
