package com.example.week2daily3homework;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;

import static com.example.week2daily3homework.DatabaseConstants.DATABASE_NAME;
import static com.example.week2daily3homework.DatabaseConstants.DATABASE_VERSION;
import static com.example.week2daily3homework.DatabaseConstants.FIELD_NAME;
import static com.example.week2daily3homework.DatabaseConstants.FIELD_SOUND;
import static com.example.week2daily3homework.DatabaseConstants.FIELD_TYPE;
import static com.example.week2daily3homework.DatabaseConstants.IMAGE_RESOURCE_ID;
import static com.example.week2daily3homework.DatabaseConstants.TABLE_NAME;

public class animalDatabaseHelper extends SQLiteOpenHelper {

    public animalDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createQuery = "CREATE TABLE " + TABLE_NAME + " ("
                + FIELD_NAME + " TEXT PRIMARY KEY, "
                + FIELD_TYPE + " TEXT, "
                + FIELD_SOUND + " TEXT, "
                + IMAGE_RESOURCE_ID + " INTEGER);";
        db.execSQL(createQuery);
        Animal animal = new Animal("Mammal", "Human", "Talk", R.drawable.human);
        ContentValues content = new ContentValues();
        content.put(FIELD_NAME, animal.getName());
        content.put(FIELD_TYPE, animal.getType());
        content.put(FIELD_SOUND, animal.getSound());
        content.put(IMAGE_RESOURCE_ID, animal.getImage());
        db.insert(TABLE_NAME, null, content);

        animal = new Animal("Mammal", "Cat", "Meow", R.drawable.cat);
        content = new ContentValues();
        content.put(FIELD_NAME, animal.getName());
        content.put(FIELD_TYPE, animal.getType());
        content.put(FIELD_SOUND, animal.getSound());
        content.put(IMAGE_RESOURCE_ID, animal.getImage());
        db.insert(TABLE_NAME, null, content);

        animal = new Animal("Reptile", "Snake", "Hiss", R.drawable.snake);
        content = new ContentValues();
        content.put(FIELD_NAME, animal.getName());
        content.put(FIELD_TYPE, animal.getType());
        content.put(FIELD_SOUND, animal.getSound());
        content.put(IMAGE_RESOURCE_ID, animal.getImage());
        db.insert(TABLE_NAME, null, content);

        animal = new Animal("Fish", "Shark", "None", R.drawable.shark);
        content = new ContentValues();
        content.put(FIELD_NAME, animal.getName());
        content.put(FIELD_TYPE, animal.getType());
        content.put(FIELD_SOUND, animal.getSound());
        content.put(IMAGE_RESOURCE_ID, animal.getImage());
        db.insert(TABLE_NAME, null, content);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    public void insertAnimal(Animal animal){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        if(animal != null){
            String type = animal.getType();
            String name = animal.getName();
            String sound = animal.getSound();
            int resourceId = animal.getImage();

            contentValues.put(FIELD_NAME, name);
            contentValues.put(FIELD_TYPE, type);
            contentValues.put(FIELD_SOUND, sound);
            contentValues.put(IMAGE_RESOURCE_ID, resourceId);

            database.insert(TABLE_NAME, null,contentValues);
        }
    }

    public ArrayList<Animal> getAllAnimals(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query ="SELECT * FROM " + TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);

        if(cursor.moveToFirst()){
            ArrayList<Animal> arrayList = new ArrayList<>();
            do {
                String type = cursor.getString(cursor.getColumnIndex(FIELD_TYPE));
                String name = cursor.getString(cursor.getColumnIndex(FIELD_NAME));
                String sound = cursor.getString(cursor.getColumnIndex(FIELD_SOUND));
                int resourceId = Integer.parseInt(cursor.getString(cursor.getColumnIndex(IMAGE_RESOURCE_ID)));
                arrayList.add(new Animal(type, name, sound, resourceId));
            } while(cursor.moveToNext());
            return arrayList;
        } else {
            return null;
        }
    }

    public Animal getAnimal(String passedName){
        Animal returnAnimal = null;
        if(passedName != null && !passedName.isEmpty()) {
            SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
            String query = "SELECT * FROM " + TABLE_NAME
                    + " WHERE " + FIELD_NAME + " = \"" + passedName + "\"";
            Cursor cursor = sqLiteDatabase.rawQuery(query, null);
            if (cursor.moveToFirst()) {
                String name = cursor.getString(cursor.getColumnIndex(FIELD_NAME));
                String type = cursor.getString(cursor.getColumnIndex(FIELD_TYPE));
                String sound = cursor.getString(cursor.getColumnIndex(FIELD_SOUND));
                int resourceId = Integer.parseInt(cursor.getString(cursor.getColumnIndex(IMAGE_RESOURCE_ID)));
                returnAnimal = new Animal(type, name, sound, resourceId);
            }
            cursor.close();
        }
        return returnAnimal;
    }

    public int deleteAnimal(String passedName){
        String whereClause = FIELD_NAME + " = \"" + passedName + "\"";
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME, whereClause, null);
    }

    public int updateAnimal(Animal passedAnimal){
        if(passedAnimal != null) {
            String whereClause = FIELD_NAME + " = \"" + passedAnimal.getName() + "\"";
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(FIELD_NAME, passedAnimal.getName());
            contentValues.put(FIELD_TYPE, passedAnimal.getType());
            contentValues.put(FIELD_SOUND, passedAnimal.getSound());
            contentValues.put(IMAGE_RESOURCE_ID, String.valueOf(passedAnimal.getImage()));
            return sqLiteDatabase.update(TABLE_NAME, contentValues, whereClause, null);
        }
        return 0;
    }
}
