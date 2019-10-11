package permission.auron.com.samplepermissionhelper;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import permission.auron.com.permissionhelper.ActivityManagePermission;
import permission.auron.com.permissionhelper.PermissionResult;
import permission.auron.com.permissionhelper.utils.PermissionUtils;
import permission.auron.com.samplemarshmallowpermissionhelper.R;
import permission.auron.com.samplepermissionhelper.checkPermission.ActivityCheckPermission;

public class MainActivity extends ActivityManagePermission {

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    public static String TAG = MainActivity.class.getSimpleName();
    private ImageView imageView;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.app_name);
        getSupportActionBar().setSubtitle(R.string.askSingleActivity);
        floatingActionButton = findViewById(R.id.fab);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //single permission
                askCompactPermission(PermissionUtils.Manifest_CAMERA, new PermissionResult() {
                    @Override
                    public void permissionGranted() {
                        //permission granted
                        //replace with your action
                        dispatchTakePictureIntent();

                    }

                    @Override
                    public void permissionDenied() {
                        //permission denied
                        //replace with your action
                        Log.d(TAG, "permissionDenied");
                    }

                    @Override
                    public void permissionForeverDenied() {
                        //permission denied
                        //replace with your action
                        Log.d(TAG, "permissionForeverDenied");
                        showDialog();

                    }
                });
            }
        });


    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null)
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.ask_single_activity:
                return true;
            case R.id.ask_multi_activity:
                startActivity(new Intent(MainActivity.this, ActivityMultiplePermission.class));
                return true;
            case R.id.ask_single_fragment:
                startActivity(new Intent(MainActivity.this, ActivityContainer.class));
                return true;
//            case R.id.ask_annotation :
//                startActivity(new Intent(MainActivity.this, ActivityAnnotation.class)); work in progress ;-)
            //               return true;
            case R.id.check_permission:
                startActivity(new Intent(MainActivity.this, ActivityCheckPermission.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void showDialog() {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(MainActivity.this, R.style.AppCompatAlertDialogStyle);
        builder.setTitle(R.string.attention);
        builder.setMessage(R.string.messageperm);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                openSettingsApp(MainActivity.this);
            }
        });
        builder.setNegativeButton("Cancel", null);
        builder.show();
    }
}