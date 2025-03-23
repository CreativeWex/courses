package examples.supplier;

import examples.supplier.model.Role;
import examples.supplier.service.UserRoleService;

import java.util.Collections;
import java.util.Optional;
import java.util.function.Supplier;

public class Main {
  private static final Supplier<Double> RANDOM_DOUBLE_SUPPLIER = Math::random;
  private static final Supplier<Role> DEFAULT_USER = () -> new Role(11L, "GUEST", Collections.emptyList());

  public static void main(String[] args) {
    UserRoleService service = new UserRoleService();
    Role role = service.getById(1).orElse(DEFAULT_USER.get());
    System.out.println(role);
  }
}
