package com.dekraftsman.megacashout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ListView;

public class FiveActivity extends AppCompatActivity {

    ListView fiveListView;
    String[] fiveoddsitems;
    String[] fiveodds;
    String[] fiveoptions;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);
        
        Resources res = getResources();
        fiveListView = findViewById(R.id.tenListView);
        fiveoddsitems = res.getStringArray(R.array.fiveoddsitems);
        fiveodds = res.getStringArray(R.array.fiveodds);
        fiveoptions = res.getStringArray(R.array.fiveoptions);
        
        FiveAdapter fiveAdapter = new FiveAdapter(this, fiveoddsitems, fiveodds, fiveoptions);
        fiveListView.setAdapter(fiveAdapter);
    }
}
