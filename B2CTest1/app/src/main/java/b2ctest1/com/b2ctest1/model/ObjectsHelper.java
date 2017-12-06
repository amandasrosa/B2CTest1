package b2ctest1.com.b2ctest1.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Amanda on 05/12/2017.
 */

public class ObjectsHelper {

    boolean firstLoad = true;

    public static void createProducts (Context context) {
        ProductDAO dao = new ProductDAO(context);

        Product p1 = new Product();
        p1.setId(1);
        p1.setDescription("Suit");
        p1.setPrice(68.00);
        dao.dbinsert(p1);

        Product p2 = new Product();
        p2.setId(2);
        p2.setDescription("Shirt");
        p2.setPrice(14.00);
        dao.dbinsert(p2);

        Product p3 = new Product();
        p3.setId(3);
        p3.setDescription("Dress");
        p3.setPrice(43.00);
        dao.dbinsert(p3);

        Product p4 = new Product();
        p4.setId(4);
        p4.setDescription("Jacket");
        p4.setPrice(47.00);
        dao.dbinsert(p4);

        Product p5 = new Product();
        p5.setId(5);
        p5.setDescription("Pants");
        p5.setPrice(27.00);
        dao.dbinsert(p5);

        Product p6 = new Product();
        p6.setId(6);
        p6.setDescription("Cardigan");
        p6.setPrice(18.00);
        dao.dbinsert(p6);

        Product p7 = new Product();
        p7.setId(7);
        p7.setDescription("Gloves");
        p7.setPrice(3.00);
        dao.dbinsert(p7);

        Product p8 = new Product();
        p8.setId(8);
        p8.setDescription("Pyjama");
        p8.setPrice(35.00);
        dao.dbinsert(p8);

        Product p9 = new Product();
        p9.setId(9);
        p9.setDescription("Vest");
        p9.setPrice(8.00);
        dao.dbinsert(p9);

        Product p10 = new Product();
        p10.setId(10);
        p10.setDescription("Shoes");
        p10.setPrice(22.00);
        dao.dbinsert(p10);

        dao.close();
    }

    public static boolean checkEmailNPassHelper (String email, String password, Context context) {
        UserDAO dao = new UserDAO(context);

        boolean validLogin = dao.checkEmailNPass(email,password);

        return validLogin;
    }
}
