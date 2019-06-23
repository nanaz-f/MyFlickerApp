package com.example.flicker.Presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.flicker.BaseView;
import com.example.flicker.Model.response;
import com.example.flicker.Network.APIClient;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Presenter {

    //public static final String APIKey = "898380df8abce6aedbc90b738b5e382a" ;
    public BaseView view;
    public Context context;

    public Presenter(Context context, BaseView view) {
        this.context = context;
        this.view = view;
    }

    public void downloadImage(){

        APIClient.getRetrofit()
                .loadPhotos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<response>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(response photosResponse) {
                        if(photosResponse.photos.getPhoto() != null){
                            view.updateUI(photosResponse.photos.getPhoto());
                        }else{
                            Toast.makeText(context," An Error Occured :( ", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(context," An Error Occured :( ", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
