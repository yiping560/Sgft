package tw.sgft.m0200;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

          private List<TestData> data;
          //Layout讀取器，用來讀取版型xml檔
          private LayoutInflater inflater;

          public CustomAdapter(List<TestData> data, LayoutInflater inflater) {
                    this.data = data;
                    this.inflater = inflater;
          }

          class ViewHolder {
                    LinearLayout ll;
                    ImageView icon;
                    TextView name, desc;
          }

          @Override
          public int getCount() {
                    return data.size();
          }

          @Override
          public TestData getItem(int position) {
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
                              view = inflater.inflate(R.layout.m0200_adapter_set, null);

                              holder.name = (TextView) view.findViewById(R.id.testdata_name);
                              holder.desc = (TextView) view.findViewById(R.id.testdata_desc);

                              view.setTag(holder);
                    } else {
                              holder = (ViewHolder) view.getTag();
                    }

                    holder.name.setText(data.get(position).getName());
                    holder.desc.setText(data.get(position).getDesc());

                    return view;
          }
}