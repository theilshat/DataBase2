package de.uni_s.ipvs.mcl.assignment5;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

//import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("/teams/14/");
        DatabaseReference postsRef = ref.child("posts3");
        DatabaseReference newPostRef = postsRef.push();
        newPostRef.setValue(new Post("ilsh1", "Experiment1"));
        String postId = newPostRef.getKey();
        Log.d("key: ", String.valueOf(postId));*/

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("teams/14/posts3");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Post post = dataSnapshot.getValue(Post.class);
                Log.d("post: ", String.valueOf(post));
            }

            public void onCancelled(DatabaseError databaseError) {
                //System.out.println("The read failed: " + databaseError.getCode());
                Log.e("The read failed: ", String.valueOf(databaseError.getCode()));
            }
        });


    }
}
