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
import android.widget.TextView;

import leonardqoli.howest.pwa30.R;
import leonardqoli.howest.pwa30.Storage.SharedPrefManager;
import leonardqoli.howest.pwa30.activities.AddDescriptionActivity;
import leonardqoli.howest.pwa30.activities.AddSpecialGuestActivity;
import leonardqoli.howest.pwa30.activities.AddTicketsActivity;
import leonardqoli.howest.pwa30.activities.LoginActivity;
import leonardqoli.howest.pwa30.activities.RegisterActivity;
import leonardqoli.howest.pwa30.activities.UpdateArtistsActivity;
import leonardqoli.howest.pwa30.activities.UpdateDescriptionActivity;
import leonardqoli.howest.pwa30.activities.UpdateSpecialGuestActivity;
import leonardqoli.howest.pwa30.activities.UpdateTicketsActivity;

public class HomeFragment extends Fragment {

    Button updateDescription, updateArtist, updateSpecialGuest, updateTickets;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        updateDescription = (Button) view.findViewById(R.id.btnUpdateDescription);
        updateArtist = (Button) view.findViewById(R.id.btnUpdateArtist);
        updateSpecialGuest = (Button) view.findViewById(R.id.btnUpdateGuest);
        updateTickets = (Button) view.findViewById(R.id.btnUpdateTicket);

        updateDescription.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HomeFragment.this.getActivity(), UpdateDescriptionActivity.class);
                startActivity(intent);
            }
        });

        updateArtist.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeFragment.this.getActivity(), UpdateArtistsActivity.class);
                startActivity(intent);
            }
        });

        updateSpecialGuest.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeFragment.this.getActivity(), UpdateSpecialGuestActivity.class);
                startActivity(intent);
            }
        });

        updateTickets.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeFragment.this.getActivity(), UpdateTicketsActivity.class);
                startActivity(intent);
            }
        });

    }
}
