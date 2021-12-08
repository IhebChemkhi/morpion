package square.ball.morubo;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void creer_compte(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void jouer(View view) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("joueurs");
        EditText editNumTel = findViewById(R.id.phone);
        String editNumTelVal = editNumTel.getText().toString();
        if (!editNumTelVal.isEmpty()) {
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot data : dataSnapshot.getChildren()) {
                        UserInformation user = new UserInformation();
                        String valNumTel = data.getValue(UserInformation.class).getNumTelephone();
                        if (editNumTelVal==valNumTel)
                           Log.i("TAG","hihi"+editNumTelVal+"  /  "+ valNumTel);
                        else
                            Log.i("TAG1",""+editNumTelVal+"/"+valNumTel);

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Log.i("TAG", "error");
                }
            });
        }
        else{
            Toast toast = Toast.makeText(this,"veuillez saisir le numero",Toast.LENGTH_LONG);
        }
    }


}
