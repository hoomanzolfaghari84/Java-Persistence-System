package Persistence.DataAccessors;

import Exceptions.FileManagerException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

public abstract class DataAccessor<TModel,TKey> {

    public DataAccessor() throws FileManagerException {

    }

    public abstract void add(TModel model) throws IOException, FileManagerException;
    public abstract void delete(TModel model);
    public abstract TModel load(TKey key) throws FileNotFoundException;
    public abstract TModel update(TModel model);
    public abstract boolean exists(TKey key);
    public abstract <T> boolean any(Predicate<T> predicate);
    public abstract <T> List<TModel> where(Predicate<T> predicate);
    public abstract List<TKey> AllExistingKeys();
}
