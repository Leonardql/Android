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
import leonardqoli.howest.pwa30.adapters.ArtistsAdapter;
import leonardqoli.howest.pwa30.adapters.InvintationsAdapter;
import leonardqoli.howest.pwa30.api.RetrofitClient;
import leonardqoli.howest.pwa30.models.ArtistsResponse;
import leonardqoli.howest.pwa30.models.Invintation;
import leonardqoli.howest.pwa30.models.InvintationsResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowInvintationsFragment extends Fragment {
    private RecyclerView recyclerView;
    private InvintationsAdapter adapter;
    private List<Invintation> invintationList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_show_invintations, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerViewInvintation);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Call<InvintationsResponse> call = RetrofitClient.getInstance().getApi().getInvintations();

        call.enqueue(new Callback<InvintationsResponse>() {
            @Override
            public void onResponse(Call<InvintationsResponse> call, Response<InvintationsResponse> response) {
                invintationList = response.body().getInvintations();
                adapter = new InvintationsAdapter(getActivity(), invintationList);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<InvintationsResponse> call, Throwable t) {
                // do something
            }
        });
    }
}
