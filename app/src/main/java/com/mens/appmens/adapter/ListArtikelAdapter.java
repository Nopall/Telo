package com.mens.appmens.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mens.appmens.R;
import com.mens.appmens.model.Artikel;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by islam on 28/08/17.
 */

public class ListArtikelAdapter extends RecyclerView.Adapter<ListArtikelAdapter.ViewHolder> {
    List<Artikel> artikels = new ArrayList<>();
    Context ctx;

    public ListArtikelAdapter(List<Artikel> artikels, Context ctx) {
        this.artikels = artikels;
        this.ctx = ctx;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.rcv_list_artikel,parent,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtJudul.setText(artikels.get(position).getTitle());
        holder.img_artikel.setImageResource(R.mipmap.ic_launcher);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_judulartikel)
        TextView txtJudul;
        @BindView(R.id.img_artikel)
        ImageView img_artikel;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }
    }
}
