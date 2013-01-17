/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gecel.exception;

/**
 *
 * @author Ivanildo
 */
public class CreateDAOException extends Exception{

    public CreateDAOException() {
    }

    public CreateDAOException(String message) {
        super(message);
    }

    public CreateDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreateDAOException(Throwable cause) {
        super(cause);
    }
    
    
}
