package com.villa.deimer.pruebatecnicarappi.views.details;

import com.villa.deimer.pruebatecnicarappi.model.entities.Detail;

public interface DetailInterface {

    void getDataSuccess(Detail detail);
    void getDataError(String error);

}
