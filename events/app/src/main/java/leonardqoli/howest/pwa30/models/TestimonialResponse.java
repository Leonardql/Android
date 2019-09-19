package leonardqoli.howest.pwa30.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TestimonialResponse {

    @SerializedName("error")
    private boolean err;

    private List<Testimonial> testimonials;

    public TestimonialResponse(boolean err, List<Testimonial> testimonials) {
        this.err = err;
        this.testimonials = testimonials;
    }

    public boolean isErr() {
        return err;
    }

    public List<Testimonial> getTestimonials() {
        return testimonials;
    }
}
