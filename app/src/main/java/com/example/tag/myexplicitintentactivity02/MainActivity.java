package com.example.tag.myexplicitintentactivity02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String KEY="EDIT_TEXT_KEY";
    public static final int SUB_ACTIVITY_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText =(EditText)findViewById(R.id.editText);
                String textString = editText.getText().toString();

                Intent intent = new Intent(MainActivity.this,SubActivity.class);
                intent.putExtra(KEY,textString);

                startActivityForResult(intent,SUB_ACTIVITY_REQUEST);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==SUB_ACTIVITY_REQUEST){
            if(resultCode==RESULT_OK){
                String str = data.getStringExtra(SubActivity.SUB_KEY);

                Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
            }
        }
    }
}
