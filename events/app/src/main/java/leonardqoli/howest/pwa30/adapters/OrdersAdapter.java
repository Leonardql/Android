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
import leonardqoli.howest.pwa30.models.Order;
import leonardqoli.howest.pwa30.models.User;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.OrdersViewHolder> {

    private Context myCtx;
    private List<Order> orderList;

    public OrdersAdapter(Context myCtx, List<Order> orderList) {
        this.myCtx = myCtx;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public OrdersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(myCtx).inflate(R.layout.recyclerview_orders, parent, false );
        return new OrdersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrdersViewHolder holder, int position) {
        Order order = orderList.get(position);

        holder.textViewOrderId.setText(String.valueOf("OrderId: " + order.getOrder_id()));
        holder.textViewFirstName.setText(order.getFirstName());
        holder.textViewLastName.setText(order.getLastName());
        holder.textViewTicket_id_1.setText(String.valueOf("Ticket ID: " + order.getTicket_id_1()));
        holder.textViewTicket_id_1_quantity.setText(String.valueOf("Quantity: " +  order.getTicket_id_1_quantity()));
        holder.textViewTicket_id_2.setText(String.valueOf("Ticket ID: " + order.getTicket_id_2()));
        holder.textViewTicket_id_2_quantity.setText(String.valueOf("Quantity: " + order.getTicket_id_2_quantity()));
        holder.textViewTicket_id_3.setText(String.valueOf("Ticket ID: " + order.getTicket_id_3()));
        holder.textViewTicket_id_3_quantity.setText(String.valueOf("Quantity: " + order.getTicket_id_3_quantity()));
        holder.textViewTotalOrder.setText(String.valueOf("Total Order: " +order.getTotalOrder() + " DOLLAR"));
        holder.textViewCreated_at.setText(order.getCreated_at());

    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    class OrdersViewHolder extends RecyclerView.ViewHolder{

        TextView textViewOrderId, textViewFirstName, textViewLastName, textViewTicket_id_1, textViewTicket_id_1_quantity, textViewTicket_id_2, textViewTicket_id_2_quantity, textViewTicket_id_3, textViewTicket_id_3_quantity,textViewTotalOrder, textViewCreated_at;

        public OrdersViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewOrderId = itemView.findViewById(R.id.textViewOrderId);
            textViewFirstName = itemView.findViewById(R.id.textViewFirstName);
            textViewLastName = itemView.findViewById(R.id.textViewLastName);

            textViewTicket_id_1 = itemView.findViewById(R.id.textViewTicket_id_1);
            textViewTicket_id_1_quantity = itemView.findViewById(R.id.textViewTicket_id_1_quantity);
            textViewTicket_id_2 = itemView.findViewById(R.id.textViewTicket_id_2);
            textViewTicket_id_2_quantity = itemView.findViewById(R.id.textViewTicket_id_2_quantity);
            textViewTicket_id_3 = itemView.findViewById(R.id.textViewTicket_id_3);
            textViewTicket_id_3_quantity = itemView.findViewById(R.id.textViewTicket_id_3_quantity);
            textViewTotalOrder = itemView.findViewById(R.id.textViewTotalOrder);
            textViewCreated_at = itemView.findViewById(R.id.textViewCreated_at);

        }
    }
}
