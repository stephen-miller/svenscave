package org.webservice.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Sven on 10/2/2016.
 */
public class RetrieveAddress {

    @NotNull
    @Size(min=1, max=10)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
