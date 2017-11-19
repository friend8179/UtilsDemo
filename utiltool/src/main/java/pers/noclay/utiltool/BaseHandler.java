package pers.noclay.utiltool;

import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 * Created by NoClay on 2017/11/19.
 */

public class BaseHandler<T extends BaseHandler.BaseHandlerCallBack> extends Handler{
    WeakReference<T> mWeakReference;

    public BaseHandler(T callBack) {
        mWeakReference = new WeakReference<T>(callBack);
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        T callBack = mWeakReference.get();
        if (callBack != null){
            callBack.callBack(msg);
        }
    }

    public interface BaseHandlerCallBack {
        public void callBack(Message msg);
    }


    public void onDestory(){
        this.removeCallbacksAndMessages(null);
    }

}
