package com.example.user.sqliteprovider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button add = (Button) findViewById(R.id.addContact);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addContact("Leonard McCoy");
                Snackbar.make(view, "Adding to Contact Database", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Button edit = (Button) findViewById(R.id.editContact);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Editing the Contact Database", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Button list = (Button) findViewById(R.id.listContact);
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listContacts();
                Snackbar.make(view, "Listing the Contact Database", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
    }
    private void addContact(String newName) {
        ContentValues newContact = new ContentValues();
        newContact.put(ContactsContract.RawContacts.ACCOUNT_NAME, newName);
        newContact.put(ContactsContract.RawContacts.ACCOUNT_TYPE, newName);
        Uri newUri = getContentResolver().insert(ContactsContract.RawContacts.CONTENT_URI, newContact);
        long rawContactsId = ContentUris.parseId(newUri);
        newContact.clear();
        newContact.put(ContactsContract.RawContacts.Data.RAW_CONTACT_ID, rawContactsId);
        newContact.put(ContactsContract.RawContacts.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE);
        newContact.put(ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME, newName);
        getContentResolver().insert(ContactsContract.Data.CONTENT_URI, newContact);
    }
    public void listContacts() {
        Cursor nameCursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        while (nameCursor.moveToNext()){
            String contactName = nameCursor.getString(nameCursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY));
            Toast.makeText(this, contactName, Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}