package com.example.bankingapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.myViewHolder>
{
    ArrayList<Accounts> dataholder;
    Context context;
    private OnNoteListener onNoteListener;
    public interface OnNoteListener
    {
        void onClick(int position);
    }
    public void OnNoteListener(OnNoteListener onNoteListener)
    {
     this.onNoteListener= onNoteListener;
    }
    public AccountAdapter(ArrayList<Accounts> dataholder , OnNoteListener onNoteListener) {
        this.dataholder = dataholder;
        this.onNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item,parent,false);
        return new myViewHolder(view,onNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.aname.setText(dataholder.get(position).getACCOUNT_NAME());
        holder.anum.setText(dataholder.get(position).getACCOUNT_NUMBER());
        holder.amm.setText(dataholder.get(position).getAMMOUNT());

    }
    @Override
    public int getItemCount()
      {
        return dataholder.size();
      }

    class myViewHolder extends RecyclerView.ViewHolder  {

        public ImageView iv;
        TextView aname, anum, amm;
        OnNoteListener onNoteListener;

        public myViewHolder(final View view, OnNoteListener onNoteListener ) {
            super(view);
            aname = (TextView) itemView.findViewById(R.id.aname);
            anum = (TextView) itemView.findViewById(R.id.anum);
            amm = (TextView) itemView.findViewById(R.id.amm);
            this.onNoteListener = onNoteListener;
             view.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     if(onNoteListener!=null && getAbsoluteAdapterPosition()!=RecyclerView.NO_POSITION)
                     {
                         onNoteListener.onClick(getAbsoluteAdapterPosition());
                     }
                 }
             });
        }



    }

}