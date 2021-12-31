package tw.sgft.m0200;

import android.content.Context;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//單純儲存用，save/load不要做在這裡
public class TestTeamData implements Serializable {
          public String title, desc;
          public TeamStatus status;

          //先public，應該不能public
          public TestJourneyData journeyData;
          public List<TestTeammateData> mateList;


          public TestTeamData(TestJourneyData target) {
                    this.journeyData = target;
                    this.mateList = new ArrayList<>();

                    Refresh();
          }

          public TestTeamData(TestJourneyData target, List<TestTeammateData> mates) {
                    this.journeyData = target;
                    this.mateList = mates;

                    Refresh();
          }

          public void Refresh() {
                    this.desc = journeyData.title;

          }


          public enum TeamStatus {
                    OPEN,
                    CLOSE
          }
}

