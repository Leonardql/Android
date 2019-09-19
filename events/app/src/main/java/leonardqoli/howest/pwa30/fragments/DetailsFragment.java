package leonardqoli.howest.pwa30.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import leonardqoli.howest.pwa30.R;

public class DetailsFragment extends Fragment {

    Button showArtists, showGuests, showOrders, showTickets, showTestimonials, showInvintations;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_show_details, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        showArtists = (Button) view.findViewById(R.id.btnShowArtists);
        showGuests = (Button) view.findViewById(R.id.btnShowGuests);
        showTickets = (Button) view.findViewById(R.id.btnShowTickets);
        showOrders = (Button) view.findViewById(R.id.btnShowOrders);
        showInvintations = (Button) view.findViewById(R.id.btnShowInvintations);
        showTestimonials = (Button) view.findViewById(R.id.btnShowTestimonial);


        showArtists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new ShowArtistsFragment()).commit();
            }
        });

        showGuests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new ShowGuestsFragment()).commit();
            }
        });

        showTickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new ShowTicketsFragment()).commit();
            }
        });

        showOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new ShowOrdersFragment()).commit();
            }
        });

        showInvintations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new ShowInvintationsFragment()).commit();
            }
        });

        showTestimonials.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new ShowTestimonialsFragment()).commit();
            }
        });
    }
}
