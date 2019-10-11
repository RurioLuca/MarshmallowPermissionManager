package permission.auron.com.samplepermissionhelper.checkPermission;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

import permission.auron.com.permissionhelper.ActivityManagePermission;
import permission.auron.com.permissionhelper.utils.PermissionUtils;
import permission.auron.com.samplemarshmallowpermissionhelper.R;
import permission.auron.com.samplepermissionhelper.ActivityContainer;
import permission.auron.com.samplepermissionhelper.ActivityMultiplePermission;

/**
 * Created by luca on 5/15/16.
 */
public class ActivityCheckPermission extends ActivityManagePermission {

    private Spinner spinner;
    private Button test;
    private AlertDialog.Builder builder;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkpermission);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.app_name);
        getSupportActionBar().setSubtitle(R.string.checkPermission);
        fab = findViewById(R.id.fab);
        test = findViewById(R.id.test);
        spinner = findViewById(R.id.spinner);
        List<String> list = new ArrayList<String>();
        list.add(PermissionUtils.Manifest_ACCESS_COARSE_LOCATION);
        list.add(PermissionUtils.Manifest_WRITE_CALENDAR);
        list.add(PermissionUtils.Manifest_ACCESS_FINE_LOCATION);
        list.add(PermissionUtils.Manifest_GROUP_LOCATION);
        list.add(PermissionUtils.Manifest_READ_SMS);
        list.add(PermissionUtils.Manifest_WRITE_EXTERNAL_STORAGE);
        list.add(PermissionUtils.Manifest_CAMERA);
        list.add(PermissionUtils.Manifest_READ_CONTACTS);


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        builder = new AlertDialog.Builder(ActivityCheckPermission.this, R.style.AppCompatAlertDialogStyle);
        builder.setPositiveButton(R.string.ok, null);

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String permission = spinner.getSelectedItem().toString();

                if (isPermissionGranted(ActivityCheckPermission.this, permission)) {


                    builder.setTitle(R.string.granted);
                    builder.setMessage(R.string.messagegranted);
                    builder.show();


                } else {

                    builder.setTitle(R.string.denied);
                    builder.setMessage(R.string.messagedenied);
                    builder.show();
                }

            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSettingsApp(ActivityCheckPermission.this);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ask_single_activity:
                this.finish();
                return true;
            case R.id.ask_multi_activity:
                startActivity(new Intent(ActivityCheckPermission.this, ActivityMultiplePermission.class));
                return true;
            case R.id.ask_single_fragment:
                startActivity(new Intent(ActivityCheckPermission.this, ActivityContainer.class));
                return true;
//            case R.id.ask_annotation :
//                startActivity(new Intent(ActivityMultiplePermission.this, ActivityAnnotation.class)); work in progress ;-)
//                return true;
            case R.id.check_permission:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
