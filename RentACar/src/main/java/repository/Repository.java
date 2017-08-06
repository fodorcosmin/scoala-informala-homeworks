package repository;

//TODO ABSTRACT REPOSITORY IS A DAO and implmenet DB for customers, cars and transactions


import java.sql.SQLException;

/**
 * Created by FCS  on 7/9/2017.
 */
public interface Repository<T> {

  /**
   *
   */
  void insert(T object) throws SQLException;

  /**
   *
   */
  void select() throws SQLException;

  /**
   *
   */
  void update();

  /**
   *
   */
  void delete();

  /**
   * @return
   */

  void getAll();

}
