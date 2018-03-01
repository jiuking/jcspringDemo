import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalculateRate {
    private Date date;
    private Calendar calendar;
    public static void main(String[] args) throws ParseException {
        new CalculateRate().calculate("2017-07-13");
    }
    private void calculate(String time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        date = sdf.parse(time);
        calendar = Calendar.getInstance();
        calendar.setTime(date);
        BigDecimal total = new BigDecimal(Double.toString(64827.2));//2827.2
        System.out.println(total);
        for (int i = 1; i < 13; i++) {
            calendar.add(Calendar.MONTH,1);
            date = calendar.getTime();
            String timer = sdf.format(date);
            System.out.print(timer+"：5402.27（含手续费235.6）||||");
            BigDecimal sum = new BigDecimal(Double.toString(5402.27)).multiply(new BigDecimal(i));
            System.out.println("第"+i+"期"+timer+"已还款金额:"+sum+"剩余欠额："+(total.subtract(sum)));
            System.out.println("================");
        }
    }

    private void printDebt() {
        for (int i = 0; i < 13; i++) {
            System.out.println("2017年");
        }
    }
}
