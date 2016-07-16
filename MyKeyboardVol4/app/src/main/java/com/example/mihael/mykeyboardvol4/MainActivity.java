package com.example.mihael.mykeyboardvol4;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.mihael.mykeyboardvol4.R;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static Button[] buttonArray;
    public static Button shift, delete, change, comma, space, dot, backspace;
    public static TextView a, b, c, d, e;
    public static TextView[][] textViews;
    public static FloatingActionMenu circleMenus[];
    public static EditText tv;
    public static int i, width, height;
    public static boolean capsSemaphore = false;
    private static boolean semaphore = true;

    public static HashMap<TextView, Integer> hm= new HashMap<>();

    public static float pxFromDp( Resources resources, final float dp) {

      /*  float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
        return px;
        */
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }


    //niz buttona
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_with_custom_action_button);

        if (semaphore){
            semaphore = false;
            BufferedReader buf = null;
            try {
                InputStream in = getAssets().open("words.txt");
                buf = new BufferedReader(new InputStreamReader(in));
            } catch (IOException e) {
                //System.out.println("neki fail");
                e.printStackTrace();
            }

            String line;
            List<String> svi = new ArrayList<String>();
            List <Integer> freq = new ArrayList<>();
            try {
                while ((line = buf.readLine()) != null){
                    String[] spliterino = line.split("\\s+");
                    svi.add(spliterino[0]);
                    freq.add(Integer.parseInt(spliterino[1]));
                }
            } catch (IOException e) {
                e.fillInStackTrace();
            }
            ListKeeper.svi = svi;
            ListKeeper.freq = freq;
        }


        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new CustomButtonDemoFragment())
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
    public static class CustomButtonDemoFragment extends Fragment {

        public CustomButtonDemoFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_main, container, false);


            tv = (EditText) rootView.findViewById(R.id.tv);
            tv.setText(ListKeeper.text);
            tv.setSelection(tv.getText().length());

            buttonArray = new Button [50];

            buttonArray[0] = (Button) rootView.findViewById(R.id.a);
            buttonArray[1] = (Button) rootView.findViewById(R.id.b);
            buttonArray[2] = (Button) rootView.findViewById(R.id.c);
            buttonArray[3] = (Button) rootView.findViewById(R.id.d);
            buttonArray[4] = (Button) rootView.findViewById(R.id.e);
            buttonArray[5] = (Button) rootView.findViewById(R.id.f);
            buttonArray[6] = (Button) rootView.findViewById(R.id.g);
            buttonArray[7] = (Button) rootView.findViewById(R.id.h);
            buttonArray[8] = (Button) rootView.findViewById(R.id.i);
            buttonArray[9] = (Button) rootView.findViewById(R.id.j);
            buttonArray[10] = (Button) rootView.findViewById(R.id.k);
            buttonArray[11] = (Button) rootView.findViewById(R.id.l);
            buttonArray[12] = (Button) rootView.findViewById(R.id.m);
            buttonArray[13] = (Button) rootView.findViewById(R.id.n);
            buttonArray[14] = (Button) rootView.findViewById(R.id.o);
            buttonArray[15] = (Button) rootView.findViewById(R.id.p);
            buttonArray[16] = (Button) rootView.findViewById(R.id.q);
            buttonArray[17] = (Button) rootView.findViewById(R.id.r);
            buttonArray[18] = (Button) rootView.findViewById(R.id.s);
            buttonArray[19] = (Button) rootView.findViewById(R.id.t);
            buttonArray[20] = (Button) rootView.findViewById(R.id.u);
            buttonArray[21] = (Button) rootView.findViewById(R.id.v);
            buttonArray[22] = (Button) rootView.findViewById(R.id.w);
            buttonArray[23] = (Button) rootView.findViewById(R.id.x);
            buttonArray[24] = (Button) rootView.findViewById(R.id.y);
            buttonArray[25] = (Button) rootView.findViewById(R.id.z);


            shift = (Button) rootView.findViewById(R.id.shift);
            delete = (Button) rootView.findViewById(R.id.del);

            change = (Button) rootView.findViewById(R.id.change);
            comma = (Button) rootView.findViewById(R.id.coma);
            space = (Button) rootView.findViewById(R.id.space);
            dot = (Button) rootView.findViewById(R.id.dot);
            backspace = (Button) rootView.findViewById(R.id.backspace);

            //List <String> l = MyT9.getSuggestions("a");

            for (i=0; i<26; i++){

                buttonArray[i].setTransformationMethod(null);//lowerCase je sad

            }


            //ok vrijeme je za postavljanje još nekih action listenera...
            change.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    ListKeeper.text = tv.getText().toString();

                    Intent i = new Intent(getActivity(), SwapActivity.class);
                    startActivity(i);
                }
            });

            delete.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v){
                    String text = tv.getText().toString();
                    if (text.length() > 0) {
                        tv.setText(text.substring(0, text.length() - 1)); //setText, getText
                    }
                    tv.setSelection(tv.getText().length());
                    for (int k=0; k<26; k++){
                        circleMenus[k].close(true); //ok ovo radi, samo su problem prazni prijedlozi
                        if (capsSemaphore){

                            for (i = 0; i < 26; i++) {
                                String text2 = buttonArray[i].getText().toString().toLowerCase();
                                buttonArray[i].setText(text2);
                                buttonArray[i].setTransformationMethod(null);//lowerCase je sad
                            }
                            capsSemaphore = false;
                        }

                    }
                }
            });

            delete.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String text = tv.getText().toString();
                    if (text.length() > 0) {
                        tv.setText(text.substring(0, text.length() - 1)); //setText, getText
                    }
                    tv.setSelection(tv.getText().length());
                    for (int k = 0; k < 26; k++) {
                        circleMenus[k].close(true); //ok ovo radi, samo su problem prazni prijedlozi

                    }
                    //ovo bi trebo svugdje
                    if (capsSemaphore) {

                        for (i = 0; i < 26; i++) {
                            String text2 = buttonArray[i].getText().toString().toLowerCase();
                            buttonArray[i].setText(text2);
                            buttonArray[i].setTransformationMethod(null);//lowerCase je sad
                        }
                        capsSemaphore = false;
                    }
                }
            });
            //change later
            shift.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    for (int k=0; k<26; k++){
                        circleMenus[k].close(true); //ok ovo radi, samo su problem prazni prijedlozi
                    }
                    if (!capsSemaphore) {
                        for (i = 0; i < 26; i++) {
                            String text = buttonArray[i].getText().toString().toUpperCase();
                            buttonArray[i].setText(text);
                        }
                        capsSemaphore = true;
                    } else {
                        for (i = 0; i < 26; i++) {
                            String text = buttonArray[i].getText().toString().toLowerCase();
                            buttonArray[i].setText(text);
                            buttonArray[i].setTransformationMethod(null);//lowerCase je sad
                        }
                        capsSemaphore = false;
                    }
                }

            });


            comma.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    tv.append(",");
                    for (int k=0; k<26; k++) {
                        circleMenus[k].close(true); //ok ovo radi, samo su problem prazni prijedlozi
                    }
                    if (capsSemaphore){

                        for (i = 0; i < 26; i++) {
                            String text = buttonArray[i].getText().toString().toLowerCase();
                            buttonArray[i].setText(text);
                            buttonArray[i].setTransformationMethod(null);//lowerCase je sad
                        }
                        capsSemaphore = false;
                    }
                }


            });

            space.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    tv.append(" ");
                    tv.setSelection(tv.getText().toString().length());
                    for (int k=0; k<26; k++){

                        circleMenus[k].close(true); //ok ovo radi, samo su problem prazni prijedlozi
                    }
                    if (capsSemaphore){

                        for (i = 0; i < 26; i++) {
                            String text = buttonArray[i].getText().toString().toLowerCase();
                            buttonArray[i].setText(text);
                            buttonArray[i].setTransformationMethod(null);//lowerCase je sad
                        }
                        capsSemaphore = false;
                    }
                }


            });

            dot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tv.append(".");
                    for (int k=0; k<26; k++){

                        circleMenus[k].close(true); //ok ovo radi, samo su problem prazni prijedlozi
                    }
                    if (capsSemaphore){

                        for (i = 0; i < 26; i++) {
                            String text = buttonArray[i].getText().toString().toLowerCase();
                            buttonArray[i].setText(text);
                            buttonArray[i].setTransformationMethod(null);//lowerCase je sad
                        }
                        capsSemaphore = false;
                    }
                }


            });

            backspace.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tv.append("\n");
                    for (int k=0; k<26; k++){
                        circleMenus[k].close(true); //ok ovo radi, samo su problem prazni prijedlozi
                    }
                    if (capsSemaphore){

                        for (i = 0; i < 26; i++) {
                            String text = buttonArray[i].getText().toString().toLowerCase();
                            buttonArray[i].setText(text);
                            buttonArray[i].setTransformationMethod(null);//lowerCase je sad
                        }
                        capsSemaphore = false;
                    }
                }


            });
