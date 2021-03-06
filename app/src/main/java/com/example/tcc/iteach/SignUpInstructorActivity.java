package com.example.tcc.iteach;

import android.accounts.NetworkErrorException;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
//import com.google.firebase.storage.FirebaseStorage;
//import com.google.firebase.storage.StorageReference;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class SignUpInstructorActivity extends AppCompatActivity implements View.OnClickListener , AdapterView.OnItemSelectedListener {
Instructor instructor;
private TextView textViewSignin2 , textViewBrowse,textview , textViewDOB, textViewGender , textViewSpecialty, textViewPayment, textViewPlace , textViewMethod;
private EditText editTextPasswordInstructor , yearsExperience, editTextEmailInstructor,editTextFirstName,editTextLastName , editTextNumberInstructor, lessonsPrice;
private DatePicker datePicker;
private RadioGroup radioGroupGender;
private RadioButton male, female;
private Spinner specialtySpinner , paymentSpinner, placeSpinner , method;
private Button buttonContinueToLocation , buttonBrowse;
private Button register;
FirebaseAuth firebaseAuth;
DatabaseReference databaseReference;
FirebaseUser firebaseUser;
FirebaseDatabase database;
ProgressDialog progressDialog;
String  instructorEmail, instructorPassword , firstName, lastName  , gender, date , yearsOfExperience , instructorsPhoneNum , chosenString, priceString ,   chosenPaymentMethod,chosenPlace , chosenMethod , insId;
long longInstructorsPhoneNum;
int intYearsOfExperience;
double price;
private LatLng location;
    private String encryptedLocation;
private String latitude,longitude;
private static String cryptoPass = "sup3rS3xy";
    List<String> chosen = new ArrayList<String>();
    MultiSelectionSpinner spinner;
FirebaseStorage storage;

    private DatabaseReference usersRef;
    private FirebaseAuth mAuth;

    private String current_user_id;
Uri pdfUri;
    StorageReference storageReference;
ProgressDialog progressDialog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_instructor);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        textViewSignin2 = (TextView) findViewById(R.id.textViewSignin2);
        editTextEmailInstructor = (EditText) findViewById(R.id.editTextEmailInstructor);
        editTextPasswordInstructor= (EditText) findViewById(R.id.editTextPasswordInstructor);
        editTextFirstName=(EditText) findViewById(R.id.editTextFirstName);
        editTextLastName=(EditText) findViewById(R.id.editTextLastName);
        editTextNumberInstructor= (EditText) findViewById(R.id.editTextNumberInstructor);
        lessonsPrice= (EditText)findViewById(R.id.lessonsPrice);
        datePicker=(DatePicker)findViewById(R.id.datePicker);
        radioGroupGender=(RadioGroup)findViewById(R.id.radioGroupGender);
        yearsExperience= (EditText)findViewById(R.id.yearsExperience);
        paymentSpinner=(Spinner)findViewById(R.id.payment);
        placeSpinner=(Spinner)findViewById(R.id.place);
        buttonContinueToLocation=(Button)findViewById(R.id.buttonContinueToLocation);
        register=(Button)findViewById(R.id.buttonRegister);
        textViewDOB=(TextView) findViewById(R.id.textViewDOB);
        textview=(TextView) findViewById(R.id.textview);
        textViewGender=(TextView) findViewById(R.id.textViewGender);
        textViewSpecialty=(TextView) findViewById(R.id.textViewSpecialty);
        male=(RadioButton) findViewById(R.id.male);
        female=(RadioButton)findViewById(R.id.female);
        textViewPayment= (TextView) findViewById(R.id.textViewPayment);
        textViewPlace=(TextView) findViewById(R.id.textViewPlace);
        textViewMethod=(TextView) findViewById(R.id.textViewMethod);
        textViewBrowse= (TextView) findViewById(R.id.textViewBrowse);
        buttonBrowse=(Button) findViewById(R.id.buttonBrowse2);
        //notification=(TextView) findViewById(R.id.notification);
method=(Spinner)findViewById(R.id.method);
storage= FirebaseStorage.getInstance();
database=FirebaseDatabase.getInstance();
        progressDialog =new ProgressDialog(this);
// database stuff
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference("Instructors");
// onclick methods calling
        textViewSignin2.setOnClickListener(this);
        buttonContinueToLocation.setOnClickListener(this);
        register.setOnClickListener(this);
        buttonBrowse.setOnClickListener(this);

        //************************************************************

