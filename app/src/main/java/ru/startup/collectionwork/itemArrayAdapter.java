package ru.startup.collectionwork;


import android.content.Context;
import android.view.*;
import android.widget.*;
import java.util.*;

public class itemArrayAdapter extends ArrayAdapter {
    private List<String[]> scoreList = new ArrayList();

   static class ItemViewHolder {
        TextView name;
        TextView score;
        TextView scor;
    }

    public itemArrayAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public void add(String[] object) {
        scoreList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.scoreList.size();
    }

    @Override
    public String[] getItem(int index) {
        return this.scoreList.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ItemViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.item_layout, parent, false);
            viewHolder = new ItemViewHolder();
            viewHolder.name = (TextView) row.findViewById(R.id.name);
            viewHolder.score = (TextView) row.findViewById(R.id.score);
            viewHolder.scor = (TextView) row.findViewById(R.id.scor);
            row.setTag(viewHolder);
        } else {
            viewHolder = (ItemViewHolder)row.getTag();
        }
        String[] stat = getItem(position);
        viewHolder.name.setText(stat[0]);
        viewHolder.score.setText(stat[1]);
        viewHolder.scor.setText(stat[2]);
        return row;
    }
}