package tw.sgft.m0200;

import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

//版本2
public class TestDataRepository {

          private static TestDataRepository _tdr;
          private Travel _data;

          //private建構子
          private TestDataRepository() {}

          public static TestDataRepository getInstance() {
                    if (_tdr == null) {_tdr = new TestDataRepository();}
                    return _tdr;
          }

          public Travel getData() {
                    if (_data == null) {
                              _data = new Travel();
                              _data.HappySet = new ArrayList<>();
                    }
                    return _data;
          }



//          public void setData(TestTeamData data) {
//                    //if(){}
//                    _data.HappySet.add(data);
//          }

          public void save(Context context) {

                    FileOutputStream fos = null;
                    ObjectOutputStream oos = null;

                    try {
                              Log.d("555", "002");
                              //路徑：data/user/0/tw.sgft.m0200/files/
                              fos = context.openFileOutput("test.sav", Context.MODE_PRIVATE);
                              Log.d("555", "003");
                              oos = new ObjectOutputStream(fos);
                              Log.d("555", "004");
                              oos.writeObject(this);
                              Log.d("555", "005");
                    } catch (Exception e) {
                              Log.d("555", "000");
                              e.printStackTrace();
                    } finally {
                              try {
                                        Log.d("555", "006");
                                        if (oos != null) oos.close();
                                        if (fos != null) fos.close();
                              } catch (Exception e) {
                                        Log.d("555", "001");
                                        e.printStackTrace();
                              }
                    }
                    Log.d("555", context.getFilesDir().getPath() + "/007");
          }

          public Travel load(Context context) {

                    Travel temp = null;
                    FileInputStream fis = null;
                    ObjectInputStream ois = null;

                    try {
                              fis = context.openFileInput("test.sav");
                              ois = new ObjectInputStream(fis);
                              temp = (Travel) ois.readObject();
                    } catch (Exception e) {
                              e.printStackTrace();
                    } finally {
                              try {
                                        if (fis != null) fis.close();
                                        if (ois != null) {ois.close();}
                              } catch (Exception e) {
                                        e.printStackTrace();
                              }
                    }

                    return temp;
          }

}