//************************************************************
        // fill spinners
        ArrayAdapter<CharSequence> paymentAdapter = ArrayAdapter.createFromResource(this ,R.array.paymentMethod,android.R.layout.simple_spinner_item);
        paymentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        paymentSpinner.setAdapter(paymentAdapter);
        //setContentView(R.layout.activity_sign_up_instructor);
        paymentSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> placeAdapter = ArrayAdapter.createFromResource(this,R.array.lessonsPlace,android.R.layout.simple_spinner_item);
        placeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        placeSpinner.setAdapter(placeAdapter);
        placeSpinner.setOnItemSelectedListener(this);


        ArrayAdapter<CharSequence> methodAdapter = ArrayAdapter.createFromResource(this,R.array.method,android.R.layout.simple_spinner_item);
        methodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        method.setAdapter(methodAdapter);
        method.setOnItemSelectedListener(this);

        spinner=(MultiSelectionSpinner) findViewById(R.id.input1);
        List<String> list = new ArrayList<String>();

        list.add("العربية");
        list.add("الانكليزية");
        list.add("الرياضيات");
        list.add("الكيمياء");
        list.add("الفيزياء");
        list.add("الموسيقى");
        list.add("الرقص");
        list.add("الرسم");
        list.add("الطبخ");
        spinner.setItems(list);

        // Location
        Bundle bundle = getIntent().getParcelableExtra("bundle");
        if (bundle!=null){
        location = bundle.getParcelable("location");
        encryptedLocation=encryptIt( location.toString() );}


