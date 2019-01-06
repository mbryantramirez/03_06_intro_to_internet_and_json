package com.example.bionic.lesson0306json;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class HoundAdapter extends RecyclerView.Adapter<HoundViewHolder> {

  private List<String> houndUrls;

  HoundAdapter(List<String> houndUrls) {
    this.houndUrls = houndUrls;
  }

  @NonNull
  @Override
  public HoundViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View view = LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.hound_item, viewGroup, false);
    return new HoundViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull HoundViewHolder houndViewHolder, int i) {
    String url = houndUrls.get(i);
    houndViewHolder.bind(url);
  }

  @Override
  public int getItemCount() {
    return houndUrls.size();
  }
}
