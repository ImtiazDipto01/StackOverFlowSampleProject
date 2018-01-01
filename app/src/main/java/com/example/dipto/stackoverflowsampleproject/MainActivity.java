package com.example.dipto.stackoverflowsampleproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView ;
    SampleRecylerAdapter sampleRecylerAdapter ;
    RecyclerView.LayoutManager layoutManager ;
    SearchView searchView ;

    String[] names = {"Imtiaz Dipto", "Arnab", "kopay dimu saad", "Imtiaz Kalam Abir", "Nazmul hasan", "ami imtiaz", "saad boka"} ;
    List<String> list ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>() ;

        recyclerView = findViewById(R.id.my_recyler) ;
        searchView = findViewById(R.id.search_view_sample) ;

        layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        sampleRecylerAdapter = new SampleRecylerAdapter(this, getData()) ;
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(sampleRecylerAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                newText = newText.toLowerCase() ;
                List<String> searchnames = new ArrayList<>() ;

                for(int i = 0 ; i < names.length ; i++){
                    String name = names[i].toLowerCase() ;
                    if(name.contains(newText)){
                        searchnames.add(name) ;
                    }
                }
                sampleRecylerAdapter.setFilter(searchnames);
                return true;
            }
        });
    }

    private List<String> getData(){

        for(int i = 0 ; i < names.length ; i++){
            list.add(names[i]);
        }
        return list ;
    }
}
