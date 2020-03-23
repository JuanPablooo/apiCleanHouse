package br.com.cleanhouse.error;

public class ResourceNotFoundDetails {
    private String title;
    private int status;
    private long timestamp;
    private String developerMessage;
    private String causa;


    public ResourceNotFoundDetails() {
    }

    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public String getCausa() {
        return causa;
    }

    public static final class Builder {
        private String title;
        private int status;
        private long timestamp;
        private String developerMessage;
        private String causa;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }
        public Builder causa(String causa) {
            this.causa = causa;
            return this;
        }

        public ResourceNotFoundDetails build() {
            ResourceNotFoundDetails resourceNotFoundDetails = new ResourceNotFoundDetails();
            resourceNotFoundDetails.developerMessage = this.developerMessage;
            resourceNotFoundDetails.timestamp = this.timestamp;
            resourceNotFoundDetails.status = this.status;
            resourceNotFoundDetails.title = this.title;
            resourceNotFoundDetails.causa = this.causa;
            return resourceNotFoundDetails;
        }
    }
}
