package com.yyb.shopping.exception;

import com.sun.istack.internal.logging.Logger;

public class UserException extends Exception {

    private static final long serialVersionUID = 1L;
    
    private static final Logger logger = Logger.getLogger(UserException.class);
    
    public UserException(String errorMsg) {
        
        //logger.error(errorMsg);
        super(errorMsg);
    }

}
