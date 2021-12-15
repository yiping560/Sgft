package tw.sgft.m0100;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

          private int resID;
          private List<TestTeamData> data;
          private Context context;

          public CustomAdapter(Context context, List<TestTeamData> data, int resID) {
                    this.context = context;
                    this.data = data;
                    this.resID = resID;
          }

          class ViewHolder {
                    TextView title, desc, status;
          }

          @Override
          public int getCount() {
                    return this.data.size();
          }

          @Override
          public TestTeamData getItem(int position) {
                    return this.data.get(position);
          }

          @Override
          public long getItemId(int position) {
                    return 0;
          }

          @Override
          public View getView(int position, View convertView, ViewGroup parent) {
                    View view = convertView;
                    ViewHolder holder;
                    if (view == null) {
                              holder = new ViewHolder();
                              view = LayoutInflater.from(context).inflate(resID, null);
                              holder.title = (TextView) view.findViewById(R.id.m0200_custom_listview_container_tittle);
                              holder.desc = (TextView) view.findViewById(R.id.m0200_custom_listview_container_description);
                              holder.status = (TextView) view.findViewById(R.id.m0200_custom_listview_container_status);

                              view.setTag(holder);
                    } else {
                              holder = (ViewHolder) view.getTag();
                    }

                    holder.title.setText(data.get(position).title);
                    holder.desc.setText(data.get(position).desc);
                    holder.status.setText(data.get(position).status);
                    Log.d("555", "001");
                    return view;
          }
}