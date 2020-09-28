package com.platform.services.metadata;

import org.hibernate.validator.constraints.Length;

public class PlatformUser {
    @Length(min = 1, max = 3)
    private String title = "";

    @Length(min = 0, max = 200)
    private String instructions = "";

    public PlatformUser() {
    }

    public PlatformUser(String title,
                    String instructions) {

        this.instructions = instructions;
        this.title = title;
    }


    public String getInstructions() {
        return instructions;
    }

    public void setinstructions(String instructions) {
        this.instructions = instructions;
    }

    public void settitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return this.title;
    }


    // event_date, source, trip_type, pickup_time, pickup_location, pickup_dropoff
    public String toString() {
        return "{\"id\"=\"" + getTitle() + "\", " +
                "\"no_of_vehicles\"=\"" + this.getInstructions()+ "\"" +
                "}";
    }

}
