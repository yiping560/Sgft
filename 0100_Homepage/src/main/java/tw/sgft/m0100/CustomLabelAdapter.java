package tw.sgft.m0100;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class CustomLabelAdapter extends BaseAdapter {

          private int resID;
          private List<String> data;
          private Context context;

          public CustomLabelAdapter(Context context, List<String> data,int resID) {
                    this.context = context;
                    this.data = data;
                    this.resID=resID;
          }

          class ViewHolder {
                    CheckBox cb;
                    TextView title;
          }


          @Override
          public int getCount() {
                    return data.size();
          }

          @Override
          public String getItem(int position) {
                    return data.get(position);
          }

          @Override
          public long getItemId(int position) {
                    return position;
          }

          @Override
          public View getView(int position, View convertView, ViewGroup parent) {
                    View view = convertView;
                    ViewHolder holder;
                    if (view == null) {
                              holder = new ViewHolder();
                              view = LayoutInflater.from(context).inflate(resID, null);

                              holder.cb = (CheckBox) view.findViewById(R.id.m0200_label_check);
                              holder.title = (TextView) view.findViewById(R.id.m0200_label_title);


                              view.setTag(holder);
                    } else {
                              holder = (ViewHolder) view.getTag();
                    }

                    holder.title.setText(data.get(position));
                    Log.d("555","001");
                    return view;
          }
}