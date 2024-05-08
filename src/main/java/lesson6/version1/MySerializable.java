package lesson6.version1;


import java.nio.file.Path;

public interface MySerializable<T> {

     Path writeObject(Path path);

      T readObject(Path path);
}
