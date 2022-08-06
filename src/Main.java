import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] product = {"Молоко: ", "Соль: ", "Хлеб: ", "Сахар: ", "Напитки: ", "Рыба: "};
    String[] productCost = {"80", "30", "35", "95", "70", "150"};
    String[] productSale = {"Соль: ", "Сахар: ", "Крупа: ", null, null, null};
    int[] costAll = new int[productCost.length];

    System.out.println("____________________\n" + "В наличии продукты:\n" + "____________________\n");
    for (int i = 0; i < product.length; i++) {
      System.out.println((i + 1) + ": " + product[i] + " " + productCost[i] + " руб/кг(шт).");
    }



    int num = 0;
    int price = 0;
    int total = 0;

    while (true) {
      System.out.print("Введите позицию товара [1-6]: > ");
      String inputNum = scanner.nextLine();
      System.out.print("Введите количество покупаемого: > ");
      String inputLot = null;

      try {
        inputLot = scanner.nextLine();
      } catch (NumberFormatException e) {
        System.out.println("Ошибка! Нужно вводить только числа!");
        continue;
      }

      if ("end".equals(inputNum) || "end".equals(inputLot)) {
        break;
      } else if (Integer.parseInt(inputNum) < 1 || Integer.parseInt(inputNum) > product.length) {
        throw new FalsePositionException(inputNum);
      }

      try {
        num = Integer.parseInt(inputNum) - 1;
        price = Integer.parseInt(productCost[num]);

        total = costAll[num] + (Integer.parseInt(inputLot) * price);
        costAll[num] = total;

      } catch (NumberFormatException e) {
        System.out.println("Ошибка! Нужно вводить только числа!");
      }
    }
    scanner.close();
    System.out.println("\nВаш чек! Купленные продукты:");

        /*
        Логику просчитывания ИТОГО продумай пожалуйста заново. Используй только те переменные, которые уже указаны.
        НЕ вводить новых переменных и НЕ добавлять новых методов, из-за обилия доп. методов/ переменных очень сложно
        понять код и легко запутаться (даже самому ;)). Сократила наименования, а то итак запутанно, так еще и
        продуктов много
         */

    for (int temp : costAll) {
            ??? = ??? + temp;
    }

    System.out.println("______________________________________________________");
    System.out.println("Общая сумма покупки составляет: " + ??? + " руб.");

  }
}
