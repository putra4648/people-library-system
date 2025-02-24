package id.putra.peoplelibrarysystem.response;

public class AppGeneralResponse {
    private Boolean error;
    private String message;

    public AppGeneralResponse(Boolean error, String message) {
        this.error = error;
        this.message = message;
    }

    public Boolean getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
