package com.lifetime.databinding_1stdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.lifetime.databinding_1stdemo.databinding.ActivityMainBinding;
import com.lifetime.databinding_1stdemo.model.User;

public class MainActivity extends AppCompatActivity {

    private User user;
    private MyClickHandlers handlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        user = new User();
        user.setName("Other name");
        user.setEmail("othermail");

        binding.setUser(user);
        handlers = new MyClickHandlers(this);
        binding.setHandlers(handlers);
        binding.content.setHandlers(handlers);
    }

    public class MyClickHandlers {

        Context context;

        public MyClickHandlers(Context context){
            this.context = context;
        }

        public void onFabClicked(View view) {
            Toast.makeText(getApplicationContext(), "FAB Clicked", Toast.LENGTH_SHORT).show();
        }

        public void onButtonClick(View view){
            Toast.makeText(getApplicationContext(), "Button Clicked", Toast.LENGTH_SHORT).show();
        }

        public void onButtonClickWithParam(View view, User user ){
            Toast.makeText(getApplicationContext(), "Button Click! Name:"+user.getName(), Toast.LENGTH_SHORT).show();
        }

        public boolean onButtonLongPressed(View view){
            Toast.makeText(getApplicationContext(), "Button long pressed", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
