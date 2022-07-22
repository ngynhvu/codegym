package Exception_Debug.Bai_tap;

public class IllegalTriangleException extends Exception {
    IllegalTriangleException(String s){
        super(s);
    }

    IllegalTriangleException(String message,Throwable throwable, String status){
        super(message,throwable);
    }
}
