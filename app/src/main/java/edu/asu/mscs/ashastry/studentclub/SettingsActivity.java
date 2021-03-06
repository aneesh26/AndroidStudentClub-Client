package edu.asu.mscs.ashastry.studentclub;

/**
 * Copyright 2015 Aneesh Shastry
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Purpose: This is a Student Club App to enable Clubs to share information with its members.
 *          This module is used to setup the Settings activity
 *
 * @author : Aneesh Shastry  mailto:ashastry@asu.edu
 *           MS Computer Science, CIDSE, IAFSE, Arizona State University
 * @version : May 1, 2015
 */


import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class SettingsActivity extends Activity {
    EditText urlPath;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor((getResources().getColor(R.color.maroon_light)));
        urlPath = (EditText)findViewById(R.id.urlField);
        String serverURL =  PreferenceManager.getDefaultSharedPreferences(getBaseContext()).getString("serverURL", "");
        if(!serverURL.equals("")){
            urlPath.setText(serverURL);
        }





    }

    public void onClickClear(View v){
        urlPath = (EditText)findViewById(R.id.urlField);
        urlPath.setText("");

    }
    public void onClickUpdate(View v){
        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("serverURL", urlPath.getText().toString()).commit();
        Toast.makeText(SettingsActivity.this, "Settings Updated", Toast.LENGTH_SHORT).show();

    }

}