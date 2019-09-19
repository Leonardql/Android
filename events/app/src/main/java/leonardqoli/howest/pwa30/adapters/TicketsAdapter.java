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
import leonardqoli.howest.pwa30.models.Ticket;


public class TicketsAdapter extends RecyclerView.Adapter<TicketsAdapter.TicketsViewHolder> {

    private Context myCtx;
    private List<Ticket> ticketList;

    public TicketsAdapter(Context myCtx, List<Ticket> ticketList) {
        this.myCtx = myCtx;
        this.ticketList = ticketList;
    }

    @NonNull
    @Override
    public TicketsAdapter.TicketsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(myCtx).inflate(R.layout.recyclerview_tickets, parent, false );
        return new TicketsAdapter.TicketsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TicketsAdapter.TicketsViewHolder holder, int position) {
        Ticket ticket = ticketList.get(position);

        holder.textViewTicketId.setText(String.valueOf("TicketID: " + ticket.getTicket_id()));
        holder.textViewTitle.setText(ticket.getTitle());
        holder.textViewPrice.setText(String.valueOf("Price: " + ticket.getPrice()));
        holder.textViewPersonsAllowed.setText(String.valueOf("Persons allowed: " + ticket.getPersons_allowed()));
        holder.textViewHourLimitation.setText(String.valueOf("Hour limitation: " + ticket.getHour_limitation()));
    }

    @Override
    public int getItemCount() {
        return ticketList.size();
    }

    class TicketsViewHolder extends RecyclerView.ViewHolder{

        TextView textViewTicketId, textViewTitle, textViewPrice, textViewPersonsAllowed, textViewHourLimitation;

        public TicketsViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTicketId = itemView.findViewById(R.id.textViewTicketId);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            textViewPersonsAllowed = itemView.findViewById(R.id.textViewPersonsAllowed);
            textViewHourLimitation = itemView.findViewById(R.id.textViewHourLimitation);


        }
    }
}
