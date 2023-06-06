package com.example.asm1_ps28784;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NhanVien extends AppCompatActivity
{



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }




    public static ArrayList<Shape> shapeList = new ArrayList<Shape>();

    private ListView listView;

    private String selectedFilter = "all";
    private String currentSearchText = "";
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_vien);

        initSearchWidgets();
        setupData();
        setUpList();
        setUpOnclickListener();
    }

    private void initSearchWidgets()
    {
        searchView = (SearchView) findViewById(R.id.shapeListSearchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s)
            {
                currentSearchText = s;
                ArrayList<Shape> filteredShapes = new ArrayList<Shape>();

                for(Shape shape: shapeList)
                {
                    if(shape.getName().toLowerCase().contains(s.toLowerCase()))
                    {
                        if(selectedFilter.equals("all"))
                        {
                            filteredShapes.add(shape);
                        }
                        else
                        {
                            if(shape.getName().toLowerCase().contains(selectedFilter))
                            {
                                filteredShapes.add(shape);
                            }
                        }
                    }
                }
                ShapeAdapter adapter = new ShapeAdapter(getApplicationContext(), 0, filteredShapes);
                listView.setAdapter(adapter);

                return false;
            }
        });
    }


    private void setupData()
    {
        Shape circle = new Shape("0", "Circle", R.drawable.human_res);
        shapeList.add(circle);

        Shape triangle = new Shape("1","Triangle", R.drawable.human_res);
        shapeList.add(triangle);

        Shape square = new Shape("2","Square", R.drawable.human_res);
        shapeList.add(square);

        Shape rectangle = new Shape("3","Rectangle", R.drawable.human_res);
        shapeList.add(rectangle);

        Shape octagon = new Shape("4","Octagon", R.drawable.human_res);
        shapeList.add(octagon);

        Shape circle2 = new Shape("5", "Circle 2", R.drawable.human_res);
        shapeList.add(circle2);

        Shape triangle2 = new Shape("6","Triangle 2", R.drawable.human_res);
        shapeList.add(triangle2);

        Shape square2 = new Shape("7","Square 2", R.drawable.human_res);
        shapeList.add(square2);

        Shape rectangle2 = new Shape("8","Rectangle 2", R.drawable.human_res);
        shapeList.add(rectangle2);

        Shape octagon2 = new Shape("9","Octagon 2", R.drawable.human_res);
        shapeList.add(octagon2);
    }

    private void setUpList()
    {
        listView = (ListView) findViewById(R.id.shapesListView);

        ShapeAdapter adapter = new ShapeAdapter(getApplicationContext(), 0, shapeList);
        listView.setAdapter(adapter);
    }

    private void setUpOnclickListener()
    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {
                Shape selectShape = (Shape) (listView.getItemAtPosition(position));
                Intent showDetail = new Intent(getApplicationContext(), DetailActivity.class);
                showDetail.putExtra("id",selectShape.getId());
                startActivity(showDetail);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Nhân Viên");
    }

    private void filterList(String status)
    {
        selectedFilter = status;

        ArrayList<Shape> filteredShapes = new ArrayList<Shape>();

        for(Shape shape: shapeList)
        {
            if(shape.getName().toLowerCase().contains(status))
            {
                if(currentSearchText == "")
                {
                    filteredShapes.add(shape);
                }
                else
                {
                    if(shape.getName().toLowerCase().contains(currentSearchText.toLowerCase()))
                    {
                        filteredShapes.add(shape);
                    }
                }
            }
        }

        ShapeAdapter adapter = new ShapeAdapter(getApplicationContext(), 0, filteredShapes);
        listView.setAdapter(adapter);
    }




    public void allFilterTapped(View view)
    {
        selectedFilter = "all";

        ShapeAdapter adapter = new ShapeAdapter(getApplicationContext(), 0, shapeList);
        listView.setAdapter(adapter);



    }

    public void triangleFilterTapped(View view)
    {
        filterList("triangle");
    }

    public void squareFilterTapped(View view)
    {
        filterList("square");
    }

    public void octagonFilterTapped(View view)
    {
        filterList("octagon");
    }

    public void rectangleFilterTapped(View view)
    {
        filterList("rectangle");
    }

    public void circleFilterTapped(View view)
    {
        filterList("circle");
    }


}