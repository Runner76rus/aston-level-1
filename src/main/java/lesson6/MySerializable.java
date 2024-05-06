package lesson6;


import java.nio.file.Path;

public interface MySerializable<T> {

     Path writeObject(Path path);

      T readObject(Path path);
}
