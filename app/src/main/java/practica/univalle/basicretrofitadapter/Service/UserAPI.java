package practica.univalle.basicretrofitadapter.Service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserAPI {
    @GET("/api/users")
    Call<UserResponse> getAllUser();
    @GET("/api/users")
    Call<UserResponse> getUserPerPage(@Query("page") int page, @Query("per_page") int per_page);


}
