package com.example.ptsgenap10rpl204;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

//Activity ini tidak digunakan
//pada awalnya saya ingin menggunakan ini. dengan urutan : MainActivity.java -> LoginSlide2Activity.java -> DasboardActivity.java
//akan tetapi, pada saat di LoginSlide2Activity.java ketika klik "masuk" malah kembali lagi ke MainActivity.java

public class LoginSlide2Activity extends AppCompatActivity {

    //deklarasi untuk button login dengan email manual
    EditText txtEmailSlide2;
    EditText txtPasswordSlide2;
    Button buttonContinueSlide2;

    //deklarasi untuk button login dengan google
    SignInButton signin;
    int RC_SIGN_IN = 0;
    GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_slide2);

        //Script untuk botton login email manual
        txtEmailSlide2 = (EditText) findViewById(R.id.txtEmailSlide2);
        buttonContinueSlide2 = (Button) findViewById(R.id.buttonContinueSlide2);

        buttonContinueSlide2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email2 = txtEmailSlide2.getText().toString();
                String Password2 = txtPasswordSlide2.getText().toString();

                if (Email2.equalsIgnoreCase("andi")
                    && Password2.equalsIgnoreCase("asd")){

                    Toast.makeText(LoginSlide2Activity.this, "selamat", Toast.LENGTH_SHORT).show();

                    Intent move = new Intent(LoginSlide2Activity.this , DasboardActivity.class);
                    startActivity(move);
                }
                else {
                    Toast.makeText(LoginSlide2Activity.this, "gagal", Toast.LENGTH_SHORT).show();
                }

            }
        });



        //Script untuk button login dengan google
        signin = findViewById(R.id.sign_in_button);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.sign_in_button:
                        signIn();
                        break;
                }
            }
        });

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
    }


    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        //untuk google
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            Toast.makeText(LoginSlide2Activity.this, "Selamat anda berhasil login", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(LoginSlide2Activity.this, DasboardActivity.class);
            startActivity(intent);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("Error", "signInResult:failed code=" + e.getStatusCode());


        }
    }


}