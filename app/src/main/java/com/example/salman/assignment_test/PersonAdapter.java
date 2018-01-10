package com.example.salman.assignment_test;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

/**
 * Created by Salman on 10/15/2017.
 */

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.myViewHolder> {

    Button btn;
    View view1;
    FragmentActivity context;
    ArrayList<Person> info;

    public PersonAdapter(FragmentActivity context, ArrayList<Person> info) {

        this.context = context;
        this.info = info;

    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView t1;
        TextView t2;
        TextView t3;
        Button btn;
        ImageView img;


        public myViewHolder(View itemView) {
            super(itemView);
            t1 = (TextView) itemView.findViewById(R.id.name);
            t2 = (TextView) itemView.findViewById(R.id.email);
            t3 = (TextView) itemView.findViewById(R.id.phone);
            btn = (Button) itemView.findViewById(R.id.details);
            img = (ImageView) itemView.findViewById(R.id.img_android);

        }
    }


    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        view1 = LayoutInflater.from(context).inflate(R.layout.single_person, parent, false);
        myViewHolder vh = new myViewHolder(view1);

        return vh;
    }

    @Override
    public void onBindViewHolder(final myViewHolder holder, final int position) {

        Person c = info.get(position);
        holder.t1.setText(c.getName().toString());
        holder.t2.setText(c.getEmail().toString());
        holder.t3.setText(c.getPhone().toString());
        Picasso.with(this.context).load("http://placehold.it/120x120&text=image"+(position+1))
                .placeholder(R.drawable.ic_stat_name)
                .resize(160, 160).into(holder.img);
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int itemPosition = holder.getAdapterPosition();

                EventBus.getDefault().post(new Event("New message!"));
            }
        });
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.remove(position);
                notifyItemRangeChanged(position, info.size());
                Toast.makeText(context, "One item deleted  ", Toast.LENGTH_SHORT).show();


            }

        });
    }

    @Override
    public int getItemCount() {
        return info.size();
    }
}
