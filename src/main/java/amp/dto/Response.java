package amp.dto;

import com.google.gson.annotations.Expose;

import java.util.Date;

public class Response<T> {

    private Date timestamp = new Date();
    private int status;
    private String error;
    @Expose
    private T message;
    private String path;

    public Response<T> build() {
        Response<T> response = new Response<>();
        response.setStatus(200);
        response.setError("OK");
        return response;
    }


    public int getStatus() {
        return status;
    }

    public Response<T> setStatus(int status) {
        this.status = status;
        return this;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public Response<T> setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getError() {
        return error;
    }

    public Response<T> setError(String error) {
        this.error = error;
        return this;
    }

    public T getMessage() {
        return message;
    }

    public Response<T> setMessage(T message) {
        this.message = message;
        return this;
    }

    public String getPath() {
        return path;
    }

    public Response<T> setPath(String path) {
        this.path = path;
        return this;
    }

    @Override
    public String toString() {
        return "Response{" +
                "timestamp=" + timestamp +
                ", status=" + status +
                ", error='" + error + '\'' +
                ", message=" + message.toString() +
                ", path='" + path + '\'' +
                '}';
    }
}
