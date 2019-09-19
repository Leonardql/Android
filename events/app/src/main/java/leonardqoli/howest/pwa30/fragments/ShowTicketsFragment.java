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
import leonardqoli.howest.pwa30.adapters.TicketsAdapter;
import leonardqoli.howest.pwa30.api.RetrofitClient;


import leonardqoli.howest.pwa30.models.Ticket;
import leonardqoli.howest.pwa30.models.TicketsResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowTicketsFragment extends Fragment {
    private RecyclerView recyclerView;
    private TicketsAdapter adapter;
    private List<Ticket> ticketList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_show_tickets, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerViewTicket);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Call<TicketsResponse> call = RetrofitClient.getInstance().getApi().getTickets();

        call.enqueue(new Callback<TicketsResponse>() {
            @Override
            public void onResponse(Call<TicketsResponse> call, Response<TicketsResponse> response) {
                ticketList = response.body().getTickets();
                adapter = new TicketsAdapter(getActivity(), ticketList );
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<TicketsResponse> call, Throwable t) {
                // do something
            }
        });
    }
}
