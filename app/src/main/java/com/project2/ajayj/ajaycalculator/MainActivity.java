package com.project2.ajayj.ajaycalculator;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.HapticFeedbackConstants;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int flag = 0;
    private boolean isAppReadyToFinish;
    EditText edittext1;
    TextView textview1, textview2;
    Button number0, number1, number2, number3, number4, number5, number6, number7, number8, number9, textdel, symbolplus, symbolminus, symbolmul, symboldiv, dotbutton, symbolequals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        toolbar.setTitle( "Simple Calculator" );
        toolbar.setTitleTextColor( Color.BLACK );


        final Drawable upArrow = getResources().getDrawable( R.drawable.abc_ic_ab_back_material );
        upArrow.setColorFilter( getResources().getColor( R.color.black ), PorterDuff.Mode.SRC_ATOP );
        getSupportActionBar().setHomeAsUpIndicator( upArrow );

        getSupportActionBar().setDisplayHomeAsUpEnabled( true );



       /* textview1.setMovementMethod(new ScrollingMovementMethod());
        textview2.setMovementMethod(new ScrollingMovementMethod());*/


        //this will disable the keyboard popup at first
        this.getWindow().setSoftInputMode( WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN );

        edittext1 = (EditText) findViewById( R.id.edittextnumber );
        textview1 = (TextView) findViewById( R.id.textviewnumber );
        textview2 = (TextView) findViewById( R.id.textviewresult );

        number0 = (Button) findViewById( R.id.numberbtn0 );
        number1 = (Button) findViewById( R.id.numberbtn1 );
        number2 = (Button) findViewById( R.id.numberbtn2 );
        number3 = (Button) findViewById( R.id.numberbtn3 );
        number4 = (Button) findViewById( R.id.numberbtn4 );
        number5 = (Button) findViewById( R.id.numberbtn5 );
        number6 = (Button) findViewById( R.id.numberbtn6 );
        number7 = (Button) findViewById( R.id.numberbtn7 );
        number8 = (Button) findViewById( R.id.numberbtn8 );
        number9 = (Button) findViewById( R.id.numberbtn9 );

        textdel = (Button) findViewById( R.id.textdelbtn );
        symbolplus = (Button) findViewById( R.id.symplusbtn );
        symbolminus = (Button) findViewById( R.id.symminusbtn );
        symbolmul = (Button) findViewById( R.id.symmulbtn );
        symboldiv = (Button) findViewById( R.id.symdivbtn );
        dotbutton = (Button) findViewById( R.id.dotbtn );
        symbolequals = (Button) findViewById( R.id.symequalsbtn );

        number0.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.performHapticFeedback( HapticFeedbackConstants.KEYBOARD_TAP );

                CharSequence digitvalue = "0";
                numbers( digitvalue );
            }
        } );

        number1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.performHapticFeedback( HapticFeedbackConstants.KEYBOARD_TAP );

                CharSequence digitvalue = "1";
                numbers( digitvalue );
            }
        } );

        number2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.performHapticFeedback( HapticFeedbackConstants.KEYBOARD_TAP );

                CharSequence digitvalue = "2";
                numbers( digitvalue );
            }
        } );

        number3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                view.performHapticFeedback( HapticFeedbackConstants.KEYBOARD_TAP );

                CharSequence digitvalue = "3";
                numbers( digitvalue );
            }
        } );

        number4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.performHapticFeedback( HapticFeedbackConstants.KEYBOARD_TAP );

                CharSequence digitvalue = "4";
                numbers( digitvalue );
            }
        } );

        number5.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.performHapticFeedback( HapticFeedbackConstants.KEYBOARD_TAP );

                CharSequence digitvalue = "5";
                numbers( digitvalue );
            }
        } );

        number6.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.performHapticFeedback( HapticFeedbackConstants.KEYBOARD_TAP );

                CharSequence digitvalue = "6";
                numbers( digitvalue );
            }
        } );

        number7.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.performHapticFeedback( HapticFeedbackConstants.KEYBOARD_TAP );

                CharSequence digitvalue = "7";
                numbers( digitvalue );
            }
        } );

        number8.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.performHapticFeedback( HapticFeedbackConstants.KEYBOARD_TAP );

                CharSequence digitvalue = "8";
                numbers( digitvalue );
            }
        } );

        number9.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.performHapticFeedback( HapticFeedbackConstants.KEYBOARD_TAP );

                CharSequence digitvalue = "9";
                numbers( digitvalue );
            }
        } );


        //this will disable keyboard popup on click of edittext
        edittext1.setOnTouchListener( new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.onTouchEvent( event );
                InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService( Context.INPUT_METHOD_SERVICE );
                if (imm != null) {
                    imm.hideSoftInputFromWindow( v.getWindowToken(), 0 );
                }
                return true;
            }
        } );

        textdel.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.performHapticFeedback( HapticFeedbackConstants.VIRTUAL_KEY );

                //to delete last character
                /*int length = edittext1.getText().length();
                if (length > 0) {
                    edittext1.getText().delete(length - 1, length);
                }*/

                //to delete previous character of cursor
                int pos = edittext1.getSelectionStart();
                if (pos > 0) {
                    edittext1.getText().delete( pos - 1, pos );
                }

                Toast.makeText( MainActivity.this, "Long press to Clear Everything..!", Toast.LENGTH_SHORT ).show();
            }
        } );


        textdel.setOnLongClickListener( new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                view.performHapticFeedback( HapticFeedbackConstants.LONG_PRESS );
                edittext1.setText( "" );
                textview1.setText( "" );
                textview2.setText( "" );
                return true;
            }
        } );

        dotbutton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                view.performHapticFeedback( HapticFeedbackConstants.KEYBOARD_TAP );

                String num = edittext1.getText().toString();
                int pos = edittext1.getSelectionStart();

                //if edittext is empty
                if ((num.isEmpty() || (num == "-"))) {
                    edittext1.append( "0." );
                    edittext1.setSelection( edittext1.getText().length() );
                } else
                //if edittext is nonempty
                {
                    double digits1 = Double.parseDouble( num );

                    //if digits are more than one
                    if (digits1 >= 0) {

                        //if the string doesnot contain dot character
                        if (!num.contains( "." )) {
                            edittext1.getText().insert( pos, "." );
                            edittext1.setSelection( edittext1.getText().length() );
                        }
                    }
                }
            }
        } );

        symbolplus.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.performHapticFeedback( HapticFeedbackConstants.KEYBOARD_TAP );

                String symbol = "+";
                symbolAction( symbol );
            }
        } );

        symbolminus.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.performHapticFeedback( HapticFeedbackConstants.KEYBOARD_TAP );

                String symbol = "-";
                symbolAction( symbol );
            }
        } );

        symbolmul.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.performHapticFeedback( HapticFeedbackConstants.KEYBOARD_TAP );

                String symbol = "*";
                symbolAction( symbol );
            }
        } );

        symboldiv.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.performHapticFeedback( HapticFeedbackConstants.KEYBOARD_TAP );

                String symbol = "/";
                symbolAction( symbol );
            }
        } );

        symbolequals.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.performHapticFeedback( HapticFeedbackConstants.KEYBOARD_TAP );

                String num = edittext1.getText().toString();
                String num2 = textview1.getText().toString();
                String num3 = textview2.getText().toString();

                if (!num.isEmpty()) {
                    char lastchar = num.charAt( num.length() - 1 );
                    if (lastchar != '.') {
                        if (num2.isEmpty()) {
                            edittext1.setText( num );
                            textview1.setText( num + "=" );
                            textview2.setText( num );
                            edittext1.setSelection( edittext1.getText().length() );

                        } else if (!num2.isEmpty()) {

                            char symbollastchar2 = num2.charAt( num2.length() - 1 );

                            if (symbollastchar2 == '+') {
                                double digits1 = Double.parseDouble( num );
                                double digits3 = Double.parseDouble( num3 );

                                double fresult = digits3 + digits1;

                                Toast.makeText( MainActivity.this, "Final result is" + fresult, Toast.LENGTH_SHORT ).show();
                                textview2.setText( String.format( "%.2f", fresult ) );
                                textview1.append( num + "=" );
                                edittext1.setText( String.format( "%.2f", fresult ) );
                                edittext1.setSelection( edittext1.getText().length() );

                            }

                            if (symbollastchar2 == '-') {
                                double digits1 = Double.parseDouble( num );
                                double digits3 = Double.parseDouble( num3 );

                                double fresult = digits3 - digits1;

                                Toast.makeText( MainActivity.this, "Final result is" + fresult, Toast.LENGTH_SHORT ).show();
                                textview2.setText( String.format( "%.2f", fresult ) );
                                textview1.append( num + "=" );
                                edittext1.setText( String.format( "%.2f", fresult ) );
                                edittext1.setSelection( edittext1.getText().length() );

                            }

                            if (symbollastchar2 == '*') {
                                double digits1 = Double.parseDouble( num );
                                double digits3 = Double.parseDouble( num3 );

                                double fresult = digits3 * digits1;

                                Toast.makeText( MainActivity.this, "Final result is" + fresult, Toast.LENGTH_SHORT ).show();
                                textview2.setText( String.format( "%.2f", fresult ) );
                                textview1.append( num + "=" );
                                edittext1.setText( String.format( "%.2f", fresult ) );
                                edittext1.setSelection( edittext1.getText().length() );

                            }

                            if (symbollastchar2 == '/') {
                                double digits1 = Double.parseDouble( num );
                                double digits3 = Double.parseDouble( num3 );
                                if (digits1 == 0) {
                                    AlertDialog.Builder ad = new AlertDialog.Builder( MainActivity.this );
                                    ad.setMessage( "Divide by 0 not possible" );
                                    ad.setCancelable( false );

                                    ad.setPositiveButton( "Okay", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Toast.makeText( MainActivity.this, "Give a number other than 0", Toast.LENGTH_SHORT ).show();
                                        }
                                    } );
                                    AlertDialog ald = ad.create();
                                    ald.show();
                                } else {
                                    double fresult = digits3 / digits1;

                                    Toast.makeText( MainActivity.this, "Final result is" + fresult, Toast.LENGTH_SHORT ).show();
                                    textview2.setText( String.format( "%.2f", fresult ) );
                                    textview1.append( num + "=" );
                                    edittext1.setText( String.format( "%.2f", fresult ) );
                                    edittext1.setSelection( edittext1.getText().length() );

                                }

                            }
                        }
                    }
                }
            }
        } );
    }


    private void symbolAction(String symbol) {
        String num = edittext1.getText().toString();
        final String num2 = textview1.getText().toString();
        int pos = edittext1.getSelectionStart();


       /* if((symbol=="-")&&(num.isEmpty()))
        {
            edittext1.setText( "-" );
            edittext1.setSelection( edittext1.getText().length() );
        }*/

        if (!num.isEmpty()) {
            if (pos == num.length()) {
                char lastchar = num.charAt( num.length() - 1 );
                if (lastchar != '.') {
                    if (num2.isEmpty()) {
                        if (flag == 1) {
                            flag = 0;
                        }
                        textview2.setText( num );
                        textview1.append( num + symbol );
                        edittext1.setText( "" );
                    } else {

                        if (!num2.isEmpty()) {

                            String num3 = textview2.getText().toString();
                            char symbollastchar2 = num2.charAt( num2.length() - 1 );

                            if (lastchar != '.') {
                                if (!num.contains( symbol )) {
                                    if ((flag == 0) || (flag == 1)) {

                                        if (symbollastchar2 == '=') {
                                            flag = 1;
                                            textview1.setText( "" );
                                            symbolAction( symbol );
                                        }

                                        if (symbollastchar2 == '+') {
                                            if (num3.isEmpty()) {
                                                textview2.setText( num );
                                                textview1.append( num + symbol );
                                                edittext1.setText( "" );

                                            } else {
                                                textview1.append( num + symbol );

                                                double digits1 = Double.parseDouble( num );
                                                double digits3 = Double.parseDouble( num3 );

                                                double result = digits3 + digits1;

                                                Toast.makeText( MainActivity.this, "result is" + result, Toast.LENGTH_SHORT ).show();
                                                textview2.setText( String.format( "%.2f", result ) );

                                                edittext1.setText( "" );
                                            }
                                        }

                                        if (symbollastchar2 == '-') {
                                            if (num3.isEmpty()) {
                                                textview2.setText( num );
                                                textview1.append( num + symbol );
                                                edittext1.setText( "" );
                                            } else {
                                                textview1.append( num + symbol );

                                                double digits1 = Double.parseDouble( num );
                                                double digits3 = Double.parseDouble( num3 );

                                                double result = digits3 - digits1;

                                                Toast.makeText( MainActivity.this, "result is" + result, Toast.LENGTH_SHORT ).show();
                                                textview2.setText( String.format( "%.2f", result ) );

                                                edittext1.setText( "" );

                                            }
                                        }

                                        if (symbollastchar2 == '*') {
                                            if (num3.isEmpty()) {
                                                textview2.setText( num );
                                                textview1.append( num + symbol );
                                                edittext1.setText( "" );

                                            } else {
                                                textview1.append( num + symbol );

                                                double digits1 = Double.parseDouble( num );
                                                double digits3 = Double.parseDouble( num3 );

                                                double result = digits3 * digits1;


                                                Toast.makeText( MainActivity.this, "result is" + result, Toast.LENGTH_SHORT ).show();
                                                textview2.setText( String.format( "%.2f", result ) );

                                                edittext1.setText( "" );

                                            }
                                        }

                                        if (symbollastchar2 == '/') {
                                            if (num3.isEmpty()) {
                                                textview2.setText( num );
                                                textview1.append( num + symbol );
                                                edittext1.setText( "" );

                                            } else {
                                                textview1.append( num + symbol );

                                                double digits1 = Double.parseDouble( num );
                                                double digits3 = Double.parseDouble( num3 );

                                                if (digits1 == 0) {
                                                    AlertDialog.Builder ad = new AlertDialog.Builder( MainActivity.this );
                                                    ad.setMessage( "Divide by 0 not possible" );
                                                    ad.setCancelable( false );

                                                    ad.setPositiveButton( "Okay", new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            Toast.makeText( MainActivity.this, "Give a number other than 0", Toast.LENGTH_SHORT ).show();
                                                            String numtextview1 = textview1.getText().toString();
                                                            textview1.setText( numtextview1.substring( 0, numtextview1.length() - 2 ) );
                                                        }
                                                    } );
                                                    AlertDialog ald = ad.create();
                                                    ald.show();
                                                } else {
                                                    double result = digits3 / digits1;


                                                    Toast.makeText( MainActivity.this, "result is" + result, Toast.LENGTH_SHORT ).show();
                                                    textview2.setText( String.format( "%.2f", result ) );

                                                    edittext1.setText( "" );
                                                }
                                            }
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }
    }


    private void numbers(CharSequence digitvaluenumber) {

        String num = edittext1.getText().toString();

        //if edittext is empty
        if (num.isEmpty()) {
            //set number to edittext
            edittext1.setText( digitvaluenumber );
            //set cursor to the end of the edittext
            edittext1.setSelection( edittext1.getText().length() );
        }

        //if edittext is non-empty
        else {
            //getting the position of the cursor
            int pos = edittext1.getSelectionStart();
            double digits1 = Double.parseDouble( num );

            //if the string contains dot character
            if (num.contains( "." )) {
                edittext1.getText().insert( pos, digitvaluenumber );
            }
            //if edittext doesnot contain dot character
            else
                //if edittext contains only 0 but not dot
                if (digits1 == 0) {
                    //if cursor position is in 1st place which contains only 0 in edittext
                    if (pos == 0) {
                        //edittext1.append("digitvalue");
                        edittext1.getText().insert( pos, digitvaluenumber );
                        edittext1.setSelection( edittext1.getText().length() );
                    } //if cursor position is in any place which contains only 0 in edittext
                    else {
                        edittext1.setText( digitvaluenumber );
                        edittext1.setSelection( edittext1.getText().length() );
                    }

                }
                //if edittext contains any numbers with dot
                else
                    //if edittext contain other numbers
                    //if cursor position is in any place with other numbers in edittext
                    if ((digits1 > 0) && (pos >= 0)) {

                        edittext1.getText().insert( pos, digitvaluenumber );

                    }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.menu_main, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_do) {
            AlertDialog.Builder doalert = new AlertDialog.Builder( this );

            doalert.setTitle( "Do`s and Dont`s in this Calculator App..." );
            doalert.setMessage( "Do`s\n" +
                    "------------\n" +
                    "1. You can try giving the 2nd value(denominmator) value during division as 0 and try it...!!\n" +
                    "2. You can give a long  number as you want for the calculation.\n" +
                    "3. you will get only 2 decimal points after the decimal point.\n" +
                    "4. Press the DEL button to clear, Press and hold it to clear everything.\n" +
                    "5. You can insert, delete the numbers where ever you want by placing the cursor in that position.\n \n \n" +

                    "Dont`s\n" +
                    "--------------\n" +
                    "1. You cannot insert the symbols middle of the numbers by placing the cursor. \n" +
                    "2. You cannot give the negative numbers for the calculation..!! \n \n \n" +

                    "*As I will try to overcome all the issues(dont`s) in the next update" );

            doalert.setCancelable( false );

            doalert.setPositiveButton( "Okay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            } );
            AlertDialog al = doalert.create();
            al.show();

            return true;
        }
        if (id == android.R.id.home) {

            AlertDialog.Builder doalert = new AlertDialog.Builder( this );

            doalert.setTitle( "Do you want to Stop and Exit Calculation..?" );
            doalert.setMessage( "Thank you Rate my App in Google Play Store" );
            doalert.setCancelable( false );

            doalert.setPositiveButton( "Exit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    finishAffinity();
                }
            } );

            doalert.setNegativeButton( "Stay here", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            } );

            AlertDialog al = doalert.create();
            al.show();

            return true;
        }
        return super.onOptionsItemSelected( item );
    }


    @Override
    public void onBackPressed() {
        if (isAppReadyToFinish) {
            try {
                super.onBackPressed();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            Toast.makeText( this, "Another click to close", Toast.LENGTH_SHORT ).show();
            isAppReadyToFinish = true;
            new Handler().postDelayed( new Runnable() {
                @Override
                public void run() {
                    isAppReadyToFinish = false;
                }
            }, 2000 );
        }
    }


}