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
import leonardqoli.howest.pwa30.models.Testimonial;


public class TestimonialsAdapter extends RecyclerView.Adapter<TestimonialsAdapter.TestimonialViewHolder> {

    private Context myCtx;
    private List<Testimonial> testimonials;

    public TestimonialsAdapter(Context myCtx, List<Testimonial> testimonials) {
        this.myCtx = myCtx;
        this.testimonials = testimonials;
    }

    @NonNull
    @Override
    public TestimonialViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(myCtx).inflate(R.layout.recyclerview_testimonials, parent, false );
        return new TestimonialViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TestimonialViewHolder holder, int position) {
        Testimonial testimonial = testimonials.get(position);

        holder.textViewEventId.setText(String.valueOf("EVENT ID: " + testimonial.getEvent_id()));
        holder.textViewTestimonialId.setText(String.valueOf("EVENT ID: " + testimonial.getTestimonial_id()));
        holder.textViewUserId.setText(String.valueOf("USER ID: " + testimonial.getUser_id()));
        holder.textViewMessage.setText(testimonial.getComment());

    }

    @Override
    public int getItemCount() {
        return testimonials.size();
    }

    class TestimonialViewHolder extends RecyclerView.ViewHolder{

        TextView textViewEventId, textViewTestimonialId, textViewUserId, textViewMessage;

        public TestimonialViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewEventId = itemView.findViewById(R.id.textViewEventId);
            textViewTestimonialId = itemView.findViewById(R.id.textViewTestimonialId);
            textViewUserId = itemView.findViewById(R.id.textViewUserId);
            textViewMessage = itemView.findViewById(R.id.textViewMessage);


        }
    }
}
