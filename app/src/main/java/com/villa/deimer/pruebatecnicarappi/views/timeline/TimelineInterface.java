package com.villa.deimer.pruebatecnicarappi.views.timeline;

import java.util.List;
import com.villa.deimer.pruebatecnicarappi.model.entities.Item;

public interface TimelineInterface {

    void getDataSuccess(List<Item> items, int page);
    void getDataError(String error);

}
