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
import leonardqoli.howest.pwa30.adapters.OrdersAdapter;
import leonardqoli.howest.pwa30.api.RetrofitClient;
import leonardqoli.howest.pwa30.models.Order;
import leonardqoli.howest.pwa30.models.OrdersResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowOrdersFragment extends Fragment {

    private RecyclerView recyclerView;
    private OrdersAdapter adapter;
    private List<Order> orderList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_show_orders, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerViewOrder);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Call<OrdersResponse> call = RetrofitClient.getInstance().getApi().getOrders();

        call.enqueue(new Callback<OrdersResponse>() {
            @Override
            public void onResponse(Call<OrdersResponse> call, Response<OrdersResponse> response) {
                orderList = response.body().getOrders();
                adapter = new OrdersAdapter(getActivity(), orderList);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<OrdersResponse> call, Throwable t) {
                // do something
            }
        });
    }
}
