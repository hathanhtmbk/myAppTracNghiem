package com.example.myapptracnghiem.KienThucMonHoc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapptracnghiem.R;
import com.example.myapptracnghiem.question.Question;
import com.example.myapptracnghiem.question.QuestionAdapter;

import java.util.ArrayList;

public class nguyenToAdapter extends RecyclerView.Adapter<nguyenToAdapter.ViewHolder>{
    Context context;
    ArrayList<nguyenTo> nguyenTos;

    public nguyenToAdapter(Context context, ArrayList<nguyenTo> nguyenTos) {
        this.context = context;
        this.nguyenTos = nguyenTos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater .inflate(R.layout.item_nguyento,parent,false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvkihieu.setText(nguyenTos.get(position).getKiHieu());
        holder.tvten.setText(nguyenTos.get(position).getTen());
        holder.tvsohieuNT.setText(String.valueOf(nguyenTos.get(position).getSohieuNT()));
        holder.tvNTKTB.setText(String.valueOf(nguyenTos.get(position).getNgTuKhoiTB()));
        holder.tvdoAD.setText(String.valueOf(nguyenTos.get(position).getdADien()));
        holder.tvsoOxi.setText(nguyenTos.get(position).getSoOxi());
    }

    @Override
    public int getItemCount() {
        return nguyenTos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvkihieu,tvsohieuNT,tvten,tvNTKTB,tvdoAD,tvsoOxi;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvkihieu=itemView.findViewById(R.id.tvkh);
            tvten=itemView.findViewById(R.id.tvten);
            tvsohieuNT=itemView.findViewById(R.id.tvshnt);
            tvNTKTB=itemView.findViewById(R.id.tvntktb);
            tvdoAD=itemView.findViewById(R.id.tvdoAm);
            tvsoOxi=itemView.findViewById(R.id.tvox);
        }
    }
}
