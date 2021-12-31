package tw.sgft.m0200;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomLabelAdapter extends RecyclerView.Adapter<CustomLabelAdapter.ViewHolder> {

          private int resID;
          private List<String> data;

          //檢查是否被選取用
          private boolean[] isChecked;

          //

          public CustomLabelAdapter(List<String> data, int resID) {
                    this.data = data;
                    this.resID = resID;
                    isChecked = new boolean[data.size()];
          }

          @NonNull
          @Override
          public CustomLabelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                    View view = LayoutInflater.from(parent.getContext())
                              .inflate(resID, parent, false);
                    ViewHolder holder = new ViewHolder(view);
                    return holder;
          }

          @Override
          public void onBindViewHolder(ViewHolder holder, int position) {
                    holder.title.setText(data.get(position));
                    holder.cb.setChecked(isChecked[position]);
                    //回傳Item的View的按鈕監聽
                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                              @Override
                              public void onClick(View v) {
                                        isChecked[position] = !isChecked[position];
                                        notifyDataSetChanged();
                              }
                    });
          }

          @Override
          public int getItemCount() {
                    return data.size();
          }

          public String getItem(int position) {
                    return data.get(position);
          }

          public boolean getItemChecked(int position) {
                    return isChecked[position];
          }

          class ViewHolder extends RecyclerView.ViewHolder {
                    CheckBox cb;
                    TextView title;

                    ViewHolder(View view) {
                              super(view);
                              cb = (CheckBox) view.findViewById(R.id.m0200_label_check);
                              title = (TextView) view.findViewById(R.id.m0200_label_text);
                    }

          }
}