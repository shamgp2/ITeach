package com.example.tcc.iteach;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class notifications2 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private DatabaseReference databaseReference;

    ListView listView;
    ListView listView2;
    ListView listView3;

    List<Message> list;
    List<MessageCancel> list2;
    List<MessageEdit> list3;

    NotificationCancelAdapter myAdapter2;
    NotificationEditAdapter myAdapter3;

    NotificationAdapter myAdapter;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications2);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        firebaseAuth = FirebaseAuth.getInstance();
        listView2=(ListView) findViewById( R.id.list2 );
        listView3=(ListView) findViewById( R.id.list3 );

        listView=(ListView) findViewById( R.id.list1 );
        list = new ArrayList<>();
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference( "messages" );
        databaseReference.addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snap : dataSnapshot.getChildren()) {

                    Message message = snap.getValue( Message.class );
                    list.add( message );

                }



                myAdapter = new NotificationAdapter( notifications2.this, R.layout.notificationitems, list );
                listView.setAdapter( myAdapter );
                Utility.setListViewHeightBasedOnChildren( listView );



            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        } );


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(notifications2.this,ViewInstructorProfile.class);
                intent.putExtra("email",list.get(position).getEmail());
                intent.putExtra("insId",list.get(position).getInsID());

                intent.putExtra( "person","student" );
                Bundle args = new Bundle();
                String test = SignUpInstructorActivity.decryptIt( list.get(position).getLocation());
                Double lat = Double.valueOf( test.substring( test.indexOf( "(" ) + 1, test.indexOf( "," ) ) );
                Double lng = Double.valueOf( test.substring( test.indexOf( "," ) + 1, test.indexOf( ")" ) ) );
                LatLng t = new LatLng( lat, lng );
                args.putParcelable("location",t);
                intent.putExtra("bundle", args);
                startActivity(intent);
            }
        });

        databaseReference = FirebaseDatabase.getInstance().getReference( "messagesCancel" );
        databaseReference.addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snap : dataSnapshot.getChildren()) {

                    MessageCancel message = snap.getValue( MessageCancel.class );
                    if(message.getUserID().equals( firebaseAuth.getUid() ))

                        list2.add( message );

                }



                myAdapter2 = new NotificationCancelAdapter( notifications2.this, R.layout.lessonsitems, list2 );
                listView2.setAdapter( myAdapter2 );
                Utility.setListViewHeightBasedOnChildren( listView2 );



            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        } );


        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(notifications2.this,reservations2.class);

                startActivity(intent);
            }
        });


        databaseReference = FirebaseDatabase.getInstance().getReference( "messagesEdit" );
        databaseReference.addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snap : dataSnapshot.getChildren()) {

                    MessageEdit message = snap.getValue( MessageEdit.class );
                    if(message.getUserID().equals( firebaseAuth.getUid() ))

                        list3.add( message );

                }



                myAdapter3 = new NotificationEditAdapter( notifications2.this, R.layout.lessonsitems, list3);
                listView3.setAdapter( myAdapter3 );
                Utility.setListViewHeightBasedOnChildren( listView3);



            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        } );


        listView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(notifications2.this,reservations2.class);

                startActivity(intent);
            }
        });




/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.student_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent h= new Intent(notifications2.this,student_main.class);
            startActivity(h);
        } else if (id == R.id.nav_blackboard) {
            Intent h= new Intent(notifications2.this,blackboard2.class);
            startActivity(h);
        } else if (id == R.id.nav_notifications) {
            Intent h= new Intent(notifications2.this,notifications2.class);
            startActivity(h);
        } else if (id == R.id.nav_manage) {
            Intent h= new Intent(notifications2.this,settings2.class);
            startActivity(h);
        } else if (id == R.id.nav_reservations) {
            Intent h= new Intent(notifications2.this,reservations2.class);
            startActivity(h);
        }
        else if (id==R.id.nav_signOut){
            firebaseAuth.signOut();
            Intent b = new Intent(this, MainActivity.class);
            b.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(b);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
