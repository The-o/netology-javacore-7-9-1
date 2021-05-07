package ru.netology.pyas.fact;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Fact {

    private String id;
    private int version;
    private String user;
    private String text;

    private boolean deleted;
    private String source;
    private String type;
    private FactStatus status;

    public Fact(
        @JsonProperty("_id") String id,
        @JsonProperty("__v") int version,
        @JsonProperty("user") String user,
        @JsonProperty("text") String text,
        @JsonProperty("deleted") boolean deleted,
        @JsonProperty("source") String source,
        @JsonProperty("type") String type,
        @JsonProperty("status") FactStatus status
    ) {
        this.id = id;
        this.version = version;
        this.user = user;
        this.text = text;
        this.deleted = deleted;
        this.source = source;
        this.type = type;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Fact [deleted=" + deleted + ", id=" + id + ", source=" + source + ", status=" + status + ", text="
                + text + ", type=" + type + ", user=" + user + ", version=" + version + "]";
    }

    public String getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public String getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public String getSource() {
        return source;
    }

    public String getType() {
        return type;
    }

    public FactStatus getStatus() {
        return status;
    }

}
