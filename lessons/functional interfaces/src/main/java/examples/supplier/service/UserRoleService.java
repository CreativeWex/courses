package examples.supplier.service;

import examples.supplier.model.Role;

import java.util.Optional;

public class UserRoleService {
  public Optional<Role> getById(long id) {
    // мок метода, возвращающего результаты из бд
    return Optional.ofNullable(null);
  }
}
