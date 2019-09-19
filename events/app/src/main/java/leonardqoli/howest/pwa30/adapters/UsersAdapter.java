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
import leonardqoli.howest.pwa30.models.User;


public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {

    private Context myCtx;
    private List<User> userList;

    public UsersAdapter(Context myCtx, List<User> userList) {
        this.myCtx = myCtx;
        this.userList = userList;
    }

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(myCtx).inflate(R.layout.recyclerview_users, parent, false );
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        User user = userList.get(position);

        holder.textViewName.setText(user.getUserName());
        holder.textViewEmail.setText(user.getEmail());
        holder.textViewCreated_at.setText(user.getCreated_at());
    }

    @Override
    public int getItemCount()
    {
        return userList.size();
    }

    class UsersViewHolder extends RecyclerView.ViewHolder{

        TextView textViewName, textViewEmail, textViewCreated_at;

      UsersViewHolder(@NonNull View itemView) {
         super(itemView);

         textViewName = itemView.findViewById(R.id.textViewName);
         textViewEmail = itemView.findViewById(R.id.textViewEmail);
         textViewCreated_at = itemView.findViewById(R.id.textViewCreated_at);
     }
 }}
