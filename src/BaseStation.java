import java.util.Date;
import java.util.Iterator;

/**
 * Created by svetlanashmalko on 21.08.16.
 */
public final class BaseStation extends Thread {
    /*
    Базовая станция в нашем случае реализаует интерфейс Runnable
     */
    Record record;
    public void setRecord(Record record) {
        this.record = record;
    }

    /**
         * Ссылка на наш биллинг.
         */

        private static final Billing billing = Billing.getInstance();

        /**
         * Номер базовой станции
         */
        private Integer id;



        public void setId(final Integer id) {
            this.id = id;
        }

        @Override
        public void run() {
            synchronized (billing) {
                //текущая дата билинга
               final Date lastCallDate = Billing.getInstance().getLastCallDate();

                //проверяем весь биллинг с датой текущего элемента
                 int i=0;
                    Iterator it=billing.callHistory.iterator();
                    while (it.hasNext()){
                        System.out.println(i+Thread.currentThread().getName());
                        if (record.date.compareTo(billing.callHistory.get(i).date)==0) {
                            System.out.println(record.name+ " абонент недоступен");
                            return;

                        }
                        it.next();
                        i++;
                    }

                //добавляем запись
                Billing.getInstance().addRecord(record);
                //формируем сообщение об успешной транзакции
                System.out.println("Звонок "+record.name+" добавлен в биллинг."+ record.date);

            }
        }
    }


