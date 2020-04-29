package zza_lab8;

import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

public class SolvingProblem { // КЛАСС РЕШЕНИЯ ЗАДАНИЯ
    ReentrantLock reentrantLock = new ReentrantLock(); // "Входящий замок" потоков
    float[][] arraySolutions; // Массив вычисленных значений заданий

    SolvingProblem(float[][] arraySolutions) { // Инициализация решателя заданий
        this.arraySolutions = arraySolutions; // Получаем доступ к внешнему массиву вычисленных значений заданий
    }

    void doExpr(int numSolution) { // Метод решения заданий
        reentrantLock.lock(); // Блокировка других потоков

        try {
            System.out.println("Поток " + numSolution + " успешно захватил управление решателем заданий ...");

            // ------------------------------------------------------- АЛГОРИТМ РЕШЕНИЯ ВАРИАНТА ЗАДАНИЯ ---
           // Scanner sc = new Scanner(System.in); // Подключение к консоли
            System.out.print("Введите A: "); // Вывод значения
            float a = (int) (Math.random()*10); // sc.nextFloat(); // Ввод с консоли вещественного значения
            System.out.println(a);
            System.out.print("Введите B: "); // Вывод вопроса
            float b = (int) (Math.random()*10); // sc.nextFloat();// Ввод с консоли вещественного значения
            System.out.println(b);
            int x = 0;
            if( x >= 5 ){
         float c = (float) (5 * (Math.pow(a,2) + Math.pow(b,2))/(x-4));
         arraySolutions[numSolution - 1][0] = a; // Сохранение решения в результирующем массиве
            arraySolutions[numSolution - 1][1] = b; // Сохранение решения в результирующем массиве
            arraySolutions[numSolution - 1][2] = c; // Сохранение решения в результирующем массиве
            
      }else{
         float c = (float)(6 * a * b) - 5 * x; 
          arraySolutions[numSolution - 1][0] = a;
           arraySolutions[numSolution - 1][1] = b;
           arraySolutions[numSolution - 1][2] = c;
           System.out.println("Решение задания " + numSolution + " было успешно получено и передано в основной поток!");
      }
   }
     
           
            

           
        catch (Exception e) {
       
            arraySolutions[numSolution - 1][0] = 0; // Сохранение решения в результирующем массиве при ошибке расчета
            arraySolutions[numSolution - 1][1] = 0; // Сохранение решения в результирующем массиве при ошибке расчета
            arraySolutions[numSolution - 1][2] = 0; // Сохранение решения в результирующем массиве при ошибке расчета
        } finally {
        
            System.out.println("Поток " + numSolution + " отключился от управления решателем заданий.");
            System.out.println();
    
            reentrantLock.unlock(); // Снятие блокировки "замка" на разрешения работы других потоков
        }}

    

}