package com.balkhiz.mrng;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.Task;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class LoginScreen2 extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    private ImageButton imageButton;
    private Button signup;
    private ImageButton imageButton2;
    private CallbackManager callbackManager;
    private Button SignIn;
    private GoogleApiClient googleApiClient;
    private static final int RC_SIGN_IN = 007;
    private Button SignOut;
    private static final int REQ_CODE = 9001;

    private EditText editText;
    private EditText editText2;

    private SignInButton mGoogleSignInButton;
    private GoogleApiClient mGoogleApiClient;
    private GoogleSignInClient mGoogleSignInClient;
    private static final String TAG = MainActivityScreen3.class.getSimpleName();
    private boolean mIntentInProgress;
    private boolean mSignInClicked;
    private ConnectionResult mConnectionResult;
    private SignInButton btnSignIn;
    private TextView userName;
    private TextView email;


    Button login;

   // TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        } else {
            getWindow().clearFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        }
        setContentView( R.layout.activity_login_screen );
        addButtonClickListener();

        Typeface myTypeface=Typeface.createFromAsset( getAssets(),"Lato-Bold.ttf" );
        TextView myTextView =(TextView) findViewById( R.id.textView );
        myTextView.setTypeface( myTypeface );

        Typeface myTypeface2=Typeface.createFromAsset( getAssets(),"Lato-Bold.ttf" );
        TextView myTextView2 =(TextView) findViewById( R.id.login );
        myTextView2.setTypeface( myTypeface2 );

        Typeface myTypeface3=Typeface.createFromAsset( getAssets(),"Lato-Light.ttf" );
        TextView myTextView3 =(TextView) findViewById( R.id.textView1 );
        myTextView3.setTypeface( myTypeface3 );

        Typeface myTypeface4=Typeface.createFromAsset( getAssets(),"Lato-Light.ttf" );
        TextView myTextView4 =(TextView) findViewById( R.id.textView2 );
        myTextView4.setTypeface( myTypeface4 );

        Typeface myTypeface5=Typeface.createFromAsset( getAssets(),"Lato-Bold.ttf" );
        TextView myButton5 =(TextView) findViewById( R.id.login );
        myButton5.setTypeface( myTypeface5 );


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder( GoogleSignInOptions.DEFAULT_SIGN_IN )
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder( LoginScreen2.this )
                .addApi( Auth.GOOGLE_SIGN_IN_API, gso )
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient( this, gso );

        imageButton = (ImageButton) findViewById( R.id.image );
        imageButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                facebookLogin();
            }
        } );

        ImageButton imageButton2 = (ImageButton) findViewById( R.id.image3 );
        imageButton2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        } );


     FacebookSdk.sdkInitialize(LoginScreen2.this.getApplicationContext());
    callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {

            Log.d("Success", "Login");
            AccessToken accessToken = loginResult.getAccessToken();
            Profile profile = Profile.getCurrentProfile();

            // Facebook Email address
            GraphRequest request = GraphRequest.newMeRequest(
                    loginResult.getAccessToken(),
                    new GraphRequest.GraphJSONObjectCallback() {
                        @Override
                        public void onCompleted(
                                JSONObject object,
                                GraphResponse response) {
                            Log.v("LoginActivity Response ", response.toString());

                            try {
                                String Name = object.getString("name");

                                String FEmail = object.getString("email");

                                Intent i = new Intent( LoginScreen2.this,welcomeActivityScreen4.class );
                                // saveLoginDetails();
                                startActivity( i );
                                finish();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
            Bundle parameters = new Bundle();
            parameters.putString("fields", "id,name,email,gender, birthday");
            request.setParameters(parameters);
            request.executeAsync();
        }
        @Override
        public void onCancel() {
            Toast.makeText(LoginScreen2.this, "Login Cancel", Toast.LENGTH_LONG).show();
        }
        @Override
        public void onError(FacebookException exception) {
            Toast.makeText(LoginScreen2.this, exception.getMessage(), Toast.LENGTH_LONG).show();
        }
    });
}

    //@Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image3:
                signIn();
                break;
            // ...
        }
        Intent i = new Intent( LoginScreen2.this, MainActivityScreen3.class );
        startActivity( i );
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult( signInIntent, RC_SIGN_IN );
    }

    private void facebookLogin() {
        LoginManager.getInstance().logInWithReadPermissions( this, Arrays.asList( "public_profile", "email" ) );
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult( requestCode, resultCode, data );

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task <GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent( data );
            handleSignInResult( task );
        }
        callbackManager.onActivityResult( requestCode, resultCode, data );
    }

    private void handleSignInResult(Task <GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult( ApiException.class );

            // Signed in successfully, show authenticated UI.
            updateUI( account );
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w( TAG, "signInResult:failed code=" + e.getStatusCode() );
            updateUI( null );
        }
    }

    private void updateUI(Object o) {
        Intent i=new Intent( LoginScreen2.this,welcomeActivityScreen4.class );
        startActivity( i );
    }


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    public void addButtonClickListener() {
        login = (Button) findViewById( R.id.login );
        login.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( LoginScreen2.this, welcomeActivityScreen4.class );
                startActivity( i );
            }
        } );
    }
}
