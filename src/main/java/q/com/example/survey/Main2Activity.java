package q.com.example.survey;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main2Activity extends AppCompatActivity {
    EditText edittext;
    Button savebtn;
    TextView textview;
      FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference databaseAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        databaseAnswers= database.getReference("appli");

        textview=findViewById(R.id.ques1);
        edittext=findViewById(R.id.edittext);
        savebtn=findViewById(R.id.savebtn);

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("bhani","worked 1");
                addAnswer();
            }
        });}

   public void addAnswer(){
       String question= textview.getText().toString();
       String ans=savebtn.getText().toString();
       String text=edittext.getText().toString().trim();
       Log.d("bhani","worked 2");


       if(!TextUtils.isEmpty(text)) {
           String id=databaseAnswers.push().getKey();
           Answer answer=new Answer(id,question,text);
           databaseAnswers= database.getReference();
           Log.d("bhani","worked 3");

           databaseAnswers.child("appli").child(id).setValue(answer).addOnSuccessListener(new OnSuccessListener<Void>() {
               @Override
               public void onSuccess(Void aVoid) {
                   Log.d("bhani","worked 4");

               }
           }).addOnFailureListener(new OnFailureListener() {
               @Override
               public void onFailure(@NonNull Exception e) {
                   Log.d("bhani","worked 5"+e.toString());


               }
           });
       }
       else{
           Toast.makeText(this, "enter please", Toast.LENGTH_SHORT).show();
       }

    }
}
