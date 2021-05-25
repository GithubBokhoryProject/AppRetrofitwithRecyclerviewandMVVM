package com.example.appretrofitwithrecyclerviewandmvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.appretrofitwithrecyclerviewandmvvm.R;
import com.example.appretrofitwithrecyclerviewandmvvm.pojo.Post;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    PostViewModel postViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler_id);
        postViewModel= ViewModelProviders.of(this).get(PostViewModel.class);
        postViewModel.listMutableLiveData.observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {
                PostAdabter adabter=new PostAdabter(posts);
                RecyclerView.LayoutManager manager=new LinearLayoutManager(getApplication());
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(adabter);
            }
        });
        postViewModel.getData();
    }
}