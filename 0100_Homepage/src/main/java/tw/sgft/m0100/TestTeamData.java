package tw.sgft.m0100;

import android.content.Context;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

//單純儲存用，save/load不要做在這裡
public class TestTeamData implements Serializable {
          public String title,desc,status;

          public TestTeamData(String str1,String str2,String str3) {
                    this.title = str1;
                    this.desc = str2;
                    this.status = str3;
          }

          public TestJourneyData journeyData;
          public List<TestTeammateData> mateList;

          public TestTeamData(TestJourneyData target, List<TestTeammateData> mates) {
                    this.title = "Test";
                    this.journeyData = target;
                    this.mateList = mates;
          }
}