package com.itg8.adminapp.teachers;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;
import com.itg8.adminapp.R;
import com.itg8.adminapp.common.GenericAdapter;
import com.itg8.adminapp.common.OnRecyclerItemClickListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TeacherDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TeacherDetailFragment extends Fragment implements OnRecyclerItemClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.text_name)
    TextView textName;
    @BindView(R.id.btn_track)
    TextView btnTrack;
    @BindView(R.id.card_teacher_name)
    CardView cardTeacherName;
    @BindView(R.id.calendarView)
    CalendarView calendarView;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    Unbinder unbinder;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public TeacherDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TeacherDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TeacherDetailFragment newInstance(String param1, String param2) {
        TeacherDetailFragment fragment = new TeacherDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_teacher_detail, container, false);
        unbinder = ButterKnife.bind(this, view);
        init();
        return view;
    }


    private void init() {
        setCalenderView();
        setRecyclerView();
    }

    private void setRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(new GenericAdapter(new ArrayList(),10) {
            @Override
            public RecyclerView.ViewHolder setViewHolder(ViewGroup parent, OnRecyclerItemClickListener listener) {
                TeacherPeriodViewHolder viewHolder= new TeacherPeriodViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_teacher_period_rv,parent,false));
                viewHolder.setListener(listener);
                return viewHolder;
            }

            @Override
            public void onBindData(RecyclerView.ViewHolder holder, Object val) {

            }

            @Override
            public OnRecyclerItemClickListener getListener() {
                return TeacherDetailFragment.this;
            }
        });
    }

    private void setCalenderView() {

        List<EventDay> events = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH,2);
        events.add(new EventDay(calendar, R.drawable.ic_circle_green));
        calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 3);
        events.add(new EventDay(calendar, R.drawable.ic_circle_red));

        calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 4);
        events.add(new EventDay(calendar, R.drawable.ic_circle_blue));
        calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 5);
        events.add(new EventDay(calendar, R.drawable.ic_circle_green));
        calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 6 );
        events.add(new EventDay(calendar, R.drawable.ic_circle_green));



        Calendar min = Calendar.getInstance();
        min.add(Calendar.MONTH, -2);

        Calendar max = Calendar.getInstance();
        max.add(Calendar.MONTH, 2);

        calendarView.setMinimumDate(min);
        calendarView.setMaximumDate(max);

        calendarView.setEvents(events);



//        calendarView.setDisabledDays(getDisabledDays());
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onItemClicked(View view, int position) {

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
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
