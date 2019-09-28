package com.example.myapplication.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.adapter.ExerciseAdapter;
import com.example.myapplication.entity.Exercise;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ExerciseFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ExerciseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExerciseFragment extends Fragment {

    private static final String ARG_PARAM = "param";

    private String mParam;

    private ExerciseFragment.OnFragmentInteractionListener mListener;



    private ListView lvExecise;
    private Object JSON;


    public ExerciseFragment() {

        // Required empty public constructor

    }



    public static ExerciseFragment newInstance(String param) {

        ExerciseFragment fragment = new ExerciseFragment();

        Bundle args = new Bundle();

        args.putString(ARG_PARAM, param);

        fragment.setArguments(args);

        return fragment;

    }



    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

            mParam = getArguments().getString(ARG_PARAM);

        }

    }



    List<ExerciseAdapter.Exercise> exercises;

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_execise, container, false);

        // 准备的列表

        initData();



        // 1. 获取列表控件

        lvExecise = view.findViewById(R.id.list_view);

        // 2. 创建集合类控件需要的Adaper数据适配器（作用：UI与ArrayLt数据的桥梁）

//        String[] data = {"软件1711", "软件1721", "软件1731", "软件1741", "软件1751"};

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(

//                getActivity(), android.R.layout.simple_list_item_1, data);

        ExerciseAdapter adapter = new ExerciseAdapter(getActivity(), exercises);

        // 3. 设置ListView的Adapter

        lvExecise.setAdapter(adapter);



        // 4. ListView中的item的事件监听

        lvExecise.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Exercise exercise = (Exercise) parent.getItemAtPosition(position);

//                Intent intent = new Intent(ExerciseFragment.this.getContext(), ExerciseDetailActivity.class);

//                intent.putExtra("id", exercise.getId());

//                intent.putExtra("title", exercise.getTitle());

//                ExerciseFragment.this.startActivity(intent);

            }

        });

        return view;

    }



    private void initData() {

        exercises = new ArrayList<ExerciseAdapter.Exercise>();



        try {

            // 1. 从assets目录中获取资源的输入流

            InputStream input = getResources().getAssets().open("exercise_title.json");

            // 2. 将inputstream转为String

            String json = IOUtils.convert(input, StandardCharsets.UTF_8);

            // 3. 利用fastjson将字符串转为对象集合

            exercises = JSON.parseArray(json, Exercise.class);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }



    private void generateData() {

        exercises = new List<ExerciseAdapter.Exercise>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(@Nullable Object o) {
                return false;
            }

            @NonNull
            @Override
            public Iterator<ExerciseAdapter.Exercise> iterator() {
                return null;
            }

            @NonNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @NonNull
            @Override
            public <T> T[] toArray(@NonNull T[] ts) {
                return null;
            }

            @Override
            public boolean add(ExerciseAdapter.Exercise exercise) {
                return false;
            }

            @Override
            public boolean remove(@Nullable Object o) {
                return false;
            }

            @Override
            public boolean containsAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(@NonNull Collection<? extends ExerciseAdapter.Exercise> collection) {
                return false;
            }

            @Override
            public boolean addAll(int i, Collection<? extends ExerciseAdapter.Exercise> collection) {
                return false;
            }

            @Override
            public boolean removeAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(@Nullable Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public ExerciseAdapter.Exercise get(int i) {
                return null;
            }

            @Override
            public ExerciseAdapter.Exercise set(int i, ExerciseAdapter.Exercise exercise) {
                return null;
            }

            @Override
            public void add(int i, ExerciseAdapter.Exercise exercise) {

            }

            @Override
            public ExerciseAdapter.Exercise remove(int i) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<ExerciseAdapter.Exercise> listIterator() {
                return null;
            }

            @Override
            public ListIterator<ExerciseAdapter.Exercise> listIterator(int i) {
                return null;
            }

            @Override
            public List<ExerciseAdapter.Exercise> subList(int i, int i1) {
                return null;
            }
        };

        for(int i = 0; i < 15; i++) {

            ExerciseAdapter.Exercise exercise = new ExerciseAdapter.Exercise();

            exercise.setId(i + 1);

            switch (i) {

                case 0:

                    exercise.setTitle("第1章 Android基础入门");

                    exercise.setSubTitle("共计5题");



                    break;

                case 1:

                    exercise.setTitle("第2章 探究活动Activity");

                    exercise.setSubTitle("共计5题");



                    break;

                case 2:

                    exercise.setTitle("第3章 Android UI开发");

                    exercise.setSubTitle("共计5题");


                    break;

                case 3:

                    exercise.setTitle("第4章 探究碎片Fragment");

                    exercise.setSubTitle("共计5题");



                    break;

                case 4:

                    exercise.setTitle("第5章 广播接收者");

                    exercise.setSubTitle("共计5题");



                    break;

                case 5:

                    exercise.setTitle("第6章 数据存储");

                    exercise.setSubTitle("共计5题");



                    break;

                case 6:

                    exercise.setTitle("第7章 内容提供者");

                    exercise.setSubTitle("共计5题");



                    break;

                case 7:

                    exercise.setTitle("第8章 手机多媒体");

                    exercise.setSubTitle("共计5题");



                    break;

                case 8:

                    exercise.setTitle("第9章 网络编程");

                    exercise.setSubTitle("共计5题");



                    break;

                case 9:

                    exercise.setTitle("第10章 服务");

                    exercise.setSubTitle("共计5题");



                    break;

                case 10:

                    exercise.setTitle("第11章 基于位置的服务");

                    exercise.setSubTitle("共计5题");



                    break;

                case 11:

                    exercise.setTitle("第12章 Material Design实战");

                    exercise.setSubTitle("共计5题");


                    break;

                case 12:

                    exercise.setTitle("第13章 高级技巧");

                    exercise.setSubTitle("共计5题");



                    break;

                case 13:

                    exercise.setTitle("第14章 开发天气App");

                    exercise.setSubTitle("共计5题");


                    break;

                case 14:

                    exercise.setTitle("第15章 项目发布上线");

                    exercise.setSubTitle("共计5题");



                    break;

                default:

                    break;

            }

            exercises.add(exercise);

        }

    }



    public void onButtonPressed(Uri uri) {

        if (mListener != null) {

            mListener.setToolbarTitle("向Activity传值");

        }

    }



    @Override

    public void onAttach(Context context) {

        super.onAttach(context);

        if (context instanceof ExerciseFragment.OnFragmentInteractionListener) {

            mListener = (ExerciseFragment.OnFragmentInteractionListener) context;

            mListener.setToolbarTitle("向Activity传值");



        } else {

//            throw new RuntimeException(context.toString()

//                    + " must implement OnFragmentInteractionListener");

        }

    }



    @Override

    public void onDetach() {

        super.onDetach();

        mListener = null;

    }



    /**

     * This interface must be implemented by activities that contain this

     * fragment to allow an interaction in this fragment to be communicated

     * to the activity and potentially other fragments contained in that

     * activity.

     * <p>

     * See the Android Training lesson <a href=

     * "http://developer.android.com/training/basics/fragments/communicating.html"

     * >Communicating with Other Fragments</a> for more information.

     */

    public interface OnFragmentInteractionListener {

        void setToolbarTitle(String title);

    }

}

