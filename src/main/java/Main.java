import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {
    public static int norm = 85; //норматив потребления на одного человека

    public static BigDecimal dayNorm = new BigDecimal("4.51");
    public static BigDecimal dayMoreNorm = new BigDecimal("8.31");
    public static BigDecimal nightNorm = new BigDecimal("2.20");
    public static BigDecimal nightMoreNorm = new BigDecimal("4.34");

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

        int consumptionDay = currentDay - previousDay; //потребление по тарифу 'День'
        int consumptionNight = currentNight - previousNight; //потребление по тарифу 'Ночь'
        int sumMonth = consumptionDay + consumptionNight; //сумма потребления за месяц
        System.out.println("Потребление по тарифу 'День' составило: " + consumptionDay +
                "\nПотребление по тарифу 'Ночь' составило: " + consumptionNight +
                "\nСумма потребления за месяц: " + sumMonth);

        if (sumMonth <= norm) {
            BigDecimal sumDay = dayNorm.multiply(BigDecimal.valueOf(consumptionDay));
            BigDecimal sumNight = nightNorm.multiply(BigDecimal.valueOf(consumptionNight));
            BigDecimal result = sumDay.add(sumNight);

            System.out.println("Стоимость по по тарифу 'День' составила: " + sumDay +
                    "\nСтоимость по тарифу 'Ночь' составила: " + sumNight +
                    "\nОбщая стоимость потребления за месяц: " + result);
        } else {

            BigDecimal consumDay = new BigDecimal(consumptionDay);
            BigDecimal sumMonD = new BigDecimal(sumMonth);
            BigDecimal averSumD = consumDay.divide(sumMonD, 2, RoundingMode.CEILING);
            //точность в две цифры после запятой с округлением в большую сторону
            BigDecimal averageSumD = averSumD.multiply(BigDecimal.valueOf(norm));
            BigDecimal sumDayNorm = averageSumD.multiply(dayNorm);
            BigDecimal sumDayMoreNorm = consumDay.subtract(averageSumD).multiply(dayMoreNorm);
            BigDecimal sumDay = sumDayNorm.add(sumDayMoreNorm);

            BigDecimal consumNight = new BigDecimal(consumptionNight);
            BigDecimal sumMonN = new BigDecimal(sumMonth);
            BigDecimal averSumN = consumNight.divide(sumMonN, 2, RoundingMode.CEILING);
            //точность в две цифры после запятой с округлением в большую сторону
            BigDecimal averageSumN = averSumN.multiply(BigDecimal.valueOf(norm));
            BigDecimal sumNightNorm = averageSumN.multiply(nightNorm);
            BigDecimal sumNightMoreNorm = consumNight.subtract(averageSumN).multiply(nightMoreNorm);
            BigDecimal sumNight = sumNightNorm.add(sumNightMoreNorm);

            BigDecimal result = sumDay.add(sumNight);

            System.out.println("Стоимость по по тарифу 'День' составила: " + sumDay +
                    "\nСтоимость по тарифу 'Ночь' составила: " + sumNight +
                    "\nОбщая стоимость потребления за месяц: " + result);
        }
    }
}
