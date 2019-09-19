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


public class ArtistsAdapter extends RecyclerView.Adapter<ArtistsAdapter.ArtistsViewHolder> {

    private Context myCtx;
    private List<Artist> artistList;

    public ArtistsAdapter(Context myCtx, List<Artist> artistList) {
        this.myCtx = myCtx;
        this.artistList = artistList;
    }

    @NonNull
    @Override
    public ArtistsAdapter.ArtistsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(myCtx).inflate(R.layout.recyclerview_artists, parent, false );
        return new ArtistsAdapter.ArtistsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistsAdapter.ArtistsViewHolder holder, int position) {
        Artist artist = artistList.get(position);

        holder.textViewArtistId.setText(String.valueOf("ArtistID: " + artist.getArtist_id()));
        holder.textViewFirstName.setText(artist.getFirstName());
        holder.textViewLastName.setText(artist.getLastName());
        holder.textViewRole.setText(artist.getRole());
        holder.textViewMotto.setText(artist.getMotto());
    }

    @Override
    public int getItemCount() {
        return artistList.size();
    }

    class ArtistsViewHolder extends RecyclerView.ViewHolder{

        TextView textViewArtistId, textViewFirstName, textViewLastName, textViewRole, textViewMotto;

        public ArtistsViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewArtistId = itemView.findViewById(R.id.textViewArtistId);
            textViewFirstName = itemView.findViewById(R.id.textViewFirstName);
            textViewLastName = itemView.findViewById(R.id.textViewLastName);
            textViewRole = itemView.findViewById(R.id.textViewRole);
            textViewMotto = itemView.findViewById(R.id.textViewMotto);


        }
    }
}
