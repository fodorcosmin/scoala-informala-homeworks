package repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * Created by Cosmin on 7/13/2017.
 */

//TODO SHOULD i test CRUD methods in repo? // Suggestions appreciated

@RunWith(value = Parameterized.class)
public class RepositoryTest<T> {

  public Repository<T> repository;

  public RepositoryTest(Repository<T> repository) {
    this.repository = repository;
  }

  @Test

  /**
   * Checks if after the actual adding of the T object the List (ArrayList in this case is empty)
   */
  public void add(T object) {
  }

  @Test
  public void addAll() throws Exception {
  }

  @Test
  public void update() throws Exception {
  }

  @Test
  public void remove() throws Exception {
  }

  @Test
  public void saveToFile() throws Exception {
  }

  @Test
  public void readAll() throws Exception {
  }

}
