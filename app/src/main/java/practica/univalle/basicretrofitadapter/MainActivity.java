package practica.univalle.basicretrofitadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import practica.univalle.basicretrofitadapter.Adapters.UserAdapter;
import practica.univalle.basicretrofitadapter.Models.User;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<User> userList;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAdapter();
    }

    public void initAdapter(){
        userList = new ArrayList<>();
        initUsers();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        userAdapter = new UserAdapter(this,userList);
        recyclerView.setAdapter(userAdapter);
    }
    public void initUsers(){
        userList.add(new User(1,"matatan@gmail.com","Andres","Pereira","https://reqres.in/img/faces/1-image.jpg"));
        userList.add(new User(2,"matatan1@gmail.com","Pero","Pereira","https://reqres.in/img/faces/3-image.jpg"));
        userList.add(new User(3,"matatan2@gmail.com","marco","Pereira","https://reqres.in/img/faces/5-image.jpg"));
        userList.add(new User(4,"matatan3@gmail.com","Juanes","Pereira","https://reqres.in/img/faces/6-image.jpg"));
        userList.add(new User(5,"matatan4@gmail.com","Terry","Pereira","https://reqres.in/img/faces/7-image.jpg"));
        userList.add(new User(6,"matatan5@gmail.com","Valdomero","Pereira","https://reqres.in/img/faces/4-image.jpg"));
        userList.add(new User(7,"matatan6@gmail.com","Juan","Pereira","https://reqres.in/img/faces/4-image.jpg"));
        userList.add(new User(8,"matatan7@gmail.com","Jhon","Pereira","https://reqres.in/img/faces/4-image.jpg"));
        userList.add(new User(9,"matatan@gmail.com","Andres","Pereira","https://reqres.in/img/faces/4-image.jpg"));


    }
}