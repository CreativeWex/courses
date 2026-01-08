package demoLifeCycle;

public class ThreadLifecycle {
  /**
   * Жизненный цикл потоков
   */
  public static void main(String[] args) throws InterruptedException {
    // Просмотр активных потоков
    System.out.println("==========[Просмотр системных потоков]======================================================================");
    printSystemThreadsInfo();

    // Создание потока - NEW, объект расположен в heap. В стеке хранится только ссылка на объект. У потока нет своего стека.
    System.out.println("==========[Создание потока demo-thread]======================================================================");
    Thread thread = new Thread(() -> {
      try {
        doSomething();             // RUNNABLE
        Thread.sleep(1000); // TIMED_WAITING
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }, "demo-thread");
    System.out.printf("Статус потока demo-thread: %s \uD83D\uDFE2%n", thread.getState());
    System.out.println("Результат Thread.activeCount(): %s".formatted(Thread.activeCount()));
    printThreadsInGroup("main");

    // Запуск потока
    System.out.println("==========[Запуск потока demo-thread]======================================================================");
    thread.start();
    System.out.println("Результат Thread.activeCount(): %s".formatted(Thread.activeCount()));
    System.out.printf("Статус потока demo-thread: %s \uD83D\uDFE2%n", thread.getState());
    printThreadsInGroup("main");

    System.out.println("==========[Смена статуса]======================================================================");
    System.out.printf("Статус потока demo-thread: %s \uD83D\uDFE2%n", thread.getState());
    Thread.sleep(100);
    System.out.printf("Статус потока demo-thread: %s \uD83D\uDFE2%n", thread.getState());
    Thread.sleep(1000);
    System.out.printf("Статус потока demo-thread: %s \uD83D\uDFE2%n", thread.getState());
  }

  private static void doSomething() {
    int x = 0;
    for (int i = 0; i < 100_000; i++) {
      x++;
    }
  }

  private static void printSystemThreadsInfo() {
    Thread.getAllStackTraces().keySet()
        .forEach(ThreadLifecycle::printThreadStatus);
  }

  private static void printThreadStatus(Thread thread) {
    String message = """
          Поток: '%s',
          Состояние: '%s',
          isAlive: '%s',
          isDaemon: '%s',
          group: '%s'
       """.formatted(thread.getName(), thread.getState(), thread.isAlive(), thread.isDaemon(), thread.getThreadGroup());
    System.out.println(message);
  }

  private static void printThreadsInGroup(String groupName) {
    // Находим корневую группу
    ThreadGroup root = Thread.currentThread().getThreadGroup();
    while (root.getParent() != null) {
      root = root.getParent();
    }
    Thread[] allThreads = new Thread[root.activeCount() * 2];
    root.enumerate(allThreads, true);
    System.out.printf("Потоки в группе '%s':%n", groupName);

    for (Thread t : allThreads) {
      if (t != null && t.getThreadGroup() != null && t.getThreadGroup().getName().equals(groupName)) {
        printThreadStatus(t);
      }
    }
  }
}
