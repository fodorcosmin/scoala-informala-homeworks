package repository;


/**
 * Created by FCS  on 7/9/2017.
 */
public interface Repository<T> {

  /**
   *
   */
  void add(T t);

  /**
   *
   */
  void update(T t);

  /**
   *
   */
  void delete(T t);

  /**
   * @return
   */


}
