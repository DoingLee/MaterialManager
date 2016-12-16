package utils;

/**
 * Created by Doing on 2016/12/16 0016.
 */
public class Result<T> {
    private boolean success;
    private T data;

    public Result(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.success = isSuccess;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
