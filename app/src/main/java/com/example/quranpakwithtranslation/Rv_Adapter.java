package com.example.quranpakwithtranslation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Rv_Adapter extends RecyclerView.Adapter<Rv_Adapter.MyVH> {

    List<Rv_model> friendsList;
    public Rv_Adapter(List<Rv_model> friendsList) {
        this.friendsList = friendsList;
    }

    @NonNull
    @Override
    public Rv_Adapter.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_item, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Rv_Adapter.MyVH holder, int position) {
        holder.data=friendsList.get(position);
        holder.textViewParaID.setText(String.valueOf(holder.data.getParaID()));
        holder.textViewSurahID.setText(String.valueOf(holder.data.getSurahID()));
        holder.textViewAyahNo.setText(String.valueOf(holder.data.getAyahNo()));
        holder.textViewArabic.setText(holder.data.getArabic());
        holder.textViewTran.setText(holder.data.getTran());
    }

    @Override
    public int getItemCount() {
        return friendsList.size();
    }


    public class MyVH extends RecyclerView.ViewHolder {
        TextView textViewParaID;
        TextView textViewSurahID;
        TextView textViewAyahNo;
        TextView textViewArabic;
        TextView textViewTran;
        Rv_model data;
        public MyVH(@NonNull View itemView) {
            super(itemView);
            textViewParaID = itemView.findViewById(R.id.textViewParaID);
            textViewSurahID = itemView.findViewById(R.id.textViewSurahID);
            textViewAyahNo = itemView.findViewById(R.id.textViewAyahNo);
            textViewArabic = itemView.findViewById(R.id.textViewArabic);
            textViewTran = itemView.findViewById(R.id.textViewTran);
        }
    }
}
