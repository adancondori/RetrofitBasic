package practica.univalle.basicretrofitadapter.Example3;

import practica.univalle.basicretrofitadapter.Example2.CustomBroadcastReceiver;

public class Singleton {
    private static Singleton instance;
    private BroadCastReceiver receiver;
    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void setDynamicReceiver(BroadCastReceiver receiver){
        this.receiver = receiver;
    }
    public BroadCastReceiver getReceiver(){
        return receiver;
    }
}
