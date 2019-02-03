package com.example.gridviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class GridAdapter extends BaseAdapter {

    private List<Item> list;
    private LayoutInflater layoutInflater;
    private Context context;

    public class ViewHolder{
        TextView syamei;
        TextView maker;
        TextView spec;
        TextView drive;
    }


    public GridAdapter(Context context, int layoutResourceId, List<Item> list){

        this.list = list;;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(this.context);
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View  v = convertView;
        ViewHolder viewHolder;

        if(convertView == null){
            v = layoutInflater.inflate(R.layout.layout_each_item,parent,false);

            viewHolder = new ViewHolder();
            viewHolder.syamei = v.findViewById(R.id.textView);
            viewHolder.maker = v.findViewById(R.id.textView2);
            viewHolder.spec = v.findViewById(R.id.textView3);
            viewHolder.drive = v.findViewById(R.id.textView4);



            v.setId(position);
            v.setTag(viewHolder);
        }else{

            viewHolder =(ViewHolder)convertView.getTag();

        }

        viewHolder.syamei.setText(list.get(position).getSyamei());
        viewHolder.maker.setText(list.get(position).getMaker());
        viewHolder.spec.setText(list.get(position).getSpec());
        viewHolder.drive.setText(list.get(position).getDrive());

        return v;
    }
}
