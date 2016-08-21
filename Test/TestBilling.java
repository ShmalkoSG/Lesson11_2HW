import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static java.lang.Thread.sleep;

/**
 * Created by svetlanashmalko on 22.08.16.
 */

public class TestBilling {

    @Before
    public void setUp(){
        Date today=new java.util.Date();
        BaseStation station1=new BaseStation();
        station1.setId(1);
        station1.setRecord(new Record(89280000000L,"MegaFone",new Date(today.getTime()+10000)));

        BaseStation station2=new BaseStation();
        station2.setId(2);
        station2.setRecord(new Record(89040000000L,"Tele2",new Date(today.getTime()+20000)));

        BaseStation station21=new BaseStation();
        station21.setId(21);
        station21.setRecord(new Record(8999999999L,"SkyLink",new Date(today.getTime()+20000)));

        BaseStation station3=new BaseStation();
        station3.setId(3);
        station3.setRecord(new Record(89030000000L,"Beeline",new Date(today.getTime()+30000)));

        station1.start();
        station2.start();
        station21.start();
        station3.start();


        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testBilling() {

        Assert.assertTrue(4==Billing.getInstance().countCall());
    }

    @Test
    public void testBillingFalse() {

        Assert.assertFalse(5==Billing.getInstance().countCall());
    }
}
