import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import static java.lang.Thread.sleep;

/**
 * Created by svetlanashmalko on 21.08.16.
 */
public final class Billing {

    /*
    Детализация звонков телефонного номера
     */
    private static Billing instance;

    /*
    История звонков
     */
    public ArrayList <Record> callHistory=new ArrayList<>();

    /**
     * Инициализации счета. Указываем сколько у нас денег в самом начале
     *

     * Замечание: Конструктор имеет приватную область видимости, так как мы должны гарантировать
     * что объект MoneyAccount в нашей системе будет существовать в единственном экземпляре
     */
    public Billing() {

        callHistory.add(new Record(89890009000L,"MTC",new java.util.Date()));
    }

    /*
     Возвращает ссылку на билинг. При первом обращении создает единственный экземпляр билинга.

     */
    public  Date getLastCallDate(){

        return callHistory.get(callHistory.size()-1).getDate();

    }

    public static Billing getInstance() {
        if (instance == null) {
            instance = new Billing();
        }
        return instance;
    }

    /*
    Добавляем запись
    */

    public void addRecord(Record rec) {
        callHistory.add(rec);
    }
    public void print(){
    int i=0;
    Iterator it=instance.callHistory.iterator();
    while (it.hasNext()){
           System.out.println(callHistory.get(i).name+ callHistory.get(i).date);

        it.next();
        i++;
    }}
    /*
    Показывает сколкьо звонков
     */

    public  Integer countCall() {
        return callHistory.size();
    }



    public static void main(String[] args) throws InterruptedException {

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

        //подождем 100 мс. пока все потоки сделают своё дело
        sleep(100);
        instance.print();



    }

}

