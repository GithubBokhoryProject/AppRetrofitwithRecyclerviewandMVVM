package com.example.appretrofitwithrecyclerviewandmvvm.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appretrofitwithrecyclerviewandmvvm.R;
import com.example.appretrofitwithrecyclerviewandmvvm.pojo.Post;

import java.util.List;

public class PostAdabter extends RecyclerView.Adapter<PostAdabter.PostViewHolder> {

List<Post> postArrayList;

    public PostAdabter(List<Post> postArrayList) {
        this.postArrayList = postArrayList;
    }

    @NonNull

    @Override
    public PostViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post,null,false);
        PostViewHolder postViewHolder=new PostViewHolder(v);
        return postViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull  PostViewHolder holder, int position) {
    Post post=postArrayList.get(position);
    holder.title.setText(post.getTitle());
    holder.body.setText(post.getBody());

    }

    @Override
    public int getItemCount() {
        return postArrayList.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder{
     TextView title,body;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.txt_title);
            body=itemView.findViewById(R.id.txt_body);
        }
    }
}
