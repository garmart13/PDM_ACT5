package unam.fca.dmoviles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.time.LocalDateTime;

public class MainActivity extends AppCompatActivity {

    private final static String TEXT_VIEW_KEY = "TEXT_VIEW_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tv = findViewById(R.id.tv);
        final Button btn = findViewById(R.id.btn);


        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv.setText(LocalDateTime.now().toString());
            }
        });

    }



    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        final TextView tv = findViewById(R.id.tv);
        tv.setText(savedInstanceState.getString(TEXT_VIEW_KEY));
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        final TextView tv = findViewById(R.id.tv);
        outState.putString(TEXT_VIEW_KEY, tv.getText().toString());
        super.onSaveInstanceState(outState);
    }

}