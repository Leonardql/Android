package leonardqoli.howest.pwa30.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import leonardqoli.howest.pwa30.R;
import leonardqoli.howest.pwa30.models.Artist;
import leonardqoli.howest.pwa30.models.Guest;

public class GuestsAdapter extends RecyclerView.Adapter<GuestsAdapter.GuestsViewHolder> {

    private Context myCtx;
    private List<Guest> guestList;

    public GuestsAdapter(Context myCtx, List<Guest> guestList) {
        this.myCtx = myCtx;
        this.guestList = guestList;
    }

    @NonNull
    @Override
    public GuestsAdapter.GuestsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(myCtx).inflate(R.layout.recyclerview_guests, parent, false );
        return new GuestsAdapter.GuestsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GuestsAdapter.GuestsViewHolder holder, int position) {
        Guest guest = guestList.get(position);

        holder.textViewGuestId.setText(String.valueOf("GuestID: " + guest.getGuest_id()));
        holder.textViewFirstName.setText(guest.getFirstName());
        holder.textViewLastName.setText(guest.getLastName());
        holder.textViewRole.setText(guest.getRole());
    }

    @Override
    public int getItemCount() {
        return guestList.size();
    }

    class GuestsViewHolder extends RecyclerView.ViewHolder{

        TextView textViewGuestId, textViewFirstName, textViewLastName, textViewRole;

        public GuestsViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewGuestId = itemView.findViewById(R.id.textViewGuestId);
            textViewFirstName = itemView.findViewById(R.id.textViewFirstName);
            textViewLastName = itemView.findViewById(R.id.textViewLastName);
            textViewRole = itemView.findViewById(R.id.textViewRole);
         }
    }
}
