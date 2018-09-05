package com.villa.deimer.pruebatecnicarappi.views.video;

import com.villa.deimer.pruebatecnicarappi.model.entities.Video;
import java.util.List;

public interface VideoInterface {

    void getDataSuccess(List<Video> videos);
    void getDataError(String error);

}
