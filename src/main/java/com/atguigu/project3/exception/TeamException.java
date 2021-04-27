package com.atguigu.project3.exception;

/**
 * TeamException class
 *
 * @author jiazhikai
 * @date 2021/4/26
 */
public class TeamException extends Exception {
    static final long serialVersionUID = -3387514229948L;
    public TeamException(){
        super();
    }
    public TeamException(String message){
        super(message);
    }
}
