package com.example.up_splash;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class recadapter extends RecyclerView.Adapter<recadapter.ViewHolder> {
    LayoutInflater inflater;
  Context context;
    List<Photoss> E1;

    public recadapter(Context applicationContext, ArrayList<Photoss> photosses) {
        this.inflater=LayoutInflater.from(applicationContext);
        this.E1=photosses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rvlayut,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            String lin1= E1.get(position).getMurl();
        context = holder.itemView.getContext();

        context= context.getApplicationContext();
        Glide.with(context)
                .load(lin1)
                .centerCrop()
                .into(holder.ur1);
        String dd= E1.get(position).getMtext();
        holder.dec.setText(dd);
        String lin2= E1.get(position).getMurl2();
        Glide.with(context)
                .load(lin2)
                .centerCrop()
                .into(holder.ur2);
        String name= E1.get(position).getMname();
        holder.nam.setText(name);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Photoss p1=E1.get(position);
                String url= p1.getMurl();
                String t=p1.getMtext();
                Intent intent=new Intent(view.getContext(),MainActivity2.class);
                intent.putExtra("a1",url);
                intent.putExtra("a3",t);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        holder.nam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Photoss p1=E1.get(position);
            String bbio=p1.getBb();
            String llo= p1.getLoc();
            String pf=p1.getMurl2();
            String nnn=p1.getMname();
                Intent intent=new Intent(view.getContext(),MainActivity3.class);
                intent.putExtra("a1",bbio);
                intent.putExtra("a3",llo);
                intent.putExtra("a6",pf);
                intent.putExtra("a8",nnn);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return E1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView dec, nam;
        ImageView ur1,ur2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView=itemView.findViewById(R.id.cardd);
            dec=itemView.findViewById(R.id.tt);
            nam=itemView.findViewById(R.id.nn);
            ur1=itemView.findViewById(R.id.im1);
            ur2=itemView.findViewById(R.id.ii);
        }
    }
}
