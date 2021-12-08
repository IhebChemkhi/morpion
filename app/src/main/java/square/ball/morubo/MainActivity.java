package square.ball.morubo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private int nbJoueur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void modifier(View view){
        /*FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("message");
        ref.setValue("Bonjour tout le monde");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.i("TAG", dataSnapshot.getValue(String.class));
                TextView text = findViewById(R.id.textView);
                text.setText(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/

        EditText numero = findViewById(R.id.Numero);
        EditText nom = findViewById(R.id.Nom);
        EditText prenom = findViewById(R.id.Prenom);

        String numeroValue=numero.getText().toString();
        String nomValue=nom.getText().toString();
        String prenomValue=prenom.getText().toString();

        if (!(numeroValue.isEmpty() && nomValue.isEmpty() && prenomValue.isEmpty())) {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference("/");

            ref.child("joueurs").child(String.valueOf(nbJoueur)).child("numTelephone").setValue(numeroValue);
            ref.child("joueurs").child(String.valueOf(nbJoueur)).child("nom").setValue(nomValue);
            ref.child("joueurs").child(String.valueOf(nbJoueur)).child("prenom").setValue(prenomValue);
            nbJoueur++;
        }
        else{
            Toast toast = Toast.makeText(this, "Veuillez saisir tout les champs", Toast.LENGTH_LONG);
        }

    }

}