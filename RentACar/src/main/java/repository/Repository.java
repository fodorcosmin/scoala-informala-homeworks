package repository;

import java.io.IOException;
import java.util.List;

/**
 * Created by Fodor Cosmin (inspired by Andrei :)) ) on 7/9/2017.
 */
public interface Repository<T> {
  /**
   * Adds a object in the repository
   *
   * @param object
   */
  void add(T object);

  /**
   * Adds object in a arraylist of the specified type
   *
   * @param object
   */
  void addAll(List<T> object);

  /**
   * Returns all objects in the repository
   *
   * @return the specified type
   */
  List<T> getAll();

  /**
   * updates the arraylist containing the specified type
   *
   * @param object
   */
  void update(List<T> object);

  /**
   * Remove a object from the specified type
   *
   * @param object
   */
  void remove(T object);

  /**
   * Saves a object into a file from an Arraylist.
   */
  void saveToFile(T object);

  /**
   * blabla
   *
   * @return
   * @throws IOException
   * @throws ClassNotFoundException
   */
  List<T> readAll();

}