//wrap content -> mathc parent
            // FrameLayout.LayoutParams tvParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);


            //lol 100x100 je previse za tablet eheheh
            //getResources().getDimensionPixelSize(R.dimen.popup_window) daje fiksno, to nam se ne svidja




            //      System.out.println("YO");
            //      System.out.println(width + " " + height);

            DisplayMetrics dm = new DisplayMetrics();
//WAHA konacno radi, vjerojatno bi sad i onaj dp radio, al sad kad imamo dimenzije ekrana
            //reko bi da ak s tim mogu nastelat to je uvjerljivo najbolje, jel
            ((Activity)rootView.getContext()).getWindowManager().getDefaultDisplay().getMetrics(dm);

            //    System.out.println("TRAX " + dm.widthPixels + " " + dm.heightPixels);

            //    float px = pxFromDp (getResources(), 40);
            float px_w =  Math.min( (float)ListKeeper.W, (float)ListKeeper.H );//(float) dm.widthPixels / 10f;
            float px_h = Math.min( (float)ListKeeper.W, (float)ListKeeper.H );//(float) px_w / 1.4f;
            FrameLayout.LayoutParams tvParams = new FrameLayout.LayoutParams((int)px_w, (int)px_h);
            final int numOfPopUps = 5;

            textViews = new TextView[26][numOfPopUps];

            //  System.out.println("TU");
            //   System.out.println(buttonArray[0].getWidth() + " " + buttonArray[1].getHeight());

            for (int i=0; i<26; i++) {

                for (int j = 0; j < numOfPopUps; j++) {

                    textViews[i][j] = new TextView(getActivity());
                    //  Button b = (Button) rootView.findViewById(R.id.marketBtn);
                    textViews[i][j].setBackgroundResource(R.drawable.blue_bckg); //btn_dialog, holo_light_frame
                    textViews[i][j].setLayoutParams(tvParams);


                }
            }
            //rubni ce imat 4 txtviewa pa smo konstruirali 1 vise, nebitno

            //nije settan nikakav tekst

            circleMenus = new FloatingActionMenu[26];
            for (int i=0; i<26; i++){ //pretpostavka samo oko slova da skaće eto kaj ja znam

                if (i == 'a' - 'a' || i == 'q' - 'a' || i == 'p' - 'a' || i == 'l' - 'a'
                        || i == 'o' - 'a' || i == 'k' - 'a' || i == 'm' - 'a'){
                    continue; //ovo cemo rucno rijesit
                }
//getResources().getDimensionPixelSize(R.dimen.radius_my)

                circleMenus[i] = new FloatingActionMenu.Builder(getActivity())
                        .setStartAngle(0) // A whole circle!
                        .setEndAngle(360)
                        .setRadius((int)(px_h * 1.1f)) //radius
                        .addSubActionView(textViews[i][0])
                        .addSubActionView(textViews[i][1])
                        .addSubActionView(textViews[i][2])
                        .addSubActionView(textViews[i][3])
                        .addSubActionView(textViews[i][4])
                        .attachTo(buttonArray[i])
                        .build();

                circleMenus[i].setStateChangeListener(new FloatingActionMenu.MenuStateChangeListener() {
                    @Override
                    public void onMenuOpened(FloatingActionMenu menu) {
                        for (int k=0; k<26; k++){
                            circleMenus[k].close(true); //ok ovo radi, samo su problem prazni prijedlozi
                        }

                        Button curr = (Button) menu.getActionView(); //nas button
                        String buttonText = curr.getText().toString();
                        tv.append(buttonText); //treba ofc pazit na up, low case i to, who cares
                        String tvS = tv.getText().toString().toLowerCase();
                        String arr []= tvS.split("\\s+");//zicer rijec jer upravo smo appendali slovo
                        String lastWord = arr[arr.length - 1];
                        int index = buttonText.toLowerCase().toCharArray()[0] - 'a'; //znamo da je to jedan char

                        List<String> ponuda = MyT9.getSuggestions(lastWord);

                        int ponudaSize = ponuda.size();
                        if (ponuda.size() == 0){
                            //najbolje odma zatvorit, vidit cemo
                            // menu.close(true);
                            for (int i=0; i<numOfPopUps; i++){
                                textViews[index][i].setText("");
                            }
                            return;
                        }

                        for (int i=0; i<numOfPopUps; i++){
                            if (i < ponudaSize) {
                                textViews[index][i].setText(ponuda.get(i));
                                textViews[index][i].setTextSize(15.0f);
                                textViews[index][i].setGravity(Gravity.CENTER);
                            } else{
                                textViews[index][i].setText(ponuda.get(ponudaSize - 1));
                                textViews[index][i].setTextSize(15.0f);
                                textViews[index][i].setGravity(Gravity.CENTER);
                            }

                        }
                        if (capsSemaphore){

                            for (int i = 0; i < 26; i++) {
                                String text = buttonArray[i].getText().toString().toLowerCase();
                                buttonArray[i].setText(text);
                                buttonArray[i].setTransformationMethod(null);//lowerCase je sad
                            }
                            capsSemaphore = false;
                        }


                    }

                    @Override
                    public void onMenuClosed(FloatingActionMenu menu) {

                    }
                });

            }
            //setMenus();
            Integer[] svi = new Integer[4];
            svi[0] = 0;
            svi[1] = 'q' - 'a';
            svi[2] = 'p' - 'a';
            svi[3] = 'l' - 'a';

            for (int i=0; i<4; i++){
                int ind = svi[i];
                if (i==0 || i == 1){
                    circleMenus[ind] = new FloatingActionMenu.Builder(getActivity())
                            .setStartAngle(-90)
                            .setEndAngle(90)
                            .setRadius((int) (px_h * 1.2)) //radius
                            .addSubActionView(textViews[ind][0])
                            .addSubActionView(textViews[ind][1])
                            .addSubActionView(textViews[ind][2])
                            .addSubActionView(textViews[ind][3])
                            .attachTo(buttonArray[ind])
                            .build();
                }
                else {
                    circleMenus[ind] = new FloatingActionMenu.Builder(getActivity())
                            .setStartAngle(90)
                            .setEndAngle(270)
                            .setRadius((int) (px_h * 1.2)) //radius
                            .addSubActionView(textViews[ind][0])
                            .addSubActionView(textViews[ind][1])
                            .addSubActionView(textViews[ind][2])
                            .addSubActionView(textViews[ind][3])
                            .attachTo(buttonArray[ind])
                            .build();


                }
                circleMenus[ind].setStateChangeListener(new FloatingActionMenu.MenuStateChangeListener() {
                    @Override
                    public void onMenuOpened(FloatingActionMenu menu) {
                        for (int k=0; k<26; k++){
                            circleMenus[k].close(true); //ok ovo radi, samo su problem prazni prijedlozi
                        }

                        Button curr = (Button) menu.getActionView(); //nas button
                        String buttonText = curr.getText().toString();
                        tv.append(buttonText); //treba ofc pazit na up, low case i to, who cares
                        String tvS = tv.getText().toString().toLowerCase();
                        String arr []= tvS.split("\\s+");//zicer rijec jer upravo smo appendali slovo
                        String lastWord = arr[arr.length - 1];
                        int index = buttonText.toLowerCase().toCharArray()[0] - 'a'; //znamo da je to jedan char

                        List<String> ponuda = MyT9.getSuggestions(lastWord);

                        int ponudaSize = ponuda.size();
                        if (ponuda.size() == 0){
                            //najbolje odma zatvorit, vidit cemo
                            // menu.close(true);
                            for (int i=0; i<numOfPopUps; i++){
                                textViews[index][i].setText("");
                            }
                            return;
                        }

                        for (int i=0; i<4; i++){
                            if (i < ponudaSize) {
                                textViews[index][i].setText(ponuda.get(i));
                                textViews[index][i].setTextSize(15.0f);
                                textViews[index][i].setGravity(Gravity.CENTER);
                            } else{
                                textViews[index][i].setText(ponuda.get(ponudaSize - 1));
                                textViews[index][i].setTextSize(15.0f);
                                textViews[index][i].setGravity(Gravity.CENTER);
                            }

                        }
                        if (capsSemaphore){

                            for (int i = 0; i < 26; i++) {
                                String text = buttonArray[i].getText().toString().toLowerCase();
                                buttonArray[i].setText(text);
                                buttonArray[i].setTransformationMethod(null);//lowerCase je sad
                            }
                            capsSemaphore = false;
                        }


                    }

                    @Override
                    public void onMenuClosed(FloatingActionMenu menu) {

                    }
                });



            }


            //setMenus();
            Integer[] svi2 = new Integer[3];
            svi2[0] = 'o' - 'a';
            svi2[1] = 'k' - 'a';
            svi2[2] = 'm' - 'a';

            for (int i=0; i<3; i++){
                int ind = svi2[i];

                circleMenus[ind] = new FloatingActionMenu.Builder(getActivity())
                            .setStartAngle(30)
                            .setEndAngle(330)
                            .setRadius((int) (1.1f * px_h)) //radius
                            .addSubActionView(textViews[ind][0])
                            .addSubActionView(textViews[ind][1])
                            .addSubActionView(textViews[ind][2])
                            .addSubActionView(textViews[ind][3])
                            .addSubActionView(textViews[ind][4])
                            .attachTo(buttonArray[ind])
                            .build();

                circleMenus[ind].setStateChangeListener(new FloatingActionMenu.MenuStateChangeListener() {
                    @Override
                    public void onMenuOpened(FloatingActionMenu menu) {
                        for (int k=0; k<26; k++){
                            circleMenus[k].close(true); //ok ovo radi, samo su problem prazni prijedlozi
                        }

                        Button curr = (Button) menu.getActionView(); //nas button
                        String buttonText = curr.getText().toString();
                        tv.append(buttonText); //treba ofc pazit na up, low case i to, who cares
                        String tvS = tv.getText().toString().toLowerCase();
                        String arr []= tvS.split("\\s+");//zicer rijec jer upravo smo appendali slovo
                        String lastWord = arr[arr.length - 1];
                        int index = buttonText.toLowerCase().toCharArray()[0] - 'a'; //znamo da je to jedan char

                        List<String> ponuda = MyT9.getSuggestions(lastWord);

                        int ponudaSize = ponuda.size();
                        if (ponuda.size() == 0){
                            //najbolje odma zatvorit, vidit cemo
                            // menu.close(true);
                            for (int i=0; i<numOfPopUps; i++){
                                textViews[index][i].setText("");
                            }
                            return;
                        }

                        for (int i=0; i<numOfPopUps; i++){
                            if (i < ponudaSize) {
                                textViews[index][i].setText(ponuda.get(i));
                                textViews[index][i].setTextSize(15.0f);
                                textViews[index][i].setGravity(Gravity.CENTER);
                            } else{
                                textViews[index][i].setText(ponuda.get(ponudaSize - 1));
                                textViews[index][i].setTextSize(15.0f);
                                textViews[index][i].setGravity(Gravity.CENTER);
                            }

                        }
                        if (capsSemaphore){

                            for (int i = 0; i < 26; i++) {
                                String text = buttonArray[i].getText().toString().toLowerCase();
                                buttonArray[i].setText(text);
                                buttonArray[i].setTransformationMethod(null);//lowerCase je sad
                            }
                            capsSemaphore = false;
                        }


                    }

                    @Override
                    public void onMenuClosed(FloatingActionMenu menu) {

                    }
                });



            }





            //aha ovo je ok zelimo ih 5
            //kraj fora
            for (int i=0; i<26; i++) {
                if (i == 'a' - 'a' || i == 'q' - 'a' || i == 'p' - 'a' || i == 'l' - 'a'){
                    continue; //ovo cemo rucno rijesit
                }
                for (int j = 0; j < numOfPopUps; j++) {
                    //ovo je sad jako ruzno
                    hm.put(textViews[i][j], i);

                    textViews[i][j].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            TextView currTextView = (TextView) v;
                            tv.append(currTextView.getText().toString());

                            Integer currInt = hm.get(currTextView);

                            circleMenus[currInt].close(true);
                        }

                    });

                }


            }

            for (int j=0; j<4; j++){ //number of buttons
                int ind = svi[j];
                for (int k=0; k<4; k++) {//number of textViews
                    hm.put(textViews[ind][k], ind);
                    textViews[ind][k].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            TextView currTextView = (TextView) v;
                            tv.append(currTextView.getText().toString());

                            Integer currInt = hm.get(currTextView);

                            circleMenus[currInt].close(true);
                        }

                    });


                }
            }




            return rootView;
        }
    }
    @Override
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }
}
