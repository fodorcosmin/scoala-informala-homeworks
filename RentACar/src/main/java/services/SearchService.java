package services;

import java.io.IOException;
import java.util.List;

/**
 * Created by Cosmin on 7/9/2017.
 */
public interface SearchService<T> {


  /**
   * Search service by ID for the specified type
   *
   * @return
   */
  List<T> findById(int id) throws IOException;

}
