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
import leonardqoli.howest.pwa30.api.RetrofitClient;
import leonardqoli.howest.pwa30.models.Artist;
import leonardqoli.howest.pwa30.models.ArtistsResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowArtistsFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArtistsAdapter adapter;
    private List<Artist> artistList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_show_artists, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerViewArtist);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Call<ArtistsResponse> call = RetrofitClient.getInstance().getApi().getArtists();

        call.enqueue(new Callback<ArtistsResponse>() {
            @Override
            public void onResponse(Call<ArtistsResponse> call, Response<ArtistsResponse> response) {
                artistList = response.body().getArtists();
                adapter = new ArtistsAdapter(getActivity(), artistList);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ArtistsResponse> call, Throwable t) {
                // do something
            }
        });
    }
}
