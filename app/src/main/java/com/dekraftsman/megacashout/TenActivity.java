package com.dekraftsman.megacashout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ListView;

public class TenActivity extends AppCompatActivity {

    ListView tenListView;
    String[] tenoddsitems;
    String[] tenodds;
    String[] tenoptions;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ten);
        
        Resources res = getResources();
        tenListView = findViewById(R.id.tenListView);
        tenoddsitems = res.getStringArray(R.array.tenoddsitems);
        tenodds = res.getStringArray(R.array.tenodds);
        tenoptions = res.getStringArray(R.array.tenoptions);
        
        TenAdapter tenAdapter = new TenAdapter(this, tenoddsitems, tenodds, tenoptions);
        tenListView.setAdapter(tenAdapter);
    }
}
