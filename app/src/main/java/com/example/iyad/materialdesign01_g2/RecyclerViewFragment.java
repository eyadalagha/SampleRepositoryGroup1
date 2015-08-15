package com.example.iyad.materialdesign01_g2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iyad on 8/1/2015.
 */
public class RecyclerViewFragment extends Fragment{

    ArrayList<Employee> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recycler_view_fragment_layout, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(savedInstanceState == null) {

            list = new ArrayList<Employee>();

            Employee e1 = new Employee("Ahmed", R.drawable.f1);
            Employee e2 = new Employee("Ali", R.drawable.f2);
            Employee e3 = new Employee("Amal", R.drawable.f3);
            Employee e4 = new Employee("Ahmed", R.drawable.f1);
            Employee e5 = new Employee("Ali", R.drawable.f2);
            Employee e6 = new Employee("Amal", R.drawable.f3);
            Employee e7 = new Employee("Ahmed", R.drawable.f1);
            Employee e8 = new Employee("Ali", R.drawable.f2);
            Employee e9 = new Employee("Amal", R.drawable.f3);

            list.add(e1);
            list.add(e2);
            list.add(e3);
            list.add(e4);
            list.add(e5);
            list.add(e6);
            list.add(e7);
            list.add(e8);
            list.add(e9);
        }else{
            list = savedInstanceState.getParcelableArrayList("employees");
        }

        final MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(this.getActivity(), list);

        final RecyclerView rv = (RecyclerView) this.getView().findViewById(R.id.recyclerView);
        rv.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(this.getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(manager);

        DefaultItemAnimator animator = new DefaultItemAnimator();
        animator.setAddDuration(3000);
        animator.setRemoveDuration(3000);
        rv.setItemAnimator(animator);

        adapter.setOnRecyclerViewListener(new MyRecyclerViewAdapter.RecyclerViewListener() {
            public void itemSelected(View v, int position){
                Toast.makeText(getActivity(), position + "", Toast.LENGTH_LONG).show();
                list.remove(position);
                adapter.notifyItemRemoved(position);
            }
        });

        final SwipeRefreshLayout swipeLayout = (SwipeRefreshLayout)this.getView().findViewById(R.id.swipLayout);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Employee e = new Employee("Amal",R.drawable.f2);
                list.add(0,e);
                adapter.notifyItemInserted(0);
                swipeLayout.setRefreshing(false);
            }
        });



    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("employees", list);
    }
}
