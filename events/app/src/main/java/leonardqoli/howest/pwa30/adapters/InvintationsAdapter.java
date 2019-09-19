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
import leonardqoli.howest.pwa30.models.Invintation;


public class InvintationsAdapter extends RecyclerView.Adapter<InvintationsAdapter.InvintationsViewHolder> {

    private Context myCtx;
    private List<Invintation> invintationList;

    public InvintationsAdapter(Context myCtx, List<Invintation> invintationList) {
        this.myCtx = myCtx;
        this.invintationList = invintationList;
    }

    @NonNull
    @Override
    public InvintationsAdapter.InvintationsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(myCtx).inflate(R.layout.recyclerview_invintations, parent, false );
        return new InvintationsAdapter.InvintationsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InvintationsAdapter.InvintationsViewHolder holder, int position) {
        Invintation invintation = invintationList.get(position);

        holder.textViewInvintationId.setText(String.valueOf("INVINTATION ID: " + invintation.getInvintation_id()));
        holder.textViewUserId.setText(String.valueOf("USER ID: " + invintation.getUser_id()));
        holder.textViewGuestName.setText(invintation.getGuestName());
        holder.textViewGuestNumber.setText(invintation.getGuestNumber());
        holder.textViewGuestEmail.setText(invintation.getGuestEmail());
        holder.textViewGuestMessage.setText(invintation.getGuestMessage());
    }

    @Override
    public int getItemCount() {
        return invintationList.size();
    }

    class InvintationsViewHolder extends RecyclerView.ViewHolder{

        TextView textViewInvintationId, textViewUserId, textViewGuestName, textViewGuestNumber, textViewGuestEmail, textViewGuestMessage;

        public InvintationsViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewInvintationId = itemView.findViewById(R.id.textViewInvintationId);
            textViewUserId = itemView.findViewById(R.id.textViewUserId);
            textViewGuestName = itemView.findViewById(R.id.textViewGuestName);
            textViewGuestNumber = itemView.findViewById(R.id.textViewGuestNumber);
            textViewGuestEmail = itemView.findViewById(R.id.textViewGuestEmail);
            textViewGuestMessage = itemView.findViewById(R.id.textViewGuestMessage);


        }
    }
}
