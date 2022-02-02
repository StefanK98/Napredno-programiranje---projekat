/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;
import transfer.util.ResponseStatus;

/**
 *
 * @author Kujovic
 */
public class Response implements Serializable{
    private Object data;
    private Exception error;
    private ResponseStatus responseStatus;

    public Response() {
    }

    public Response(Object data, Exception error, ResponseStatus responseStatus) {
        this.data = data;
        this.error = error;
        this.responseStatus = responseStatus;
    }

    /**
     * @return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * @return the error
     */
    public Exception getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(Exception error) {
        this.error = error;
    }

    /**
     * @return the responseStatus
     */
    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    /**
     * @param responseStatus the responseStatus to set
     */
    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
    
    
    
}
