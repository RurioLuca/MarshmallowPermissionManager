package permission.auron.com.samplepermissionhelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import permission.auron.com.samplemarshmallowpermissionhelper.R;
import permission.auron.com.samplepermissionhelper.checkPermission.ActivityCheckPermission;
import permission.auron.com.samplepermissionhelper.fragment.FragmentSinglePermission;

/**
 * Created by luca on 9/2/16.
 */
public class ActivityContainer extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.app_name);
        getSupportActionBar().setSubtitle(R.string.askSingleFragment);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.content_frame, Fragment.instantiate(ActivityContainer.this, FragmentSinglePermission.class.getName()))
                .commit();

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
            case R.id.ask_single_fragment:
                this.finish();
                return true;
            case R.id.ask_multi_activity:
                startActivity(new Intent(ActivityContainer.this, ActivityMultiplePermission.class));
                return true;
            case R.id.check_permission:
                startActivity(new Intent(ActivityContainer.this, ActivityCheckPermission.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}
