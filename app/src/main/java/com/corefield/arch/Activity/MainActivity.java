package com.corefield.arch.Activity;


import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.corefield.arch.DATABASE.DatabaseManager;
import com.corefield.arch.Fragment.AccountFragment;
import com.corefield.arch.Fragment.HomeFragment;
import com.corefield.arch.Fragment.ListFragment;
import com.corefield.arch.Fragment.NotificationFragment;
import com.corefield.arch.R;

public class MainActivity extends AppCompatActivity {

    private DatabaseManager databaseManager;
    private FrameLayout mMainFrameLayout;
    private BottomNavigationView mBottomNavigation;
    // Fragment declaration
    private HomeFragment mHomeFragment = new HomeFragment();
    private NotificationFragment mNotificationFragment = new NotificationFragment();
    private AccountFragment mAccountFragment = new AccountFragment();
    private ListFragment mListFragment = new ListFragment();

    //Toolbar
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("ToolBar");
        setSupportActionBar(toolbar);

        mMainFrameLayout = findViewById(R.id.place_holder);
        mBottomNavigation = findViewById(R.id.main_navitation);


        // fragment passing function

        setFragment(mHomeFragment);

        mBottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {

                    case R.id.navigation_home:

                        setFragment(mHomeFragment);
                        return true;

                    case R.id.navigation_notification:

                        setFragment(mNotificationFragment);
                        return true;

                    case R.id.navigation_account:

                        setFragment(mAccountFragment);
                        return true;
                    case R.id.navigation_list:

                        setFragment(mListFragment);
                        return true;


                    default:
                        return false;

                }


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addlist:
                dailogue();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.place_holder, fragment);
        fragmentTransaction.commit();

    }

    private void dailogue() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_view);
        Button dialogSubmitBtn = dialog.findViewById(R.id.btn_submit);
        final EditText etEnterName = dialog.findViewById(R.id.et_put_name);
        final EditText etEnterMarks = dialog.findViewById(R.id.et_put_mark);
        ImageView imageViewClose = dialog.findViewById(R.id.close_dialog);
        imageViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialogSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name = etEnterName.getText().toString();
                int Marks = Integer.valueOf(etEnterMarks.getText().toString());

                databaseManager = new DatabaseManager(getApplicationContext());
                databaseManager.open();
                databaseManager.insert(Name, Marks);
                databaseManager.close();
               /* Bundle bundle = new Bundle();
                bundle.putString("key", txt);
                // set Fragmentclass Arguments
                ListFragment listFragment = new ListFragment();
                listFragment.setArguments(bundle);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.place_holder, listFragment);
                fragmentTransaction.commit();*/
                Toast.makeText(MainActivity.this, "Successfully Added", Toast.LENGTH_SHORT).show();
              //  dialog.dismiss();
            }
        });
        dialog.show();
    }


}

