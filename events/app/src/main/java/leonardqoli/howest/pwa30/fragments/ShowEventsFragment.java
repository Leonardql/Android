package leonardqoli.howest.pwa30.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import leonardqoli.howest.pwa30.R;
import leonardqoli.howest.pwa30.Storage.SharedPrefManager;
import leonardqoli.howest.pwa30.adapters.EventsAdapter;
import leonardqoli.howest.pwa30.adapters.UsersAdapter;
import leonardqoli.howest.pwa30.api.RetrofitClient;
import leonardqoli.howest.pwa30.models.Event;
import leonardqoli.howest.pwa30.models.EventsResponse;
import leonardqoli.howest.pwa30.models.User;
import leonardqoli.howest.pwa30.models.UsersResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowEventsFragment extends Fragment {


    private RecyclerView recyclerView;
    private List<Event> eventList;
    private EventsAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_show_events, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Call<EventsResponse> call = RetrofitClient.getInstance().getApi().getEvents();

        call.enqueue(new Callback<EventsResponse>() {
            @Override
            public void onResponse(Call<EventsResponse> call, Response<EventsResponse> response) {

                eventList = response.body().getEvents();
                adapter = new EventsAdapter(getActivity(), eventList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<EventsResponse> call, Throwable t) {
                // do something
            }
        });
    }







}
