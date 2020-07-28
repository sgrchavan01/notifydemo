package com.example.notificationtask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<NotificationModel> notificationModels;
    NotificationAdapter notificationAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.custom_toolbar_bg));
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.notification_recyclerview);
        getNotifcationData();

        notificationAdapter = new NotificationAdapter(getApplicationContext(),notificationModels);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(notificationAdapter);

    }

    private void getNotifcationData() {
        notificationModels=new ArrayList<>();
        NotificationModel notificationModel=new NotificationModel(R.drawable.person,"Bikru","Online","Provider","You have recivied 100545150, Cleaning Service");
        notificationModels.add(notificationModel);
        notificationModel = new NotificationModel(R.drawable.person1, "Nitesh", "Online", "Provider", "You have accepted 100000100, Pest control sevice");
        notificationModels.add(notificationModel);
        notificationModel = new NotificationModel(R.drawable.person2, "Ajay", "Online", "Admin", "Invite to accept Ref.****** accept as per schedule check order mangment after acceptance.");
        notificationModels.add(notificationModel);
        notificationModel = new NotificationModel(R.drawable.person3, "Ajay kr", "Online", "Provider", "You have recivied 100545150, Cleaning Service");
        notificationModels.add(notificationModel);
        notificationModel = new NotificationModel(R.drawable.person, "Bikru", "Online", "Provider", "You have recivied 100545150, Cleaning Service");
        notificationModels.add(notificationModel);
        notificationModel = new NotificationModel(R.drawable.person1, "Bikru", "Online", "Provider", "You have recivied 100545150, Cleaning Service");
        notificationModels.add(notificationModel);
        notificationModel = new NotificationModel(R.drawable.person2, "Bikru", "Online", "Provider", "You have recivied 100545150, Cleaning Service");
        notificationModels.add(notificationModel);
        notificationModel = new NotificationModel(R.drawable.person3, "Bikru", "Offline", "Provider", "You have recivied 100545150, Cleaning Service");
        notificationModels.add(notificationModel);


    }

    private class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {
        Context context;
        ArrayList<NotificationModel> notificationModels;
        View view;
        public NotificationAdapter(Context context, ArrayList<NotificationModel> notificationModels) {
            this.context=context;
            this.notificationModels=notificationModels;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notify_item, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
            holder.profileView.setImageResource(notificationModels.get(position).getImage());
          holder.olofTextView.setText(notificationModels.get(position).getOlof());
            holder.txtprovider.setText(notificationModels.get(position).getUserType());
            holder.txtusername.setText(notificationModels.get(position).getUsername());
            holder.txtdecp.setText(notificationModels.get(position).getDescp());

            if (notificationModels.get(position).getUserType().equals("Admin"))
            {
                holder.updownLayout.setVisibility(View.VISIBLE);
                holder.upButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        holder.upButton.setVisibility(View.GONE);
                        holder.downButton.setVisibility(View.VISIBLE);
                        holder.adminLinearLayout.setVisibility(View.VISIBLE);
                    }
                });

                holder.downButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        holder.upButton.setVisibility(View.VISIBLE);
                        holder.downButton.setVisibility(View.GONE);
                        holder.adminLinearLayout.setVisibility(View.GONE);
                    }
                });
            }else {
                holder.updownLayout.setVisibility(View.GONE);
                holder.adminLinearLayout.setVisibility(View.GONE);
            }

            if (notificationModels.get(position).getOlof().equals("Offline"))
            {
                holder.mainlayout.setBackground(getResources().getDrawable(R.drawable.custom_grey_layout));
                holder.olofTextView.setBackground(getResources().getDrawable(R.drawable.button_grey_bg));
            }else {
                holder.mainlayout.setBackground(getResources().getDrawable(R.drawable.custom_layout));
                holder.olofTextView.setBackground(getResources().getDrawable(R.drawable.button_orange_bg));

            }







        }

        @Override
        public int getItemCount() {
            return notificationModels.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView profileView;
            TextView olofTextView,txtprovider,txtusername,txtdecp;
            ImageButton upButton,downButton;
            LinearLayout adminLinearLayout, mainlayout,updownLayout;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                profileView=itemView.findViewById(R.id.profile_image);
                olofTextView=itemView.findViewById(R.id.txt_oloff);
                txtprovider=itemView.findViewById(R.id.txt_provider);
                txtusername=itemView.findViewById(R.id.txt_username);
                txtdecp=itemView.findViewById(R.id.txt_descp);
                downButton=itemView.findViewById(R.id.btn_down);
                upButton=itemView.findViewById(R.id.btn_up);
                updownLayout=itemView.findViewById(R.id.linear_updown);
                adminLinearLayout=itemView.findViewById(R.id.linear_admin);
                mainlayout=itemView.findViewById(R.id.main_layout);

            }
        }
    }
}
