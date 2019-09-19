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
import leonardqoli.howest.pwa30.adapters.TestimonialsAdapter;
import leonardqoli.howest.pwa30.api.RetrofitClient;
import leonardqoli.howest.pwa30.models.Artist;
import leonardqoli.howest.pwa30.models.ArtistsResponse;
import leonardqoli.howest.pwa30.models.Testimonial;
import leonardqoli.howest.pwa30.models.TestimonialResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowTestimonialsFragment extends Fragment {
    private RecyclerView recyclerView;
    private TestimonialsAdapter adapter;
    private List<Testimonial> testimonialList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_show_testimonials, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerViewTestimonial);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Call<TestimonialResponse> call = RetrofitClient.getInstance().getApi().getTestimonials();

        call.enqueue(new Callback<TestimonialResponse>() {
            @Override
            public void onResponse(Call<TestimonialResponse> call, Response<TestimonialResponse> response) {
                testimonialList = response.body().getTestimonials();
                adapter = new TestimonialsAdapter(getActivity(), testimonialList);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<TestimonialResponse> call, Throwable t) {
                // do something
            }
        });
    }
}
