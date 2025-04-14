package demo04.component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class LifecycleDemoComponent implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

  public LifecycleDemoComponent() {
    System.out.println("2️⃣ [Constructor] Конструктор: объект создан");
  }

  @Override
  public void setBeanName(String name) {
    System.out.println("3️⃣ [BeanNameAware] Имя бина: " + name);
//    System.out.println("🛑 Создание бина @Component");
  }

  @Override
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    System.out.println("4️⃣ [BeanFactoryAware] Бин регистрируется в BeanFactory");
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    System.out.println("5️⃣ [ApplicationContextAware] Контекст установлен");
  }

  @PostConstruct
  public void postConstruct() {
    System.out.println("6️⃣ [@PostConstruct] Метод postConstruct вызван");
  }

  @Override
  public void afterPropertiesSet() {
    System.out.println("7️⃣ [InitializingBean] afterPropertiesSet вызван");
  }

  @PreDestroy
  public void preDestroy() {
    System.out.println("8️⃣ [@PreDestroy] Метод preDestroy вызван");
  }

  @Override
  public void destroy() {
    System.out.println("9️⃣ [DisposableBean] destroy вызван");
  }

  @Override
  protected void finalize() throws Throwable {
    super.finalize();
    System.out.println("🔚 [GC] finalize() вызван (бин уничтожен сборщиком мусора)");
  }
}
