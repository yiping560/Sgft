package tw.sgft.m0200;

public class TestData {
          private String _name;
          private String _desc;

          //建構子
          public TestData() { }

          public String getName() {return _name;}

          public String getDesc() {return _desc;}

          public void setName(String name) {
                    this._name = name;
          }

          public void setDesc(String desc) {
                    this._desc = desc;
          }
}