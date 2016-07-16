package com.example.mihael.mykeyboardvol4;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.mihael.mykeyboardvol4.R;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SwapActivity extends AppCompatActivity {


    public static EditText tv;
    public static Button buttonNumbers [];
    public static Button monkey, colon, semicolon, dash, hyphen, hashTag, left_bracket, right_bracket, slash, plus;
    public static Button empty, dot, dot2, comma, question, ex_mark, single_quote, double_quote, del, back, space, newLine;


    //niz buttona
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_with_custom_action_button2);


        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new CustomButtonDemoFragmente())
                    .commit();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_with_custom_action_button, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class CustomButtonDemoFragmente extends Fragment {

        public CustomButtonDemoFragmente() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.additional_layout, container, false);

            buttonNumbers = new Button[10];
            tv = (EditText) rootView.findViewById(R.id.tv2);
            tv.setText(ListKeeper.text);
            tv.setSelection(tv.getText().length());
            buttonNumbers[0] = (Button) rootView.findViewById(R.id.c0);
            buttonNumbers[1] = (Button) rootView.findViewById(R.id.c1);
            buttonNumbers[2] = (Button) rootView.findViewById(R.id.c2);
            buttonNumbers[3] = (Button) rootView.findViewById(R.id.c3);
            buttonNumbers[4] = (Button) rootView.findViewById(R.id.c4);
            buttonNumbers[5] = (Button) rootView.findViewById(R.id.c5);
            buttonNumbers[6] = (Button) rootView.findViewById(R.id.c6);
            buttonNumbers[7] = (Button) rootView.findViewById(R.id.c7);
            buttonNumbers[8] = (Button) rootView.findViewById(R.id.c8);
            buttonNumbers[9] = (Button) rootView.findViewById(R.id.c9);
            monkey =  (Button) rootView.findViewById(R.id.k1);
            colon =  (Button) rootView.findViewById(R.id.k2);
            semicolon =  (Button) rootView.findViewById(R.id.k3);
            dash =  (Button) rootView.findViewById(R.id.k4);
            hyphen =  (Button) rootView.findViewById(R.id.k5);
            hashTag =  (Button) rootView.findViewById(R.id.k6);
            left_bracket =  (Button) rootView.findViewById(R.id.k7);
            right_bracket =  (Button) rootView.findViewById(R.id.k8);
            slash =  (Button) rootView.findViewById(R.id.k9);
            plus =  (Button) rootView.findViewById(R.id.k10);
            empty =  (Button) rootView.findViewById(R.id.z1);
            dot =  (Button) rootView.findViewById(R.id.z2);
            comma =  (Button) rootView.findViewById(R.id.z3);
            question =  (Button) rootView.findViewById(R.id.z4);
            ex_mark =  (Button) rootView.findViewById(R.id.z5);
            single_quote =  (Button) rootView.findViewById(R.id.z6);
            double_quote =  (Button) rootView.findViewById(R.id.z7);
            del =  (Button) rootView.findViewById(R.id.del2);
            back =  (Button) rootView.findViewById(R.id.abc);
            space =  (Button) rootView.findViewById(R.id.space2);
            dot2 = (Button) rootView.findViewById(R.id.dot2);
            newLine =  (Button) rootView.findViewById(R.id.backspace2);

            for (int i=0; i<10; i++){

                buttonNumbers[i].setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v){
                        String buttonText = ((Button)v).getText().toString();
                        tv.append(buttonText); //treba ofc pazit na up, low case i to, who cares
                    }
                });

            }

            monkey.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v){
                    String buttonText = ((Button)v).getText().toString();
                    tv.append("@"); //treba ofc pazit na up, low case i to, who cares
                }
            });

            colon.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String buttonText = ((Button) v).getText().toString();
                    tv.append(":"); //treba ofc pazit na up, low case i to, who cares
                }
            });

            semicolon.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String buttonText = ((Button) v).getText().toString();
                    tv.append(";"); //treba ofc pazit na up, low case i to, who cares
                }
            });

            dash.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String buttonText = ((Button) v).getText().toString();
                    tv.append("_"); //treba ofc pazit na up, low case i to, who cares
                }
            });

            hyphen.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String buttonText = ((Button) v).getText().toString();
                    tv.append("-"); //treba ofc pazit na up, low case i to, who cares
                }
            });

            hashTag.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String buttonText = ((Button) v).getText().toString();
                    tv.append("#"); //treba ofc pazit na up, low case i to, who cares
                }
            });

            left_bracket.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String buttonText = ((Button) v).getText().toString();
                    tv.append("("); //treba ofc pazit na up, low case i to, who cares
                }
            });

            right_bracket.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String buttonText = ((Button) v).getText().toString();
                    tv.append(")"); //treba ofc pazit na up, low case i to, who cares
                }
            });
            slash.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String buttonText = ((Button) v).getText().toString();
                    tv.append("/"); //treba ofc pazit na up, low case i to, who cares
                }
            });
            plus.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String buttonText = ((Button) v).getText().toString();
                    tv.append("+"); //treba ofc pazit na up, low case i to, who cares
                }
            });

            dot.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String buttonText = ((Button) v).getText().toString();
                    tv.append("."); //treba ofc pazit na up, low case i to, who cares
                }
            });
            dot2.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String buttonText = ((Button) v).getText().toString();
                    tv.append("."); //treba ofc pazit na up, low case i to, who cares
                }
            });
            comma.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String buttonText = ((Button) v).getText().toString();
                    tv.append(","); //treba ofc pazit na up, low case i to, who cares
                }
            });
            question.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String buttonText = ((Button) v).getText().toString();
                    tv.append("?"); //treba ofc pazit na up, low case i to, who cares
                }
            });

            ex_mark.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String buttonText = ((Button) v).getText().toString();
                    tv.append("!"); //treba ofc pazit na up, low case i to, who cares
                }
            });

            single_quote.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String buttonText = ((Button) v).getText().toString();
                    tv.append("'"); //treba ofc pazit na up, low case i to, who cares
                }
            });
            double_quote.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String buttonText = ((Button) v).getText().toString();
                    tv.append("\""); //treba ofc pazit na up, low case i to, who cares
                }
            });
            del.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String text = tv.getText().toString();
                    tv.setText(text.substring(0, text.length() - 1)); //setText, getText
                    tv.setSelection(tv.getText().length());
                }
            });

            back.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    ListKeeper.text = tv.getText().toString();

                    Intent i = new Intent(getActivity(), MainActivity.class);
                    startActivity(i);
                }
            });

            space.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String buttonText = ((Button) v).getText().toString();
                    tv.append(" "); //treba ofc pazit na up, low case i to, who cares
                }
            });
            newLine.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String buttonText = ((Button) v).getText().toString();
                    tv.append("\n"); //treba ofc pazit na up, low case i to, who cares
                }
            });







            return rootView;
        }
    }
    @Override
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }
}
