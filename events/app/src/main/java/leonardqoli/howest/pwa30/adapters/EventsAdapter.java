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
import leonardqoli.howest.pwa30.models.Event;


public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventsViewHolder> {

    private Context myCtx;
    private List<Event> eventList;

    public EventsAdapter(Context myCtx, List<Event> eventList) {
        this.myCtx = myCtx;
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public EventsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(myCtx).inflate(R.layout.recyclerview_events, parent, false );
        return new EventsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsAdapter.EventsViewHolder holder, int position) {
        Event event = eventList.get(position);

        holder.textViewEventId.setText(String.valueOf("Event ID: " +event.getEvent_id()));
        holder.textViewDate.setText(event.getDate());
        holder.textViewEventTitle.setText(event.getTitle());
        holder.textViewInfo.setText(event.getInfo());
        holder.textViewCreated_at.setText(event.getCreated_at());
    }

    @Override
    public int getItemCount()
    {
        return eventList.size();
    }

    class EventsViewHolder extends RecyclerView.ViewHolder {

        TextView textViewEventId, textViewDate, textViewEventTitle, textViewInfo, textViewCreated_at;

        EventsViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewEventId = itemView.findViewById((R.id.textViewEventId));
            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewEventTitle = itemView.findViewById(R.id.textViewEventTitle);
            textViewInfo = itemView.findViewById(R.id.textViewInfo);
            textViewCreated_at = itemView.findViewById(R.id.textViewCreated_at);
        }
    }
}
