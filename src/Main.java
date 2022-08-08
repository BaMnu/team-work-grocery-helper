import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    final int minNumOfLot = 1;

    String[] product = {"Молоко", "Соль", "Хлеб", "Крупа", "Мясо"};
    int[] productCost = {80, 30, 35, 70, 150};
    int[] costAll = new int[productCost.length];
    int[] writeProd = new int[product.length];

    System.out.println("____________________");
    System.out.println("В наличии продукты:");

    for (int i = 0; i < product.length; i++) {
      System.out.println((i + 1) + ": " + product[i] + ": " + productCost[i] + " руб/кг(шт).");
    }

    int num;
    int sumCost = 0;
    int prodCount;

    while (true) {
      System.out.print("\nВведите позицию покупаемого товара [1-5]: > ");
      String inputNum = scanner.nextLine();

      if ("end".equals(inputNum)) {
        break;
      }

      if (Integer.parseInt(inputNum) < minNumOfLot || Integer.parseInt(inputNum) > product.length) {
        System.out.println(new FalsePositionException(inputNum));
        continue;
      }

      System.out.print("Введите количество покупаемого: > ");

      try {

        String inputLot = scanner.nextLine();
        if ("end".equals(inputLot)) {
          break;
        }

        prodCount = Integer.parseInt(inputLot);
        num = Integer.parseInt(inputNum) - 1;

      } catch (NumberFormatException e) {
        System.out.println("Ошибка! Нужно вводить только числа!");
        continue;
      }

      writeProd[num] += prodCount;
      costAll[num] = productCost[num] * writeProd[num];

    }

    System.out.println("\nВаш чек! Купленные продукты: ");
    for (int i = 0; i < product.length; i++) {
      if (writeProd[i] != 0) {
        System.out.println("'" + product[i] + "'" + " общая стоимость за " + writeProd[i] +
            " кг/шт. " + costAll[i] + " руб. ["
            + productCost[i] + " руб./шт.]");
      }
      sumCost += costAll[i];
    }
    System.out.println("______________________________________________________");
    System.out.println("\nОбщая сумма покупки составляет: " + sumCost + " руб.");
    scanner.close();
  }
}