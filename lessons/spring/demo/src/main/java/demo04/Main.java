package demo04;

import demo04.component.LifecycleDemoComponent;
import demo04.configuration.ApplicationConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
  public static void main(String[] args) {
    System.out.println("1️⃣ [Main] Запуск Spring context");

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

    // Достаём бин, чтобы убедиться в его создании
    context.getBean(LifecycleDemoComponent.class);

    System.out.println("🔄 [Main] Контекст работает...");

    // Закрытие контекста вручную, чтобы вызвать @PreDestroy и destroy()
    context.close();

    // Принудительно очищаем объекты
    System.gc();

    System.out.println("✅ [Main] Программа завершена");
  }
}
