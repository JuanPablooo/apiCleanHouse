package br.com.cleanhouse.uploads;

public class FileUpload {
    private String mimeType;
    private String base64;

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    @Override
    public String toString() {
        return "FileUpload{" +
                ", mimeType='" + mimeType + '\'' +
                ", base64='" + base64 + '\'' +
                '}';
    }
}
