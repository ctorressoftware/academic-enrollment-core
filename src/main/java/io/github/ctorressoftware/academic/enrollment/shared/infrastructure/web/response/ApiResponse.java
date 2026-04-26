package io.github.ctorressoftware.academic.enrollment.shared.infrastructure.web.response;

public class ApiResponse<T> {
    private final boolean success;
    private final String errorCode;
    private final String errorMessage;
    private final T data;

    private ApiResponse(boolean success, String errorCode, String errorMessage, T data) {
        this.success = success;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.data = data;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(
                true,
                null,
                null,
                data);
    }

    public static <T> ApiResponse<T> error(String errorCode, String errorMessage) {
        return new ApiResponse<>(
                false,
                errorCode,
                errorMessage,
                null);
    }

    public boolean isSuccess() {
        return success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public T getData() {
        return data;
    }
}
