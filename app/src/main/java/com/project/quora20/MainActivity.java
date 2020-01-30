package com.project.quora20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;
import com.project.quora20.adapter.HomeAdapter;
import com.project.quora20.entity.Question;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, HomeAdapter.QuestionCommunication {
    private Toolbar toolbar;
    private SharedPreferences sharedPreferences;
    private SearchView searchView;
    private TextView userName;
    private TextView userEmail;
    private TextView userLevel;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Button newPostToolbar;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager homeLayoutManager;
    HomeAdapter.QuestionCommunication questionCommunication;
    List<Question> questionList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView=findViewById(R.id.homeRecyclerView);
        homeLayoutManager=new LinearLayoutManager(this);

        recyclerView.setLayoutManager(homeLayoutManager);
        recyclerView.setHasFixedSize(true);
        adapter=new HomeAdapter(questionList,questionCommunication);//to be modified...
        recyclerView.setAdapter(adapter);


        toolbar=findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);

        sharedPreferences=getSharedPreferences("LoginData",MODE_PRIVATE);
        String userSP=sharedPreferences.getString("User","");
        String emailSP=sharedPreferences.getString("Email","");
        String levelSP=sharedPreferences.getString("Level","");
        View headerView = navigationView.getHeaderView(0);
        String userId=sharedPreferences.getString("UserId","");
        System.out.println(userId+"MAIN ACTIVITY GUEST USERID");
        userName = (TextView) headerView.findViewById(R.id.userName);
        userName.setText(userSP);
        userEmail=(TextView)headerView.findViewById(R.id.userEmail);
        userEmail.setText(emailSP);
        userLevel=(TextView)headerView.findViewById(R.id.level);
        userLevel.setText(levelSP);


        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar, R.string.openNav,
                R.string.closeNav
        );

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        getSupportActionBar().setTitle("Quora 2.0");
        toolbar.setSubtitle("Ask to know!");
//        toolbar.setLogo(R.drawable.ic_directions_run_black_24dp);

        newPostToolbar = (Button)findViewById(R.id.newPostToolbar);
        newPostToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newPostIntent=new Intent(getApplicationContext(), NewPost.class);
                startActivity(newPostIntent);
            }
        });

        searchView=findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(getApplicationContext(),query.toString(),Toast.LENGTH_SHORT).show();
//                Intent searchIntent=new Intent(MainActivity.this,SearchResults.class);
//                searchIntent.putExtra("searchKey",query);
//                startActivity(searchIntent);
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }
    @Override
    public void onClick(Question question) {
//        Intent productIntent=new Intent( MainActivity.this, ProductDetails.class);
//        productIntent.putExtra("Image", product.getImageUrl());
//        productIntent.putExtra("ProductName",product.getName());
//        productIntent.putExtra(("ProductDescription"),product.getDescription());
//        productIntent.putExtra(("ColorAttribute"),product.getProductAttributes().getColor());
//        productIntent.putExtra(("SizeAttribute"),product.getProductAttributes().getSize());
//        productIntent.putExtra(("MaterialAttribute"),product.getProductAttributes().getMaterial());
//        productIntent.putExtra(("PID"),product.getProductId());
//        startActivity(productIntent);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        Toast.makeText(this, "this menu item clicked", Toast.LENGTH_SHORT).show();
        switch(item.getItemId()) {
            case R.id.sports_nav_menu:
                Intent catIntent1 = new Intent(this, QuestionAnswer.class);
                catIntent1.putExtra("categoryId",2);
                this.startActivity(catIntent1);
                break;
            case R.id.technology_nav_menu:
//                Intent catIntent2= new Intent(this,CategoryProducts.class);
//                catIntent2.putExtra("categoryId",3);
//                this.startActivity(catIntent2);
                break;
            case R.id.lifestyle_nav_menu:
//                Intent catIntent3= new Intent(this,CategoryProducts.class);
//                catIntent3.putExtra("categoryId",4);
//                this.startActivity(catIntent3);
                break;
            case R.id.food_nav_menu:
//                Intent catIntent4= new Intent(this,CategoryProducts.class);
//                catIntent4.putExtra("categoryId",5);
//                this.startActivity(catIntent4);
                break;
            case R.id.movies_nav_menu:
//                Intent catIntent5= new Intent(this,CategoryProducts.class);
//                catIntent5.putExtra("categoryId",1);
//                this.startActivity(catIntent5);
                break;
            case R.id.logout:
//                sharedPreferences=getSharedPreferences("LoginData",MODE_PRIVATE);
//                String logincheckLogout=sharedPreferences.getString("LoginCheck","false");
//                if(logincheckLogout.equals("true")) {
//                    SharedPreferences preferences = getSharedPreferences("LoginData", MODE_PRIVATE);
//                    SharedPreferences.Editor editor = preferences.edit();
//                    editor.clear();
//                    editor.commit();
//                    Intent logoutIntent = new Intent(MainActivity.this, Login.class);
//                    startActivity(logoutIntent);
//                }
//                else{
//                    Toast.makeText(getApplicationContext(),"LoginFirst",Toast.LENGTH_SHORT).show();
//                }
                break;
            case R.id.details_nav_menu:
                sharedPreferences=getSharedPreferences("LoginData",MODE_PRIVATE);
                Intent intent=new Intent(this,MyProfile.class);
                startActivity(intent);
//                String logincheck=sharedPreferences.getString("LoginCheck","false");
//                if(logincheck.equals("true")) {
//                    Intent userDetails = new Intent(MainActivity.this, UserDetails.class);
//                    startActivity(userDetails);
//                }
//                else {
//                    Toast.makeText(getApplicationContext(),"LoginFirst",Toast.LENGTH_SHORT).show();
//                }
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
    }

}
