package com.example.app.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.app.R;
import com.example.app.Object.Student;

import java.util.List;

public class studentAdapter extends BaseAdapter {

    List<Student> studentList;

    public studentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public int getCount() {
        return this.studentList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return this.studentList.size();
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items,parent,false);
        TextView txName=view.findViewById(R.id.nameItem);
        TextView txClass=view.findViewById(R.id.Classrom);
        TextView txAddress=view.findViewById(R.id.address);
        Student student=studentList.get(i);
        txName.setText(student.getName());
        txClass.setText(student.getClassroom());
        txAddress.setText(student.getAddress());

        return view;
    }
}
