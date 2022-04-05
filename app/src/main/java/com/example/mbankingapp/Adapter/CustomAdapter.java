package com.example.mbankingapp.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mbankingapp.BankAccountData.Transaction;
import com.example.mbankingapp.BankAccountData.User;
import com.example.mbankingapp.R;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    User user;
    List<String> amount = new ArrayList<>();
    List<String> description = new ArrayList<>();
    List<String> date = new ArrayList<>();
    List<String> type = new ArrayList<>();
    int accountId;
    int i = 0;
    int counter = 0;

    public CustomAdapter(User usr, int numberOfAccount){
        this.user = usr;
        this.accountId = numberOfAccount;

        for(i = 0; i < user.accounts.get(numberOfAccount).transactions.size(); i++) {
            Transaction t = user.accounts.get(numberOfAccount).transactions.get(i);

            amount.add(t.getAmount());
            date.add(t.getDate());
            description.add(t.getDescription());
            type.add(t.getType());
        }
    }

    public CustomAdapter(){
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

        public TextView getAmount() {
            return amount;
        }

        public TextView getType() {
            return type;
        }

        public TextView getDescription() {
            return description;
        }

        public TextView getDate() {
            return date;
        }

    }


    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.transaction_model, parent, false);
        Log.d("VIEW", "View " + this.counter + " created!");
        this.counter += 1;

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.amount.setText(amount.get(position));
        holder.date.setText(date.get(position));
        holder.type.setText(type.get(position));
        holder.description.setText(description.get(position));

    }

    @Override
    public int getItemCount() {
        return amount.size();
    }
}
