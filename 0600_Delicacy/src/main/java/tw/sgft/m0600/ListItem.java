package tw.sgft.m0600;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListItem extends BaseAdapter {
    private Context context;
    private  int resID;
    private String[] data;
    private int[] imgset;

    public ListItem(Context context,String[] data, int resID,int[] imgset)  {
        this.context =context;
        this.data =data;
        this.resID=resID;
        this.imgset=imgset;
    }

    class ViewHolder{
        ImageView imgView;
        TextView txtView;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public String getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(resID, null);

            holder.txtView = view.findViewById(R.id.txtView);
            holder.imgView = view.findViewById(R.id.imgView);

            view.setTag(holder);
        }else {
            holder=(ViewHolder) view.getTag();
        }

        holder.txtView.setText(data[position]);
        holder.imgView.setImageResource(imgset[position]);


        return view;
    }
}