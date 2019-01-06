package com.example.bionic.lesson0306json;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

public class HoundViewHolder extends RecyclerView.ViewHolder {

  private ImageView houndImage;

  HoundViewHolder(@NonNull View itemView) {
    super(itemView);
    houndImage = itemView.findViewById(R.id.hound_iv);
  }

  void bind(String url) {
    Picasso.get().load(url).centerCrop().fit().into(houndImage);
  }
}
