package com.example.flicker.Network;

import com.example.flicker.Model.response;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface APIClientInterface {

    @GET("?method=flickr.photos.getRecent&api_key=898380df8abce6aedbc90b738b5e382a&format=json&nojsoncallback=1&extras=url_s")
    Observable<response> loadPhotos();
}