// end location

        mAuth = FirebaseAuth.getInstance();
        //  current_user_id = mAuth.getCurrentUser().getUid();

        firebaseAuth = FirebaseAuth.getInstance();
        usersRef = FirebaseDatabase.getInstance().getReference().child("users");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
       super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==9 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
            selectPdf();
        }
        else
            Toast.makeText(SignUpInstructorActivity.this,"الرجاء السماح بالوصول لملفاتك" , Toast.LENGTH_LONG).show();
    }

    private void selectPdf() {

        Intent intent2 = new Intent();
        intent2.setType("application/pdf");
        intent2.setAction(Intent.ACTION_GET_CONTENT);
        //pdfUri=intent2.getData();
       // Toast.makeText(SignUpInstructorActivity.this,"ameera" , Toast.LENGTH_LONG).show();

        startActivityForResult(intent2,86);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==86 && resultCode==RESULT_OK && data!=null){
            pdfUri=data.getData();
            textViewBrowse.setText("A file is selected "+ data.getData().getLastPathSegment());
        }
        else {
            Toast.makeText(SignUpInstructorActivity.this,"الرجاء اختيار ملف ",Toast.LENGTH_LONG).show();
        }
    }

    public String registerInstructor(){
        instructorEmail = editTextEmailInstructor.getText().toString();
        instructorPassword = editTextPasswordInstructor.getText().toString();

        firstName= editTextFirstName.getText().toString();
        lastName= editTextLastName.getText().toString();
        yearsOfExperience = yearsExperience.getText().toString();
        instructorsPhoneNum = editTextNumberInstructor.getText().toString();
        date = datePicker.getDayOfMonth()+"/"+datePicker.getMonth()+"/"+datePicker.getYear();
        priceString = lessonsPrice.getText().toString();
        // To know if user selects male or female
        int radioId= radioGroupGender.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(radioId);
        if(radioButton!=null)
        gender = radioButton.getText().toString();
        chosen=spinner.getSelectedStrings();
        // Toast.makeText(SignUpInstructorActivity.this,chosen.get( 0 ), Toast.LENGTH_SHORT).show();


        chosenString= spinner.getSelectedItemsAsString(); // this variable contains the specialties chosen by the instructor as a string EX:Arablic,English
        //instructor = new Instructor(firstName,lastName,date,gender,encryptedLocation,longInstructorsPhoneNum, intYearsOfExperience,price,0 , chosenPaymentMethod, chosenPlace , chosenMethod );
        chosenString= spinner.getSelectedItemsAsString();
        if(encryptedLocation== null ){
            // email is empty!
            Toast.makeText(this, "فضلاً اختر موقعك من الخارطة", Toast.LENGTH_LONG).show();
            return null;
        }

        if(TextUtils.isEmpty(instructorEmail)){
            // email is empty!
            Toast.makeText(this, "فضلأ أدخل ايميل", Toast.LENGTH_LONG).show();
            return null;
        }


        if(TextUtils.isEmpty(instructorPassword)){
            // password is empty!
            Toast.makeText(this, "فضلأ أدخل كلمة مرور", Toast.LENGTH_LONG).show();
            return null;
        }

        if (instructorPassword.length()<6){
            Toast.makeText(this, "لايجب أن يكون طول كلمة المرور أقل من ستة أحرف", Toast.LENGTH_LONG).show();
            return null;
        }


        if(TextUtils.isEmpty(instructorsPhoneNum)){
            Toast.makeText(this, "فضلاً أدخل رقم هاتفك", Toast.LENGTH_LONG).show();
            return null;
        }
            if(instructorsPhoneNum.length()!= 10&& !(instructorsPhoneNum.substring( 0,1 ).equals( "05" ))){
                    Toast.makeText(this, "رقم الهاتف يجب أن يكون من 10 أرقام ويبدأ ب 05", Toast.LENGTH_LONG).show();
                return null;
            }
        if(TextUtils.isEmpty(firstName)){
           Toast.makeText(this, "فضلاً أدخل اسمك الأول", Toast.LENGTH_LONG).show();
            return null;
        }

        if(TextUtils.isEmpty(lastName)){
            Toast.makeText(this, "فضلاُ أدخل اسم شهرتك", Toast.LENGTH_LONG).show();
            return null;
        }

        if(TextUtils.isEmpty(date)){
            Toast.makeText(this, "فضلأ أدخل تاريخ ميلادك", Toast.LENGTH_LONG).show();
            return null;
        }

        if(datePicker.getYear()>2000){
            Toast.makeText(this, "عذراً غير مسموح لك التسجيل بهذا العمر", Toast.LENGTH_LONG).show();
            return null;
        }

        if(TextUtils.isEmpty(gender)){
            Toast.makeText(this, "فضلأ اختر جنسك", Toast.LENGTH_LONG).show();
            return null;
        }
        if(chosen.size()==0){
            // email is empty!
            Toast.makeText(this, "فضلأ اختر المواد التي تدرسها", Toast.LENGTH_LONG).show();
            return null;
        }



        if(TextUtils.isEmpty(yearsOfExperience)){
            Toast.makeText(this, "فضلأ أدخل عدد سنوات خبرتك", Toast.LENGTH_LONG).show();
            return null;
        }



        if(TextUtils.isEmpty(priceString)){
            Toast.makeText(this, "فضلاً أدخل سعر الدرس", Toast.LENGTH_LONG).show();
            return null;
        }

            if(pdfUri==null){
                Toast.makeText(this, "فضلاً أرفق سيرتك الذاتية", Toast.LENGTH_LONG).show();
                return null;
            }
// if validations are ok we register user
        intYearsOfExperience=Integer.parseInt(yearsOfExperience);
        longInstructorsPhoneNum=Long.parseLong(instructorsPhoneNum);
price=Double.parseDouble(priceString);
        progressDialog.setMessage("تسجيل الحساب....الرجاء الانتظار");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(instructorEmail,instructorPassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            progressDialog.dismiss();
                           // this variable contains the specialties chosen by the instructor as a string EX:Arablic,English
                            firebaseUser=firebaseAuth.getCurrentUser();
                          // Toast.makeText(SignUpInstructorActivity.this, "email "+ instructorEmail, Toast.LENGTH_LONG).show();
String userID = firebaseUser.getUid();
                            instructor = new Instructor(firstName,lastName,date,gender,encryptedLocation,longInstructorsPhoneNum, intYearsOfExperience,price,0,0,0 ,chosenPaymentMethod, chosenPlace , chosenMethod , instructorEmail, chosen , userID );
                            //Toast.makeText(SignUpInstructorActivity.this, "chosen "+ instructor.subjects.get(0), Toast.LENGTH_LONG).show();

                            /* Intent intent = new Intent(SignUpInstructorActivity.this,ViewInstructorProfile.class);
                            intent.putExtra("instructorsFName",firstName);*/

                           // String id = databaseReference.push().getKey();
                            databaseReference.child(firebaseUser.getUid()).setValue(instructor);
//final String fileName = System.currentTimeMillis()+"";
                            storageReference=storage.getReference();
                            storageReference.child(firebaseUser.getUid()).putFile(pdfUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                  String url = storageReference.getDownloadUrl().toString();
                                  databaseReference.child(firebaseUser.getUid()).child("Cv").setValue(url);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(SignUpInstructorActivity.this, "فشل تحميل الملف", Toast.LENGTH_SHORT).show();

                                }
                            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                                }
                            });

                          //  StorageReference storageReference=storage.getReference("Instructors");
                            //storageReference.child(firebaseUser.getUid()).child("Cv").putFile(pdfUri);
                            databaseReference.child(firebaseUser.getUid()).child("subjects").setValue(chosen);
                            Toast.makeText(SignUpInstructorActivity.this, "تم تسجيل الحساب بنجاح", Toast.LENGTH_SHORT).show();
                            FirebaseMessaging.getInstance().subscribeToTopic("notificationsLessons");
                            FirebaseMessaging.getInstance().subscribeToTopic("notificationsCancel");
                            FirebaseMessaging.getInstance().subscribeToTopic("notificationsEdit");



                            FirebaseDatabase.getInstance().getReference("messages").push().setValue(new Message( "أستاذ جديد", "أستاذ جديد انضم لنا..قد تكون مهتماً بالمواد التي يدرسها ويسكن بالقرب منك .." ,instructorEmail,encryptedLocation,firstName+" "+lastName,userID));
                            final FirebaseUser user = mAuth.getCurrentUser();
                            user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(SignUpInstructorActivity.this, "تم  ارسال ايميل تفعيل الى حسابك", Toast.LENGTH_SHORT).show();
                                }
                            });

                            current_user_id = mAuth.getCurrentUser().getUid();
                            HashMap postsMap = new HashMap();
                            postsMap.put("fullname",firstName+" "+lastName);
                            usersRef.child(current_user_id).updateChildren(postsMap);
                         startActivity(new Intent(getApplicationContext(),instructor_main.class));
                            }

                        else if (!task.isSuccessful())
                            {progressDialog.dismiss();
                            // if  (((FirebaseAuthException) task.getException()).getErrorCode().equals(""));
                            try{
                               throw task.getException(); }
                            catch (FirebaseAuthWeakPasswordException e){
                                Toast.makeText(SignUpInstructorActivity.this, "طول كلمة السر يجب أن يتعدى الخمس حروف ", Toast.LENGTH_LONG).show();

                            }

                            catch (FirebaseAuthInvalidCredentialsException e){
                                Toast.makeText(SignUpInstructorActivity.this, "البريد الالكتروني المزود غير صالح ", Toast.LENGTH_LONG).show();

                               }

                            catch (FirebaseAuthUserCollisionException e){
                                Toast.makeText(SignUpInstructorActivity.this, "هذا الحساب مسجل مسبقاً", Toast.LENGTH_LONG).show();

                            }
                            catch(NetworkErrorException e){
                                Toast.makeText(SignUpInstructorActivity.this, "تحقق من اتصالك بشبكة الانترنت أو حاول لاحقاًً", Toast.LENGTH_LONG).show();

                            }
                            catch (Exception e){
                                Toast.makeText(SignUpInstructorActivity.this,"لقد حصل خطأ .. الرجاء المحاولة لاحقاً", Toast.LENGTH_LONG).show();

                            }


                             }//else
                    }//oncomplete
                });
        return null;
    }

    @Override
    public void onClick(View view) {
        if(view== textViewSignin2){
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
        if (view==buttonContinueToLocation ){
            Intent intent = new Intent(SignUpInstructorActivity.this,LocationActivity.class);
            intent.putExtra("key", "instructor" );
            intent.putExtra("search", "false" );

            startActivity(intent);


            }
        if (view==register ){


            registerInstructor();
            //startActivity(new Intent(this,blackboard.class));
        }

        if (view==buttonBrowse){
            //Toast.makeText(SignUpInstructorActivity.this,"marwa", Toast.LENGTH_LONG).show();
            selectPdf();

          /* if(ContextCompat.checkSelfPermission(SignUpInstructorActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(SignUpInstructorActivity.this,"select pdf method called", Toast.LENGTH_LONG).show();
                selectPdf();
            }


            else {
                Toast.makeText(SignUpInstructorActivity.this,"Line 370", Toast.LENGTH_LONG).show();

                ActivityCompat.requestPermissions(SignUpInstructorActivity.this,new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},9);
            }*/
        }



        }



    public static String encryptIt(String value) {
        try {
            DESKeySpec keySpec = new DESKeySpec(cryptoPass.getBytes("UTF8"));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(keySpec);

            byte[] clearText = value.getBytes("UTF8");
            // Cipher is not thread safe
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            String encryptedValue = Base64.encodeToString(cipher.doFinal(clearText), Base64.DEFAULT);
            return encryptedValue;

        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return value;
    };
    public static String decryptIt(String value) {
        try {
            DESKeySpec keySpec = new DESKeySpec(cryptoPass.getBytes("UTF8"));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(keySpec);

            byte[] encrypedPwdBytes = Base64.decode(value, Base64.DEFAULT);
            // cipher is not thread safe
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decrypedValueBytes = (cipher.doFinal(encrypedPwdBytes));

            String decrypedValue = new String(decrypedValueBytes);
            return decrypedValue;

        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return value;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(adapterView==paymentSpinner)
        chosenPaymentMethod = adapterView.getItemAtPosition(i).toString();


        if(adapterView==placeSpinner)
            chosenPlace= adapterView.getItemAtPosition(i).toString();

        if(adapterView==method)
            chosenMethod= adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}
