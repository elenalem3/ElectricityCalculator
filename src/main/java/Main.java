import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static int norm = 85; //норматив потребления на одного человека

    public static BigDecimal dayNorm = new BigDecimal("4.51");
    public static BigDecimal dayMoreNorm = new BigDecimal("8.31");
    public static BigDecimal nightNorm = new BigDecimal("2.20");
    public static BigDecimal nightMoreNorm = new BigDecimal("4.34");
//    public static double dayNorm = 4.51;
//    public static double dayMoreNorm = 8.31;
//    public static double nightNorm = 2.20;
//    public static double nightMoreNorm = 4.34;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите предыдущее показание счетчика за день: ");
        int previousDay = scanner.nextInt();
        System.out.println("Введите текущее показание счетчика за день: ");
        int currentDay = scanner.nextInt();
        System.out.println("Введите предыдущее показание счетчика за ночь: ");
        int previousNight = scanner.nextInt();
        System.out.println("Введите текущее показание счетчика за ночь: ");
        int currentNight = scanner.nextInt();

        int consumptionDay = currentDay - previousDay; //потребление дневное
        int consumptionNight = currentNight - previousNight; //потребление ночное
        int sumMonth = consumptionDay + consumptionNight; //сумма потребления за месяц
        System.out.println("Потребление по тарифу 'День' составило: " + consumptionDay +
                "\nПотребление по тарифу 'Ночь' составило: " + consumptionNight +
                "\nСумма потребления за месяц: " + sumMonth);

        if (sumMonth <= norm) {
            BigDecimal sumDay = dayNorm.multiply(BigDecimal.valueOf(consumptionDay));
            BigDecimal sumNight = nightNorm.multiply(BigDecimal.valueOf(consumptionNight));
            BigDecimal result = sumDay.add(sumNight);
//            double sumDay = consumptionDay * dayNorm;
//            double sumNight = currentNight * nightNorm;
            System.out.println("Стоимость по по тарифу 'День' составила: " + sumDay +
                    "\nСтоимость по тарифу 'Ночь' составила: " + sumNight +
                    "\nОбщая стоимость потребления за месяц: " + result);
        } else {
//            double sumDay = sumDay(consumptionDay, sumMonth);
//            double sumNight = sumNight(consumptionNight, sumMonth);

//            System.out.println("Стоимость по по тарифу 'День' составила: " + sumDay +
//                    "\nСтоимость по тарифу 'Ночь' составила: " + sumNight +
//                    "\nОбщая стоимость потребления за месяц: " + (sumDay + sumNight));
        }
    }

//    public static double sumDay(int consumptionDay, int sumMonth) {
//        double averageSum = norm * (consumptionDay % sumMonth);
//        double sumDayNorm = averageSum * dayNorm;
//        double sumDayMoreNorm = (consumptionDay - averageSum) * dayMoreNorm;
//        double sum = sumDayNorm + sumDayMoreNorm;
//        return sum;
//    }

//    public static double sumNight(int consumptionNight, int sumMonth) {
//        double averageSum = norm * (consumptionNight % sumMonth);
//        double sumNightNorm = averageSum * nightNorm;
//        double sumNightMoreNorm = (consumptionNight - averageSum) * nightMoreNorm;
//        double sum = sumNightNorm + sumNightMoreNorm;
//        return sum;
//    }

}
