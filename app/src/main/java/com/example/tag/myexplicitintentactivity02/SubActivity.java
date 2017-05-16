package com.example.tag.myexplicitintentactivity02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by tag on 2017/05/16.
 */

public class SubActivity extends Activity {
    public static final String SUB_KEY = "SUB_KEY";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        final EditText editText = (EditText)findViewById(R.id.subEditText);

        Intent intent = getIntent();
        String str = intent.getStringExtra(MainActivity.KEY);

        editText.setText(str);
        TextView textView = (TextView)findViewById(R.id.subTextView);
        textView.setText("こんにちは！"+str+"さん");


        Button button = (Button)findViewById(R.id.subButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newStr = editText.getText().toString();

                Intent newIntent = new Intent();
                newIntent.putExtra(SUB_KEY,newStr);

                setResult(RESULT_OK,newIntent);

                finish();

            }
        });

    }
}
