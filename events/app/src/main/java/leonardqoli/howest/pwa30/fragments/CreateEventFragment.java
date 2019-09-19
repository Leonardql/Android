package leonardqoli.howest.pwa30.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;

import leonardqoli.howest.pwa30.R;
import leonardqoli.howest.pwa30.activities.AddArtistsActivity;
import leonardqoli.howest.pwa30.activities.AddDescriptionActivity;
import leonardqoli.howest.pwa30.activities.AddSpecialGuestActivity;
import leonardqoli.howest.pwa30.activities.AddTicketsActivity;
import leonardqoli.howest.pwa30.activities.MainActivity;
import leonardqoli.howest.pwa30.activities.UpdateArtistsActivity;

public class CreateEventFragment extends Fragment{

    Button addDescription, addArtist, addSpecialGuest, addTickets, btnEdit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_create_event, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        addDescription = (Button) view.findViewById(R.id.btnAddEvent);
        addArtist = (Button) view.findViewById(R.id.btnAddArtists);
        addSpecialGuest = (Button) view.findViewById(R.id.btnAddSpecialGuest);
        addTickets = (Button) view.findViewById(R.id.bntAddTickets);
        btnEdit = (Button) view.findViewById(R.id.btnEdit);


        addDescription.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(CreateEventFragment.this.getActivity(), AddDescriptionActivity.class);
                startActivity(intent);
            }
        });

        addArtist.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateEventFragment.this.getActivity(), AddArtistsActivity.class);
                startActivity(intent);
            }
        });

        addSpecialGuest.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateEventFragment.this.getActivity(), AddSpecialGuestActivity.class);
                startActivity(intent);
            }
        });

        addTickets.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateEventFragment.this.getActivity(), AddTicketsActivity.class);
                startActivity(intent);
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateEventFragment.this.getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
