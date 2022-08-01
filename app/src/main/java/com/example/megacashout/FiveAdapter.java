package com.example.megacashout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class FiveAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    String[] fiveoddsitems;
    String[] fiveodds;
    String[] fiveoptions;
    
    public FiveAdapter(Context c, String[] i, String[] o, String[] op) {
        fiveoddsitems = i;
        fiveodds = o;
        fiveoptions = op;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    
    @Override
    public int getCount() {
        return fiveoddsitems.length;
    }

    @Override
    public Object getItem(int i) {
        return fiveoddsitems[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
    
	@SuppressLint({"ViewHolder", "InflateParams"}) View v = mInflater.inflate(R.layout.five_odds_listview, null);
        TextView gameTextView = v.findViewById(R.id.gameTextView);
        TextView oddsTextView = v.findViewById(R.id.oddsTextView);
        TextView optionTextView =  v.findViewById(R.id.optionTextView);

        String game = fiveoddsitems[i];
        String odd = fiveodds[i];
        String option = fiveoptions[i];

        gameTextView.setText(game);
        oddsTextView.setText(odd);
        optionTextView.setText(option);
        return v;
    }
}
