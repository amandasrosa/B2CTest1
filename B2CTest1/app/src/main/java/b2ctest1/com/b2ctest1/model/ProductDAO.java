package b2ctest1.com.b2ctest1.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amanda on 05/12/2017.
 */

public class ProductDAO extends SQLiteOpenHelper {

    public ProductDAO(Context context) {
        super(context, "c0719157DBB", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Product (id INTEGER PRIMARY KEY, description TEXT NOT NULL, price REAL NOT NULL)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Product";
        db.execSQL(sql);
        onCreate(db);
    }

    public void dbinsert(Product product) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues productData = new ContentValues();
        productData.put("description", product.getDescription());
        productData.put("price",product.getPrice());

        db.insert("Product", null, productData);
    }

    public List<Product> dbSearch() {
        SQLiteDatabase db = getReadableDatabase();

        String sql = "SELECT * FROM Product;";

        Cursor c = db.rawQuery(sql, null);
        List<Product> productList = new ArrayList<Product>();

        while (c.moveToNext()) {
            Product product = new Product();

            product.setId(c.getInt(c.getColumnIndex("id")));
            product.setDescription(c.getString(c.getColumnIndex("description")));
            product.setPrice(c.getDouble(c.getColumnIndex("price")));

            productList.add(product);
        }
        c.close();

        return productList;
    }
}
