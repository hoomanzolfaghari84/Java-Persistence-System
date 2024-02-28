package Persistence.DataAccessors;

import Exceptions.FileManagerException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

public abstract class DataAccessor<TModel,TKey> {
    protected static File entriesDirectory;

    public DataAccessor(File dataFilesDirectory , String modelDirectoryName) throws FileManagerException {
        entriesDirectory = new File(dataFilesDirectory + "/" + modelDirectoryName);
        if(!entriesDirectory.exists() && !entriesDirectory.mkdirs()) throw new FileManagerException("creating model directory "+ modelDirectoryName + " was unsuccessful");
    }

    public abstract void add(TModel model) throws IOException, FileManagerException;
    public abstract void delete(TModel model);
    public abstract TModel load(TKey key) throws FileNotFoundException;
    public abstract TModel update(TModel model);
    public abstract boolean exists(TKey key);
    public abstract <T> boolean any(Predicate<T> predicate);
    public abstract <T> List<TModel> where(Predicate<T> predicate);

}
