package com.example.mbankingapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mbankingapp.BankAccountData.User;
import com.example.mbankingapp.R;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    User user;

    public CustomAdapter(User usr){
        this.user = usr;
    }

    public CustomAdapter(){
    }

    public void updateAdapter(User usr) {
        this.user = usr;
    }


    // reference to TextViews made in transaction_model.xml
    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView amount;
        public TextView type;
        public TextView description;
        public TextView date;

        public ViewHolder(View itemView) {
            super(itemView);
            // assigning views to variables
            amount = (TextView) itemView.findViewById(R.id.amount);
            type = (TextView) itemView.findViewById(R.id.type);
            description = (TextView) itemView.findViewById(R.id.description);
            date = (TextView) itemView.findViewById(R.id.date);
        }

    }

    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.transaction_model, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomAdapter.ViewHolder holder, int position) {
        holder.amount.setText(user.accounts.get(0).transactions.get(position).getAmount());
        holder.date.setText(user.accounts.get(0).transactions.get(position).getDate());
        holder.type.setText(user.accounts.get(0).transactions.get(position).getType());
        holder.description.setText(user.accounts.get(0).transactions.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return user.accounts.get(0).transactions.size();
    }
}
