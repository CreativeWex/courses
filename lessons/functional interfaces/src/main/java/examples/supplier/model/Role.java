package examples.supplier.model;

import java.util.List;

public class Role {
  private final long id;
  private final String name;
  private final List<String> grants;

  public Role(long id, String name, List<String> grants) {
    this.id = id;
    this.name = name;
    this.grants = grants;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<String> getGrants() {
    return grants;
  }

  @Override
  public String toString() {
    return "Role{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", grants=" + grants +
        '}';
  }
}
