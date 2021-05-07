package ru.netology.pyas.fact;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FactStatus {

    private boolean verified;
    private String feedback;
    private int sentCount;

    public FactStatus(
        @JsonProperty("verified") boolean verified,
        @JsonProperty("feedback") String feedback,
        @JsonProperty("sentCount") int sentCount
    ) {
        this.verified = verified;
        this.feedback = feedback;
        this.sentCount = sentCount;
    }

    public boolean isVerified() {
        return verified;
    }

    public String getFeedback() {
        return feedback;
    }

    public int getSentCount() {
        return sentCount;
    }

    @Override
    public String toString() {
        return "FactStatus [feedback=" + feedback + ", sentCount=" + sentCount + ", verified=" + verified + "]";
    }

}