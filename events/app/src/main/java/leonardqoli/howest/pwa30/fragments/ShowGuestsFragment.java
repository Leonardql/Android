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

import java.util.List;

import leonardqoli.howest.pwa30.R;
import leonardqoli.howest.pwa30.adapters.GuestsAdapter;
import leonardqoli.howest.pwa30.api.RetrofitClient;

import leonardqoli.howest.pwa30.models.Guest;
import leonardqoli.howest.pwa30.models.GuestsResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowGuestsFragment extends Fragment {

    private RecyclerView recyclerView;
    private GuestsAdapter adapter;
    private List<Guest> guestList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_show_guest, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerViewGuests);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Call<GuestsResponse> call = RetrofitClient.getInstance().getApi().getGuests();

        call.enqueue(new Callback<GuestsResponse>() {
            @Override
            public void onResponse(Call<GuestsResponse> call, Response<GuestsResponse> response) {
                guestList = response.body().getGuests();
                adapter = new GuestsAdapter(getActivity(), guestList);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<GuestsResponse> call, Throwable t) {
                // do something
            }
        });
    }
}
