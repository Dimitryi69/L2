package com.example.l2.Exception;

public class EduException extends Exception {
    public EduException(Throwable e)
    {
        initCause(e);
    }
}
