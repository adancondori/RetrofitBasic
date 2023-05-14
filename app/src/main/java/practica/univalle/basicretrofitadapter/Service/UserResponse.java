package practica.univalle.basicretrofitadapter.Service;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import practica.univalle.basicretrofitadapter.Models.User;


public class UserResponse {
    @SerializedName("page")
    public int page=0;
    @SerializedName("per_page")
    public int per_page=0;
    @SerializedName("total")
    public int total=0;
    @SerializedName("total_pages")
    public int total_pages=0;
    @SerializedName("data")
    public List<User> data= new ArrayList();

    public List<User> getUser() {
        return data;
    }
}
